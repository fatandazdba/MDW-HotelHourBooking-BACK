package hotel.hour.booking.rest_controllers;

import hotel.hour.booking.business_controllers.ReservaController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ReservaResource.RESERVAS)
public class ReservaResource {
    public static final String RESERVAS = "/reservas";
    public static final String SEARCH = "/search";

    @Autowired
    private ReservaController reservaController;

    @GetMapping(value = SEARCH, produces = {"application/json"})
    public List<String> findHoursAvailableByIdAndDay(@RequestParam String idRoom, @RequestParam String day) {
        return this.reservaController.findHoursAvailableByIdAndDay(idRoom, day);
    }

    @GetMapping(value = SEARCH, produces = {"application/json"})
    public Boolean findDaysAvailableByIdRoom(@RequestParam int id) {
        return this.reservaController.findDaysAvailableByIdRoom(id);
    }
}
