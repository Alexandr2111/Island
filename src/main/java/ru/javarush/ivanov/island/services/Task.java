package ru.javarush.ivanov.island.services;

import lombok.Getter;
import ru.javarush.ivanov.island.entity.map.Cell;
import ru.javarush.ivanov.island.entity.organizms.Organism;
import ru.javarush.ivanov.island.entity.organizms.animals.Animal;

@Getter
public class Task {

    private final Organism organism;
    private final Cell cell;

    public Task(Organism organism, Cell cell) {
        this.organism = organism;
        this.cell = cell;
    }

    public void doTask() {
        if (organism instanceof Animal animal) {
            if (animal.eat(cell)) {
                animal.spawn(cell);
            }
            animal.move(cell);

        } else {
            organism.spawn(cell);
        }
    }

}
