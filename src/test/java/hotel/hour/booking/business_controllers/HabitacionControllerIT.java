package hotel.hour.booking.business_controllers;

import hotel.hour.booking.TestConfig;
import hotel.hour.booking.documents.Habitacion;
import hotel.hour.booking.documents.Hotel;
import hotel.hour.booking.documents.ServicioHabitacion;
import hotel.hour.booking.documents.TipoHabitacion;
import hotel.hour.booking.dtos.HabitacionDto;
import hotel.hour.booking.exceptions.NotFoundException;
import hotel.hour.booking.repositories.HabitacionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class HabitacionControllerIT {

    @Autowired
    private HabitacionController roomController;

    @Autowired
    private HabitacionRepository roomRepository;

    private HabitacionDto roomnDto;
    private Habitacion room;

    @BeforeEach
    void seed() {
        Hotel hotel = new Hotel();
        hotel.setId("1");
        hotel.setNombre("Palacio de los Veladas");
        hotel.setDireccionPostal("05001");
        hotel.setDirector("Rodrigo Navarro");
        hotel.setImagenRepresentativa("/img/logo.jpg");

        this.roomnDto = new HabitacionDto();

        this.room = new Habitacion();
        this.room.setId("1");
        this.room.setPrecioDia(new BigDecimal(50.50));
        this.room.setPrecioHora(new BigDecimal(10.30));
        this.room.getServicios().add(ServicioHabitacion.JACUZZI);
        this.room.getServicios().add(ServicioHabitacion.INTERNET);
        this.room.setTipo(TipoHabitacion.DOBLE);

        this.roomRepository.save(this.room);
    }

    @Test
    void testNotFoundException() {
        assertThrows(NotFoundException.class, () -> this.roomController.readRoom("non-exist"));
    }

    @Test
    void testReadRoom() {
        assertNotNull(this.roomController.readRoom("1"));
    }
}
