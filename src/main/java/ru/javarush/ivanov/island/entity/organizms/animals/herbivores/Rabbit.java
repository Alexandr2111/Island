package ru.javarush.ivanov.island.entity.organizms.animals.herbivores;

import ru.javarush.ivanov.island.abstraction.annotations.TypeData;
import ru.javarush.ivanov.island.entity.organizms.Limit;

@TypeData(name = "Кролик", icon = "\uD83D\uDC07", maxWeight = 2, maxCountInCell = 150,
        flockSize = 50, maxSpeed = 2, maxFood = 0.45)
public class Rabbit extends Herbivore {
    public Rabbit(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
