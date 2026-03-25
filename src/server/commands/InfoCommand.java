package server.commands;

import common.Response;
import common.Request;
import server.utils.CollectionManager;

/**
 * показывает информацию о коллекции
 */
public class InfoCommand implements Command {
    private CollectionManager collectionManager;

    /**
     * создаёт команду info
     * @param collectionManager менеджер коллекции
     */
    public InfoCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    /**
     * @return имя команды "info"
     */
    public String getName(){
        return "info";
    }

    @Override
    /**
     * @return описание команды
     */
    public String getDescription(){
        return "возвращает информацию о коллекции";
    }

    @Override
    /**
     * показывает информацию - тип, дата, размер
     * @param request запрос
     * @return информация о коллекции
     */
    public Response execute(Request request){
        String result = collectionManager.info();
        Response response = new Response(true,result);
        return response;
    }
}
