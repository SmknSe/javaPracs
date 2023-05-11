package com.example.pw15.phones;

import com.example.pw15.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("phones")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @PostMapping
    public Phone save(@RequestBody Phone phone){
        return phoneService.save(phone);
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id){
        System.out.println(id);
        phoneService.deleteById(id);
    }

    @GetMapping
    public Iterable<Phone> findAll(){
        Iterable<Phone> ph =  phoneService.findAll();
        return ph;
    }

    @GetMapping("/id")
    public Phone findById(@RequestParam Long id){
        Iterable<Phone> phones = phoneService.findAll();
        for (Phone p:phones){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    @GetMapping("/sorted")
    public List<Phone> getSorted(){
        return phoneService.getSorted();
    }

    @GetMapping("/filter/{name}")
    public List<Phone> getFiltered(@PathVariable(name = "name") String name){
        return phoneService.getFiltered(name);
    }
}
