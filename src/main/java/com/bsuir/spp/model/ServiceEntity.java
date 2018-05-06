package com.bsuir.spp.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @EqualsAndHashCode
@Table(name = "service",schema = "companyDB")
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="serv_id",nullable = false,updatable = false)
    private int id;
    @Column(name="serv_name",nullable = false,length = 50)
    private String name;
    @Column(name="serv_time",nullable = false)
    private float time;
    @Column(name="serv_price",nullable = false)
    private float price;
    @Column(name="serv_count_people",nullable = false)
    private int countPeople;
    @Column(name="serv_description",length = 100)
    private String description;

    @ManyToMany
    @JoinTable(name="m2m_serv_tool",
            joinColumns=
            @JoinColumn(name="serv_id", referencedColumnName="serv_id"),
            inverseJoinColumns=
            @JoinColumn(name="tool_id", referencedColumnName="tool_id")
    )
    private List<Tool> tools;

    @ManyToMany
    @JoinTable(name="m2m_serv_material",
            joinColumns=
            @JoinColumn(name="serv_id", referencedColumnName="serv_id"),
            inverseJoinColumns=
            @JoinColumn(name="material_id", referencedColumnName="material_id")
    )
    private List<Material> materials;

    @ManyToMany
    @JoinTable(name="m2m_serv_equipment",
            joinColumns=
            @JoinColumn(name="serv_id", referencedColumnName="serv_id"),
            inverseJoinColumns=
            @JoinColumn(name="equipment_id", referencedColumnName="equipment_id")
    )
    private List<Equipment> equipments;


}
