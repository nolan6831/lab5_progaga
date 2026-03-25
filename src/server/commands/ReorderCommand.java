package server.commands;

import common.Response;
import common.Request;
import server.utils.CollectionManager;

/**
 * сортирует коллекцию в обратном порядке
 * @param request запрос
 * @return результат сортировки
 */
public class ReorderCommand implements Command {
    private CollectionManager collectionManager;

    public ReorderCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
    @Override
    public Response execute(Request request){
        boolean isReordered = this.collectionManager.reorder();
        if(isReordered){
        Response response = new Response(true, "успешно отсортировано наоборот");
        return response;
        }
        else{
            Response response = new Response(false, "обратная сортировка невозможна");
            return response;
        }
    }


    @Override
    public String getName(){
        return "reorder";
    }

    @Override
    public String getDescription(){
        return "сортирует в обратном порядке";
    }
}
