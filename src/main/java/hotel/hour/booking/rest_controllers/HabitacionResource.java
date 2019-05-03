package hotel.hour.booking.rest_controllers;

import hotel.hour.booking.business_controllers.HabitacionController;
import hotel.hour.booking.dtos.HabitacionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('OPERATOR')")
@RestController
@RequestMapping(HabitacionResource.ROOM)
public class HabitacionResource {

    public static final String ROOM = "/rooms";
    public static final String CODE_ID = "/{id}";

    @Autowired
    private HabitacionController roomController;

    @GetMapping
    public List<HabitacionDto> readAll() {
        return this.roomController.readAll();
    }

    @GetMapping(value = CODE_ID)
    public HabitacionDto readRoom(@PathVariable String id) {
        return this.roomController.readRoom(id);
    }

}
