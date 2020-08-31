package com.casestudy.stockexchange.Service;

import com.casestudy.stockexchange.Entity.Company;
import com.casestudy.stockexchange.Entity.CompanyStockExchange;
import com.casestudy.stockexchange.Entity.StockExchange;
import com.casestudy.stockexchange.Repositories.CompanyRepository;
import com.casestudy.stockexchange.Repositories.StockExchangeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StockExchangeServiceImpl implements StockExchangeService {
    @Autowired
    ModelMapper modelMapper;


    private StockExchangeRepository stockExchangeRepository;
    private CompanyRepository companyRepository;

    @Autowired
    public StockExchangeServiceImpl(StockExchangeRepository stockExchangeRepository, CompanyRepository companyRepository) {
        this.stockExchangeRepository = stockExchangeRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<StockExchange> getStockexchangeList() {
        return stockExchangeRepository.findAll();
    }


    @Override
    public StockExchange addStockexchange(StockExchange stockExchange) {
        return stockExchangeRepository.save(stockExchange);
    }

    @Override
    public Company addCompanyToStockExchange(Company company, StockExchange stockExchange, String companyCode) {
        company.addStockExchange(stockExchange,companyCode);
        return company;
    }


    @Override
    public List<Company> getCompaniesByStockexchangeId(Integer id) {
        Optional<StockExchange> optional = stockExchangeRepository.findById(id);
        if(optional.isPresent()){
            List<Company> retList = new ArrayList<Company>();
            List<CompanyStockExchange> pairList = optional.get().getCompanies();
            for(CompanyStockExchange pair : pairList)
                retList.add(pair.getCompany());
           return  retList;
        }
        return null;
    }

    @Override
    public List<Company> getCompaniesByStockExchangeName(String name) {
        Optional<StockExchange> optional = stockExchangeRepository.findByName(name);
        if(optional.isPresent()){
            List<Company> retList = new ArrayList<Company>();
            List<CompanyStockExchange> pairList = optional.get().getCompanies();
            for(CompanyStockExchange pair : pairList)
                retList.add(pair.getCompany());
            return  retList;
        }
        return null;
    }

    @Override
    public Company addCompanytoStockExchangeById(Company company, Integer stockexchangeId, String companyCode) {
        Optional<StockExchange> optional = stockExchangeRepository.findById(stockexchangeId);
        if(optional.isPresent()){
            StockExchange stockExchange = optional.get();
            CompanyStockExchange companyStockExchange = new CompanyStockExchange(company, stockExchange,companyCode);
            stockExchange.addCompany(company,companyCode);
            stockExchangeRepository.save(stockExchange);
        }
        return null;
    }
}
