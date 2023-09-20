package ru.javarush.ivanov.island;


import ru.javarush.ivanov.island.config.Setting;
import ru.javarush.ivanov.island.entity.Game;
import ru.javarush.ivanov.island.entity.map.GameMap;
import ru.javarush.ivanov.island.repository.EntityFactory;
import ru.javarush.ivanov.island.repository.Factory;
import ru.javarush.ivanov.island.repository.GameMapCreator;
import ru.javarush.ivanov.island.services.GameWorker;
import ru.javarush.ivanov.island.view.ConsoleView;
import ru.javarush.ivanov.island.view.View;

public class AppRunner {
    public static void main(String[] args) {
        Factory entityFactory = new EntityFactory();
        GameMapCreator gameMapCreator = new GameMapCreator(entityFactory);
        int rows = Setting.get().getRows();
        int cols = Setting.get().getCols();
        GameMap gameMap = gameMapCreator.createRandomFilledGameMap(rows, cols, false);
        View view = new ConsoleView(gameMap);
        Game game = new Game(gameMap, entityFactory,view);
        GameWorker gameWorker = new GameWorker(game);
        gameWorker.start();
    }
}
