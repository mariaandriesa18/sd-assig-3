package ro.utcn.sd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.utcn.sd.entity.Community;

public interface CommunityRepository extends JpaRepository<Community, Integer> {
}
