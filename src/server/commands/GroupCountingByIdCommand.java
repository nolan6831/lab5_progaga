package server.commands;

import common.Request;
import common.Response;
import server.utils.CollectionManager;

/**
 * группирует города по id
 * @return список по одному id
 */
public class GroupCountingByIdCommand implements Command {
    private CollectionManager collectionManager;

    public GroupCountingByIdCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }


    @Override
    public Response execute(Request request){
        String result = this.collectionManager.groupCountingById();

        Response response = new Response(true,result);
        return response;
    }
    @Override
    public String getName(){
        return "group_counting_by_id";
    }

    @Override
    public String getDescription(){
        return "группирует и считает города по id";
    }
}
