package com.casestudy.stockexchange.Repositories;

import com.casestudy.stockexchange.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {

}
