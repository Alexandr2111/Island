package ru.javarush.ivanov.island.abstraction.entity;

import ru.javarush.ivanov.island.entity.map.Cell;

public interface Reproducible {

    boolean spawn(Cell currentCell);

}
