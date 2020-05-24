package com.example.demo.domain.user;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    private Long id;
    private String firstName;
    private int age;
    private String email;

}
