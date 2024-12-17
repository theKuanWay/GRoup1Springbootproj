package sg.edu.ntu.ftbsolutionscrm.controller;

import sg.edu.ntu.ftbsolutionscrm.entity.Salesperson;
//import sg.edu.ntu.ftbsolutionscrm.service.SalesPersonService;
import sg.edu.ntu.ftbsolutionscrm.service.SalesPersonService;
import org.springframework.web.bind.annotation.RestController;



import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/salesperson")
public class SalesperonController 
{

private SalesPersonService salesPersonService;



    public SalesperonController(SalesPersonService salesPersonService)
    {
        this.salesPersonService=salesPersonService;
    }

    //Create Salesperson
 @PostMapping("")
    public ResponseEntity<Salesperson> createSalePerson(@Valid @RequestBody Salesperson salesperson) 
    {
     Salesperson newNewSalesPerson = salesPersonService.createSalePerson(salesperson);
     return new ResponseEntity<>(newNewSalesPerson,HttpStatus.CREATED);
    }
//read one salesperson
@GetMapping("/{id}")
  public ResponseEntity<Salesperson> getSalesPerson(@PathVariable Long id) {
    return new ResponseEntity<>(salesPersonService.getSalesPerson(id), HttpStatus.OK);
  }

  //get all Salespersons
  @GetMapping("")
  public ResponseEntity<List<Salesperson>> getAllSalesPerson() {
    return new ResponseEntity<>(salesPersonService.getAllSalesPerson(), HttpStatus.OK);
  }

   // Update
  @PutMapping("/{id}")
  public ResponseEntity<Salesperson> updateSalesPerson(@PathVariable Long id, @RequestBody Salesperson salesperson) {
    Salesperson updatedSalesperson = salesPersonService.updateSalesPerson(id, salesperson);
    return new ResponseEntity<>(updatedSalesperson, HttpStatus.OK);
  }


  // Delete
  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteSalesPerson(@PathVariable Long id) {
    salesPersonService.deleteSalesPerson(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }


  // localhost:8080/customers/search?firstName=Stephen
  @GetMapping("/search")
  public ResponseEntity <List<Salesperson>> searchSalesperson(@RequestParam String firstName) {
    List<Salesperson> foundSalesperson = salesPersonService.getSalespersonbyFirstName(firstName);
    return new ResponseEntity<>(foundSalesperson, HttpStatus.OK);
  }





}
