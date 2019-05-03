package hotel.hour.booking.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document
public class Habitacion {

    @Id
    private String id;
    private TipoHabitacion tipo;
    private List<ServicioHabitacion> servicios;
    private BigDecimal precioHora;
    private BigDecimal precioDia;

    public Habitacion() {
        this.servicios = new ArrayList<>();
    }

    public Habitacion(String id, TipoHabitacion tipo, List<ServicioHabitacion> servicios, BigDecimal precioHora, BigDecimal precioDia) {
        this.id = id;
        this.tipo = tipo;
        this.servicios = servicios;
        this.precioHora = precioHora;
        this.precioDia = precioDia;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habitacion that = (Habitacion) o;
        return Objects.equals(id, that.id) &&
                tipo == that.tipo &&
                Objects.equals(servicios, that.servicios) &&
                Objects.equals(precioHora, that.precioHora) &&
                Objects.equals(precioDia, that.precioDia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo, servicios, precioHora, precioDia);
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "id='" + id + '\'' +
                ", tipo=" + tipo +
                ", servicios=" + servicios +
                ", precioHora=" + precioHora +
                ", precioDia=" + precioDia +
                '}';
    }
}
