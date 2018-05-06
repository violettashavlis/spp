package com.bsuir.spp.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="measures")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Measure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="measure_id",updatable = false,nullable = false)
    private int id;

    @Column(name="measures_name",nullable = false,unique = true,length = 20)
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
