package com.example.pw15.manufactures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("manufactures")
public class ManufactureController {
    @Autowired
    private ManufactureService manufactureService;

    @PostMapping
    public Manufacture save(@RequestBody Manufacture manufacture){
        return manufactureService.save(manufacture);
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id){
        manufactureService.deleteById(id);
    }

    @GetMapping
    public Iterable<Manufacture> findAll(){
        Iterable<Manufacture> mf =  manufactureService.findAll();
        return mf;
    }

    @GetMapping("/sorted")
    public List<Manufacture> getSorted(){
        return manufactureService.getSorted();
    }

    @GetMapping("/filter/{name}")
    public List<Manufacture> getFiltered(@PathVariable(name="name") String name){
        return manufactureService.getFiltered(name);
    }


}
