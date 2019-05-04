package hotel.hour.booking.business_controllers;

import hotel.hour.booking.documents.Reserva;
import hotel.hour.booking.exceptions.BadRequestException;
import hotel.hour.booking.repositories.HabitacionRepository;
import hotel.hour.booking.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Controller
public class ReservaController {
    @Autowired
    private HabitacionRepository habitacionRepository;
    @Autowired
    private ReservaRepository reservaRepository;


    public List<String> findHoursAvailableByIdAndDay(String idRoom, String day) {
        if (!habitacionRepository.findById(idRoom).isPresent()) {
            throw new BadRequestException("Room not found");

        } else {
            List<Reserva> reservasRoom = this.reservaRepository.findReservasByHabitacionId(idRoom);
            Map<Integer, String> hours = cargarHoras();
            DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate ld = LocalDate.parse(day, DATEFORMATTER);
            LocalDateTime ldt = LocalDateTime.of(ld, LocalDateTime.now().toLocalTime());

            for (Reserva reserva : reservasRoom) {

                LocalDateTime inicioReserva = reserva.getFechaInicio();

                LocalDateTime finReserva = reserva.getFechaFin();

                int horaini = inicioReserva.getHour();
                int horaFin = finReserva.getHour();

                filtradoHoras(ldt, hours, inicioReserva, finReserva, horaini, horaFin);


            }
            return hours.values().stream().collect(Collectors.toList());
        }

    }

    private void filtradoHoras(LocalDateTime ldt, Map<Integer, String> hours, LocalDateTime inicioReserva, LocalDateTime finReserva, int horaini, int horaFin) {
        if (inicioReserva.toLocalDate().equals(ldt.toLocalDate())) {
            if (horaini > horaFin) {
                for (int j = horaini; j < 24; j++) {
                    hours.remove(j);
                }
            } else {
                for (int j = horaini; j <= horaFin + 2; j++) {
                    if (hours.containsKey(j)) {
                        hours.remove(j);
                    }
                }
            }
        } else if (finReserva.toLocalDate().equals(ldt.toLocalDate())) {

            for (int j = 0; j < horaFin + 2; j++) {
                if (hours.containsKey(j)) {
                    hours.remove(j);
                }
            }


        }
    }

    private Map<Integer, String> cargarHoras() {
        Map<Integer, String> hours = new TreeMap<>();

        for (int i = 0; i < 24; i++) {
            String val = String.valueOf(i);
            if (val.length() < 2) {
                val = "0" + val;
            }
            hours.put(i, val + ":00");
        }
        return hours;
    }


}
