public class Stream{
    // Attribute
    private static int zaehler = 1;
    private int streamId;
    private Datum zeitstempel;
    private Kunde empfaenger;
  
    // Konstruktor
    public Stream(Kunde derKunde) {
        this.streamId = zaehler++;
        this.zeitstempel = new Datum();
        this.empfaenger = derKunde;
    }
  
    // get- und set-Methoden
    public int getStreamId(){
        return streamId;
    } 

    public Kunde getEmpfaenger(){
        return empfaenger;
    }

    public Datum getDatum() {
        return zeitstempel;
    }
}