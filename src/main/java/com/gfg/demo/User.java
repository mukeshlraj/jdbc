package com.gfg.demo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    int id;
    String name;
    String country;
    int age;
}
