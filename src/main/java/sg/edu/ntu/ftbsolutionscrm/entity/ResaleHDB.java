package sg.edu.ntu.ftbsolutionscrm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "resale_hdb")
public class ResaleHDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer month;

    private String town;

    @Column(name = "flat_type")
    private String flatType;

    private String block;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "storey_range")
    private String storeyRange;

    @Column(name = "floor_area_sqm")
    private Double floorAreaSqm;

    @Column(name = "flat_model")
    private String flatModel;

    @Column(name = "lease_commence_date")
    private Integer leaseCommenceDate;

    @Column(name = "remaining_lease")
    private String remainingLease;

    @Column(name = "resale_price")
    private Integer resalePrice;
}
