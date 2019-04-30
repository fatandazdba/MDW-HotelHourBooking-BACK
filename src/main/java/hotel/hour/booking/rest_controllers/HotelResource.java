package hotel.hour.booking.rest_controllers;

import hotel.hour.booking.business_controllers.HotelController;
import hotel.hour.booking.dtos.HabitacionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER') or hasRole('OPERATOR')")
@RestController
@RequestMapping(HotelResource.HOTEL)
public class HotelResource {

    public static final String HOTEL = "/hotels";
    public static final String SEARCH = "/search";

    @Autowired
    private HotelController hotelController;

    @GetMapping(value = SEARCH)
    public List<HabitacionDto> readRoomsByHotelNameAndHotelAddress(@RequestParam String nombre, @RequestParam String direccionPostal) {
        return this.hotelController.findRoomsByNombreAndDireccionPostal(nombre, direccionPostal);
    }

}
