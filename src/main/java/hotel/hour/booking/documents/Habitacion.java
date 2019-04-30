package hotel.hour.booking.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
public class Habitacion {

    @Id
    private String id;
    private String tipo;
    private String servicios;
    private BigDecimal precioHora;
    private BigDecimal precioDia;

    @DBRef
    private Hotel hotel;

    public Habitacion(){

    }

    public Habitacion(String tipo, String servicios, BigDecimal precioHora, BigDecimal precioDia, Hotel hotel){
        this.tipo=tipo;
        this.servicios=servicios;
        this.precioHora=precioHora;
        this.precioDia=precioDia;
        this.hotel=hotel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "Habitacion{" +
                "id='" + id + '\'' +
                ", tipo='" + tipo + '\'' +
                ", servicios='" + servicios + '\'' +
                ", precioHora=" + precioHora +
                ", precioDia=" + precioDia +
                ", hotel=" + hotel +
                '}';
    }
}
