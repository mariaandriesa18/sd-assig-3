package ro.utcn.sd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.utcn.sd.entity.Award;

public interface AwardRepository extends JpaRepository<Award, Integer> {
}
