package com.fnkaya.accountservice.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
@Builder
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "passwd")
    private String password;
}
