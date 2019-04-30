package hotel.hour.booking.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import hotel.hour.booking.documents.Reserva;

@JsonInclude(Include.NON_NULL)
public class ReservaDto {

    private String id;
    private String email;
    private String username;
    private String password;
    private String repetirPassword;
    private String fecha;
    private Boolean estado;

    public ReservaDto(){

    }

    public ReservaDto(Reserva reserva){
        this.id=reserva.getId();
        this.email=reserva.getEmail();
        this.username=reserva.getUsername();
        this.password=reserva.getPassword();
        this.repetirPassword=reserva.getRepetirPasword();
        this.fecha=reserva.getFecha();
        this.estado=reserva.isEstado();
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

    public String getRepetirPassword() {
        return repetirPassword;
    }

    public void setRepetirPassword(String repetirPassword) {
        this.repetirPassword = repetirPassword;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ReservaDto{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", repetirPassword='" + repetirPassword + '\'' +
                ", fecha='" + fecha + '\'' +
                ", estado=" + estado +
                '}';
    }
}
