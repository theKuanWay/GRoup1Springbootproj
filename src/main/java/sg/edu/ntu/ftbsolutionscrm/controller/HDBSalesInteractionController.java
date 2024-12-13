package sg.edu.ntu.ftbsolutionscrm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import sg.edu.ntu.ftbsolutionscrm.service.SalesHDBInteractionService;
import sg.edu.ntu.ftbsolutionscrm.entity.SalesHDBInteraction;
import sg.edu.ntu.ftbsolutionscrm.repository.SalesHDBInteractionRepository;
import sg.edu.ntu.ftbsolutionscrm.repository.SalespersonRepository;
import sg.edu.ntu.ftbsolutionscrm.service.SalesHDBInteractionService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping
public class HDBSalesInteractionController 
{
    private  SalesHDBInteractionService salesHDBInteractionService;

    public HDBSalesInteractionController(SalesHDBInteractionService salesHDBInteractionService )
    {
        this.salesHDBInteractionService = salesHDBInteractionService;
    }
    //create
    @PostMapping("")
    public ResponseEntity<SalesHDBInteraction> saveSalesHDBInteraction(@Valid @RequestBody SalesHDBInteraction salesHDBInteraction) 
    {
        SalesHDBInteraction newSalesHDBInteraction = salesHDBInteractionService.saveSalesHDBInteraction(salesHDBInteraction);
        return new ResponseEntity<>(newSalesHDBInteraction, HttpStatus.CREATED);

    }
    
    //get all
    @GetMapping("")
    public ResponseEntity<List<SalesHDBInteraction>> getAllSalesHDBInteractions()
    {
    return new ResponseEntity<>(salesHDBInteractionService.getAllSalesHDBInteractions(), HttpStatus.OK);
    }



    //read one particular 
    @GetMapping("/{id}")
    public ResponseEntity<SalesHDBInteraction> getSalesHDBInteraction(@PathVariable Long id) { 
        return new ResponseEntity<>(salesHDBInteractionService.getSalesHDBInteraction(id), HttpStatus.OK);

    }
    


    // Delete
  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteSalesHDBInteraction(@PathVariable Long id) {
    salesHDBInteractionService.deleteSalesHDBInteraction(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }



}
