package sg.edu.ntu.ftbsolutionscrm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.ntu.ftbsolutionscrm.entity.HDBUser;
import sg.edu.ntu.ftbsolutionscrm.entity.SalesHDBInteraction;
import sg.edu.ntu.ftbsolutionscrm.entity.Salesperson;
import sg.edu.ntu.ftbsolutionscrm.exception.HDBSalesInteractionNotFoundException;
import sg.edu.ntu.ftbsolutionscrm.repository.SalesHDBInteractionRepository;

@Service
public class SalesHDBInteractionServiceImpl implements SalesHDBInteractionService {

    private SalesHDBInteractionRepository salesHDBInteractionRepository;

    public SalesHDBInteractionServiceImpl(SalesHDBInteractionRepository salesHDBInteractionRepository)
    {
        this.salesHDBInteractionRepository=salesHDBInteractionRepository;
    }


    @Override
    public SalesHDBInteraction saveSalesHDBInteraction(SalesHDBInteraction salesHDBInteraction) 
    {
        SalesHDBInteraction newSalesHDBInteraction=salesHDBInteractionRepository.save(salesHDBInteraction);
        return newSalesHDBInteraction;
    }

    @Override
    public SalesHDBInteraction getSalesHDBInteraction(Long id) {
        return salesHDBInteractionRepository.findById(id).orElseThrow(() -> new HDBSalesInteractionNotFoundException(id));

    }

    @Override
    public List<SalesHDBInteraction> getAllSalesHDBInteractions() {
        return salesHDBInteractionRepository.findAll();
    }

    @Override
    public SalesHDBInteraction updateSalesHDBInteraction(Long id, SalesHDBInteraction salesHDBInteraction) 
    {
        SalesHDBInteraction HDBSaleInteractionToUpdate = salesHDBInteractionRepository.findById(id).orElseThrow(() -> new HDBSalesInteractionNotFoundException(id));
        //HDBSaleInteractionToUpdate.setSalespersonID(salesHDBInteraction.getSalespersonID()); 
       // HDBSaleInteractionToUpdate.setHdbUserId(salesHDBInteraction.getHdbUserId());
       
        HDBSaleInteractionToUpdate.setReview(salesHDBInteraction.getReview());
       
        return salesHDBInteractionRepository.save(HDBSaleInteractionToUpdate);
    
    
    }

    @Override
    public void deleteSalesHDBInteraction(Long id) {
        salesHDBInteractionRepository.deleteById(id);
    }
    
}
