package com.example.pw15.repos;

import com.example.pw15.entities.Manufacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManufactureRepo extends JpaRepository<Manufacture,Long> {
    List<Manufacture> findAllByName(String name);

}
