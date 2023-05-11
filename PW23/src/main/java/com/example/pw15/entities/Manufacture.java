package com.example.pw15.entities;


import com.example.pw15.entities.Phone;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @ToString.Exclude
    private List<Phone> phones;

}
