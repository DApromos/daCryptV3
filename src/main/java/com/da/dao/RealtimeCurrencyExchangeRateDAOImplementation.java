package com.da.dao;

import com.da.entity.RealtimeCurrencyExchangeRate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RealtimeCurrencyExchangeRateDAOImplementation implements RealtimeCurrencyExchangeRateDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<RealtimeCurrencyExchangeRate> getRealtimeCurrencyExchangeRate() {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        List<RealtimeCurrencyExchangeRate> realtimeCurrencyExchangeRates =
                session.createQuery("from RealtimeCurrencyExchangeRate", RealtimeCurrencyExchangeRate.class)
                        .getResultList();

        tx.commit();
        session.close();
        return realtimeCurrencyExchangeRates;
    }


    @Override
    public void saveRealtimeCurrencyExchangeRate(RealtimeCurrencyExchangeRate realtimeCurrencyExchangeRate) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(realtimeCurrencyExchangeRate);
        tx.commit();
        session.close();

    }

}

