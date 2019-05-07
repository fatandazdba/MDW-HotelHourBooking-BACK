package hotel.hour.booking.rest_controllers;

import hotel.hour.booking.business_controllers.ReservaController;
import hotel.hour.booking.documents.Reserva;
import hotel.hour.booking.dtos.ReservaDto;
import hotel.hour.booking.repositories.ReservaRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;


@ApiTestConfig
public class ReservasResourceIT {
    @Autowired
    private RestService restService;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ReservaController reservaController;

    private List<Reserva> initialReservaDB;
    private ReservaDto reservaDto;

    @BeforeEach
    void backupReservasDB() {

        initialReservaDB = this.reservaRepository.findAll();
        Reserva reserva = new Reserva();
        reserva.setId("13");
        reserva.setFechaInicio(LocalDateTime.now());
        reserva.setFechaFin(LocalDateTime.now().plusHours(2));
        Reserva reservabbdd = reservaRepository.save(reserva);
        this.reservaDto = new ReservaDto(reservabbdd);
    }

    @AfterEach
    void resetTicketDB() {
        this.reservaRepository.deleteAll();
        this.reservaRepository.saveAll(this.initialReservaDB);
    }

    @Test
    void testSearchReservaswithParamIdRoomAndDay() {

/*        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String day = LocalDateTime.now().format(formatters);
        List<?> hours = Arrays.asList(
                this.restService.restBuilder().port(8080)
                        .path(ReservaResource.RESERVAS)
                        .path(ReservaResource.SEARCH+"?idRoom=1&day="+day).get().build());
        assertTrue(hours.size()>0);*/
    }

    @Test
    void testSearchReservasByIdAndIdRoomWithinParams() {
     /*   HttpClientErrorException exception = assertThrows(HttpClientErrorException.class, () ->
                this.restService.restBuilder().port(8080)
                        .path(ReservaResource.RESERVAS)
                        .path(ReservaResource.SEARCH)
                        .get().build());
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());*/
    }

    @Test
    void testSearchByDateAndRoomThrowBadRequest() {

    /*    String[] res = (String[]) this.restService.restBuilder()
                .path(ReservaResource.RESERVAS)
                .path(ReservaResource.SEARCH)
                .param("idRoom", "123459")
                .param("day", "01/06/2019")
                .get().build();*/
        // assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }

    @Test
    void testfindHoursAvailableByIdAndDay(){
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String day = LocalDateTime.now().format(formatters);
        List<?> hours = Arrays.asList(
                this.restService.restBuilder().port(8080)
                        .path(ReservaResource.RESERVAS)
                        .path(ReservaResource.SEARCH+"?idRoom=1&day="+day).get().build());
        assert (hours.size()>0);
    }
}
