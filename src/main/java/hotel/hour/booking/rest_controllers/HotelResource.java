package hotel.hour.booking.rest_controllers;

import hotel.hour.booking.business_controllers.HotelController;
import hotel.hour.booking.dtos.HabitacionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(HotelResource.HOTEL)
public class HotelResource {

    public static final String HOTEL = "/hotels";
    public static final String SEARCH = "/search";

    @Autowired
    private HotelController hotelController;

    @GetMapping(value = SEARCH)
    public List<HabitacionDto> readRoomsByHotelNameAndHotelAddress(@RequestParam String nombre, @RequestParam String direccionPostal) {
        return this.hotelController.findRoomsByNombreAndAddressHotel(nombre, direccionPostal);
    }

}
