package hotel.hour.booking.business_controllers;

import hotel.hour.booking.TestConfig;
import hotel.hour.booking.documents.Habitacion;
import hotel.hour.booking.documents.Hotel;
import hotel.hour.booking.documents.ServicioHabitacion;
import hotel.hour.booking.documents.TipoHabitacion;
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
class HabitacionControllerIT {

    @Autowired
    private HabitacionController roomController;

    @Autowired
    private HabitacionRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;

    private Habitacion room;
    private Habitacion room2;

    @BeforeEach
    void seed() {
        Hotel hotel = new Hotel();
        hotel.setId("1");
        hotel.setNombre("Palacio de los Veladas");
        hotel.setDireccionPostal("05001");
        hotel.setDirector("Rodrigo Navarro");
        hotel.setImagenRepresentativa("/img/logo.jpg");

        this.room = new Habitacion();
        this.room.setId("1");
        this.room.setPrecioDia(new BigDecimal(50.50));
        this.room.setPrecioHora(new BigDecimal(10.30));
        this.room.getServicios().add(ServicioHabitacion.AIRE);
        this.room.getServicios().add(ServicioHabitacion.MINIBAR);
        this.room.setTipo(TipoHabitacion.INDIVIDUAL);

        this.room2 = new Habitacion();
        this.room2.setId("2");
        this.room2.setPrecioDia(new BigDecimal(60.50));
        this.room2.setPrecioHora(new BigDecimal(20.30));
        this.room2.getServicios().add(ServicioHabitacion.JACUZZI);
        this.room2.setTipo(TipoHabitacion.SUITE);

        hotel.getHabitaciones().add(room);
        hotel.getHabitaciones().add(room2);

        this.hotelRepository.save(hotel);
    }

    @Test
    void testNotFoundException() {
        assertThrows(NotFoundException.class, () -> this.roomController.readRoom("non-exist"));
    }

    @Test
    void testReadRoom() {
        assertNotNull(this.roomController.readRoom("1"));
    }

    @Test
    void testReadAllRooms() {
        List<HabitacionDto> rooms = this.roomController.readAll();
        assertNotNull(rooms);
        assertTrue(rooms.size() > 0);
    }
}
