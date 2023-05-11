package com.example.demo15.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

//используем Lombok
@Entity
@Table(name = "manufactures")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Manufacture {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "manufacture_seq", sequenceName = "manufacture_sequence", allocationSize = 1)
    @GeneratedValue(generator = "manufacture_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "manufacture")
    private List<Phone> phones;

}
