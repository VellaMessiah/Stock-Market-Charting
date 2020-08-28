package com.casestudy.stockexchange.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CompanyStockExchangeId implements Serializable {
    @Column(name = "companyId")
    private int companyId;

    @Column(name = "stockexchangeId")
    private int stockExchangeId;

}
