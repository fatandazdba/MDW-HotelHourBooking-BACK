package hotel.hour.booking.business_controllers;

import hotel.hour.booking.TestConfig;
import hotel.hour.booking.documents.Habitacion;
import hotel.hour.booking.documents.Hotel;
import hotel.hour.booking.documents.ServicioHabitacion;
import hotel.hour.booking.documents.TipoHabitacion;
import hotel.hour.booking.dtos.HabitacionDto;
import hotel.hour.booking.repositories.HotelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class HotelControllerIT {

    @Autowired
    private HotelController hotelController;

    @Autowired
    private HotelRepository hotelRepository;

    private Hotel hotel;

    @BeforeEach
    void seed() {
        this.hotel = new Hotel();
        this.hotel.setId("1");
        this.hotel.setNombre("Palacio de los Veladas");
        this.hotel.setDireccionPostal("05001");
        this.hotel.setDirector("Rodrigo Navarro");
        this.hotel.setImagenRepresentativa("/img/logo.jpg");

        Habitacion room = new Habitacion();
        room.setId("1");
        room.setPrecioDia(new BigDecimal(50.50));
        room.setPrecioHora(new BigDecimal(10.30));
        room.getServicios().add(ServicioHabitacion.AIRE);
        room.setTipo(TipoHabitacion.DOBLE);

        this.hotel.getHabitaciones().add(room);

        this.hotelRepository.save(this.hotel);
    }

    @Test
    void testReadRoomsByNameAndAddressHotel() {
        List<HabitacionDto> rooms = this.hotelController.findRoomsByNombreAndAddressHotel(this.hotel.getNombre(), this.hotel.getDireccionPostal());

        assertNotNull(rooms);
        assertTrue(rooms.size() > 0);
    }
}
