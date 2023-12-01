package ma.ehtp.project.controller;

import ma.ehtp.project.entities.ObjectData;
import ma.ehtp.project.services.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private ObjectService objectService;

    @GetMapping("/objects")
    public ResponseEntity<List<ObjectData>> getAllObjects() {
        List<ObjectData> objects = objectService.getAllObjects();
        return ResponseEntity.ok(objects);
    }

    @PostMapping("/object")
    public ResponseEntity<Object> addObject(@RequestBody ObjectData object) {
        objectService.addObject(object);
        return ResponseEntity.ok(object);
    }

    @PostMapping("/addRandomObject")
    public ResponseEntity<Object> addRandomObject() {
        objectService.addRandomObject();
        return ResponseEntity.ok("Object with random values added successfully");
    }
}

