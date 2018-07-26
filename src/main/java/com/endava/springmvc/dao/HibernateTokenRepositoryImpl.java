package com.endava.springmvc.dao;

import com.endava.springmvc.model.PersistentLogin;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository("tokenRepositoryDao")
@Transactional
public class HibernateTokenRepositoryImpl extends AbstractDao<String, PersistentLogin> implements PersistentTokenRepository {

    static final Logger logger = LoggerFactory.getLogger(HibernateTokenRepositoryImpl.class);

    @Override
    public void createNewToken(PersistentRememberMeToken persistentRememberMeToken) {
        logger.info("Creating token for new user: {}", persistentRememberMeToken.getUsername());
        PersistentLogin persistentLogin = new PersistentLogin();
        persistentLogin.setUsername(persistentRememberMeToken.getUsername());
        persistentLogin.setSeries(persistentRememberMeToken.getSeries());
        persistentLogin.setToken(persistentRememberMeToken.getTokenValue());
        persistentLogin.setLast_used(persistentRememberMeToken.getDate());
        persist(persistentLogin);

    }

    @Override
    public void updateToken(String seriasId, String tokenValue, Date date) {
        logger.info("Update Token for seriesID : {}",seriasId);
        PersistentLogin persistentLogin = getByKey(seriasId);
        persistentLogin.setToken(tokenValue);
        persistentLogin.setLast_used(date);
        update(persistentLogin);

    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriasId) {
        logger.info("Fetch Token if any for seriesId: {}", seriasId);
        try {
            Criteria criteria = createEntityCriteria();
            criteria.add(Restrictions.eq("series", seriasId));
            PersistentLogin persistentLogin = (PersistentLogin) criteria.uniqueResult();
            return new PersistentRememberMeToken(persistentLogin.getUsername(), persistentLogin.getSeries(),
                    persistentLogin.getToken(), persistentLogin.getLast_used());
        } catch (Exception e) {
            logger.info("Token not found...");
            return null;
        }
    }

    @Override
    public void removeUserTokens(String username) {
        logger.info("Removing token for user : {}", username);
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        PersistentLogin persistentLogin = (PersistentLogin) criteria.uniqueResult();
        if (persistentLogin != null) {
            logger.info("rememberMe was selected and deleted");
            delete(persistentLogin);
        }
    }
}
