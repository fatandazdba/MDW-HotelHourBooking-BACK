package hotel.hour.booking.data_services;

import hotel.hour.booking.documents.Cliente;
import hotel.hour.booking.documents.Habitacion;
import hotel.hour.booking.documents.Hotel;
import hotel.hour.booking.documents.Reserva;

import java.util.ArrayList;
import java.util.List;

public class DatabaseGraph {
    private List<Cliente> clienteList;
    private List<Habitacion> habitacionList;
    private List<Hotel> hotelList;
    private List<Reserva> reservaList;

    public DatabaseGraph() {
        this.clienteList = new ArrayList<>();
        this.habitacionList = new ArrayList<>();
        this.hotelList = new ArrayList<>();
        this.reservaList = new ArrayList<>();
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    public List<Habitacion> getHabitacionList() {
        return habitacionList;
    }

    public void setHabitacionList(List<Habitacion> habitacionList) {
        this.habitacionList = habitacionList;
    }

    public List<Hotel> getHotelList() {
        return hotelList;
    }

    public void setHotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }
}
