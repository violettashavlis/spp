package com.bsuir.spp.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "materials",schema = "companyDB")
@NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode @ToString
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="material_id",updatable = false,nullable = false)
    private int id;

    @Column(name="material_name",nullable = false,length = 50)
    private String name;

    @Column(name="material_mark",nullable = false,length = 50)
    private String mark;

    @Column(name="material_price",nullable = false,length = 50)
    private float price;

    @ManyToOne(optional = false,cascade = CascadeType.REFRESH)
    @JoinColumn(name="material_measure_id",nullable = false,updatable = false)
    private Measure measure;

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

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }
}
