package com.example.demo15.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "phones")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Phone {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "phone_seq", sequenceName = "phone_sequence", allocationSize = 1)
    @GeneratedValue(generator = "phone_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "creation_Year")
    private int creationYear;

    @Override
    public String toString() {
        return "Phone{" +
                "name ='" + name + '\'' +
                ", creationYear='" + creationYear+"}";
    }
}
