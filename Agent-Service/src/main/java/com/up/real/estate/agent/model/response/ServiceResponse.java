package com.up.real.estate.agent.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.up.real.estate.agent.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ServiceResponse {

    private String agent_Id;
    private String name;
    private String email;
    private Long mobNumber;
    private int age;
    private Address address;

}
