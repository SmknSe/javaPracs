package com.example.pw15.phones;

import com.example.pw15.manufactures.Manufacture;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="manufacture_id", insertable = false, updatable = false)
    public Manufacture manufacture;

    @Column(name = "manufacture_id")
    private Long manufactureId;
}
