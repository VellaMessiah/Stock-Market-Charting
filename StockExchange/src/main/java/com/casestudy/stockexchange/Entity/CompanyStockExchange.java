package com.casestudy.stockexchange.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "company_stockexchange")
public class CompanyStockExchange implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_group_id")
    private int id;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Company company;


    @ManyToOne
    @JoinColumn
    private StockExchange stockexchange;


    @Column(name = "company_code")
    private String companyCode;


    public boolean equals(Object o){
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        CompanyStockExchange that = (CompanyStockExchange)o;
        return this.company.equals(that.stockexchange) && this.stockexchange.equals(that.stockexchange);
    }

    public int hashCode(){
        return Objects.hash(company,stockexchange);
    }

    public CompanyStockExchange(Company company, StockExchange stockExchange, String companyCode) {
        this.company=company;
        this.stockexchange=stockExchange;
        this.companyCode=companyCode;
    }

    public CompanyStockExchange() {
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public StockExchange getStockexchange() {
        return stockexchange;
    }

    public void setStockexchange(StockExchange stockexchange) {
        this.stockexchange = stockexchange;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}
