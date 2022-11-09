package pwo.seq;

import java.math.BigDecimal;

/**
 * Klasa słuzaca do generowania ciagu 
 * Fibonacciego.
 * 
 * @author Michał Nurzyński
 * @version 1.0.0
 */
public class FibonacciGenerator extends Generator {

    /**
     * Konstruktor klasy pozwalajacy na ustawienie poczatkowych wyrazow ciagu
     */
    public FibonacciGenerator() {
        current = new BigDecimal(0);
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(0);
    }

    /**
     * Metoda powodujaca reset metody {@link #nextTerm()} 
     */
    @Override
    public void reset() {
        super.reset();
        current = new BigDecimal(0);
        f_1 = new BigDecimal(1);
        f_2 = new BigDecimal(0);
    }
    
    /**
     * Metoda zwracajaca kolejne wartosci ciagu
     * 
     * @return Wartosc kolejnego wyrazu ciagu
     */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex > 1) {
            current = f_1.add(f_2);
            f_2 = f_1;
            f_1 = current;
        } else if (lastIndex == 1) {
            current = new BigDecimal(1);
        } else {
            current = new BigDecimal(0);
        }

        lastIndex++;
        return current;
    }

}
