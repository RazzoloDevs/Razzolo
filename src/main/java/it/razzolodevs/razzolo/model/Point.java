package main.java.it.razzolodevs.razzolo.model;

/**
 * @param i indice riga matrice
 * @param j indice colonna matrice
 * @param value valore casella
 * @param index indice stringa
 */

public record Point(int i, int j, char value, int index) {
    public static String getString(Point[] points){
        StringBuilder s = new StringBuilder();
        for(Point p : points)
            s.append(p.value);
        return s.toString();
    }
}