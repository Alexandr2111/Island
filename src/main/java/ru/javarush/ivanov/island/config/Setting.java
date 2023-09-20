package ru.javarush.ivanov.island.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import ru.javarush.ivanov.island.entity.organizms.Organism;
import ru.javarush.ivanov.island.entity.organizms.animals.herbivores.*;
import ru.javarush.ivanov.island.entity.organizms.animals.predators.*;
import ru.javarush.ivanov.island.entity.organizms.plants.Plant;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter(AccessLevel.PROTECTED)
public class Setting {

    public static final String SETTING_YAML = "ivanov/setting.yaml";
    private static final Class<?>[] TYPES = new Class[]{
            Wolf.class, Bear.class, Eagle.class, Fox.class, Boa.class,
            Horse.class, Mouse.class, Deer.class, Rabbit.class, Goat.class,
            Sheep.class, Boar.class, Buffalo.class, Duck.class, Caterpillar.class,
            Plant.class};
    public static final Organism[] PROTOTYPES = EntityScanner.createPrototypes(TYPES);

    private static volatile Setting SETTING;

    public static Setting get() {
        Setting setting = SETTING;
        if (Objects.isNull(setting)) {
            synchronized (Setting.class) {
                if (Objects.isNull(setting = SETTING)) {
                    setting = SETTING = new Setting();
                }
            }
        }
        return setting;
    }

    private int period;
    private int rows;
    private int cols;

    private int showRows;
    private int showCols;
    private int consoleCellWith;
    private int percentAnimalSlim;
    private int percentPlantGrow;
    @Getter(AccessLevel.PROTECTED)
    private Map<String, Map<String, Integer>> foodMap = new LinkedHashMap<>();

    public Map<String, Integer> getFoodMap(String keyName) {
        this.foodMap.putIfAbsent(keyName, new LinkedHashMap<>());
        return foodMap.get(keyName);
    }

    private Setting() {
        loadFromDefault();
        updateFromYaml();
    }

    private void loadFromDefault() {
        period = Default.PERIOD;

        rows = Default.ROWS;
        cols = Default.COLS;

        showRows = Default.SHOW_ROWS;
        showCols = Default.SHOW_COLS;
        consoleCellWith = Default.CONSOLE_CELL_WITH;
        percentAnimalSlim = Default.PERCENT_ANIMAL_SLIM;
        percentPlantGrow = Default.PERCENT_PLANT_GROW;
        for (int i = 0, n = Default.names.length; i < n; i++) {
            String key = Default.names[i];
            this.foodMap.putIfAbsent(key, new LinkedHashMap<>());
            for (int j = 0; j < n; j++) {
                int ratio = Default.setProbablyTable[i][j];
                if (ratio > 0) {
                    this.foodMap.get(key).put(Default.names[j], ratio);
                }
            }
        }
    }

    @SneakyThrows
    private void updateFromYaml() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        ObjectReader readerForUpdating = mapper.readerForUpdating(this);
        URL resource = Setting.class.getClassLoader().getResource(SETTING_YAML);
        if (Objects.nonNull(resource)) {
            readerForUpdating.readValue(resource.openStream());
        }
    }

    @Override
    public String toString() {
        ObjectMapper yaml = new ObjectMapper(new YAMLFactory());
        yaml.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            return yaml.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
