package com.example.pw15.services;

import com.example.pw15.manufactures.Manufacture;
import com.example.pw15.repos.ManufactureRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ManufactureService {

    @Autowired
    private ManufactureRepo manufactureRepo;

    public Manufacture save(Manufacture manufacture){
        log.info("save manufacture {}",manufacture);
        return manufactureRepo.save(manufacture);
    }

    public void deleteById(Long id){
        log.info("delete manufacture at  id {}",id);
        manufactureRepo.deleteById(id);
    }

    public Iterable<Manufacture> findAll(){
        log.info("find all manufactures");
        return manufactureRepo.findAll();
    }

    public List<Manufacture> getFiltered(String name){
        log.info("find all manufactures with name {}",name);
        return manufactureRepo.findAllByName(name);
    }

    public List<Manufacture> getSorted(){
        log.info("find all manufactures with sort");
        return manufactureRepo.findAll(Sort.by("name"));
    }
}
