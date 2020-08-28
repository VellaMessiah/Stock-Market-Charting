package com.casestudy.stockexchange.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "company_stockexchange")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyStockExchange {
    @EmbeddedId
    private CompanyStockExchangeId companyStockExchangeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("companyId")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("stockexchangeId")
    private StockExchange stockexchange;


    @Column(name = "company_code")
    private String companyCode;

    public CompanyStockExchange(Company company, StockExchange stockExchange, String companyCode) {
        this.company = company;
        this.stockexchange=stockExchange;
        this.companyCode=companyCode;
    }


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
}
