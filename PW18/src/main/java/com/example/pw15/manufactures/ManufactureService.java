package com.example.pw15.manufactures;

import com.example.pw15.repos.ManufactureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufactureService {

    @Autowired
    private ManufactureRepo manufactureRepo;

    public Manufacture save(Manufacture manufacture){
        return manufactureRepo.save(manufacture);
    }

    public void deleteById(Long id){
        manufactureRepo.deleteById(id);
    }

    public Iterable<Manufacture> findAll(){
        return manufactureRepo.findAll();
    }

    public List<Manufacture> getFiltered(String name){
        return manufactureRepo.findAllByName(name);
    }

    public List<Manufacture> getSorted(){
        return manufactureRepo.findAll(Sort.by("name"));
    }
}
