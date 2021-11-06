package com.example.tp_chap6;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  id;
    private String Libelle;
    private String Capacite;


    @ManyToMany
    @JsonIgnoreProperties("group")
    private List<User> user;

    public Group(String libelle, String capacite, List<User> user) {
        Libelle = libelle;
        Capacite = capacite;
        this.user = user;
    }
}
