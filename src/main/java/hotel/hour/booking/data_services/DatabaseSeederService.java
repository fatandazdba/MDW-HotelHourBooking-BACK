package hotel.hour.booking.data_services;

import hotel.hour.booking.documents.Cliente;
import hotel.hour.booking.documents.EstadoReserva;
import hotel.hour.booking.documents.Reserva;
import hotel.hour.booking.repositories.ClienteRepository;
import hotel.hour.booking.repositories.HabitacionRepository;
import hotel.hour.booking.repositories.HotelRepository;
import hotel.hour.booking.repositories.ReservaRepository;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

@Service
public class DatabaseSeederService {
    private static final String VARIOUS_CODE = "1";

    private static final String VARIOUS_NAME = "Varios";

    private static final String PREFIX_CODE_ARTICLE = "84";

    private static final Long FIRST_CODE_ARTICLE = 840000000000L;

    private static final Long LAST_CODE_ARTICLE = 840000099999L;

    @Autowired
    public ClienteRepository clienteRepository;
    @Autowired
    public HabitacionRepository habitacionRepository;
    @Autowired
    public HotelRepository hotelRepository;
    @Autowired
    public ReservaRepository reservaRepository;
    @Autowired
    private Environment environment;


    @Value("${miw.databaseSeeder.ymlFileName:#{null}}")
    private String ymlFileName;

    @PostConstruct
    public void constructor() {
        String[] profiles = this.environment.getActiveProfiles();
        if (Arrays.stream(profiles).anyMatch("dev"::equals)) {
            this.deleteAllAndInitializeAndLoadYml();
        } else if (Arrays.stream(profiles).anyMatch("prod"::equals)) {
            this.initialize();
        }
    }

    private void initialize() {
        Cliente cliente = null;
        if (!this.clienteRepository.findById(this.VARIOUS_CODE).isPresent()) {
            cliente = new Cliente("0105139711","Juan","Lopez","juanlopez@hotmail.com","juan2019","66645856","calle atocha");
            this.clienteRepository.save(cliente);
        }
        Optional<Reserva> reserva = this.reservaRepository.findById("12");
        if (reserva.isPresent()) {
            reserva.get().setFechaInicio(LocalDateTime.now());
            reserva.get().setFechaFin(LocalDateTime.now().plusHours(1));
            reserva.get().setHabitacion(this.habitacionRepository.findById("1").get());
            reserva.get().setEstado(EstadoReserva.PAY_PENDING);
            this.reservaRepository.save(reserva.get());
        }



    }

    public void deleteAllAndInitialize() {
        LogManager.getLogger(this.getClass()).warn("------- Delete All -----------");
        // Delete Repositories -----------------------------------------------------
        this.clienteRepository.deleteAll();
        this.habitacionRepository.deleteAll();

        this.hotelRepository.deleteAll();
        this.reservaRepository.deleteAll();
        // -------------------------------------------------------------------------
        this.initialize();
    }

    public void deleteAllAndInitializeAndLoadYml() {
        this.deleteAllAndInitialize();
        this.seedDatabase();
        this.initialize();
    }

    public void seedDatabase() {
        if (this.ymlFileName != null) {
            try {
                LogManager.getLogger(this.getClass()).warn("------- Initial Load: " + this.ymlFileName + "-----------");
                this.seedDatabase(new ClassPathResource(this.ymlFileName).getInputStream());
            } catch (IOException e) {
                LogManager.getLogger(this.getClass()).error("File " + this.ymlFileName + " doesn't exist or can't be opened");
            }
        } else {
            LogManager.getLogger(this.getClass()).error("File db.yml doesn't configured");
        }


    }

    public void seedDatabase(InputStream input) {
        Yaml yamlParser = new Yaml(new Constructor(DatabaseGraph.class));
        DatabaseGraph dbservice = yamlParser.load(input);

        this.clienteRepository.saveAll(dbservice.getClienteList());
        this.habitacionRepository.saveAll(dbservice.getHabitacionList());
        this.hotelRepository.saveAll(dbservice.getHotelList());
        this.reservaRepository.saveAll(dbservice.getReservaList());

        LogManager.getLogger(this.getClass()).warn("------- Seed...   " + "-----------");
    }



}
