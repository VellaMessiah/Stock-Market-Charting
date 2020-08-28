package com.casestudy.stockexchange.Service;

import com.casestudy.stockexchange.Entity.Company;
import com.casestudy.stockexchange.Entity.StockExchange;

import java.util.List;

public interface StockExchangeService {
    public List<StockExchange> getStockexchangeList();
    public StockExchange addStockexchange(StockExchange stockExchange);
    public Company addCompanyToStockExchange(Company company, StockExchange stockExchange, String companyCode);
    public List<Company> getCompaniesByStockexchangeId(Integer id);
    public List<Company> getCompaniesByStockExchangeName(String name);
    public Company addCompanytoStockExchangeById(Company company, Integer stockexchangeId, String companyCode);
}
