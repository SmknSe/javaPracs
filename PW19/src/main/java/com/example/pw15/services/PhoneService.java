package com.example.pw15.services;

import com.example.pw15.phones.Phone;
import com.example.pw15.repos.PhoneRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PhoneService {

    @Autowired
    private PhoneRepo phoneRepo;

    public Phone save(Phone phone){
        log.info("save phone {}",phone);
        return phoneRepo.save(phone);
    }

    public void deleteById(Long id){
        log.info("delete phone at id {}",id);
        phoneRepo.deleteById(id);
    }

    public Iterable<Phone> findAll(){
        log.info("find all phones");
        return phoneRepo.findAll();
    }

    public List<Phone> getSorted(){
        log.info("find all phones with sort");
        return phoneRepo.findAll(Sort.by("name"));
    }

    public List<Phone> getFiltered(String name){
        log.info("find all phones with name {}",name);
        return phoneRepo.findAllByName(name);
    }
}
