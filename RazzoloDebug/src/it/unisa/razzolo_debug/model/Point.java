package it.unisa.razzolo_debug.model;

/**
 * @param i indice riga matrice
 * @param j indice colonna matrice
 * @param value valore casella
 * @param index indice stringa
 */

public record Point(int i, int j, char value, int index) {
    public static Direction[] directions = {
        new Direction(0, -1),   // up
        new Direction(1, -1),   // up-dx
        new Direction(1, 0),    // dx
        new Direction(1, 1),    // dw-dx
        new Direction(0, 1),    // dw
        new Direction(-1, 1),   // dw-sx
        new Direction(-1, 0),   // sx
        new Direction(-1, -1)   // up-sx
    };
}