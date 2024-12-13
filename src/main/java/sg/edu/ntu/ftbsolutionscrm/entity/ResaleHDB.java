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
public class ResaleHdb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "month")
    private String month;

    @Column(name = "town")
    private String town;

    @Column(name = "flat_type")
    private String flatType;

    @Column(name = "block")
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

    public ResaleHdb() {

    }

    public ResaleHdb(String month, String town, String flatType, String block, String streetName, String storeyRange,
            Double floorAreaSqm, String flatModel, Integer leaseCommenceDate, String remainingLease,
            Integer resalePrice) {
        this.month = month;
        this.town = town;
        this.flatType = flatType;
        this.block = block;
        this.streetName = streetName;
        this.storeyRange = storeyRange;
        this.floorAreaSqm = floorAreaSqm;
        this.flatModel = flatModel;
        this.leaseCommenceDate = leaseCommenceDate;
        this.remainingLease = remainingLease;
        this.resalePrice = resalePrice;
    }
}
