package server.commands;

import common.Response;
import common.Request;
import server.utils.CollectionManager;

/**
 * очищает коллекцию
 */
public class ClearCommand implements Command {
    private CollectionManager collectionManager;

    /**
     * создаёт команду clear
     * @param collectionManager менеджер коллекции
     */
    public ClearCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    /**
     * выполняет команду clear - очищает коллекцию
     * @param request запрос
     * @return результат очистки
     */
    public Response execute(Request request){
        collectionManager.clear();
        return new Response(true,"коллекция очищена");
    }

    @Override
    /**
     * @return имя команды "clear"
     */
    public String getName(){
        return "clear";
    }

    @Override
    /**
     * @return описание команды
     */
    public String getDescription(){
        return "чистит коллекцию";
    }

}
