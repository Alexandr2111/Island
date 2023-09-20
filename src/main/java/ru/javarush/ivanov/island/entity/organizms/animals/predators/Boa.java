package ru.javarush.ivanov.island.entity.organizms.animals.predators;

import ru.javarush.ivanov.island.abstraction.annotations.TypeData;
import ru.javarush.ivanov.island.entity.organizms.Limit;

@TypeData(name = "Удав", icon = "\uD83D\uDC0D", maxWeight = 15, maxCountInCell = 30,
        flockSize = 17, maxSpeed = 1, maxFood = 3)
public class Boa extends Predator {
    public Boa(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
