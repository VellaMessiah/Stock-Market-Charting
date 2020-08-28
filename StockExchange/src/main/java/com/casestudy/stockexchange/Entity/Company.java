package com.casestudy.stockexchange.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "sector_id")
    @EqualsAndHashCode.Exclude
    private Sector sector;


   @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
   @EqualsAndHashCode.Exclude
    private List<CompanyStockExchange> listedInStockExchanges;

   @Transactional
   public void addStockexchange(CompanyStockExchange input){
       if(listedInStockExchanges.isEmpty()){
           listedInStockExchanges.add(input);
           return;
       }
       Iterator<CompanyStockExchange> it = listedInStockExchanges.iterator();
       while(it.hasNext()){
           CompanyStockExchange current = it.next();
           if(current.equals(input)) return;
       }
       listedInStockExchanges.add(input);
   }


}
