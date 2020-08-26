package com.casestudy.stockexchange.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company {
    @Id
    @Column(name = "company_code")
    private int companyCode;

    @Column(name = "company_name")
    private String companyName;

    private float turnover;

    private String ceo;

    @JsonManagedReference
    @OneToMany
    private List<Director> boardOfDirectors = new ArrayList<Director>();

    private String description;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Sector sector;

    @Column(name = "stock_code")
    private String stockCode;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    private List<StockExchange> stockExchangeList = new ArrayList<StockExchange>();


}
