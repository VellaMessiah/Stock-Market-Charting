package com.casestudy.stockexchange.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stockexchange")
@EqualsAndHashCode
public class StockExchange {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private int stockexchangeId;


    @EqualsAndHashCode.Include
    @Column(name = "stock_exchange")
    private String name;

    @EqualsAndHashCode.Exclude
    private String brief;

    @Column(name = "contact_address")
    @EqualsAndHashCode.Exclude
    private String contactAddress;

    @EqualsAndHashCode.Exclude
    private String remarks;


    @OneToMany(mappedBy = "stockexchange", fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    private List<CompanyStockExchange> companies= new ArrayList<CompanyStockExchange>();

    public void addCompany(Company company, String companyCode){
        CompanyStockExchange companyStockExchange = new CompanyStockExchange(company,this,companyCode);
        companies.add(companyStockExchange);
        company.getListedInStockExchanges().add(companyStockExchange);
    }

}
