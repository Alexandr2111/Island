package ru.javarush.ivanov.island.entity.organizms.animals.herbivores;

import ru.javarush.ivanov.island.abstraction.annotations.TypeData;
import ru.javarush.ivanov.island.entity.organizms.Limit;

@TypeData(name = "Олень", icon = "\uD83E\uDD8C", maxWeight = 300, maxCountInCell = 20,
        flockSize = 5, maxSpeed = 4, maxFood = 60)
public class Deer extends Herbivore {
    public Deer(String name, String icon, Limit limit) {
        super(name, icon, limit);
    }

}
