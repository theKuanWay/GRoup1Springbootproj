package sg.edu.ntu.ftbsolutionscrm.service;
import java.util.List;
import sg.edu.ntu.ftbsolutionscrm.entity.SalesHDBInteraction;


public interface SalesHDBInteractionService 
{
    SalesHDBInteraction saveSalesHDBInteraction(SalesHDBInteraction salesHDBInteraction);

    SalesHDBInteraction getSalesHDBInteraction(Long id);
  
    List<SalesHDBInteraction> getAllSalesHDBInteractions();
  
    SalesHDBInteraction updateSalesHDBInteraction(Long id, SalesHDBInteraction salesHDBInteraction);
  
    void deleteSalesHDBInteraction(Long id);
}
