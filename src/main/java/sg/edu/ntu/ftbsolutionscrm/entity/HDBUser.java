package sg.edu.ntu.ftbsolutionscrm.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "hdb_user")
public class HDBUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    @NotBlank(message = "First name required")
    private String firstName;
    @Column(name = "last_name")
    @NotBlank(message = "Last name required")
    private String lastName;
    @Column(name = "email")
    @Email(message = "Email should be valid")
    private String email;
    @Column(name = "marital_status")
    @NotBlank(message = "Please state your marital status")
    private Boolean isMarriedBoolean;
    @Column(name = "contact_no")
    @Size(min = 8, max = 8)
    private String contactNo;
    @Column(name = "year_of_birth")
    private int year_of_birth;
    @Column(name = "Close to School")
    private Boolean close_to_school;
    @Column(name = "Close to Mall")
    private Boolean close_to_mall;
    @Column(name = "Close to Public Transportation")
    private Boolean close_to_transportation;
    @Column(name = "Close to Major Roadways")
    private Boolean close_to_roadways;
    
  

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Boolean getIsMarriedBoolean() {
        return isMarriedBoolean;
    }
    public void setIsMarriedBoolean(Boolean isMarriedBoolean) {
        this.isMarriedBoolean = isMarriedBoolean;
    }
    public String getContactNo() {
        return contactNo;
    }
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
    public int getYear_of_birth() {
        return year_of_birth;
    }
    public void setYear_of_birth(int year_of_birth) {
        this.year_of_birth = year_of_birth;
    }
    public Boolean getClose_to_school() {
        return close_to_school;
    }
    public void setClose_to_school(Boolean close_to_school) {
        this.close_to_school = close_to_school;
    }
    public Boolean getClose_to_mall() {
        return close_to_mall;
    }
    public void setClose_to_mall(Boolean close_to_mall) {
        this.close_to_mall = close_to_mall;
    }
    public Boolean getClose_to_transportation() {
        return close_to_transportation;
    }
    public void setClose_to_transportation(Boolean close_to_transportation) {
        this.close_to_transportation = close_to_transportation;
    }
    public Boolean getClose_to_roadways() {
        return close_to_roadways;
    }
    public void setClose_to_roadways(Boolean close_to_roadways) {
        this.close_to_roadways = close_to_roadways;
    }


}
