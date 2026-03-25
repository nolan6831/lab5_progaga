package server.commands;

import common.Response;
import common.Request;
import server.utils.CollectionManager;

/**
 * удаляет первый элемент из спискуа
 */
public class RemoveFirstCommand implements Command{
    private CollectionManager collectionManager;

    public RemoveFirstCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(Request request){

        boolean isRemoved = this.collectionManager.removeFirst();
        if(isRemoved){
            Response response = new Response(true, "первый элемент удален");
            return response;
        }
        else{
            Response response = new Response(false, "удалить первый элемент невозможно");
            return response;
        }
    }
    @Override
    public String getName(){
        return "remove_first";
    }

    @Override
    public String getDescription(){
        return "удаляет первый элемент в коллекции";
    }
}
