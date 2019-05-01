package hotel.hour.booking.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import hotel.hour.booking.documents.Hotel;
import hotel.hour.booking.documents.Habitacion;
import hotel.hour.booking.documents.ServicioHabitacion;
import hotel.hour.booking.documents.TipoHabitacion;

import java.math.BigDecimal;
import java.util.Arrays;

@JsonInclude(Include.NON_NULL)
public class HabitacionDto {

    private String Id;
    private TipoHabitacion[] tipo;
    private ServicioHabitacion[] servicios;
    private BigDecimal precioHora;
    private BigDecimal precioDia;

    private Hotel hotel;

    public HabitacionDto(){
    }

    public HabitacionDto(Habitacion habitacion){
        this.Id=habitacion.getId();
        this.tipo = new TipoHabitacion[]{TipoHabitacion.INDIVIDUAL};
        this.servicios = new ServicioHabitacion[]{ServicioHabitacion.TV};
        this.precioHora=habitacion.getPrecioHora();
        this.precioDia=habitacion.getPrecioDia();
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "HabitacionDto{" +
                "Id='" + Id + '\'' +
                ", tipo=" + Arrays.toString(tipo) +
                ", servicios=" + Arrays.toString(servicios) +
                ", precioHora=" + precioHora +
                ", precioDia=" + precioDia +
                ", hotel=" + hotel +
                '}';
    }
}
