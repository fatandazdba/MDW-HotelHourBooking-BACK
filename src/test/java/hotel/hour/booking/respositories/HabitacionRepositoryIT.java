package hotel.hour.booking.respositories;

import hotel.hour.booking.TestConfig;
import hotel.hour.booking.documents.Habitacion;
import hotel.hour.booking.documents.Hotel;
import hotel.hour.booking.documents.ServicioHabitacion;
import hotel.hour.booking.documents.TipoHabitacion;
import hotel.hour.booking.repositories.HabitacionRepository;
import hotel.hour.booking.repositories.HotelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class HabitacionRepositoryIT {

    @Autowired
    private HabitacionRepository roomRepository;

    @Autowired
    private HotelRepository hotelRepository;

    private Habitacion room;
    private Habitacion room2;

    @BeforeEach
    void seedDb() {
        Hotel hotel = new Hotel();
        hotel.setId("10");
        hotel.setNombre("Palacio de los Veladas");
        hotel.setDireccionPostal("05001");
        hotel.setDirector("Rodrigo Navarro");
        hotel.setImagenRepresentativa("/img/logo.jpg");

        this.room = new Habitacion();
        this.room.setId("7");
        this.room.setPrecioDia(new BigDecimal(50.50));
        this.room.setPrecioHora(new BigDecimal(10.30));
        this.room.getServicios().add(ServicioHabitacion.AIRE);
        this.room.getServicios().add(ServicioHabitacion.MINIBAR);
        this.room.setTipo(TipoHabitacion.INDIVIDUAL);

        this.room2 = new Habitacion();
        this.room2.setId("8");
        this.room2.setPrecioDia(new BigDecimal(60.50));
        this.room2.setPrecioHora(new BigDecimal(20.30));
        this.room2.getServicios().add(ServicioHabitacion.JACUZZI);
        this.room2.setTipo(TipoHabitacion.SUITE);
        this.roomRepository.save(this.room);
        this.roomRepository.save(this.room2);
        hotel.getHabitaciones().add(room);
        hotel.getHabitaciones().add(room2);

        this.hotelRepository.save(hotel);
    }

    @Test
    void testFindById() {
        Optional<Habitacion> room = this.roomRepository.findById(this.room.getId());
        assertTrue(room.isPresent());
        assertEquals(this.room.getPrecioDia(), room.get().getPrecioDia());
        assertEquals(this.room.getPrecioHora(), room.get().getPrecioHora());
        assertTrue(room.get().getServicios().size() > 0);
        assertEquals(this.room.getTipo(), TipoHabitacion.INDIVIDUAL);
    }

    @Test
    void testReadAll() {
        assertTrue(this.roomRepository.findAll().size() > 0);
    }
}
