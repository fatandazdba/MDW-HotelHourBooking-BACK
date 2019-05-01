package hotel.hour.booking.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import hotel.hour.booking.documents.Habitacion;
import hotel.hour.booking.documents.ServicioHabitacion;
import hotel.hour.booking.documents.TipoHabitacion;

import java.math.BigDecimal;
import java.util.Arrays;

@JsonInclude(Include.NON_NULL)
public class HabitacionDto {

    private String id;
    private TipoHabitacion[] tipo;
    private ServicioHabitacion[] servicios;
    private BigDecimal precioHora;
    private BigDecimal precioDia;

    public HabitacionDto() {
    }

    public HabitacionDto(Habitacion habitacion){
        this.id=habitacion.getId();
        this.tipo = new TipoHabitacion[]{TipoHabitacion.INDIVIDUAL};
        this.servicios = new ServicioHabitacion[]{ServicioHabitacion.TV};
        this.precioHora=habitacion.getPrecioHora();
        this.precioDia=habitacion.getPrecioDia();
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
        return "HabitacionDto{" +
                "id='" + id + '\'' +
                ", tipo=" + Arrays.toString(tipo) +
                ", servicios=" + Arrays.toString(servicios) +
                ", precioHora=" + precioHora +
                ", precioDia=" + precioDia +
                '}';
    }
}
