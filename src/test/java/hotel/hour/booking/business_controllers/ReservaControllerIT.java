package hotel.hour.booking.business_controllers;

import hotel.hour.booking.TestConfig;
import hotel.hour.booking.documents.*;
import hotel.hour.booking.dtos.HabitacionDto;
import hotel.hour.booking.dtos.ReservaDto;
import hotel.hour.booking.exceptions.BadRequestException;
import hotel.hour.booking.repositories.ClienteRepository;
import hotel.hour.booking.repositories.HabitacionRepository;
import hotel.hour.booking.repositories.ReservaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class ReservaControllerIT {

    @Autowired
    private ReservaController reservaController;

    @Autowired
    private ReservaRepository reservaRepository;
    @Autowired
    private HabitacionRepository habitacionRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    private ReservaDto reservaDto;
    private Reserva reserva;
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
        Cliente cliente = new Cliente();
        cliente.setDni("1234567F");
        cliente.setId("1");
        cliente.setNombres("Paco");
        cliente.setApellidos("Perez");
        cliente.setPassword("aaaa");
        this.clienteRepository.save(cliente);
        Reserva reserva = new Reserva();
        reserva.setId("1");
        reserva.setHabitacion(room);

        LocalDateTime dateFrom = LocalDateTime.parse("2019-06-01 15:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime dateTo = LocalDateTime.parse("2019-06-01 19:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        reserva.setFechaInicio(dateFrom);
        reserva.setFechaFin(dateTo);
        reserva.setEstado(EstadoReserva.BOOKING);
        reserva.setCliente(cliente);
        this.reservaRepository.save(reserva);

    }

    @Test
    void findHoursAvailableByIdAndDay() {
        List<String> lista = reservaController.findHoursAvailableByIdAndDay("1", "01/06/2019");
        assertTrue(lista.size() == 17);
        assertFalse(lista.contains("15"));
        assertFalse(lista.contains("16"));
        assertFalse(lista.contains("17"));
        assertFalse(lista.contains("18"));
        assertFalse(lista.contains("19"));
        assertFalse(lista.contains("20"));
        assertFalse(lista.contains("21"));
    }

    @Test
    void FindHoursAvailableByIdAndDayReservasEmpty() {
        List<String> lista = reservaController.findHoursAvailableByIdAndDay("1", "11/06/2019");
        assertTrue(lista.size() == 24);
    }

    @Test
    void FindHoursAvailableByIdAndDayReservasHoursTwoDaysIsBegin() {
        Reserva reserva = new Reserva();
        reserva.setId("2");
        reserva.setHabitacion(room);
        LocalDateTime dateFrom = LocalDateTime.parse("2019-06-02 23:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime dateTo = LocalDateTime.parse("2019-06-03 08:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        reserva.setFechaInicio(dateFrom);
        reserva.setFechaFin(dateTo);
        reserva.setEstado(EstadoReserva.BOOKING);
        this.reservaRepository.save(reserva);
        List<String> lista = reservaController.findHoursAvailableByIdAndDay("1", "02/06/2019");
        assertTrue(lista.size() == 23);
    }

    @Test
    void FindHoursAvailableByIdAndDayReservasHoursTwoDaysDayisEnd() {
        Reserva reserva = new Reserva();
        reserva.setId("2");
        reserva.setHabitacion(room);

        LocalDateTime dateFrom = LocalDateTime.parse("2019-06-04 15:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime dateTo = LocalDateTime.parse("2019-06-05 18:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        reserva.setFechaInicio(dateFrom);
        reserva.setFechaFin(dateTo);
        reserva.setEstado(EstadoReserva.BOOKING);
        this.reservaRepository.save(reserva);
        List<String> lista = reservaController.findHoursAvailableByIdAndDay("1", "05/06/2019");
        assertTrue(lista.size() == 4);
    }

    @Test()
    void findHoursAvailableByIdAndDayException() {
        BadRequestException thrown = assertThrows(BadRequestException.class, () ->
                reservaController.findHoursAvailableByIdAndDay("1235", "01/06/2019"));
        assertTrue(thrown.getMessage().contains("Room not found"));
    }
}
