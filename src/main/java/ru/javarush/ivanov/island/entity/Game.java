package ru.javarush.ivanov.island.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.javarush.ivanov.island.entity.map.GameMap;
import ru.javarush.ivanov.island.repository.Factory;
import ru.javarush.ivanov.island.view.View;

@Getter
@RequiredArgsConstructor
public class Game {

    private final GameMap gameMap;
    private final Factory entityFactory;
    private final View view;

}
