package server.commands;

import common.Request;
import common.Response;
import server.utils.CollectionManager;

/**
 * фильтрует города по началу имени
 */
public class FilterStartsWithName implements Command{
    private CollectionManager collectionManager;

    /**
     * создаёт команду filter_starts_with_name
     * @param collectionManager менеджер коллекции
     */
    public FilterStartsWithName(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }


    @Override
    /**
     * фильтрует города по началу имени - возвращает подходящие
     * @param request запрос с началом имени
     * @return отфильтрованный список
     */
    public Response execute(Request request){
        String arg = request.getStringArgument();
        if (arg == null) {
            arg = "";
        }
        String result = this.collectionManager.filterStartsWithName(arg);
        Response response = new Response(true,result);
        return response;
    }
    @Override
    /**
     * @return имя команды
     */
    public String getName(){
        return "filter_starts_with_name";
    }

    @Override
    /**
     * @return описание команды
     */
    public String getDescription(){
        return "возвращает города по фильтру сортировку их имени";
    }
}
