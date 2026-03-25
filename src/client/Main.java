package client;

import common.City;
import server.utils.CollectionManager;
import server.utils.CommandManager;
import server.commands.*;
import server.utils.FileManager;

import java.util.Vector;

/**
 * точка входа приложения
 * @param args аргументы командной строки
 */
public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Ошибка: укажите имя файла с коллекцией в аргументах командной строки.");
            System.exit(1);
        }
        String filePath = args[0];

        FileManager fileManager = new FileManager(filePath);
        Vector<City> loadedCollection = fileManager.readCollection();

        CollectionManager collectionManager = new CollectionManager(loadedCollection);

        CommandManager commandManager = new CommandManager();

        commandManager.register("add", new AddCommand(collectionManager));
        commandManager.register("show", new ShowCommand(collectionManager));
        commandManager.register("info", new InfoCommand(collectionManager));
        commandManager.register("update", new UpdateIdCommand(collectionManager));
        commandManager.register("remove_by_id", new RemoveByIdCommand(collectionManager));
        commandManager.register("clear", new ClearCommand(collectionManager));
        commandManager.register("save", new SaveCommand(collectionManager, fileManager));
        commandManager.register("exit", new ExitCommand());
        commandManager.register("remove_first", new RemoveFirstCommand(collectionManager));
        commandManager.register("reorder", new ReorderCommand(collectionManager));
        commandManager.register("remove_all_by_government", new RemoveAllByGovernmentCommand(collectionManager));
        commandManager.register("group_counting_by_id", new GroupCountingByIdCommand(collectionManager));
        commandManager.register("filter_starts_with_name", new FilterStartsWithName(collectionManager));
        commandManager.register("help", new HelpCommand(commandManager));
        commandManager.register("execute_script", new ExecuteScriptCommand(commandManager));
        ClientRun.runCli(commandManager);
    }
    //dsaasd
}