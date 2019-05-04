package hotel.hour.booking.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import hotel.hour.booking.documents.EstadoReserva;
import hotel.hour.booking.documents.Reserva;
import hotel.hour.booking.documents.Habitacion;
import hotel.hour.booking.documents.Cliente;

import java.time.LocalDateTime;
import java.util.Arrays;

@JsonInclude(Include.NON_NULL)
public class ReservaDto {

    private String Id;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private Habitacion habitacion;
    private Cliente cliente;
    private EstadoReserva estado;
    private double precioTotal;

    public ReservaDto(){

    }

    public ReservaDto(Reserva reserva){
        this.Id=reserva.getId();
        this.inicio = reserva.getFechaInicio();
        this.fin = reserva.getFechaFin();
        this.habitacion=reserva.getHabitacion();
        this.cliente=reserva.getCliente();
        this.estado = reserva.getEstado();
        this.precioTotal=reserva.getPrecioTotal();
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
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

    public EstadoReserva getEstados() {
        return estado;
    }

    public void setEstados(EstadoReserva estados) {
        this.estado = estados;
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
                "Id='" + Id + '\'' +

                ", habitacion=" + habitacion +
                ", cliente=" + cliente +
                ", estado=" + estado +
                ", precioTotal=" + precioTotal +
                '}';
    }
}
