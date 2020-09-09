package ro.utcn.sd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.utcn.sd.entity.RecyclingInformation;

public interface RecyclingInformationRepository extends JpaRepository<RecyclingInformation, Integer> {
    
}
