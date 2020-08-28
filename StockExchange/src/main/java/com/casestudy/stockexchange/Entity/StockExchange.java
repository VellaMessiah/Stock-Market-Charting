package com.casestudy.stockexchange.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @Column(name="stockexchangeId")
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
    private List<CompanyStockExchange> companies;

    @Transactional
    public void addCompany(CompanyStockExchange input){
        if(companies.isEmpty()){
            companies.add(input);
            return;
        }
        Iterator<CompanyStockExchange> it = companies.iterator();
        while(it.hasNext()){
            CompanyStockExchange current = it.next();
            if(current.equals(input)) return;
        }
        companies.add(input);
    }
}
