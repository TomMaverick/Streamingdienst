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
        Kunde neuerKunde = new Kunde(name);         // Erstellt einen neuen Kunden
        kundenliste.add(neuerKunde);                // und fügt es der Kundenliste hinzu.
        return neuerKunde;
    }

    public Kunde sucheKunde(String kundeName) {
        for(Kunde k : kundenliste) {                // Durchsucht die Kundenliste nach dem Kundennamen
            if (k.getName().equals(kundeName)) {    // Wenn Kundenname gefunden gib den Namen aus, ansonsten null
                return k;
            }
        }
        return null;
    }

    public boolean addStream(String kundeName) {
        for (Kunde k : kundenliste) {               // Suche den Kunden in der Kundenliste
            if (k.getName().equals(kundeName)) {
                Stream neuerStream = new Stream(k); // Füge dem Kunden einen neuen Stream hinzu
                k.addStream(neuerStream);
                return true;
            }
        }
        return false;
    }

    public int statistik(String kundeName, Datum dVon, Datum dBis) {
        int anzStreams = 0;
        long vonMillis = dVon.getTimeInMillis();
        long bisMillis = dBis.getTimeInMillis();

        // Falls Kunde nicht gefunden wird, gib 0 zurück
        Kunde k = sucheKunde(kundeName);
        if(k == null) {
            return 0;
        }
        
        // Prüfe für jeden Stream eines Kunden, ob er im angegebenen Zeitraum liegt
        for (Stream s : k.getMeineStreams()) {
            long streamMillis = s.getDatum().getTimeInMillis();
            if(streamMillis >= vonMillis && streamMillis <= bisMillis) {
                anzStreams++;
            }
        }
        return anzStreams;
    }

    // Set-Get Methoden
    // Rufe die Kundenliste des Streamingdiensts ab
    public ArrayList<Kunde> getKunden() {
        return kundenliste;
    }

    // Rufe die Streams aller Kunden ab
    public ArrayList<Stream> getStreams() {
        ArrayList<Stream> alleStreams = new ArrayList<>();
        for (Kunde k : kundenliste) {
            alleStreams.addAll(k.getMeineStreams());
        }
        return alleStreams;
    }
}
