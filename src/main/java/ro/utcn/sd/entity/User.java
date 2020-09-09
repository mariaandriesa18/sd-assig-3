package ro.utcn.sd.entity;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    private  String user_id;

    @Column
    private String user_type;

    @Column
    private String user_name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String surname;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "community_id")
    private Community community;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL )
    private HouseholdProfile householdProfile;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private RecyclingInformation recyclingInformation;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public HouseholdProfile getHouseholdProfile() {
        return householdProfile;
    }

    public void setHouseholdProfile(HouseholdProfile householdProfile) {
        this.householdProfile = householdProfile;
    }

    public RecyclingInformation getRecyclingInformation() {
        return recyclingInformation;
    }

    public void setRecyclingInformation(RecyclingInformation recyclingInformation) {
        this.recyclingInformation = recyclingInformation;
    }


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }
}
