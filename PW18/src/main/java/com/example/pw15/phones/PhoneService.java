package com.example.pw15.phones;

import com.example.pw15.repos.PhoneRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneService {

    @Autowired
    private PhoneRepo phoneRepo;

    public Phone save(Phone phone){
        return phoneRepo.save(phone);
    }

    public void deleteById(Long id){
        phoneRepo.deleteById(id);
    }

    public Iterable<Phone> findAll(){
        return phoneRepo.findAll();
    }

    public List<Phone> getSorted(){
        return phoneRepo.findAll(Sort.by("name"));
    }

    public List<Phone> getFiltered(String name){
        return phoneRepo.findAllByName(name);
    }
}
