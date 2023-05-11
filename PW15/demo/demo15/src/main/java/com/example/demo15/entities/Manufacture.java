package com.example.demo15.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//используем Lombok
@Entity
@Table(name = "manufactures")
@Setter
@Getter
@NoArgsConstructor
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

    @Override
    public String toString() {
        return "Manufacture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
