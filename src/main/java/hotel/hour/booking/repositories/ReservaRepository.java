package hotel.hour.booking.repositories;

import hotel.hour.booking.documents.Reserva;
import hotel.hour.booking.dtos.ReservaDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ReservaRepository extends MongoRepository<Reserva, String> {

    @Query(value = "{}", fields = "{ 'Id' : 0 }")
    List<ReservaDto> findAllReservas();

    @Query("{$and:["
            + "?#{ [0] == null ? { $where : 'true'} : { email : {$regex :[0], $options : 'i'} } },"
            + "?#{ [1] == null ? { $where : 'true'} : { username : {$gte :[1]} } },"
            + "?#{ [2] == null ? { $where : 'true'} : { estado : {$gte :[2]} } }"
            + "] }")
    List<ReservaDto> findByEmailAndUsernameAndEstado
            (String email, String username, boolean estado);

}
