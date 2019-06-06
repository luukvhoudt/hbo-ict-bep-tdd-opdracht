package nl.hu.taxcalculator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class IncomeTaxCalculator {
    private boolean aowQualified;

    private ArrayList<Quartile> aowQuartiles;
    private ArrayList<Quartile> nonAowQuartiles;


    public IncomeTaxCalculator(LocalDate birthDate) {
        this(birthDate, LocalDate.now());
    }

    public IncomeTaxCalculator(LocalDate birthDate, LocalDate forDate) {
        aowQuartiles = new ArrayList<>();

        aowQuartiles.add(new Quartile(0, 20142, 18.65));
        aowQuartiles.add(new Quartile(20143, 34404, 22.95));
        aowQuartiles.add(new Quartile(34405, 68507, 40.85));
        aowQuartiles.add(new Quartile(68508, Integer.MAX_VALUE, 51.95));

        nonAowQuartiles = new ArrayList<>();
        nonAowQuartiles.add(new Quartile(0, 20142, 36.55));
        nonAowQuartiles.add(new Quartile(20143, 33994, 40.85));
        nonAowQuartiles.add(new Quartile(33995, 68507, 40.85));
        nonAowQuartiles.add(new Quartile(68508, Integer.MAX_VALUE, 51.95));

        aowQualified = new AOWQualifier(forDate).doesDateQualify(birthDate);
    }

    public int calculateIncomeTax(int income) {
        return runIncomeTaxCalculation(aowQualified ? aowQuartiles.iterator() : nonAowQuartiles.iterator(), income);
    }

    private int runIncomeTaxCalculation(Iterator<Quartile> i, int income) {
        int output = 0;
        while (i.hasNext()) {
            Quartile q = i.next();
            output += q.qualifies(income) ? q.result(income) : 0;
        }
        return output;
    }
}
