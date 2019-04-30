package hotel.hour.booking.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Hotel {

    @Id
    private String id;
    private String nombre;
    private String director;
    private String direccionPostal;
    private String imagenRepresentativa;

    private List<Habitacion> habitaciones;

    public Hotel() {
        habitaciones = new ArrayList<>();
    }

    public Hotel(String nombre, String director, String direccionPostal, String imagenRepresentativa, List<Habitacion> habitaciones) {
        this.nombre = nombre;
        this.director = director;
        this.direccionPostal = direccionPostal;
        this.imagenRepresentativa = imagenRepresentativa;
        this.habitaciones = habitaciones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "Hotel{" +
                "Id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", director='" + director + '\'' +
                ", direccionPostal='" + direccionPostal + '\'' +
                ", imagenRepresentativa='" + imagenRepresentativa + '\'' +
                ", habitaciones='" + habitaciones + '\'' +
                '}';
    }
}
