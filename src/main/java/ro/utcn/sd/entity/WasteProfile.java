package ro.utcn.sd.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "waste_profile")
public class WasteProfile {

    @Id
    @GeneratedValue
    private Integer waste_profile_id;

    @Column
    private Integer waste_amount_per_month;

    @Column
    private Integer recycled_amount_per_month;

    @OneToOne
    @JoinColumn(name = "household_profile_id")
    private HouseholdProfile householdProfile;

    @OneToMany(mappedBy = "wasteProfile")
    private List<DailyWaste> dailyWasteList;

    public WasteProfile() {

    }

    public Integer getWaste_profile_id() {
        return waste_profile_id;
    }

    public void setWaste_profile_id(Integer waste_profile_id) {
        this.waste_profile_id = waste_profile_id;
    }

    public HouseholdProfile getHouseholdProfile() {
        return householdProfile;
    }

    public void setHouseholdProfile(HouseholdProfile householdProfile) {
        this.householdProfile = householdProfile;
    }

    public Integer getWaste_amount_per_month() {
        return waste_amount_per_month;
    }

    public void setWaste_amount_per_month(Integer waste_amount_per_month) {
        this.waste_amount_per_month = waste_amount_per_month;
    }

    public Integer getRecycled_amount_per_month() {
        return recycled_amount_per_month;
    }

    public void setRecycled_amount_per_month(Integer recycled_amount_per_month) {
        this.recycled_amount_per_month = recycled_amount_per_month;
    }

    public List<DailyWaste> getDailyWasteList() {
        return dailyWasteList;
    }

    public void setDailyWasteList(List<DailyWaste> dailyWasteList) {
        this.dailyWasteList = dailyWasteList;
    }
}
