package com.up.real.estate.agent.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Agent {

    private String name;
    private String email;
    private Long mobNumber;
    private int age;
    private String password;
    private Address address;

}
