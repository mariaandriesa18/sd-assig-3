package ro.utcn.sd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.utcn.sd.entity.HouseholdProfile;

public interface HouseholdProfileRepository extends JpaRepository<HouseholdProfile,  Integer> {



}
