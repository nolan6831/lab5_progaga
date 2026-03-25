package server.commands;

import common.Request;
import common.Response;
import server.utils.CollectionManager;

/**
 * группирует и считает города по id
 */
public class GroupCountingByIdCommand implements Command {
    private CollectionManager collectionManager;

    /**
     * создаёт команду group_counting_by_id
     * @param collectionManager менеджер коллекции
     */
    public GroupCountingByIdCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }


    @Override
    /**
     * группирует города по id - считает количество
     * @param request запрос
     * @return сгруппированный список
     */
    public Response execute(Request request){
        String result = this.collectionManager.groupCountingById();

        Response response = new Response(true,result);
        return response;
    }
    @Override
    /**
     * @return имя команды
     */
    public String getName(){
        return "group_counting_by_id";
    }

    @Override
    /**
     * @return описание команды
     */
    public String getDescription(){
        return "группирует и считает города по id";
    }
}
