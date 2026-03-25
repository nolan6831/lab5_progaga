package server.commands;

import common.Response;
import common.Request;
import server.utils.CollectionManager;

/**
 * сортирует коллекцию в обратном порядке
 */
public class ReorderCommand implements Command {
    private CollectionManager collectionManager;

    /**
     * создаёт команду reorder
     * @param collectionManager менеджер коллекции
     */
    public ReorderCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
    @Override
    /**
     * сортирует коллекцию в обратном порядке - переворачивает
     * @param request запрос
     * @return результат сортировки
     */
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
    /**
     * @return имя команды
     */
    public String getName(){
        return "reorder";
    }

    @Override
    /**
     * @return описание команды
     */
    public String getDescription(){
        return "сортирует в обратном порядке";
    }
}
