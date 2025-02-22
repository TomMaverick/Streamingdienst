public class UI {    
    public static void main(String[] args) {
        Streamingdienst sd = new Streamingdienst("See All");

        String derName = "Klaus Kleber";
        if(sd.sucheKunde(derName) == null){
            System.out.println("Kunde \"" +derName + "\" nicht gefunden."
                                + "\nKunde \"" +derName + "\" wird angelegt\n");
            sd.addKunde(derName);
        }
        else
            System.out.println("Kunde \"" +derName + "\" bereits im System enthalten\n");

        derName = "Nils Neuer";
        if(sd.sucheKunde(derName) == null){
            System.out.println("Kunde \"" +derName + "\" nicht gefunden."
                                + "\nKunde \"" +derName + "\" wird angelegt\n");
            sd.addKunde(derName);
        }
        else
            System.out.println("Kunde \"" +derName + "\" bereits im System enthalten\n");

        if(sd.sucheKunde(derName) == null){
            System.out.println("Kunde \"" +derName + "\" nicht gefunden."
                                + "\nKunde \"" +derName + "\" wird angelegt\n");
            sd.addKunde(derName);
        }
        else
            System.out.println("Kunde \"" +derName + "\" bereits im System enthalten\n");

        if(sd.addStream(derName))
            System.out.println("Stream für \"" + derName + "\" hinzugefügt!");
        else
            System.out.println("Stream nicht angelegt, Kunde \"" + derName + "\" unbekannt!");

        derName = "Tim Toner";
        if(sd.addStream(derName))
            System.out.println("Stream für \"" + derName + "\" hinzugefügt!");
        else
            System.out.println("Stream nicht angelegt, Kunde \"" + derName + "\" unbekannt!");

        derName = "Nils Neuer";
        if(sd.addStream(derName))
            System.out.println("Stream für \"" + derName + "\" hinzugefügt!");
        else
            System.out.println("Stream nicht angelegt, Kunde \"" + derName + "\" unbekannt!");

        derName = "Klaus Kleber";
        if(sd.addStream(derName))
            System.out.println("Stream für \"" + derName + "\" hinzugefügt!");
        else
            System.out.println("Stream nicht angelegt, Kunde \"" + derName + "\" unbekannt!");

        derName = "Nils Neuer";
        if(sd.addStream(derName))
            System.out.println("Stream für \"" + derName + "\" hinzugefügt!");
        else
            System.out.println("Stream nicht angelegt, Kunde  \"" + derName + "\"  unbekannt!");

        // Ausgaben
        System.out.println("\nKunden des Streamingdienstes:");
        for(Kunde k: sd.getKunden()){
            System.out.println("\t" + k.getName());
        }

        System.out.println("\nStreams des Streamingdienstes und deren Empfaenger:");
        for(Stream s: sd.getStreams()){
            System.out.println("\tStream-ID: " + s.getStreamId() + "; Kunde: "
                               + s.getEmpfaenger().getName());
        }

        System.out.println("\nStream-IDs von Nils Neuer:");
        for(Stream s: sd.sucheKunde("Nils Neuer").getMeineStreams()){
            System.out.println("\t" + s.getStreamId());
        }


        // Test der Statistikfunktion aus Aufgabe 4
        Datum vonDatum = new Datum("01.01.2025");   // Startdatum der Suche
        Datum bisDatum = new Datum();               // Enddatum der Suche (Heute)

        System.out.println("\n\nStatistiken:");
        for (Kunde kunde : sd.getKunden()) {
            int anzahlStreams = sd.statistik(kunde.getName(), vonDatum, bisDatum);
            System.out.println("Anzahl Streams von " + kunde.getName() + " im Zeitraum vom " + vonDatum.toString() + " bis " + bisDatum.toString() + ": " + anzahlStreams);
        }
    }
}