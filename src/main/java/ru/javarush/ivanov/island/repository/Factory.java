package ru.javarush.ivanov.island.repository;

import ru.javarush.ivanov.island.entity.map.Cell;
import ru.javarush.ivanov.island.entity.organizms.Organism;

import java.util.List;

public interface Factory {

    Cell createRandomCell(boolean empty);

    List<Organism> getAllPrototypes();

}
