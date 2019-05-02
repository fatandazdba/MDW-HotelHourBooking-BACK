package hotel.hour.booking.documents;

public enum TipoHabitacion {
    INDIVIDUAL("INDIVIDUAL"), DOBLE("DOBLE"), TRIPLE("TRIPLE"), SUITE("SUITE");

    private String val;

    TipoHabitacion(String val) {
        this.val = val;
    }

    public String getVal() {
        return this.val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
