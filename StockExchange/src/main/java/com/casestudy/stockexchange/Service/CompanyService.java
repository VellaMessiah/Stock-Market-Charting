package com.casestudy.stockexchange.Service;

import com.casestudy.stockexchange.Entity.Company;
import com.casestudy.stockexchange.Entity.Director;
import com.casestudy.stockexchange.Entity.StockExchange;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    public Optional<Company> findByCode(int code);
    public Company addCompany(Company c);
    public Optional<Company> addDirectorByCode(int companyCode,Director d);
    public List<Company> findAllCompanies();
    public List<StockExchange> addStockExchange(Integer companyId,Integer stockExchangeId);
}
