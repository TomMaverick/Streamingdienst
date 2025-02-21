import java.util.ArrayList;

public class Streamingdienst {
    private String bezeichnung;
    private ArrayList<Kunde> kundenliste;

    // Konstruktor
    public Streamingdienst(String bez) {
        this.bezeichnung = bez;
        this.kundenliste = new ArrayList<>();
    }

    // Methoden
    public Kunde addKunde(String name) {
        Kunde neuerKunde = new Kunde(name);
        kundenliste.add(neuerKunde);
        return neuerKunde;
    }

    public Kunde sucheKunde(String kundeName) {
        for(Kunde k : kundenliste) {
            if (k.getName().equals(kundeName)) {
                return k;
            }
        }
        return null;
    }

    public boolean addStream(String kundeName) {
        for (Kunde k : kundenliste) {
            if (k.getName().equals(kundeName)) {
                Stream neuerStream = new Stream(k);     // Neuer Stream wird Kunden zugewiesen
                k.addStream(neuerStream);
                return true;
            }
        }
        return false;
    }

    // Set-Get Methoden
    public ArrayList<Kunde> getKunden() {
        return kundenliste;
    }

    public ArrayList<Stream> getStreams() {
        ArrayList<Stream> alleStreams = new ArrayList<>();
        for (Kunde k : kundenliste) {
            alleStreams.addAll(k.getMeineStreams());
        }
        return alleStreams;
    }
}
