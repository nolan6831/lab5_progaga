package server.commands;

import common.Response;
import common.Request;
import server.utils.CollectionManager;

public class ShowCommand implements Command {
    private CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(Request request){
        String result = this.collectionManager.show();
        Response response = new Response(true,result);
        return response;
    }


    @Override
    public String getName(){
        return "show";
    }

    @Override
    public String getDescription(){
        return "показывает содержимое коллекции";
    }
}
