package hotel.hour.booking.repositories;

import hotel.hour.booking.documents.Cliente;
import hotel.hour.booking.dtos.ClienteDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

    @Query(value = "{}", fields = "{ 'Id' : 0 }")
    List<ClienteDto> findAllCliente();

    Optional<Cliente> findById(String id);
}
