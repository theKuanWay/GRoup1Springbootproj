package sg.edu.ntu.ftbsolutionscrm.exception;

public class SalesPersonNotFoundException extends RuntimeException {
    public SalesPersonNotFoundException(Long id){
        super("Could not find Salesperson with id: "+ id + ".");
    }
    
}
