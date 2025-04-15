package veicolo;
import java.util.ArrayList;
import java.util.List;

// Interfaccia Veicolo
interface Veicolo {
    void avvia();
    void ferma();
    String getTipo();
}

// Classe astratta MezzoDiTrasporto
abstract class MezzoDiTrasporto implements Veicolo {
    protected String targa;
    protected boolean inMovimento;

    public MezzoDiTrasporto(String targa) {
        this.targa = targa;
        this.inMovimento = false;
    }

    public void avvia() {
        if (!inMovimento) {
            inMovimento = true;
            System.out.println(getTipo() + " con targa " + targa + " avviato.");
        } else {
            System.out.println(getTipo() + " con targa " + targa + " è già in movimento.");
        }
    }

    public void ferma() {
        if (inMovimento) {
            inMovimento = false;
            System.out.println(getTipo() + " con targa " + targa + " fermato.");
        } else {
            System.out.println(getTipo() + " con targa " + targa + " è già fermo.");
        }
    }
}

// Classe concreta Auto
class Auto extends MezzoDiTrasporto {
    public Auto(String targa) {
        super(targa);
    }

    public String getTipo() {
        return "Auto";
    }
}

// Classe concreta Moto
class Moto extends MezzoDiTrasporto {
    public Moto(String targa) {
        super(targa);
    }
    public String getTipo() {
        return "Moto";
    }
}

// Classe principale per gestire la flotta di veicoli
public class GestioneVeicoli {
    public static void main(String[] args) {
        List<Veicolo> flotta = new ArrayList<>();

        // Aggiungi veicoli alla flotta
        flotta.add(new Auto("AB123CD"));
        flotta.add(new Moto("EF456GH"));
        flotta.add(new Auto("IJ789KL"));
        flotta.add(new Moto("MN012OP"));

        // Avvia i veicoli
        for (Veicolo veicolo : flotta) {
            veicolo.avvia();
        }

        System.out.println("\nFermiamo i veicoli...\n");

        // Ferma i veicoli
        for (Veicolo veicolo : flotta) {
            veicolo.ferma();
        }
    }
}