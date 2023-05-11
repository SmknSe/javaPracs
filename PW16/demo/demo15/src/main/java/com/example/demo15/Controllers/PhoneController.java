package com.example.demo15.Controllers;

import com.example.demo15.entities.Manufacture;
import com.example.demo15.entities.Phone;
import com.example.demo15.services.PhoneService;
import com.example.demo15.services.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PhoneController {
    private final PhoneService serviceTableService;

    @Autowired
    public PhoneController(PhoneService serviceTableService) {
        this.serviceTableService = serviceTableService;
    }

    @PostMapping(value = "/phones",consumes = {"application/json"})
    public ResponseEntity<?> createPhone(@RequestBody Phone phone) {
        serviceTableService.createEntity(phone);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value="/phones")
    public ResponseEntity<List<Phone>> read() {
        final List<Phone> phones = serviceTableService.readAllEntity();
        return phones != null && !phones.isEmpty()
                ? new ResponseEntity<>(phones, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/phones/{id}")
    public ResponseEntity<Phone> read(@PathVariable(name="id") long id) {
        System.out.println("\nqwe");
        final Phone phone = serviceTableService.readOneEntity(id);
        return phone != null
                ? new ResponseEntity<>(phone, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value="/phones/{id}")
    public ResponseEntity<?> update(@PathVariable(name="id") long id, @RequestBody Phone phone) {
        final boolean isUpdated = serviceTableService.updateEntity(phone, id);
        return isUpdated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value="/phones/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") long id) {
        final boolean isDeleted = serviceTableService.deleteEntity(id);
        return isDeleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/phones/{id}/manufacture")
    public Manufacture getPhoneManufacture(@PathVariable("id") Long phoneId){
        return serviceTableService.getManufactureByPhone(phoneId);
    }

}
