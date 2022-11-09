package pwo.utils;

import java.math.BigDecimal;

/**
 * Interfejs dowolnego generatora liczbowego
 * o wyrazach zdefiniowanych w zakresie od 0.
 * 
 * @author Michał Nurzyński
 * @version 1.0.0
 */
public interface SequenceGenerator {

    /**
     * Powoduje, że metoda {@link #nextTerm()}
     * rozpoczyna się od 0.<br>
     * Nie wpływa na działanie metody {@link #getTerm(int)}.
     */
    void reset();

    /**
     * Zwraca kolejny wyraz ciagu.
     * 
     * @return Wartość wyrazu ciagu
     * @see #getTerm(int) 
     */
    BigDecimal nextTerm();

    /**
    * Zwraca wyraz ciągu o podanym indeksie.
    *
    * @param i Nr wyrazu ciągu dla którego
    * jest uzyskiwana wartość
    * @return Wartość wyrazu ciągu o indeksie i
    * @exception IllegalArgumentException jeżeli i<0
    * @see #nextTerm()
    */

    BigDecimal getTerm(int i);
}
