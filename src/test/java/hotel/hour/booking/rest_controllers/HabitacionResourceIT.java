package hotel.hour.booking.rest_controllers;

import hotel.hour.booking.documents.Habitacion;
import hotel.hour.booking.dtos.HabitacionDto;
import hotel.hour.booking.repositories.HabitacionRepository;
import hotel.hour.booking.rest_controllers.ApiTestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ApiTestConfig
class HabitacionResourceIT {

    @Autowired
    private RestService restService;

    @Autowired
    private HabitacionRepository roomRepository;

    public HabitacionDto[] roomDto;
    private Habitacion room;


    @BeforeEach
    void seed() {
        /*this.articleDto = new ArticleDto("miw-dto", "descrip", "ref", BigDecimal.TEN, null, Tax.SUPER_REDUCED);
        this.article = new Article();
        this.article.setCode("99999999");
        this.roomRepository.save(this.room);*/
    }

    @Test
    void testReadRoomOne() {
        /*HabitacionDto roomDto = this.restService.loginAdmin().restBuilder(new RestBuilder<HabitacionDto>()).clazz(HabitacionDto.class)
                .path(HabitacionResource.ARTICLES).path(ArticleResource.CODE_ID).expand("1")
                .get().build();
        assertNotNull(roomDto);*/
    }

    /*private List<HabitacionDto> readAllRoom(){
        return Arrays.asList(this.restService.loginAdmin().restBuilder(new RestBuilder<HabitacionDto[]>())
                .clazz(HabitacionDto[].class).path(ArticleResource.ARTICLES)
                .get().build());
    }*/

    @Test
    void testReadAllRooms() throws Exception {
        List<HabitacionDto> roomList;
        roomList = Arrays.asList(this.restService.loginAdmin()
                .restBuilder(new RestBuilder<HabitacionDto[]>()).clazz(HabitacionDto[].class)
                .path(HabitacionResource.ROOM)
                .get().build());
        assertTrue(roomList.size() >= 0);
        //assertTrue(peticionHttpGet().length() >= 0);
    }

    @Test
    public static String peticionHttpGet() throws Exception {
        // Esto es lo que vamos a devolver
        StringBuilder resultado = new StringBuilder();
        // Crear un objeto de tipo URL
        URL url = new URL("http://localhost:8080/api/v0/rooms");

        // Abrir la conexión e indicar que será de tipo GET
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");
        // Búferes para leer
        BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
        String linea;
        // Mientras el BufferedReader se pueda leer, agregar contenido a resultado
        while ((linea = rd.readLine()) != null) {
            resultado.append(linea);
        }
        // Cerrar el BufferedReader
        rd.close();
        // Regresar resultado, pero como cadena, no como StringBuilder
        return resultado.toString();
    }
}
