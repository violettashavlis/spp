package com.bsuir.spp.model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "certificates",schema = "companyDB")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="certificate_id",updatable = false,nullable = false)
    private int id;

    @Column(name="certificate_doc",nullable = false)
    @Type(type="text")
    private String doc;

    @Column(name="certificate_name",nullable = false,length = 20)
    private String name;

    @Column(name="certificate_date",nullable = false)
    private LocalDate date;

    @Column(name="certificate_validity",nullable = false)
    private LocalDate validity;

}
