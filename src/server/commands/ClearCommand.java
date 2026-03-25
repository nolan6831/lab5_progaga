package server.commands;

import common.Response;
import common.Request;
import server.utils.CollectionManager;

/**
 * обращается к колекции и очищает ее
 * @return возвращает пустую коллекцию
 */
public class ClearCommand implements Command {
    private CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(Request request){
        collectionManager.clear();
        return new Response(true,"коллекция очищена");
    }

    @Override
    public String getName(){
        return "clear";
    }

    @Override
    public String getDescription(){
        return "чистит коллекцию";
    }

}
