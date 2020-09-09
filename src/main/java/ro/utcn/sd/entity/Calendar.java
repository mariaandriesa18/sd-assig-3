package ro.utcn.sd.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "calendar")
public class Calendar {

    @Id
    @GeneratedValue
    private Integer calendar_id;

    @Column
    private String requestor;

    @Column
    private Date waste_collection_date;

    @OneToOne
    @JoinColumn(name = "household_profile_id")
    private HouseholdProfile householdProfile;

    public Calendar() { }

    public Integer getCalendar_id() {
        return calendar_id;
    }

    public void setCalendar_id(Integer calendar_id) {
        this.calendar_id = calendar_id;
    }

    public String getRequestor() {
        return requestor;
    }

    public void setRequestor(String requestor) {
        this.requestor = requestor;
    }

    public Date getWaste_collection_date() {
        return waste_collection_date;
    }

    public void setWaste_collection_date(Date waste_collection_date) {
        this.waste_collection_date = waste_collection_date;
    }

    public HouseholdProfile getHouseholdProfile() {
        return householdProfile;
    }

    public void setHouseholdProfile(HouseholdProfile householdProfile) {
        this.householdProfile = householdProfile;
    }


}
