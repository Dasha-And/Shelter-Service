package shelter.service.service;

import org.springframework.stereotype.Service;
import shelter.service.model.Bookings;
import shelter.service.repository.BookingsRepository;

import java.util.List;

@Service
public class BookingsService {
    
    final
    BookingsRepository bookingsRepository;

    public BookingsService(BookingsRepository bookingsRepository) {
        this.bookingsRepository = bookingsRepository;
    }

    public Bookings saveBookings(Bookings bookings) {
        return bookingsRepository.save(bookings);
    }

    public Bookings getBookingsDetailsById(int id) {
        return bookingsRepository.findBookingsById(id);
    }

    public List<Bookings> getBookingsDetails() {
        return bookingsRepository.findAll();
    }

    public Bookings updateBookings(Bookings bookings) {
        return bookingsRepository.save(bookings);
    }

    public void deleteBookings(int id) {
        bookingsRepository.deleteById(id);
    }

    public List<Bookings> findBookingsByAnimal(int animalId) {
        return bookingsRepository.findBookingsByAnimalId(animalId);
    }
}
