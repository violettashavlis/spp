package com.bsuir.spp.model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments",schema = "companyDB")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comment_id",updatable = false,nullable = false)
    private int id;

    @Column(name="comment_text",nullable = false)
    @Type(type="text")
    private String text;

    @Column(name="comment_time",nullable = false)
    private LocalDateTime time;

    @Column(name="user_id",nullable = false)
    private int userId;
}
