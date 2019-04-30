package hotel.hour.booking.business_controllers;

import hotel.hour.booking.dtos.HabitacionDto;
import hotel.hour.booking.exceptions.NotFoundException;
import hotel.hour.booking.repositories.HabitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HabitacionController {

    @Autowired
    private HabitacionRepository roomRepository;

    public List<HabitacionDto> readAll() {
        return this.roomRepository.findAll().stream().map(HabitacionDto::new).collect(Collectors.toList());
    }

    public HabitacionDto readRoom(String id) {
        return new HabitacionDto(this.roomRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Article id (" + id + ")")));
    }
}
