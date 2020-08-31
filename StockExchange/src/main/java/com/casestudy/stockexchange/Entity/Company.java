package com.casestudy.stockexchange.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
public class Company {
    @Id
    @EqualsAndHashCode.Include
    private int companyId;

    @Column(name = "company_name")
    @EqualsAndHashCode.Include
    private String companyName;

    @EqualsAndHashCode.Exclude
    private float turnover;

    @EqualsAndHashCode.Exclude
    private String ceo;

    @JsonManagedReference
    @OneToMany
    @EqualsAndHashCode.Exclude
    private List<Director> boardOfDirectors = new ArrayList<Director>();

    @EqualsAndHashCode.Exclude
    private String description;

    @JsonManagedReference
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CompanyStockExchange> listedInStockExchanges= new ArrayList<CompanyStockExchange>();

   public void addStockExchange(StockExchange stockExchange, String companyCode){
       CompanyStockExchange companyStockExchange = new CompanyStockExchange(this,stockExchange,companyCode);
       listedInStockExchanges.add(companyStockExchange);
       stockExchange.getCompanies().add(companyStockExchange);
   }



}
