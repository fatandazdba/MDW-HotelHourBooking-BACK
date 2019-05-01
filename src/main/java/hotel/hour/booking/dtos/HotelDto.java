package hotel.hour.booking.dtos;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import hotel.hour.booking.documents.Habitacion;
import hotel.hour.booking.documents.Hotel;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelDto {

    private String Id;
    private String nombre;
    private String director;
    private String direccionPostal;
    private String imagenRepresentativa;
    private List<Habitacion> habitaciones;

    public HotelDto(){

    }

    public HotelDto(Hotel hotel){
        this.Id=hotel.getId();
        this.nombre=hotel.getNombre();
        this.director=hotel.getDirector();
        this.direccionPostal=hotel.getDireccionPostal();
        this.imagenRepresentativa=hotel.getImagenRepresentativa();
        this.habitaciones=hotel.getHabitaciones();
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDireccionPostal() {
        return direccionPostal;
    }

    public void setDireccionPostal(String direccionPostal) {
        this.direccionPostal = direccionPostal;
    }

    public String getImagenRepresentativa() {
        return imagenRepresentativa;
    }

    public void setImagenRepresentativa(String imagenRepresentativa) {
        this.imagenRepresentativa = imagenRepresentativa;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    @Override
    public String toString() {
        return "HotelDto{" +
                "Id='" + Id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", director='" + director + '\'' +
                ", direccionPostal='" + direccionPostal + '\'' +
                ", imagenRepresentativa='" + imagenRepresentativa + '\'' +
                ", habitaciones=" + habitaciones +
                '}';
    }
}
