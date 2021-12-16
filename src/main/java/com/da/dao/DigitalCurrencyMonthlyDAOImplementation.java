package com.da.dao;

import com.da.entity.DigitalCurrencyMonthly;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DigitalCurrencyMonthlyDAOImplementation implements DigitalCurrencyMonthlyDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<DigitalCurrencyMonthly> getMonthlyReport() {

        Session session = sessionFactory.getCurrentSession();

        List<DigitalCurrencyMonthly> monthlyList =
                session.createQuery("from digitalCurrenciesMonthly", DigitalCurrencyMonthly.class)
                        .getResultList();

        return monthlyList;
    }

    @Override
    public void saveSingleItem(DigitalCurrencyMonthly digitalCurrencyMonthly) {
        Session session = sessionFactory.getCurrentSession();
        session.save(digitalCurrencyMonthly);
    }

    @Override
    public void saveMonthlyReport(List<DigitalCurrencyMonthly> monthlyReport) {
        Session session = sessionFactory.getCurrentSession();
        for(DigitalCurrencyMonthly item: monthlyReport) {
            session.save(item);
        }



    }
}
