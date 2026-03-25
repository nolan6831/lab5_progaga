package server.commands;

import common.Response;
import common.Request;
import server.utils.CollectionManager;

/**
 * удаляет первый элемент из коллекции
 */
public class RemoveFirstCommand implements Command{
    private CollectionManager collectionManager;

    /**
     * создаёт команду remove_first
     * @param collectionManager менеджер коллекции
     */
    public RemoveFirstCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    /**
     * удаляет первый элемент - удаляет из начала
     * @param request запрос
     * @return результат удаления
     */
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
    /**
     * @return имя команды
     */
    public String getName(){
        return "remove_first";
    }

    @Override
    /**
     * @return описание команды
     */
    public String getDescription(){
        return "удаляет первый элемент в коллекции";
    }
}
