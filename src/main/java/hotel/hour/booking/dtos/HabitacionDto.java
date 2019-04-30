package hotel.hour.booking.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import hotel.hour.booking.documents.Hotel;
import hotel.hour.booking.documents.Habitacion;

import java.math.BigDecimal;

@JsonInclude(Include.NON_NULL)
public class HabitacionDto {

    private String Id;
    private String tipo;
    private String servicios;
    private BigDecimal precioHora;
    private BigDecimal precioDia;

    private Hotel hotel;

    public HabitacionDto(){
    }

    public HabitacionDto(Habitacion habitacion){
        this.Id=habitacion.getId();
        this.tipo=habitacion.getTipo();
        this.servicios=habitacion.getServicios();
        this.precioHora=habitacion.getPrecioHora();
        this.precioDia=habitacion.getPrecioDia();
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
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
                ", tipo='" + tipo + '\'' +
                ", servicios='" + servicios + '\'' +
                ", precioHora=" + precioHora +
                ", precioDia=" + precioDia +
                ", hotel=" + hotel +
                '}';
    }
}
