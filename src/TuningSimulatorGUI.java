import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;

// 1. EL "BACKEND" (Lógica de clases)

class IncompatibilidadPiezaException extends Exception {
    public IncompatibilidadPiezaException(String mensaje) { super(mensaje); }
}

enum CategoriaPieza { ESCAPE, ADMISION, TURBO }

interface Instalable {
    void aplicarMejora(Vehiculo v) throws IncompatibilidadPiezaException;
    String getNombrePieza();
    CategoriaPieza getCategoria();
}

interface Homologable { boolean esLegalParaCalle(); }

class Inventario<T> {
    private List<T> items = new ArrayList<>();
    public void agregar(T item) { items.add(item); }
    public T obtener(int indice) { return items.get(indice); }
    public int cantidad() { return items.size(); }
}

abstract class Vehiculo {
    protected String modelo;
    protected int caballosDeFuerza;
    protected int hpBase; // ¡NUEVO!: Para que el coche recuerde sus caballos originales
    protected String rutaImagen; 
    protected List<Instalable> modificaciones = new ArrayList<>();

    public Vehiculo(String modelo, int hpBase, String rutaImagen) {
        this.modelo = modelo;
        this.hpBase = hpBase; // Guardamos el valor original de fábrica
        this.caballosDeFuerza = hpBase;
        this.rutaImagen = rutaImagen;
    }

    public void instalarPieza(Instalable pieza) throws IncompatibilidadPiezaException {
        for (Instalable mod : modificaciones) {
            if (mod.getCategoria() == pieza.getCategoria()) {
                throw new IncompatibilidadPiezaException(
                    "Operación rechazada: El auto ya cuenta con una modificación de tipo " + pieza.getCategoria() + "."
                );
            }
        }
        pieza.aplicarMejora(this); 
        modificaciones.add(pieza);
    }

    public void aumentarHP(int extraHP) { this.caballosDeFuerza += extraHP; }
    
    //Metodo para Vacíar la lista de piezas y reiniciar los HP
    public void restaurarDeFabrica() {
        this.modificaciones.clear();
        this.caballosDeFuerza = this.hpBase;
    }
    
    public String getRutaImagen() { return rutaImagen; }

    @Override
    public String toString() { return modelo; }

    public String obtenerFichaTecnica() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- FICHA TÉCNICA: ").append(modelo).append(" ---\n");
        sb.append("HP Actuales: ").append(caballosDeFuerza).append("\n");
        sb.append("Modificaciones instaladas: ").append(modificaciones.size()).append("\n\n");
        
        for (Instalable mod : modificaciones) {
            sb.append("- ").append(mod.getNombrePieza());
            if (mod instanceof Homologable) {
                boolean legal = ((Homologable) mod).esLegalParaCalle();
                sb.append(legal ? " (Legal para calle)\n" : " (SOLO PISTA)\n");
            } else {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}

class AutoDeportivo extends Vehiculo {
    public AutoDeportivo(String modelo, int hpBase, String rutaImagen) {
        super(modelo, hpBase, rutaImagen);
    }
}

// CLASES DE LAS PIEZAS

class SistemaEscape implements Instalable, Homologable {
    private String tipo;
    private int aumentoHP;
    private boolean cumpleNormaEmisiones;

    public SistemaEscape(String tipo, int aumentoHP, boolean cumpleNormaEmisiones) {
        this.tipo = tipo;
        this.aumentoHP = aumentoHP;
        this.cumpleNormaEmisiones = cumpleNormaEmisiones;
    }

    @Override
    public void aplicarMejora(Vehiculo v) throws IncompatibilidadPiezaException {
        if(v.caballosDeFuerza < 100 && tipo.equals("Straight Pipe")) {
            throw new IncompatibilidadPiezaException("El motor no soporta un " + tipo + ".");
        }
        v.aumentarHP(aumentoHP);
    }

    @Override
    public String getNombrePieza() { return "Escape " + tipo + " (+" + aumentoHP + " HP)"; }
    @Override
    public CategoriaPieza getCategoria() { return CategoriaPieza.ESCAPE; }
    @Override
    public boolean esLegalParaCalle() { return cumpleNormaEmisiones; }
}

class FiltroAltoFlujo implements Instalable, Homologable {
    private String marca;
    private int aumentoHP;

    public FiltroAltoFlujo(String marca, int aumentoHP) {
        this.marca = marca;
        this.aumentoHP = aumentoHP;
    }

    @Override
    public void aplicarMejora(Vehiculo v) { v.aumentarHP(aumentoHP); }
    @Override
    public String getNombrePieza() { return "Filtro de Alto Flujo " + marca + " (+" + aumentoHP + " HP)"; }
    @Override
    public CategoriaPieza getCategoria() { return CategoriaPieza.ADMISION; }
    @Override
    public boolean esLegalParaCalle() { return true; } 
}

class ValvulaAlivio implements Instalable, Homologable {
    private String sonido;
    public ValvulaAlivio(String sonido) { this.sonido = sonido; }

    @Override
    public void aplicarMejora(Vehiculo v) { v.aumentarHP(5); } 
    @Override
    public String getNombrePieza() { return "Válvula de Alivio (Sonido: " + sonido + ") (+5 HP)"; }
    @Override
    public CategoriaPieza getCategoria() { return CategoriaPieza.TURBO; }
    @Override
    public boolean esLegalParaCalle() { return false; } 
}


// 2. EL "FRONTEND" (Interfaz Gráfica)
public class TuningSimulatorGUI {
    
    public static void main(String[] args) {
        
        // Inventarios de piezas
        Inventario<SistemaEscape> inventarioEscapes = new Inventario<>();
        inventarioEscapes.agregar(new SistemaEscape("Catback", 15, true));
        inventarioEscapes.agregar(new SistemaEscape("Straight Pipe", 25, false));

        Inventario<FiltroAltoFlujo> inventarioFiltros = new Inventario<>();
        inventarioFiltros.agregar(new FiltroAltoFlujo("K&N", 8));

        Inventario<ValvulaAlivio> inventarioValvulas = new Inventario<>();
        inventarioValvulas.agregar(new ValvulaAlivio("Stu-tu-tu-tu!"));

        // Flotilla de Autos
        Vehiculo[] flotilla = {
            new AutoDeportivo("Cupra 290", 290, "img/cupra.png"),
            new AutoDeportivo("Infiniti Q50", 300, "img/infiniti.png"),
            new AutoDeportivo("Mini Cooper S", 99, "img/mini.png")
        };
        
        Vehiculo[] autoActivo = { flotilla[0] }; 

        // Crear la ventana principal
        JFrame ventana = new JFrame("--- Welcome to Los Santos Customs ---");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(650, 550); 
        ventana.setLayout(new BorderLayout(10, 10));

        // PANEL SUPERIOR: MENÚ DESPLEGABLE Y BOTÓN DE RESET 
        JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        panelTop.add(new JLabel("Seleccionar Vehículo: "));
        JComboBox<Vehiculo> comboAutos = new JComboBox<>(flotilla);
        panelTop.add(comboAutos);
        
        // Boton para restaurar de fábrica (a un lado del menú de autos)
        JButton btnRestaurar = new JButton("🛠 Restaurar a Fábrica");
        panelTop.add(btnRestaurar);
        
        ventana.add(panelTop, BorderLayout.NORTH);

        // --- PANEL CENTRAL: PANTALLA Y FOTO ---
        JPanel panelCentro = new JPanel(new GridLayout(1, 2, 10, 10)); 
        
        JTextArea pantalla = new JTextArea();
        pantalla.setEditable(false);
        pantalla.setFont(new Font("Monospaced", Font.PLAIN, 14));
        pantalla.setText(autoActivo[0].obtenerFichaTecnica());
        panelCentro.add(new JScrollPane(pantalla));
        
        JLabel lblImagen = new JLabel("Sin Imagen", SwingConstants.CENTER);
        actualizarImagen(lblImagen, autoActivo[0].getRutaImagen());
        panelCentro.add(lblImagen);
        
        ventana.add(panelCentro, BorderLayout.CENTER);

        // PANEL INFERIOR: BOTONES DE PIEZAS
        JPanel panelPiezas = new JPanel(new GridLayout(2, 2, 5, 5));
        
        JButton btnCatback = new JButton("Instalar Catback");
        JButton btnStraightPipe = new JButton("Instalar Straight Pipe");
        JButton btnFiltro = new JButton("Instalar Filtro Alto Flujo");
        JButton btnValvula = new JButton("Instalar Válvula de Alivio");
        
        panelPiezas.add(btnCatback);
        panelPiezas.add(btnStraightPipe);
        panelPiezas.add(btnFiltro);
        panelPiezas.add(btnValvula);
        
        ventana.add(panelPiezas, BorderLayout.SOUTH);

        // Eventos
        
        comboAutos.addActionListener(e -> {
            Vehiculo autoSeleccionado = (Vehiculo) comboAutos.getSelectedItem();
            autoActivo[0] = autoSeleccionado;
            pantalla.setText("Has subido al elevador el: " + autoSeleccionado.modelo + "\n\n" + autoSeleccionado.obtenerFichaTecnica());
            actualizarImagen(lblImagen, autoSeleccionado.getRutaImagen());
        });

        // Para restaurar de Fabrica las mods del carro
        btnRestaurar.addActionListener(e -> {
            autoActivo[0].restaurarDeFabrica();
            pantalla.setText(" El auto ha sido devuelto a su estado original.\n\n" + autoActivo[0].obtenerFichaTecnica());
        });

        // Eventos de escapes
        btnCatback.addActionListener(e -> {
            try {
                autoActivo[0].instalarPieza(inventarioEscapes.obtener(0));
                pantalla.setText("¡Catback instalado!\n\n" + autoActivo[0].obtenerFichaTecnica());
            } catch (IncompatibilidadPiezaException ex) {
                JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error en Taller", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnStraightPipe.addActionListener(e -> {
            try {
                autoActivo[0].instalarPieza(inventarioEscapes.obtener(1));
                pantalla.setText("¡Straight Pipe instalado!\n\n" + autoActivo[0].obtenerFichaTecnica());
            } catch (IncompatibilidadPiezaException ex) {
                JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error en Taller", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Eventos de Filtro y Válvula
        btnFiltro.addActionListener(e -> {
            try {
                autoActivo[0].instalarPieza(inventarioFiltros.obtener(0));
                pantalla.setText("¡Filtro K&N instalado!\n\n" + autoActivo[0].obtenerFichaTecnica());
            } catch (IncompatibilidadPiezaException ex) {
                JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error en Taller", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnValvula.addActionListener(e -> {
            try {
                autoActivo[0].instalarPieza(inventarioValvulas.obtener(0));
                pantalla.setText("¡Válvula de alivio instalada!\n\n" + autoActivo[0].obtenerFichaTecnica());
            } catch (IncompatibilidadPiezaException ex) {
                JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error en Taller", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Mostrar ventana
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    // MÉTODO PARA LAS IMÁGENES
    private static void actualizarImagen(JLabel label, String ruta) {
        try {
            ImageIcon iconoOriginal = new ImageIcon(ruta);
            Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(600, 300, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(imagenEscalada));
            label.setText(""); 
        } catch (Exception e) {
            label.setIcon(null);
            label.setText("[Falta la imagen: " + ruta + "]");
        }
    }
}