package com.example.pw15.repos;

import com.example.pw15.phones.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepo extends JpaRepository<Phone,Long> {
    public List<Phone> findAllByName(String name);

}
