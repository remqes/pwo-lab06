package pwo.utils;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Klasa narzędziowa służaca do obsługi obiektów<br>
 * implementujacej interfejs {@link SequenceGenerator}
 * 
 * @author Michał Nurzyński
 * @version 1.0.0
 */

public class SequenceTools {
    
    private static String getTerms(SequenceGenerator sg, int from, int to, String sep) {
        int i = from, stop = to, step = from > to ? -1 : 1;
        String terms = "";
        
        while(true) {
            terms += sg.getTerm(i) + sep;
            if (i == stop) return terms.trim();
            i += step;
        }
    }
    
    /**
     * Zamienia wyrazy ciagu na tekst.<br>
     * Wyrazy ciagu tworza kolumnę.
     * 
     * @param sg Dowolny obiekt implementujacy {@link SequenceGenerator}
     * @param from Poczatkowy wyraz ciagu
     * @param to Koncowy wyraz ciagu
     * @return Wyrazy ciagu w postaci tekstu tworzacego kolumnę
     * @see #getTermsAsLine(pwo.utils.SequenceGenerator, int, int)
     */
    public static String getTermsAsColumn(SequenceGenerator sg, int from, int to) {
        return getTerms(sg, from, to, "\n");
    }
    
    /**
     * Zamienia wyrazy ciagu na tekst.<br>
     * Wyrazy ciagu tworza wiersz.
     * 
     * @param sg Dowolny obiekt implementujacy {@link SequenceGenerator}
     * @param from Poczatkowy wyraz ciagu
     * @param to Końcowy wyraz ciagu
     * @return Wyrazy ciagu w postaci tekstu tworzacego wiersz
     * @see #getTermsAsColumn(pwo.utils.SequenceGenerator, int, int)  
     */
    public static String getTermsAsLine(SequenceGenerator sg, int from, int to) {
        return getTerms(sg, from, to, " ");
    }
    
    /**
     * Zapisuje wyrazy ciagu do pliku w postaci kolumny.
     * 
     * @param sg Dowolny obiekt implementujacy {@link SequenceGenerator}
     * @param from Poczatkowy wyraz ciagu
     * @param to Końcowy wyraz ciagu
     * @param fileName Nazwa pliku
     * @return true jeżeli udało się zapisać plik,
     * false w przeciwnym wypadku.
     */
    public static boolean writeToFile(SequenceGenerator sg, int from, int to, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) { 
            writer.write(getTermsAsColumn(sg, from, to));
        } catch(IOException ex) {
            return false;
        }
        return true;
    }
}
