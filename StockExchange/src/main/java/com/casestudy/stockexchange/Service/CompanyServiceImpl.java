package com.casestudy.stockexchange.Service;

import com.casestudy.stockexchange.Entity.Company;
import com.casestudy.stockexchange.Entity.Director;
import com.casestudy.stockexchange.Entity.StockExchange;
import com.casestudy.stockexchange.Repositories.CompanyRepository;
import com.casestudy.stockexchange.Repositories.StockExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public Optional<Company> findById(int code) {
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



}
