package com.example.tp_chap6;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity //this tells hibernate to make a table out of this class
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;
    @OneToMany
    @JsonIgnoreProperties("user")
    private List<Logs> logs;
    @ManyToMany
    @JsonIgnoreProperties("user")
    private List<Group> group;



}