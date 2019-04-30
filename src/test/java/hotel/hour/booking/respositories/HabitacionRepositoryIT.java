package hotel.hour.booking.respositories;

import hotel.hour.booking.TestConfig;
import hotel.hour.booking.documents.Habitacion;
import hotel.hour.booking.documents.Hotel;
import hotel.hour.booking.repositories.HabitacionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class HabitacionRepositoryIT {

    @Autowired
    private HabitacionRepository roomRepository;

    private Habitacion room;
    private Habitacion room2;

    @BeforeEach
    void seedDb() {
        Hotel hotel = new Hotel();
        hotel.setId("1");
        hotel.setNombre("Palacio de los Veladas");
        hotel.setDireccionPostal("05001");
        hotel.setDirector("Rodrigo Navarro");
        hotel.setImagenRepresentativa("/img/logo.jpg");

        this.room = new Habitacion();
        this.room.setId("1");
        this.room.setHotel(hotel);
        this.room.setPrecioDia(new BigDecimal(50.50));
        this.room.setPrecioHora(new BigDecimal(10.30));
        this.room.setServicios("limpieza de habitación");
        this.room.setTipo("");

        this.room2 = new Habitacion();
        this.room2.setId("2");
        this.room2.setHotel(hotel);
        this.room2.setPrecioDia(new BigDecimal(60.50));
        this.room2.setPrecioHora(new BigDecimal(20.30));
        this.room2.setServicios("limpieza de habitación, servicio de restaurante");
        this.room2.setTipo("");

        this.roomRepository.save(this.room);
        this.roomRepository.save(this.room2);
    }

    @Test
    void testFindById() {
        Optional<Habitacion> room = this.roomRepository.findById(this.room.getId());
        assertTrue(room.isPresent());
        assertEquals(this.room.getPrecioDia(), room.get().getPrecioDia());
        assertEquals(this.room.getPrecioHora(), room.get().getPrecioHora());
        assertEquals(this.room.getServicios(), room.get().getServicios());
        assertEquals(this.room.getTipo(), room.get().getTipo());
    }
}
