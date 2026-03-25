package server.commands;

import common.Response;
import common.Request;
import server.utils.CollectionManager;

/**
 * удаляет город по id
 */
public class RemoveByIdCommand implements Command {
    private CollectionManager collectionManager;

    /**
     * создаёт команду remove_by_id
     * @param collectionManager менеджер коллекции
     */
    public RemoveByIdCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    /**
     * удаляет город по id - ищет и удаляет
     * @param request запрос с id
     * @return результат удаления
     */
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
    /**
     * @return имя команды
     */
    public String getName(){
        return "remove_by_id";
    }

    @Override
    /**
     * @return описание команды
     */
    public String getDescription(){
        return "удаляет элемент в коллекции";
    }

}
