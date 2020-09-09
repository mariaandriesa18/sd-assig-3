package ro.utcn.sd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.utcn.sd.entity.Calendar;

public interface CalendarRepository extends JpaRepository<Calendar, Integer> {
}
