
import java.util.ArrayList;

// Interfaz ImpactoEcologico
interface ImpactoEcologico {
    double obtenerImpactoEcologico();
}

// Clase Edificio
class Edificio implements ImpactoEcologico {
    private String nombre;
    private int emisionesDeCarbono;

    public Edificio(String nombre, int emisionesDeCarbono) {
        this.nombre = nombre;
        this.emisionesDeCarbono = emisionesDeCarbono;
    }

    @Override
    public double obtenerImpactoEcologico() {
        return emisionesDeCarbono * 1.5; // Algoritmo ficticio para el impacto ecológico de un edificio
    }

    public String getNombre() {
        return nombre;
    }
}

// Clase Auto
class Auto implements ImpactoEcologico {
    private String modelo;
    private double emisionesDeCarbono;

    public Auto(String modelo, double emisionesDeCarbono) {
        this.modelo = modelo;
        this.emisionesDeCarbono = emisionesDeCarbono;
    }

    @Override
    public double obtenerImpactoEcologico() {
        return emisionesDeCarbono * 2.0; // Algoritmo ficticio para el impacto ecológico de un auto
    }

    public String getModelo() {
        return modelo;
    }
}

// Clase Bicicleta
class Bicicleta implements ImpactoEcologico {
    private String tipo;
    private boolean electrica;

    public Bicicleta(String tipo, boolean electrica) {
        this.tipo = tipo;
        this.electrica = electrica;
    }

    @Override
    public double obtenerImpactoEcologico() {
        return electrica ? 0 : 0.5; // Algoritmo ficticio para el impacto ecológico de una bicicleta
    }

    public String getTipo() {
        return tipo;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<ImpactoEcologico> objetosEcologicos = new ArrayList<>();

        // Crear objetos de cada clase
        Edificio edificio = new Edificio("Oficina A", 1000);
        Auto auto = new Auto("Sedan", 150);
        Bicicleta bicicleta = new Bicicleta("Montaña", false);

        // Agregar objetos al ArrayList
        objetosEcologicos.add(edificio);
        objetosEcologicos.add(auto);
        objetosEcologicos.add(bicicleta);


        // Iterar a través del ArrayList e invocar obtenerImpactoEcologico de forma polimórfica
        for (ImpactoEcologico objeto : objetosEcologicos) {
            System.out.println("Objeto: " + obtenerIdentificacion(objeto) +
                    ", Impacto Ecológico: " + objeto.obtenerImpactoEcologico());
        }
        }
    // Método para obtener la identificación del objeto
    private static String obtenerIdentificacion(ImpactoEcologico objeto) {
        if (objeto instanceof Edificio) {
            return "Edificio: " + ((Edificio) objeto).getNombre();
        } else if (objeto instanceof Auto) {
            return "Auto: " + ((Auto) objeto).getModelo();
        } else if (objeto instanceof Bicicleta) {
            return "Bicicleta: " + ((Bicicleta) objeto).getTipo();
        } else {
            return "Desconocido";
        }
    }

    }