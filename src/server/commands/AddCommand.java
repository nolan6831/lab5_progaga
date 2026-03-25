package server.commands;

import common.City;
import common.Request;
import common.Response;
import server.utils.CollectionManager;

/**
 * добавляет элемент в коллекцию
 */
public class AddCommand implements Command {
    private CollectionManager collectionManager;

    /**
     * создаёт команду add
     * @param collectionManager менеджер коллекции
     */
    public AddCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    /**
     * выполняет команду add - добавляет город в коллекцию
     * @param request запрос с городом
     * @return результат добавления
     */
    public Response execute(Request request){
        City city = request.getCityArgument();
        this.collectionManager.add(city);
        Response result = new Response(true,"элемент добавлен");
        return result;
    }

    @Override
    /**
     * @return имя команды "add"
     */
    public String getName(){
        return "add";
    }

    @Override
    /**
     * @return описание команды
     */
    public String getDescription(){
        return "добавляет элемент в коллекцию";
    }

}
