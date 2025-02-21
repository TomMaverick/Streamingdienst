import java.util.ArrayList;

public class Kunde {
    private String name;
    private ArrayList<Stream> meineStreams;

    // Konstruktor
    public Kunde(String name) {
        this.name = name;
        this.meineStreams = new ArrayList<>();
    }

    // Methoden
    public void addStream(Stream derStream) {
        meineStreams.add(derStream);
    }

    // Get-Set
    public String getName() {
        return this.name;
    }

    public ArrayList<Stream> getMeineStreams() {
        return meineStreams;
    }
}
