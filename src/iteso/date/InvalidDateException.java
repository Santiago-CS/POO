package iteso.date;

public class InvalidDateException extends IllegalArgumentException {
    
    public InvalidDateException(String mensaje) {
        super(mensaje);
    }
}