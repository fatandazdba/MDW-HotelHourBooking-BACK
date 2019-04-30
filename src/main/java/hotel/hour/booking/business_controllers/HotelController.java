package hotel.hour.booking.business_controllers;

import hotel.hour.booking.documents.Habitacion;
import hotel.hour.booking.documents.Hotel;
import hotel.hour.booking.dtos.HabitacionDto;
import hotel.hour.booking.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    public List<HabitacionDto> findRoomsByNombreAndDireccionPostal(String nombre, String direccionPostal) {

        Hotel hotel = this.hotelRepository.findByNombreAndDireccionPostal(nombre, direccionPostal);

        List<HabitacionDto> dtos = new ArrayList<>();
        /*for (Habitacion room : rooms) {
            dtos.add(new HabitacionDto(room));
        }*/
        return dtos;
    }
}
