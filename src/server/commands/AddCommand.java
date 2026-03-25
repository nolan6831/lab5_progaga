package server.commands;

import common.City;
import common.Request;
import common.Response;
import server.utils.CollectionManager;

/**
 * добавляет элемент в коллекцию
 * @param request запрос с городом
 * @return результат добавления
 */
public class AddCommand implements Command {
    private CollectionManager collectionManager;

    public AddCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(Request request){
        City city = request.getCityArgument();
        this.collectionManager.add(city);
        Response result = new Response(true,"элемент добавлен");
        return result;
    }

    @Override
    public String getName(){
        return "add";
    }

    @Override
    public String getDescription(){
        return "добавляет элемент в коллекцию";
    }

}
