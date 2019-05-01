package hotel.hour.booking.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document
public class Reserva {

    @Id
    private String id;
    private long fechaInicio;
    private long fechaFin;
    @DBRef
    private Habitacion habitacion;
    @DBRef
    private Cliente cliente;
    private EstadoReserva[] estados;
    private String codigoReserva;
    private double precioTotal;

    public Reserva(){

    }

    public Reserva(long fechaInicio, long fechaFin, Habitacion habitacion, Cliente cliente, String estado, String codigoReserva, double precioTotal){
        this.fechaFin=fechaInicio;
        this.fechaFin=fechaFin;
        this.habitacion=habitacion;
        this.cliente=cliente;
        this.estados = new EstadoReserva[]{EstadoReserva.CANCEL};
        this.codigoReserva = codigoReserva;
        this.precioTotal = precioTotal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(long fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public long getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(long fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EstadoReserva[] getEstados() {
        return estados;
    }

    public void setEstados(EstadoReserva[] estados) {
        this.estados = estados;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id='" + id + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", habitacion=" + habitacion +
                ", cliente=" + cliente +
                ", estados=" + Arrays.toString(estados) +
                ", codigoReserva='" + codigoReserva + '\'' +
                ", precioTotal=" + precioTotal +
                '}';
    }
}
