package hotel.hour.booking.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Hotel {

    @Id
    private String Id;
    private String nombre;
    private String director;
    private String direccionPostal;
    private String imagenRepresentativa;

    public Hotel(){

    }

    public Hotel(String nombre, String director, String direccionPostal, String imagenRepresentativa){
        this.nombre=nombre;
        this.director=director;
        this.direccionPostal=direccionPostal;
        this.imagenRepresentativa=imagenRepresentativa;
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

    @Override
    public String toString() {
        return "Hotel{" +
                "Id='" + Id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", director='" + director + '\'' +
                ", direccionPostal='" + direccionPostal + '\'' +
                ", imagenRepresentativa='" + imagenRepresentativa + '\'' +
                '}';
    }
}
