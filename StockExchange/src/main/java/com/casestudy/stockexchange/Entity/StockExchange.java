package com.casestudy.stockexchange.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StockExchange {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "stock_exchange")
    private String name;

    private String brief;

    @Column(name = "contact_address")
    private String contactAddress;

    private String remarks;

    @JsonBackReference
    @ManyToMany(mappedBy = "stockExchangeList", fetch = FetchType.LAZY)
    private List<Company> companyList = new ArrayList<Company>();
}
