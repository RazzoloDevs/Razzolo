package it.unisa.razzolo_debug.model;

/**
 * @param i indice riga matrice
 * @param j indice colonna matrice
 * @param value valore casella
 * @param index indice stringa
 */

public record Point(int i, int j, char value, int index) {
}