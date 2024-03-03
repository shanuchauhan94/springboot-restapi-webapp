package com.up.real.estate.agent.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.up.real.estate.agent.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ServiceResponse {

    private Long agent_Id;
    private String name;
    private String email;
    private Long mobNumber;
    private Date dob;
    private Address address;

}
