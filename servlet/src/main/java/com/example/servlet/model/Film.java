package com.example.servlet.model;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "film")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "rate")
    private Float rate;
    @Column(name = "name")
    private String name;
    @Column(name = "year")
    private Integer year;
    @Column(name = "cnt_voters")
    private Long cntVoters;
    @Column(name = "rate_date")
    private Date rateDate;

    public Date getRateDate() {
        return rateDate;
    }

    public void setRateDate(Date rateDate) {
        this.rateDate = rateDate;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getCntVoters() {
        return cntVoters;
    }

    public void setCntVoters(Long cntVoters) {
        this.cntVoters = cntVoters;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
