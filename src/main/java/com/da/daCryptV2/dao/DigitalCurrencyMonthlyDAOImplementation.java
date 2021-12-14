package com.da.daCryptV2.dao;

import com.da.daCryptV2.entity.DigitalCurrencyMonthly;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DigitalCurrencyMonthlyDAOImplementation implements DigitalCurrencyMonthlyDAO {

    @Override
    public List<DigitalCurrencyMonthly> getMonthlyReport() {
        return null;
    }

    @Override
    public void saveMonthlyReport(List<DigitalCurrencyMonthly> monthlyReport) {

    }
}
