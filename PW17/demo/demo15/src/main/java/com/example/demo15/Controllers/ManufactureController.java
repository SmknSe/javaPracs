package com.example.demo15.Controllers;

import com.example.demo15.entities.Manufacture;
import com.example.demo15.entities.Phone;
import com.example.demo15.services.ManufactureService;
import com.example.demo15.services.TableService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ManufactureController {
    private final ManufactureService serviceTableService;


    @PostMapping(value = "/manufactures",consumes = {"application/json"})
    public ResponseEntity<?> createStudent(@RequestBody Manufacture manufacture) {
        serviceTableService.createEntity(manufacture);
        return new ResponseEntity<>(manufacture,HttpStatus.CREATED);
    }

    @GetMapping(value="/manufactures")
    public ResponseEntity<List<Manufacture>> read() {
        final List<Manufacture> students = serviceTableService.readAllEntity();
        return students != null && !students.isEmpty()
                ? new ResponseEntity<>(students, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/manufactures/{id}")
    public ResponseEntity<Manufacture> read(@PathVariable(name="id") long id) {
        final Manufacture student = serviceTableService.readOneEntity(id);
        return student != null
                ? new ResponseEntity<>(student, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value="/manufactures/{id}")
    public ResponseEntity<?> update(@PathVariable(name="id") long id, @RequestBody Manufacture student) {
        final boolean isUpdated = serviceTableService.updateEntity(student, id);
        return isUpdated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value="/manufactures/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") long id) {
        final boolean isDeleted = serviceTableService.deleteEntity(id);
        return isDeleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(value = "/sort_manufactures")
    public ResponseEntity<List<Manufacture>> getSortedManufactures() {
        final List<Manufacture> manufactures = serviceTableService.sortManufacturesByName();
        return manufactures != null && !manufactures.isEmpty()
                ? new ResponseEntity<>(manufactures, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/manufactures/{name}")
    public ResponseEntity<List<Manufacture>> getFilteredManufactures(@PathVariable(name="name") String name) {
        final List<Manufacture> manufactures = serviceTableService.filterManufacturesByName(name);
        return manufactures != null && !manufactures.isEmpty()
                ? new ResponseEntity<>(manufactures, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
