package hotel.hour.booking.repositories;

import hotel.hour.booking.documents.Habitacion;
import hotel.hour.booking.dtos.HabitacionDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HabitacionRepository extends MongoRepository<Habitacion, String> {

    @Query (value = "{}", fields = "{ '_id' : 0 }")
    List<HabitacionDto> findAllHabitaciones();

    Optional<Habitacion> findById(String id);

}
