package ru.javarush.ivanov.island.entity.organizms.animals.herbivores;

import ru.javarush.ivanov.island.abstraction.annotations.TypeData;
import ru.javarush.ivanov.island.entity.organizms.Limit;

@TypeData(name = "Овца", icon = "\uD83D\uDC11", maxWeight = 70, maxCountInCell = 140,
        flockSize = 10, maxSpeed = 3, maxFood = 15)
public class Sheep extends Herbivore {
    public Sheep(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
