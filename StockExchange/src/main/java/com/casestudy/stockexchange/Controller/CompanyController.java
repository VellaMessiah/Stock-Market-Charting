package com.casestudy.stockexchange.Controller;

import com.casestudy.stockexchange.Entity.Company;
import com.casestudy.stockexchange.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/byid/{code}")
    public ResponseEntity<?> findByCode(@PathVariable int code){
        Optional<Company> company = companyService.findByCode(code);
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
