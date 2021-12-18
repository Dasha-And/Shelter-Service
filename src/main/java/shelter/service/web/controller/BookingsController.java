package shelter.service.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import shelter.service.service.BookingsService;

@RestController
public class BookingsController {

    @Autowired
    BookingsService bookingsService;
}
