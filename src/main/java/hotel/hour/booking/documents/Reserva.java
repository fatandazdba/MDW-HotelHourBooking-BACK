package hotel.hour.booking.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Reserva {

    @Id
    private String id;
    private String email;
    private String username;
    private String password;
    private String repetirPasword;
    private String fecha;
    private Boolean estado;

    public Reserva(){

    }

    public Reserva(String email, String username, String password, String repetirPasword, String fecha, boolean estado){
        this.email=email;
        this.username=username;
        this.password=password;
        this.repetirPasword=repetirPasword;
        this.fecha=fecha;
        this.estado=estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepetirPasword() {
        return repetirPasword;
    }

    public void setRepetirPasword(String repetirPasword) {
        this.repetirPasword = repetirPasword;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "Id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", repetirPasword='" + repetirPasword + '\'' +
                ", fecha='" + fecha + '\'' +
                ", estado=" + estado +
                '}';
    }
}
