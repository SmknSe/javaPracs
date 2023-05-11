package com.example.pw15.services;

import com.example.pw15.entities.Phone;
import com.example.pw15.repos.PhoneRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class PhoneService {

    @Autowired
    private PhoneRepo phoneRepo;
    @Autowired
    private EmailService emailService;

    public Phone save(Phone phone) {
        log.info("save phone {}",phone);
        emailService.sendEmail(phone.toString());
        return phoneRepo.save(phone);
    }

    public void deleteById(Long id){
        log.info("delete phone at id {}",id);
        phoneRepo.deleteById(id);
    }

    public Iterable<Phone> findAll(){
        log.info("find all phones.txt");
        return phoneRepo.findAll();
    }

    public List<Phone> getSorted(){
        log.info("find all phones.txt with sort");
        return phoneRepo.findAll(Sort.by("name"));
    }

    public List<Phone> getFiltered(String name){
        log.info("find all phones.txt with name {}",name);
        return phoneRepo.findAllByName(name);
    }
}
