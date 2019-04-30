package hotel.hour.booking.respositories;

import hotel.hour.booking.TestConfig;
import hotel.hour.booking.documents.Habitacion;
import hotel.hour.booking.documents.Hotel;
import hotel.hour.booking.documents.RoomType;
import hotel.hour.booking.repositories.HabitacionRepository;
import hotel.hour.booking.repositories.HotelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class HotelRepositoryIT {

    @Autowired
    private HotelRepository hotelRepository;

    private Hotel hotel;

    @BeforeEach
    void seedDb() {
        this.hotel = new Hotel();
        this.hotel.setId("1");
        this.hotel.setNombre("Palacio de los Veladas");
        this.hotel.setDireccionPostal("05001");
        this.hotel.setDirector("Rodrigo Navarro");
        this.hotel.setImagenRepresentativa("/img/logo.jpg");

        Habitacion room = new Habitacion();
        room.setId("1");
        room.setHotel(hotel);
        room.setPrecioDia(new BigDecimal(50.50));
        room.setPrecioHora(new BigDecimal(10.30));
        room.setServicios("limpieza de habitación");
        room.setTipo(RoomType.INDIVIDUAL);

        this.hotel.getHabitaciones().add(room);

        Habitacion room2 = new Habitacion();
        room2.setId("2");
        room2.setHotel(hotel);
        room2.setPrecioDia(new BigDecimal(60.50));
        room2.setPrecioHora(new BigDecimal(20.30));
        room2.setServicios("limpieza de habitación, servicio de restaurante");
        room2.setTipo(RoomType.SUITE);

        this.hotel.getHabitaciones().add(room2);

        this.hotelRepository.save(this.hotel);
    }

    @Test
    void testFindByNameAndAddressHotel() {
        Hotel hotel = this.hotelRepository.findByNombreAndDireccionPostal(this.hotel.getNombre(), this.hotel.getDireccionPostal());

        assertNotNull(hotel);
        assertEquals(this.hotel.getNombre(), hotel.getNombre());
        assertEquals(this.hotel.getDireccionPostal(), hotel.getDireccionPostal());
    }
}
