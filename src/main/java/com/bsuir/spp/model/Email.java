package com.bsuir.spp.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Email {

    private String to;
    private String subject;
    private String text;

}
