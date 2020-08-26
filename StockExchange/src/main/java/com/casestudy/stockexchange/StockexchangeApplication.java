package com.casestudy.stockexchange;

import com.casestudy.stockexchange.Entity.Company;
import com.casestudy.stockexchange.Entity.Director;
import com.casestudy.stockexchange.Entity.User;
import com.casestudy.stockexchange.Repositories.DirectorRepository;
import com.casestudy.stockexchange.Service.CompanyService;
import com.casestudy.stockexchange.Service.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ui.ModelMap;

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

    public static void main(String[] args)  {
        SpringApplication.run(StockexchangeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Optional<Director> d = directorRepository.findById(1);
        Optional<Director> d2 = directorRepository.findById(2);
        Optional<Company> c = companyService.findByCode(500112);
        if(d.isPresent() && c.isPresent() ){
                companyService.addDirectorByCode(c.get().getCompanyCode(),d.get());
                System.out.println("Added");

        }
        if(d2.isPresent() && c.isPresent() ){
            companyService.addDirectorByCode(c.get().getCompanyCode(),d2.get());
            System.out.println("Added");

        }
    }

    @Bean
    ModelMapper getModelMapper(){return new ModelMapper();}

}
