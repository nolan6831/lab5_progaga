package server.commands;

import common.Request;
import common.Response;
import server.utils.CollectionManager;
import server.utils.FileManager;

public class SaveCommand implements Command {
    private final CollectionManager collectionManager;
    private final FileManager fileManager;

    public SaveCommand(CollectionManager collectionManager, FileManager fileManager) {
        this.collectionManager = collectionManager;
        this.fileManager = fileManager;
    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "сохранить коллекцию в файл";
    }

    @Override
    public Response execute(Request request) {
        try {
            fileManager.writeCollection(collectionManager.getCollection());
            return new Response(true, "Коллекция сохранена в файл.");
        } catch (Exception e) {
            return new Response(false, "Ошибка сохранения: " + e.getMessage());
        }
    }
}