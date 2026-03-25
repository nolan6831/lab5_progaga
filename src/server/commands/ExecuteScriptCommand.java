package server.commands;

import common.City;
import common.Coordinates;
import common.Human;
import common.Climate;
import common.Government;
import common.StandardOfLiving;
import common.Request;
import common.Response;
import server.utils.CommandManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * исполняет скрипт из файла
 * @param request запрос с именем файла
 * @return результат выполнения скрипта
 */
public class ExecuteScriptCommand implements Command {
    private static java.util.Vector<String> activeScripts = new java.util.Vector<>();
    private CommandManager commandManager;

    public ExecuteScriptCommand(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    @Override
    public Response execute(Request request) {
        String fileName = request.getStringArgument();
        
        if (fileName == null || fileName.trim().isEmpty()) {
            return new Response(false, "ошибка: не указано имя файла");
        }

        if (activeScripts.contains(fileName)) {
            return new Response(false, "ошибка: бесконечная рекурсия");
        }

        File scriptFile = new File(fileName);
        if (!scriptFile.exists()) {
            return new Response(false, "ошибка: файл не найден: " + fileName);
        }

        if (!scriptFile.canRead()) {
            return new Response(false, "ошибка: нет доступа на чтение файла: " + fileName);
        }

        activeScripts.add(fileName);
        StringBuilder resultMessage = new StringBuilder();
        boolean hasErrors = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(scriptFile))) {
            String line;
            int lineNumber = 0;
            
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                line = line.trim();
                
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }

                String[] parts = line.split("\\s+");
                String commandName = parts[0];

                Request commandRequest;
                Response response;

                if (commandName.equals("add")) {
                    if (parts.length < 11) {
                        hasErrors = true;
                        resultMessage.append("строка ").append(lineNumber)
                                .append(": ошибка: команда add требует 10 аргументов (name x y area population metersAboveSeaLevel climate government standardOfLiving height), найдено: ")
                                .append(parts.length - 1).append("\n");
                        continue;
                    }
                    try {
                        City city = parseCity(parts, 1);
                        commandRequest = new Request(commandName, "", city);
                        response = commandManager.executeCommand(commandRequest);
                    } catch (IllegalArgumentException e) {
                        hasErrors = true;
                        resultMessage.append("строка ").append(lineNumber)
                                .append(": ошибка: ").append(e.getMessage()).append("\n");
                        continue;
                    }
                } else if (commandName.equals("update")) {
                    if (parts.length < 12) {
                        hasErrors = true;
                        resultMessage.append("строка ").append(lineNumber)
                                .append(": ошибка: команда update требует id и 10 аргументов (name x y area population metersAboveSeaLevel climate government standardOfLiving height), найдено: ")
                                .append(parts.length - 1).append("\n");
                        continue;
                    }
                    try {
                        String idStr = parts[1];
                        City city = parseCity(parts, 2);
                        commandRequest = new Request(commandName, idStr, city);
                        response = commandManager.executeCommand(commandRequest);
                    } catch (IllegalArgumentException e) {
                        hasErrors = true;
                        resultMessage.append("строка ").append(lineNumber)
                                .append(": ошибка: ").append(e.getMessage()).append("\n");
                        continue;
                    }
                } else {
                    String argument = parts.length > 1 ? String.join(" ", java.util.Arrays.copyOfRange(parts, 1, parts.length)) : "";
                    commandRequest = new Request(commandName, argument);
                    response = commandManager.executeCommand(commandRequest);
                }
                
                if (!response.getSuccess()) {
                    hasErrors = true;
                }
                resultMessage.append("строка ").append(lineNumber)
                        .append(": ").append(response.getMessage()).append("\n");
            }
        } catch (IOException e) {
            activeScripts.remove(fileName);
            return new Response(false, "ошибка чтения файла: " + e.getMessage());
        } finally {
            activeScripts.remove(fileName);
        }

        return new Response(!hasErrors, resultMessage.toString().trim());
    }


    private City parseCity(String[] parts, int startIndex) {
        City city = new City();
        
        String name = parts[startIndex];
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name не может быть пустым");
        }
        city.setName(name);
        
        int x;
        try {
            x = Integer.parseInt(parts[startIndex + 1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("x должен быть целым числом");
        }
        
        Float y;
        try {
            y = Float.parseFloat(parts[startIndex + 2]);
            if (y > 709f) {
                throw new IllegalArgumentException("y должен быть <= 709");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("y должен быть числом");
        }
        city.setCoordinates(new Coordinates(x, y));
        
        Double area;
        try {
            area = Double.parseDouble(parts[startIndex + 3]);
            if (area <= 0) {
                throw new IllegalArgumentException("area должна быть > 0");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("area должна быть числом");
        }
        city.setArea(area);
        
        Integer population;
        try {
            population = Integer.parseInt(parts[startIndex + 4]);
            if (population <= 0) {
                throw new IllegalArgumentException("population должно быть > 0");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("population должно быть целым числом");
        }
        city.setPopulation(population);
        
        float metersAboveSeaLevel;
        try {
            metersAboveSeaLevel = Float.parseFloat(parts[startIndex + 5]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("metersAboveSeaLevel должно быть числом");
        }
        city.setMetersAboveSeaLevel(metersAboveSeaLevel);
        

        Climate climate = null;
        String climateStr = parts[startIndex + 6];
        if (!climateStr.equalsIgnoreCase("null")) {
            try {
                climate = Climate.valueOf(climateStr.toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("неверное значение climate: " + climateStr);
            }
        }
        city.setClimate(climate);

        Government government = null;
        String governmentStr = parts[startIndex + 7];
        if (!governmentStr.equalsIgnoreCase("null")) {
            try {
                government = Government.valueOf(governmentStr.toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("неверное значение government: " + governmentStr);
            }
        }
        city.setGovernment(government);
        
        StandardOfLiving standardOfLiving;
        String standardOfLivingStr = parts[startIndex + 8];
        try {
            standardOfLiving = StandardOfLiving.valueOf(standardOfLivingStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("неверное значение standardOfLiving: " + standardOfLivingStr);
        }
        city.setStandardOfLiving(standardOfLiving);
        
        Long height = null;
        String heightStr = parts[startIndex + 9];
        if (!heightStr.equalsIgnoreCase("null")) {
            try {
                height = Long.parseLong(heightStr);
                if (height <= 0) {
                    throw new IllegalArgumentException("height должен быть > 0");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("height должен быть целым числом");
            }
        }
        city.setGovernor(new Human(height));
        
        return city;
    }

    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    public String getDescription() {
        return "считать и исполнить скрипт из указанного файла";
    }

    public static void removeScript(String fileName) {
        activeScripts.remove(fileName);
    }
}
