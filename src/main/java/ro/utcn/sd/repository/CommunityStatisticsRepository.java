package ro.utcn.sd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.utcn.sd.entity.CommunityStatistics;

public interface CommunityStatisticsRepository extends JpaRepository<CommunityStatistics , Integer> {
}
