package com.bsuir.spp.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "equipment",schema = "companyDB")
@Setter @Getter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode @ToString
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="equipment_id",updatable = false,nullable = false)
    private int id;

    @Column(name="equipment_name",nullable = false,length = 50)
    private String name;

    @Column(name="equipment_state_number",nullable = false,length = 50)
    private String stateNumber;
    @Column(name="equipment_mark",nullable = false,length = 50)
    private String mark;
    @Column(name="equipment_model",nullable = false,length = 50)
    private String model;
    @Column(name="equipment_issure_year",nullable = false)
    private LocalDate issureYear;
}
