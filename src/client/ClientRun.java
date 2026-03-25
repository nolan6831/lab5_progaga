package client;

import common.City;
import common.Request;
import common.Response;
import org.jline.reader.UserInterruptException;
import server.utils.CommandManager;

/**
 * запускает клиентский интерфейс
 * @param commandManager менеджер команд
 */
public class ClientRun {
    public static void runCli(CommandManager commandManager) {
        ConsoleReader console = new ConsoleReader();
        Asker asker = new Asker(console);
        CommandHistory history = new CommandHistory();

        System.out.println("Добро пожаловать в программу упрапвления городами! Введите help для списка команд.");

        while (true) {
            String input;
            try {
                input = console.readLine("> ");
            } catch (UserInterruptException e) {
                System.out.println("\nИспользование Ctrl+C для выхода не предусмотрено. Введите 'exit' для завершения.");
                continue;
            }
            if (input == null) break;
            input = input.trim();
            if (input.isEmpty()) continue;

            String[] parts = input.split("\\s+", 2);
            String commandName = parts[0];
            String argument = parts.length > 1 ? parts[1] : "";

            if (commandName.equals("history")) {
                history.printHistory();
                continue;
            }



            history.addCommand(commandName);

            Request request;
            if (commandName.equals("add") || commandName.equals("update")) {
                if (commandName.equals("update") && argument.isEmpty()) {
                    System.out.println("Ошибка: для update нужен id");
                    continue;
                }
                City city = asker.readCity();
                request = new Request(commandName, argument, city);
            } else {
                request = new Request(commandName, argument);
            }

            Response response = commandManager.executeCommand(request);
            System.out.println(response.getMessage());

            if (commandName.equals("exit") && response.getSuccess()) {
                System.exit(0);
            }
            //dsasdas
        }
    }
}