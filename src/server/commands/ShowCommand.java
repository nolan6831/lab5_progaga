package server.commands;

import common.Response;
import common.Request;
import server.utils.CollectionManager;

/**
 * показывает элементы коллекции
 */
public class ShowCommand implements Command {
    private CollectionManager collectionManager;

    /**
     * создаёт команду show
     * @param collectionManager менеджер коллекции
     */
    public ShowCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    /**
     * показывает элементы коллекции - выводит все города
     * @param request запрос
     * @return содержимое коллекции
     */
    public Response execute(Request request){
        String result = this.collectionManager.show();
        Response response = new Response(true,result);
        return response;
    }


    @Override
    /**
     * @return имя команды
     */
    public String getName(){
        return "show";
    }

    @Override
    /**
     * @return описание команды
     */
    public String getDescription(){
        return "показывает содержимое коллекции";
    }
}
