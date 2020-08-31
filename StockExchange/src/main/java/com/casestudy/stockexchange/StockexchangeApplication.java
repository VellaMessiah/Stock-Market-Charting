package com.casestudy.stockexchange;

import com.casestudy.stockexchange.Entity.Company;
import com.casestudy.stockexchange.Entity.StockExchange;
import com.casestudy.stockexchange.Repositories.DirectorRepository;
import com.casestudy.stockexchange.Service.CompanyService;
import com.casestudy.stockexchange.Service.StockExchangeService;
import com.casestudy.stockexchange.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@ComponentScan("com.casestudy.stockexchange")
public class StockexchangeApplication implements CommandLineRunner {

    @Autowired
    UserService userService;

    @Autowired
    DirectorRepository directorRepository;

    @Autowired
    CompanyService companyService;

    @Autowired
    StockExchangeService stockExchangeService;

    public static void main(String[] args)  {
        SpringApplication.run(StockexchangeApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Company c1 = companyService.findById(500112).get();
        Company c2 = companyService.findById(500113).get();
        Company c3 = companyService.findById(500114).get();
        stockExchangeService.addCompanytoStockExchangeById(c1,1,"APPL");
        stockExchangeService.addCompanytoStockExchangeById(c2,1,"HDFC");


        List<Company> list = stockExchangeService.getCompaniesByStockexchangeId(1);
        if(list==null)
            System.out.println("NULL LIST");
        if(list.isEmpty())
            System.out.println("NO COMPANIES");
        for(Company c: list)
            System.out.println(c.getCompanyName());



    }

    @Bean
    ModelMapper getModelMapper(){return new ModelMapper();}

}
