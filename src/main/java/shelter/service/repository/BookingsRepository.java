package shelter.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shelter.service.model.Bookings;

import java.util.List;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Integer> {

    Bookings findBookingsById(int id);
    List<Bookings> findBookingsByAnimalId(int animalId);
}
