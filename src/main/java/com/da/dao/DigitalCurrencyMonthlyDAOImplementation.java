package com.da.dao;

import com.da.entity.DigitalCurrencyMonthly;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DigitalCurrencyMonthlyDAOImplementation implements DigitalCurrencyMonthlyDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<DigitalCurrencyMonthly> getMonthlyReport() {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        List<DigitalCurrencyMonthly> monthlyList =
                session.createQuery("from DigitalCurrencyMonthly", DigitalCurrencyMonthly.class)
                                .getResultList();

        tx.commit();
        session.close();
        return monthlyList;
    }


    @Override
    public void saveMonthlyReport(List<DigitalCurrencyMonthly> monthlyReport) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        for(DigitalCurrencyMonthly item: monthlyReport) {
            session.save(item);
        }

        tx.commit();
        session.close();

    }
}
