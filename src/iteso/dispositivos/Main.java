package iteso.dispositivos;

interface Bateria {
    void conectarCorriente();
    double getPorcentajeCarga();
    int getCapacidadMah();
}

interface ConexionWifi {
    double WIFI_2_4 = 2.4;
    double WIFI_5 = 5.0;
    double WIFI_6 = 6.0;

    void conectarWifi(String red, double tipoWifi);
    void desconectarWifi();
    boolean isWifiConectado();
    String getRedWifiActual();
}

interface ConexionEthernet {
    int VEL_100 = 100;
    int VEL_1000 = 1000;

    void conectarEthernet(int velocidad);
    void desconectarEthernet();
    boolean isEthernetConectado();
}

abstract class DispositivoElectronico {
    
    public static final String FAB_APPLE = "Apple";
    public static final String FAB_SAMSUNG = "Samsung";
    public static final String FAB_HP = "HP";
    public static final String FAB_DELL = "Dell";
    public static final String FAB_HISENSE = "Hisense";
    public static final String FAB_SONY = "Sony";

    public static final String OS_WINDOWS = "Windows";
    public static final String OS_LINUX = "Linux";
    public static final String OS_IOS = "IOS";
    public static final String OS_ANDROID = "Android";
    public static final String OS_GOOGLE_TV = "GoogleTV";
    public static final String OS_ROKU = "Roku";
    public static final String OS_TIZEN = "Tizen";
    public static final String OS_WEBOS = "WebOS";

    private String fabricante;
    private double pulgadasPantalla;
    private String sistemaOperativo;
    protected boolean encendido;

    public DispositivoElectronico(String fabricante, double pulgadasPantalla, String sistemaOperativo) {
        this.fabricante = fabricante;
        this.pulgadasPantalla = pulgadasPantalla;
        this.sistemaOperativo = sistemaOperativo;
        this.encendido = false; 
    }

    public void encender() {
        this.encendido = true;
        System.out.println("El dispositivo se ha encendido.");
    }

    public void apagar() {
        this.encendido = false;
        System.out.println("El dispositivo se ha apagado.");
    }

    public void consultarEstado() {
        System.out.println("Estado: " + (encendido ? "Encendido" : "Apagado"));
    }

    public void instalarAplicacion(String app) {
        if(encendido) System.out.println("Instalando aplicación: " + app + " en " + sistemaOperativo);
        else System.out.println("Enciende el dispositivo para instalar apps.");
    }

    public void desinstalarAplicacion(String app) {
        if(encendido) System.out.println("Desinstalando aplicación: " + app);
        else System.out.println("Enciende el dispositivo para desinstalar apps.");
    }

    public String getFabricante() { return fabricante; }
    public void setFabricante(String fabricante) { this.fabricante = fabricante; }

    public double getPulgadasPantalla() { return pulgadasPantalla; }
    public void setPulgadasPantalla(double pulgadasPantalla) { this.pulgadasPantalla = pulgadasPantalla; }

    public String getSistemaOperativo() { return sistemaOperativo; }
    public void setSistemaOperativo(String sistemaOperativo) { this.sistemaOperativo = sistemaOperativo; }
}


class TelefonoMovil extends DispositivoElectronico implements ConexionWifi, Bateria {
    
    private int capacidadMah;
    private double porcentajeCarga;
    private boolean wifiConectado;
    private String redWifiActual;
    private String redCelular; 

    public TelefonoMovil(String fabricante, double pulgadas, String os, int capacidadMah) {
        super(fabricante, pulgadas, os);
        this.capacidadMah = capacidadMah;
        this.porcentajeCarga = 100.0;
        this.redCelular = "Desconectado";
    }

    public void conectarLTE() { this.redCelular = "LTE"; System.out.println("Conectado a red LTE."); }
    public void conectar5G() { this.redCelular = "5G"; System.out.println("Conectado a red 5G."); }
    public void hacerLlamada(String numero) { System.out.println("Llamando al " + numero + " vía " + redCelular); }

    @Override public void conectarWifi(String red, double tipoWifi) { this.wifiConectado = true; this.redWifiActual = red; }
    @Override public void desconectarWifi() { this.wifiConectado = false; this.redWifiActual = ""; }
    @Override public boolean isWifiConectado() { return wifiConectado; }
    @Override public String getRedWifiActual() { return redWifiActual; }

    @Override public void conectarCorriente() { this.porcentajeCarga = 100.0; System.out.println("Batería cargada al 100%"); }
    @Override public double getPorcentajeCarga() { return porcentajeCarga; }
    @Override public int getCapacidadMah() { return capacidadMah; }
}

class Tableta extends DispositivoElectronico implements ConexionWifi, Bateria {
    
    private int capacidadMah;
    private double porcentajeCarga;
    private boolean wifiConectado;
    private String redWifiActual;

    public Tableta(String fabricante, double pulgadas, String os, int capacidadMah) {
        super(fabricante, pulgadas, os);
        this.capacidadMah = capacidadMah;
        this.porcentajeCarga = 100.0;
    }

    @Override public void conectarWifi(String red, double tipoWifi) { this.wifiConectado = true; this.redWifiActual = red; }
    @Override public void desconectarWifi() { this.wifiConectado = false; this.redWifiActual = ""; }
    @Override public boolean isWifiConectado() { return wifiConectado; }
    @Override public String getRedWifiActual() { return redWifiActual; }

    @Override public void conectarCorriente() { this.porcentajeCarga = 100.0; }
    @Override public double getPorcentajeCarga() { return porcentajeCarga; }
    @Override public int getCapacidadMah() { return capacidadMah; }
}

class Laptop extends DispositivoElectronico implements ConexionWifi, ConexionEthernet, Bateria {
    
    private int capacidadMah;
    private double porcentajeCarga;
    private boolean wifiConectado;
    private String redWifiActual;
    private boolean ethernetConectado;

    public Laptop(String fabricante, double pulgadas, String os, int capacidadMah) {
        super(fabricante, pulgadas, os);
        this.capacidadMah = capacidadMah;
        this.porcentajeCarga = 100.0;
    }

    @Override public void conectarCorriente() { this.porcentajeCarga = 100.0; }
    @Override public double getPorcentajeCarga() { return porcentajeCarga; }
    @Override public int getCapacidadMah() { return capacidadMah; }

    @Override public void conectarWifi(String red, double tipoWifi) { this.wifiConectado = true; this.redWifiActual = red; }
    @Override public void desconectarWifi() { this.wifiConectado = false; this.redWifiActual = ""; }
    @Override public boolean isWifiConectado() { return wifiConectado; }
    @Override public String getRedWifiActual() { return redWifiActual; }

    @Override public void conectarEthernet(int velocidad) { this.ethernetConectado = true; System.out.println("Ethernet LAN a " + velocidad + " Mbps."); }
    @Override public void desconectarEthernet() { this.ethernetConectado = false; }
    @Override public boolean isEthernetConectado() { return ethernetConectado; }
}

class SmartTV extends DispositivoElectronico implements ConexionWifi, ConexionEthernet {
    
    private boolean wifiConectado;
    private String redWifiActual;
    private boolean ethernetConectado;

    public SmartTV(String fabricante, double pulgadas, String os) {
        super(fabricante, pulgadas, os);
    }

    public void conectarHDMI(int puerto) { System.out.println("Dispositivo conectado en HDMI " + puerto); }
    public void verTVAbierta() { System.out.println("Sintonizando canales de TV Abierta..."); }

    @Override public void conectarWifi(String red, double tipoWifi) { this.wifiConectado = true; this.redWifiActual = red; }
    @Override public void desconectarWifi() { this.wifiConectado = false; }
    @Override public boolean isWifiConectado() { return wifiConectado; }
    @Override public String getRedWifiActual() { return redWifiActual; }

    @Override public void conectarEthernet(int velocidad) { this.ethernetConectado = true; }
    @Override public void desconectarEthernet() { this.ethernetConectado = false; }
    @Override public boolean isEthernetConectado() { return ethernetConectado; }
}


public class Main {
    public static void main(String[] args) {
        
        System.out.println("--- PRUEBA SMARTPHONE ---");
        TelefonoMovil iphone = new TelefonoMovil(DispositivoElectronico.FAB_APPLE, 6.1, DispositivoElectronico.OS_IOS, 3200);
        iphone.encender();
        iphone.conectar5G();
        iphone.hacerLlamada("3312345678");
        System.out.println("Batería: " + iphone.getPorcentajeCarga() + "%");

        System.out.println("\n--- PRUEBA LAPTOP ---");
        Laptop dellXPS = new Laptop(DispositivoElectronico.FAB_DELL, 15.6, DispositivoElectronico.OS_WINDOWS, 8000);
        dellXPS.encender();
        dellXPS.conectarEthernet(ConexionEthernet.VEL_1000);
        dellXPS.instalarAplicacion("Power BI");

        System.out.println("\n--- PRUEBA SMART TV ---");
        SmartTV tv = new SmartTV(DispositivoElectronico.FAB_HISENSE, 55.0, DispositivoElectronico.OS_GOOGLE_TV);
        tv.encender();
        tv.conectarWifi("RedCasa", ConexionWifi.WIFI_5);
        tv.verTVAbierta();
        tv.conectarHDMI(1);
    }
}