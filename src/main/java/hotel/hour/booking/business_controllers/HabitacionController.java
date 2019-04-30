package hotel.hour.booking.business_controllers;

import hotel.hour.booking.dtos.HabitacionDto;
import hotel.hour.booking.exceptions.NotFoundException;
import hotel.hour.booking.repositories.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HabitacionController {

    @Autowired
    private HabitacionRepository roomRepository;

    public HabitacionDto readRoom(String id) {
        return new HabitacionDto(this.roomRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Habitacion id (" + id + ")")));
    }
}
