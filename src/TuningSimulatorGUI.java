import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;

// 1. EL "BACKEND" lógica de clases original

class IncompatibilidadPiezaException extends Exception {
    public IncompatibilidadPiezaException(String mensaje) { super(mensaje); }
}

enum CategoriaPieza { MOTOR, ESCAPE, SUSPENSION, ESTETICA, AERODINAMICA }

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
    protected String rutaImagen; // NUEVO: Para guardar la foto del auto
    protected List<Instalable> modificaciones = new ArrayList<>();

    // NUEVO: Agregamos la ruta de la imagen al constructor
    public Vehiculo(String modelo, int hpBase, String rutaImagen) {
        this.modelo = modelo;
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
    
    public String getRutaImagen() { return rutaImagen; }

    // NUEVO: Sobrescribimos toString para que el menú desplegable muestre el nombre bonito
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

// ==========================================
// 2. EL "FRONTEND" (La Interfaz Gráfica con Java Swing)
// ==========================================
public class TuningSimulatorGUI {
    
    public static void main(String[] args) {
        
        // 1. Inventario de piezas
        Inventario<SistemaEscape> inventarioEscapes = new Inventario<>();
        inventarioEscapes.agregar(new SistemaEscape("Catback", 15, true));
        inventarioEscapes.agregar(new SistemaEscape("Straight Pipe", 25, false));

        // 2. Flotilla de Autos (¡Ahora incluyen ruta de imagen!)
        Vehiculo[] flotilla = {
            new AutoDeportivo("Cupra 290", 290, "img/cupra.png"),
            new AutoDeportivo("Infiniti Q50", 300, "img/infiniti.png"),
            new AutoDeportivo("Mini Cooper S", 99, "img/mini.png")
        };
        
        Vehiculo[] autoActivo = { flotilla[0] }; 

        // 3. Crear la ventana principal
        JFrame ventana = new JFrame("Los Santos Customs - Tuning Simulator");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 500); // Ventana un poco más grande
        ventana.setLayout(new BorderLayout(10, 10));

        // --- PANEL SUPERIOR: MENÚ DESPLEGABLE ---
        JPanel panelTop = new JPanel();
        panelTop.add(new JLabel("Seleccionar Vehículo: "));
        // El JComboBox recibe nuestro arreglo de autos y usa el toString() que creamos para mostrar el texto
        JComboBox<Vehiculo> comboAutos = new JComboBox<>(flotilla);
        panelTop.add(comboAutos);
        ventana.add(panelTop, BorderLayout.NORTH);

        // --- PANEL CENTRAL: PANTALLA Y FOTO ---
        JPanel panelCentro = new JPanel(new GridLayout(1, 2, 10, 10)); // Dividimos el centro en 2 columnas
        
        // Columna Izquierda: Texto
        JTextArea pantalla = new JTextArea();
        pantalla.setEditable(false);
        pantalla.setFont(new Font("Monospaced", Font.PLAIN, 14));
        pantalla.setText(autoActivo[0].obtenerFichaTecnica());
        panelCentro.add(new JScrollPane(pantalla));
        
        // Columna Derecha: Foto del coche
        JLabel lblImagen = new JLabel("Sin Imagen", SwingConstants.CENTER);
        // Función auxiliar para cargar la imagen (Evita que el programa explote si la foto no existe)
        actualizarImagen(lblImagen, autoActivo[0].getRutaImagen());
        panelCentro.add(lblImagen);
        
        ventana.add(panelCentro, BorderLayout.CENTER);

        // --- PANEL INFERIOR: BOTONES DE PIEZAS ---
        JPanel panelPiezas = new JPanel();
        JButton btnCatback = new JButton("Instalar Catback");
        JButton btnStraightPipe = new JButton("Instalar Straight Pipe");
        panelPiezas.add(btnCatback);
        panelPiezas.add(btnStraightPipe);
        ventana.add(panelPiezas, BorderLayout.SOUTH);


        // ==========================================
        // PROGRAMAR LOS EVENTOS
        // ==========================================
        
        // Evento: Al cambiar la opción en el menú desplegable
        comboAutos.addActionListener(e -> {
            // Obtenemos el auto que el usuario acaba de seleccionar
            Vehiculo autoSeleccionado = (Vehiculo) comboAutos.getSelectedItem();
            autoActivo[0] = autoSeleccionado;
            
            // Actualizamos la pantalla y la foto
            pantalla.setText("Has subido al elevador el: " + autoSeleccionado.modelo + "\n\n" + autoSeleccionado.obtenerFichaTecnica());
            actualizarImagen(lblImagen, autoSeleccionado.getRutaImagen());
        });

        // Eventos de piezas
        btnCatback.addActionListener(e -> {
            try {
                autoActivo[0].instalarPieza(inventarioEscapes.obtener(0));
                pantalla.setText(" ¡Catback instalado!\n\n" + autoActivo[0].obtenerFichaTecnica());
            } catch (IncompatibilidadPiezaException ex) {
                JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error en Taller", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnStraightPipe.addActionListener(e -> {
            try {
                autoActivo[0].instalarPieza(inventarioEscapes.obtener(1));
                pantalla.setText("✅ ¡Straight Pipe instalado!\n\n" + autoActivo[0].obtenerFichaTecnica());
            } catch (IncompatibilidadPiezaException ex) {
                JOptionPane.showMessageDialog(ventana, ex.getMessage(), "Error en Taller", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Mostrar ventana
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    // MÉTODO AUXILIAR PARA LAS IMÁGENES
    private static void actualizarImagen(JLabel label, String ruta) {
        try {
            // Intenta cargar la imagen
            ImageIcon iconoOriginal = new ImageIcon(ruta);
            // Ajustamos el tamaño para que quepa bien en la ventana
            Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(600, 300, Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(imagenEscalada));
            label.setText(""); // Quitamos el texto si la imagen cargó bien
        } catch (Exception e) {
            // Si no encuentra la imagen en la carpeta, no crashea, solo pone texto
            label.setIcon(null);
            label.setText("[Falta la imagen: " + ruta + "]");
        }
    }
}