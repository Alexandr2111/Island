package ru.javarush.ivanov.island.entity.organizms.animals.predators;

import ru.javarush.ivanov.island.abstraction.annotations.TypeData;
import ru.javarush.ivanov.island.entity.organizms.Limit;

@TypeData(name = "Орел", icon = "\uD83E\uDD85", maxWeight = 6, maxCountInCell = 20,
        flockSize = 18, maxSpeed = 3, maxFood = 1)
public class Eagle extends Predator {

    public Eagle(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }
}
