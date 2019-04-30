package hotel.hour.booking.rest_controller;

import hotel.hour.booking.documents.Habitacion;
import hotel.hour.booking.dtos.HabitacionDto;
import hotel.hour.booking.repositories.HabitacionRepository;
import hotel.hour.booking.rest_controllers.ApiTestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@ApiTestConfig
class HabitacionResourceIT {

    /*@Autowired
    private RestService restService;*/

    @Autowired
    private HabitacionRepository roomRepository;

    private HabitacionDto roomDto;
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
}
