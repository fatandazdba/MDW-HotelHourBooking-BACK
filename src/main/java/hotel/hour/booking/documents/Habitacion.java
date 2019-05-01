package hotel.hour.booking.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Arrays;

@Document
public class Habitacion {

    @Id
    private String id;
    private TipoHabitacion[] tipo;
    private ServicioHabitacion[] servicios;
    private BigDecimal precioHora;
    private BigDecimal precioDia;

    public Habitacion(){

    }

    public Habitacion(String tipo, String servicios, BigDecimal precioHora, BigDecimal precioDia) {
        this.tipo = new TipoHabitacion[]{TipoHabitacion.INDIVIDUAL};
        this.servicios = new ServicioHabitacion[]{ServicioHabitacion.TV};
        this.precioHora = precioHora;
        this.precioDia = precioDia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoHabitacion[] getTipo() {
        return tipo;
    }

    public void setTipo(TipoHabitacion[] tipo) {
        this.tipo = tipo;
    }

    public ServicioHabitacion[] getServicios() {
        return servicios;
    }

    public void setServicios(ServicioHabitacion[] servicios) {
        this.servicios = servicios;
    }

    public BigDecimal getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(BigDecimal precioHora) {
        this.precioHora = precioHora;
    }

    public BigDecimal getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(BigDecimal precioDia) {
        this.precioDia = precioDia;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "id='" + id + '\'' +
                ", tipo=" + Arrays.toString(tipo) +
                ", servicios=" + Arrays.toString(servicios) +
                ", precioHora=" + precioHora +
                ", precioDia=" + precioDia +
                '}';
    }
}
