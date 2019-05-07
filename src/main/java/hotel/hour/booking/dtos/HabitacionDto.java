package hotel.hour.booking.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import hotel.hour.booking.documents.Habitacion;
import hotel.hour.booking.documents.ServicioHabitacion;
import hotel.hour.booking.documents.TipoHabitacion;
import hotel.hour.booking.dtos.validations.BigDecimalPositive;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(Include.NON_NULL)
public class HabitacionDto {

    private String id;
    private TipoHabitacion tipo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ServicioHabitacion> servicios;

    @BigDecimalPositive
    private BigDecimal precioHora;

    @BigDecimalPositive
    private BigDecimal precioDia;

    public HabitacionDto() {
        servicios = new ArrayList<>();
    }

    public HabitacionDto(String id, TipoHabitacion tipo, List<ServicioHabitacion> servicios, BigDecimal precioHora, BigDecimal precioDia) {
        this.id = id;
        this.tipo = tipo;
        this.servicios = servicios;
        this.precioHora = precioHora;
        this.precioDia = precioDia;
    }

    public HabitacionDto(Habitacion habitacion) {
        this.id = habitacion.getId();
        this.tipo = habitacion.getTipo();
        this.servicios = habitacion.getServicios();
        this.precioHora = habitacion.getPrecioHora();
        this.precioDia = habitacion.getPrecioDia();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(TipoHabitacion tipo) {
        this.tipo = tipo;
    }

    public List<ServicioHabitacion> getServicios() {
        return servicios;
    }

    public void setServicios(List<ServicioHabitacion> servicios) {
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
        return "HabitacionDto{" +
                "id='" + id + '\'' +
                ", tipo=" + tipo +
                ", servicios=" + servicios +
                ", precioHora=" + precioHora +
                ", precioDia=" + precioDia +
                '}';
    }
}
