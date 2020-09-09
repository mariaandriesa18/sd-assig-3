package ro.utcn.sd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.utcn.sd.entity.WasteProfile;

public interface WasteProfileRepository extends JpaRepository<WasteProfile, Integer> {
}
