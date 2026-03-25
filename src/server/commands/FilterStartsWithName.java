package server.commands;

import common.Request;
import common.Response;
import server.utils.CollectionManager;

/**
 * фильтрует города по имени
 * @return отфильтрованный список городов
 */
public class FilterStartsWithName implements Command{
    private CollectionManager collectionManager;

    public FilterStartsWithName(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }


    @Override
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
    public String getName(){
        return "filter_starts_with_name";
    }

    @Override
    public String getDescription(){
        return "возвращает города по фильтру сортировку их имени";
    }
}
