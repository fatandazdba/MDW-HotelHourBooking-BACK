package hotel.hour.booking.respositories;

import hotel.hour.booking.TestConfig;
import hotel.hour.booking.documents.Habitacion;
import hotel.hour.booking.documents.Hotel;
import hotel.hour.booking.repositories.HabitacionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class HabitacionRepositoryIT {

    @Autowired
    private HabitacionRepository roomRepository;

    private Hotel hotel;
    private Habitacion room;
    private Habitacion room2;

    @BeforeEach
    void seedDb() {
        this.hotel = new Hotel();
        this.hotel.setId("1");
        this.hotel.setNombre("Palacio de los Veladas");
        this.hotel.setDireccionPostal("05001");
        this.hotel.setDirector("Rodrigo Navarro");
        this.hotel.setImagenRepresentativa("/img/logo.jpg");

        this.room = new Habitacion();
        this.room.setId("1");
        this.room.setHotel(this.hotel);
        this.room.setPrecioDia(new BigDecimal(50.50));
        this.room.setPrecioHora(new BigDecimal(10.30));
        this.room.setServicios("limpieza de habitación");
        this.room.setTipo("");

        this.room2 = new Habitacion();
        this.room2.setId("2");
        this.room2.setHotel(this.hotel);
        this.room2.setPrecioDia(new BigDecimal(60.50));
        this.room2.setPrecioHora(new BigDecimal(20.30));
        this.room2.setServicios("limpieza de habitación, servicio de restaurante");
        this.room2.setTipo("");

        this.roomRepository.save(this.room);
        this.roomRepository.save(this.room2);
    }

    @Test
    void testReadAll() {
        assertTrue(this.roomRepository.findAll().size() > 1);
    }

    @Test
    void testFindById() {
        assertTrue(this.roomRepository.findById("1").isPresent());
        assertNotNull(this.roomRepository.findById("1"));
        assertEquals("Palacio de los Veladas", this.roomRepository.findById("1").get().getHotel().getNombre());
    }
}
