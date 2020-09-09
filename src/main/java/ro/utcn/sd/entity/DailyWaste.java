package ro.utcn.sd.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "daily_waste")
public class DailyWaste {

    @Id
    @GeneratedValue
    private Integer daiky_waste_id;

    @Column
    private Date  day;

    @Column
    private Integer waste_amount;

    @Column
    private Integer recycled_amount;

    @ManyToOne
    @JoinColumn(name="waste_profile_id")
    private WasteProfile wasteProfile;

    public DailyWaste() {
    }

    public Integer getDaiky_waste_id() {
        return daiky_waste_id;
    }

    public void setDaiky_waste_id(Integer daiky_waste_id) {
        this.daiky_waste_id = daiky_waste_id;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Integer getWaste_amount() {
        return waste_amount;
    }

    public void setWaste_amount(Integer waste_amount) {
        this.waste_amount = waste_amount;
    }

    public Integer getRecycled_amount() {
        return recycled_amount;
    }

    public void setRecycled_amount(Integer recycled_amount) {
        this.recycled_amount = recycled_amount;
    }

    public WasteProfile getWasteProfile() {
        return wasteProfile;
    }

    public void setWasteProfile(WasteProfile wasteProfile) {
        this.wasteProfile = wasteProfile;
    }
}
