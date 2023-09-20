package ru.javarush.ivanov.island.services;

import ru.javarush.ivanov.island.entity.map.Cell;
import ru.javarush.ivanov.island.entity.map.GameMap;
import ru.javarush.ivanov.island.entity.organizms.Organism;
import ru.javarush.ivanov.island.entity.organizms.Organisms;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class OrganismWorker implements Runnable {

    private final Organism prototype;
    private final GameMap gameMap;
    private final Queue<Task> tasks = new ConcurrentLinkedQueue<>();

    public OrganismWorker(Organism prototype, GameMap gameMap) {
        this.prototype = prototype;
        this.gameMap = gameMap;
    }

    @Override
    public void run() {
        Cell[][] cells = gameMap.getCells();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                try {
                    processOneCell(cell);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.println("OMG. Debug it!");
                    System.exit(0);
                }
            }
        }
    }

    private void processOneCell(Cell cell) {
        String type = prototype.getType();
        Organisms organisms = cell.getResidents().get(type);
        if (Objects.nonNull(organisms)) {
            cell.getLock().lock();
            try {
                organisms.forEach(organism -> {
                    tasks.add(new Task(organism, cell));
                });
            } finally {
                cell.getLock().unlock();
            }

            tasks.forEach(Task::doTask);
            tasks.clear();
        }
    }
}
