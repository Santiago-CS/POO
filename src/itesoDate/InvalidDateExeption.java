package itesoDate;

public class InvalidDateExeption extends RuntimeException {
      
    private int year;
    private int month;
    private int day;
        
    public InvalidDateExeption(int year, int month, int day) {
        super("Fecha fuera de rango o invalida detectada.");
        this.year = year;
        this.month = month;
        this.day = day;
    }
        
    @Override
    public String toString() {
        return getMessage() +
               "\nInvalid Date: " + year + "/" + month + "/" + day;
    }
}