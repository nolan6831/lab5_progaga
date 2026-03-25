package server.commands;

import common.Response;
import common.Request;
import server.utils.CollectionManager;

/**
 * удаляет город по предоставленному id
 */
public class RemoveByIdCommand implements Command {
    private CollectionManager collectionManager;

    public RemoveByIdCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(Request request){
        String arg = request.getStringArgument();
        if (arg == null || arg.trim().isEmpty()) {
            return new Response(false, "ошибка: укажите id для удаления");
        }
        Long id;
        try {
            id = Long.parseLong(arg.trim());
        } catch (NumberFormatException e) {
            return new Response(false, "ошибка: некорректный формат id");
        }
        Response result;
        boolean isRemoved;

        isRemoved = this.collectionManager.removeById(id);
        if (isRemoved){
            result = new Response(true,"городишка удален");
            return result;
        }
        else{
            result = new Response(false,"город с таким айди не найден");
            return result;
        }
    }
    @Override
    public String getName(){
        return "remove_by_id";
    }

    @Override
    public String getDescription(){
        return "удаляет элемент в коллекции";
    }

}
