package server.commands;

import common.Request;
import common.Response;
import server.utils.CollectionManager;
import server.utils.FileManager;

/**
 * сохраняет коллекцию в файл
 */
public class SaveCommand implements Command {
    private final CollectionManager collectionManager;
    private final FileManager fileManager;

    /**
     * создаёт команду save
     * @param collectionManager менеджер коллекции
     * @param fileManager менеджер файлов
     */
    public SaveCommand(CollectionManager collectionManager, FileManager fileManager) {
        this.collectionManager = collectionManager;
        this.fileManager = fileManager;
    }

    @Override
    /**
     * @return имя команды "save"
     */
    public String getName() {
        return "save";
    }

    @Override
    /**
     * @return описание команды
     */
    public String getDescription() {
        return "сохранить коллекцию в файл";
    }

    @Override
    /**
     * сохраняет коллекцию в файл - записывает XML
     * @param request запрос
     * @return результат сохранения
     */
    public Response execute(Request request) {
        try {
            fileManager.writeCollection(collectionManager.getCollection());
            return new Response(true, "Коллекция сохранена в файл.");
        } catch (Exception e) {
            return new Response(false, "Ошибка сохранения: " + e.getMessage());
        }
    }
}