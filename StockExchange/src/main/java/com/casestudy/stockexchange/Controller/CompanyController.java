package com.casestudy.stockexchange.Controller;

import com.casestudy.stockexchange.Entity.Company;
import com.casestudy.stockexchange.Entity.StockExchange;
import com.casestudy.stockexchange.Service.CompanyService;
import com.casestudy.stockexchange.Service.StockExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    private CompanyService companyService;
    private StockExchangeService stockExchangeService;

    @Autowired
    public CompanyController(CompanyService companyService, StockExchangeService stockExchangeService) {
        this.companyService = companyService;
        this.stockExchangeService = stockExchangeService;
    }

    @GetMapping("/byid/{code}")
    public ResponseEntity<?> findByCode(@PathVariable int code){
        Optional<Company> company = companyService.findById(code);
        if(company==null)
            return new ResponseEntity<String>("No Such Company Found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<Company>(company.get(),HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Company> addCompany(@RequestBody Company company){
        return new ResponseEntity<Company>(companyService.addCompany(company),HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Company>> findAll(){
        return new ResponseEntity<List<Company>>(companyService.findAllCompanies(),HttpStatus.OK);
    }

}
