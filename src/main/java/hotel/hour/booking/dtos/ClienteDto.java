package hotel.hour.booking.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import hotel.hour.booking.documents.Cliente;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteDto {

    private String id;
    private String dni;
    private String nombres;
    private String apellidos;
    private String email;
    private String password;
    private String telefono;
    private String direccion;

    public ClienteDto(){

    }

    public ClienteDto(Cliente cliente){
        this.id=cliente.getId();
        this.dni=cliente.getDni();
        this.nombres=cliente.getNombres();
        this.apellidos=cliente.getApellidos();
        this.email=cliente.getEmail();
        this.password=cliente.getPassword();
        this.telefono=cliente.getTelefono();
        this.direccion=cliente.getDireccion();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "ClienteDto{" +
                "id='" + id + '\'' +
                ", dni='" + dni + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
