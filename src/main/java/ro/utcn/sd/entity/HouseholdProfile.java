package ro.utcn.sd.entity;

import javax.persistence.*;

@Entity
@Table(name = "household_profile")
public class HouseholdProfile {
    @Id
    @GeneratedValue
    private Integer household_profile_id;

    @Column
    private String address;

    @Column
    private String nb_of_members;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "householdProfile")
    private WasteProfile wasteProfile;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public Integer getHousehold_profile_id() {
        return household_profile_id;
    }

    public void setHousehold_profile_id(Integer household_profile_id) {
        this.household_profile_id = household_profile_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNb_of_members() {
        return nb_of_members;
    }

    public void setNb_of_members(String nb_of_members) {
        this.nb_of_members = nb_of_members;
    }

    public WasteProfile getWasteProfile() {
        return wasteProfile;
    }

    public void setWasteProfile(WasteProfile wasteProfile) {
        this.wasteProfile = wasteProfile;
    }
}
