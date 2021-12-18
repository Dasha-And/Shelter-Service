package shelter.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shelter.service.model.Bookings;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Integer> {

    Bookings findBookingsById(int id);
}
