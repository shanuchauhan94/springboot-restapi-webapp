package com.up.real.estate.agent.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agent")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Agent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private Long mobNumber;
    private Date dob;
    private String gender;
    private String password;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Address address;

}
