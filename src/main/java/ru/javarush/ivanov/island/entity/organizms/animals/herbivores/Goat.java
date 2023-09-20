package ru.javarush.ivanov.island.entity.organizms.animals.herbivores;

import ru.javarush.ivanov.island.abstraction.annotations.TypeData;
import ru.javarush.ivanov.island.entity.organizms.Limit;

@TypeData(name = "Коза", icon = "\uD83D\uDC10", maxWeight = 60, maxCountInCell = 140,
        flockSize = 10, maxSpeed = 1, maxFood = 10)
public class Goat extends Herbivore {
    public Goat(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
