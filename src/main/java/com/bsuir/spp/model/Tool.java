package com.bsuir.spp.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="tools",schema = "companyDB")
@Setter @Getter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode @ToString
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="tool_id",updatable = false,nullable = false)
    private int id;

    @Column(name="tool_name",nullable = false,length = 50)
    private String name;

    @Column(name="tool_mark",nullable = false,length = 50)
    private String mark;

    @Column(name="tool_model",nullable = false,length = 50)
    private String model;

    @Column(name="tool_issure_year",nullable = false)
    private LocalDate issureYear;
}
