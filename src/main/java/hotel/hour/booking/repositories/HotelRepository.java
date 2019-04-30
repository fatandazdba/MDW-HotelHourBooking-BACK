package hotel.hour.booking.repositories;

import hotel.hour.booking.documents.Hotel;
import hotel.hour.booking.dtos.HotelDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface HotelRepository extends MongoRepository<Hotel, String> {

    @Query(value = "{}", fields = "{ 'Id' : 0 }")
    List<HotelDto> findAllHoteles();

    @Query("{$and:["
            + "?#{ [0] == null ? { $where : 'true'} : { nombre : {$regex :[0], $options : 'i'} } },"
            + "?#{ [1] == null ? { $where : 'true'} : { director : {$gte :[1]} } },"
            + "?#{ [2] == null ? { $where : 'true'} : { direccionPostal : {$gte :[2]} } },"
            + "?#{ [3] == null ? { $where : 'true'} : { imagenRepresentativa : {$lte :[3]} } }"
            + "] }")
    List<HotelDto> findByNombreAndDirecctorAndDireccionPostalAndImagen
            (String nombre, Integer String, String direccionPostal, String imagenRepresentativa);

}
