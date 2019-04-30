package hotel.hour.booking.business_controllers;

import hotel.hour.booking.TestConfig;
import hotel.hour.booking.documents.Habitacion;
import hotel.hour.booking.documents.Hotel;
import hotel.hour.booking.documents.RoomType;
import hotel.hour.booking.dtos.HabitacionDto;
import hotel.hour.booking.exceptions.NotFoundException;
import hotel.hour.booking.repositories.HabitacionRepository;
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

    private Habitacion room;
    private Hotel hotel;

    @BeforeEach
    void seed() {
        this.hotel = new Hotel();
        this.hotel.setId("1");
        this.hotel.setNombre("Palacio de los Veladas");
        this.hotel.setDireccionPostal("05001");
        this.hotel.setDirector("Rodrigo Navarro");
        this.hotel.setImagenRepresentativa("/img/logo.jpg");

        this.room = new Habitacion();
        this.room.setId("1");
        this.room.setHotel(hotel);
        this.room.setPrecioDia(new BigDecimal(50.50));
        this.room.setPrecioHora(new BigDecimal(10.30));
        this.room.setServicios("limpieza de habitación");
        this.room.setTipo(RoomType.DOUBLE);

        this.hotelRepository.save(this.hotel);
    }

    @Test
    void testReadRoomsByNameAndAddressHotel() {
        List<HabitacionDto> rooms = this.hotelController.findRoomsByNombreAndDireccionPostal(this.hotel.getNombre(), this.hotel.getDireccionPostal());

        assertNotNull(rooms);
        assertTrue(rooms.size() > 0);
    }
}
