package sg.edu.ntu.ftbsolutionscrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.Getter;
import lombok.Setter;
import sg.edu.ntu.ftbsolutionscrm.entity.ResaleHdb;
import sg.edu.ntu.ftbsolutionscrm.service.ResaleHDBService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resale-hdb")
@Setter
@Getter
public class ResaleHdbController {

    @Autowired
    private ResaleHDBService resaleHDBService;

    @GetMapping("")
    public ResponseEntity<List<ResaleHdb>> getAllResaleHDB() {
        return new ResponseEntity<>(resaleHDBService.getAllResaleHDB(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ResaleHdb>> getResaleHDBById(@PathVariable Long id) {
        return new ResponseEntity<>(resaleHDBService.getResaleHDBById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResaleHdb> createResaleHDB(@RequestBody ResaleHdb resaleHDB) {
        return new ResponseEntity<>(resaleHDBService.saveResaleHDB(resaleHDB), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResaleHdb> updateResaleHDB(@PathVariable Long id, @RequestBody ResaleHdb resaleHDBDetails) {
        ResaleHdb updatedResaleHDB = resaleHDBService.updatResaleHDB(id, resaleHDBDetails);
        return new ResponseEntity<>(updatedResaleHDB, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResaleHDB(@PathVariable Long id) {
        if (resaleHDBService.getResaleHDBById(id).isPresent()) {
            resaleHDBService.deleteResaleHDB(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
