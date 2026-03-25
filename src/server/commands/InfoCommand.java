package server.commands;

import common.Response;
import common.Request;
import server.utils.CollectionManager;

/**
 * показывает информацию о коллекции
 * @param request запрос
 * @return информация о коллекции
 */
public class InfoCommand implements Command {
    private CollectionManager collectionManager;

    public InfoCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public String getName(){
        return "info";
    }

    @Override
    public String getDescription(){
        return "возвращает информацию о коллекции";
    }

    @Override
    public Response execute(Request request){
        String result = collectionManager.info();
        Response response = new Response(true,result);
        return response;
    }
}
