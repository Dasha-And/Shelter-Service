package shelter.service.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shelter.service.model.Bookings;
import shelter.service.service.BookingsService;

import java.util.List;

@RestController
public class BookingsController {

    @Autowired
    BookingsService bookingsService;

    @GetMapping("/bookings")
    public List<Bookings> getByAnimal(@RequestParam int animalId) {
        return bookingsService.findBookingsByAnimal(animalId);
    }

    @PostMapping("/create_booking")
    public ResponseEntity<Bookings> create(@RequestBody Bookings bookings) {
        return new ResponseEntity<>(bookingsService.saveBookings(bookings), HttpStatus.CREATED);
    }
}
