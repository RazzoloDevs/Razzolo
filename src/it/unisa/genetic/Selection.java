package it.unisa.genetic;

import it.unisa.model.Point;

import java.util.List;

public class Selection {

    // Seleziono solo gli individui che hanno un function > 0
    public void fitnessGraterThan0(final List<Point[]> l){
        l.removeIf(p -> Fitness.function(p) <= 0);
    }
}
