package sg.edu.ntu.ftbsolutionscrm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "facebook_logins")
public class FacebookLogin {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "facebook_uid", nullable = false, unique = true)
    private String facebookUid;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacebookUid() {
        return this.facebookUid;
    }

    public void setFacebookUid(String facebookUid) {
        this.facebookUid = facebookUid;
    }    

}
