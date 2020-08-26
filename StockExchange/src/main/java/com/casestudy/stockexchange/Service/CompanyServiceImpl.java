package com.casestudy.stockexchange.Service;

import com.casestudy.stockexchange.Entity.Company;
import com.casestudy.stockexchange.Entity.Director;
import com.casestudy.stockexchange.Entity.StockExchange;
import com.casestudy.stockexchange.Repositories.CompanyRepository;
import com.casestudy.stockexchange.Repositories.StockExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;
    private StockExchangeRepository stockExchangeRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository, StockExchangeRepository stockExchangeRepository) {
        this.companyRepository = companyRepository;
        this.stockExchangeRepository = stockExchangeRepository;
    }

    @Override
    public Optional<Company> findByCode(int code) {
        Optional<Company> company = companyRepository.findById(code);
        if(company.isPresent())
            return company;
        return null;
    }

    @Override
    public Company addCompany(Company c) {
        Company company = companyRepository.save(c);
        return company;
    }

    @Override
    public Optional<Company> addDirectorByCode(int companyCode, Director d) {
        Optional<Company> c = companyRepository.findById(companyCode);
        if(c.isPresent()){
            c.get().getBoardOfDirectors().add(d);
            return c;
        }
        return null;
    }

    @Override
    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public List<StockExchange> addStockExchange(Integer companyId,Integer stockExchangeId) {
        Optional<StockExchange> stockExchange = stockExchangeRepository.findById(stockExchangeId);
        Optional<Company> company = companyRepository.findById(companyId);
        if(stockExchange.isPresent() && company.isPresent() && checkStockExchange(company.get(),stockExchange.get())){
            company.get().getStockExchangeList().add(stockExchange.get());
            return company.get().getStockExchangeList();
        }
        return null;
    }

    private boolean checkStockExchange(Company company,StockExchange stockExchange){
        List<StockExchange> stockExchangeList = company.getStockExchangeList();
        if(stockExchange==null || stockExchangeList.isEmpty())
            return false;
        Iterator<StockExchange> it = stockExchangeList.iterator();
        while(it.hasNext()){
            StockExchange current = it.next();
            if(stockExchange.getId()==current.getId())
                return true;
        }
        return false;
    }
}
