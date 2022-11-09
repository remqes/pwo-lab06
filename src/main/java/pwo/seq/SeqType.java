package pwo.seq;

import java.util.stream.Stream;

/**
 * Typ wyliczeniowy obejmujacy wszystkie
 * zrealizowane ciagi. <br>
 * Jest to również menadżer służacy do pozyskania
 * obiektu klasy ciagu metoda {@link #getGenerator() }
 * 
 * @author Michał Nurzyński
 * @version 1.0.0
 */
public enum SeqType {
    /**
     * Ciag Fibonacciego
     * @see <a href="https://pl.wikipedia.org/wiki/Ci%C4%85g_Fibonacciego">Wikipedia</a>
     */
    FIB, //Fibonacci
    /**
     * Ciag Lucasa
     * @see <a href="https://en.wikipedia.org/wiki/Lucas_number">Wikipedia</a>
     */
    LUC, //Lucas
    /**
     * Ciag Tribonacciego
     * @see  <a href="https://pl.wikipedia.org/wiki/Ci%C4%85g_Fibonacciego#Ci%C4%85g_%E2%80%9ETribonacciego%E2%80%9D">Wikipedia</a>
     */
    TRI; //Tribonacci
    
    private static final int B = 0, L = 3;
    private static final String FIX_SEQTYPE = "Problem in " + SeqType.class.getName();
    
    static {
        Stream.of(SeqType.values()).forEach(t -> {
            if (t.toString().length() != L) {
                throw new IllegalStateException(FIX_SEQTYPE);
            }
        });
    }
    
    /**
     * Pozyskanie wartości typu na podstawie tekstu.<br>
     * Metoda nie jest czuła na wielkość czcionki.
     * Tylko 3 pierwsze litery słowa sa znaczace.
     * 
     * @param type W obecnej wersji: "fib", "luc" lub "tri"
     * @return Odpowiadajaca argumentowi wartość typu lub null
     */
    public static SeqType fromString(String type) {
        try {
            return valueOf(type.trim().substring(B, L).toUpperCase());
        } catch (NullPointerException | StringIndexOutOfBoundsException | IllegalArgumentException ex) {
            return null;
        }
    }
    
    /**
     * Tworzy obiekt generatora.
     * Korespondujacy z nadana wartościa.
     * 
     * @return Obiekt implementujacy {@link pwo.utils.SequenceGenerator}
     */
    public Generator getGenerator() {
        switch (this) {
            case FIB: return new FibonacciGenerator();
            case LUC: return new LucasGenerator();
            case TRI: return new TribonacciGenerator();
            default: throw new IllegalStateException(FIX_SEQTYPE);
        }
    }
}
