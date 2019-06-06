package nl.hu.taxcalculator;

public class Quartile {
    private int from;
    private int to;
    private double percentage;

    public Quartile(int from, int to, double percentage) {
        this.from = from >= to ? to - 1 : from;
        this.to = to <= from ? from + 1 : to;
        this.percentage = percentage;
    }

    public boolean qualifies(int value) {
        return from <= value;
    }

    public int result(int value) {
        // Use the maximum value (to) if the value is above this quartile.
        value = value > to ? to : value;

        // Make sure the part of the value between from and to is used.
        value = value > from ? value - from : 0;

        return (int) Math.round( ( (double) value / 100 ) * percentage);
    }

    @Override
    public String toString() {
        return "Between " + from + " and " + to + ", with percentage: " + percentage + "%";
    }
}
