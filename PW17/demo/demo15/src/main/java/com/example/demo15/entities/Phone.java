package com.example.demo15.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "phones")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Phone {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "phone_seq", sequenceName = "phone_sequence", allocationSize = 1)
    @GeneratedValue(generator = "phone_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "creation_year")
    private int creationYear;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="manufacture_id", insertable = false, updatable = false)
    public Manufacture manufacture;

    @Column(name = "manufacture_id")
    private Long manufactureId;
}
