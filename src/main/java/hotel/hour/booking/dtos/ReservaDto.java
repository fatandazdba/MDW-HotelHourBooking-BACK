package hotel.hour.booking.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import hotel.hour.booking.documents.EstadoReserva;
import hotel.hour.booking.documents.Reserva;
import hotel.hour.booking.documents.Habitacion;
import hotel.hour.booking.documents.Cliente;

import java.util.Arrays;

@JsonInclude(Include.NON_NULL)
public class ReservaDto {

    private String id;
    private long fechaInicio;
    private long fechaFin;
    private Habitacion habitacion;
    private Cliente cliente;
    private EstadoReserva[] estados;
    private String codigoReserva;
    private double precioTotal;

    public ReservaDto(){

    }

    public ReservaDto(Reserva reserva){
        this.id=reserva.getId();
        this.fechaInicio=reserva.getFechaInicio();
        this.fechaFin=reserva.getFechaFin();
        this.habitacion=reserva.getHabitacion();
        this.cliente=reserva.getCliente();
        this.estados=reserva.getEstados();
        this.codigoReserva=reserva.getCodigoReserva();
        this.precioTotal=reserva.getPrecioTotal();
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
        return "ReservaDto{" +
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
