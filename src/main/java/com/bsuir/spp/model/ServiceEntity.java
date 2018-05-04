package com.bsuir.spp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @EqualsAndHashCode
@Table(name = "service",schema = "companyDB")
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="serv_id",nullable = false,updatable = false)
    private int id;
    @Column(name="serv_name",nullable = false)
    private String name;
    @Column(name="serv_time",nullable = false)
    private float time;
    @Column(name="serv_price",nullable = false)
    private float price;
    @Column(name="serv_count_people",nullable = false)
    private int countPeople;
    @Column(name="serv_description")
    private String description;
}
