package com.casestudy.stockexchange.Repositories;

import com.casestudy.stockexchange.Entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Integer> {
}
