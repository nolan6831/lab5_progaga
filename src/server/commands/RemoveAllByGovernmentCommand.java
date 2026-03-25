package server.commands;

import common.Request;
import common.Response;
import server.utils.CollectionManager;

/**
 * удаляет города по виду правления
 */
public class RemoveAllByGovernmentCommand implements Command{
    private CollectionManager collectionManager;

    /**
     * создаёт команду remove_all_by_government
     * @param collectionManager менеджер коллекции
     */
    public RemoveAllByGovernmentCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }


    @Override
    /**
     * удаляет города по виду правления - фильтрует и удаляет
     * @param request запрос с видом правления
     * @return результат удаления
     */
    public Response execute(Request request){
        String arg = request.getStringArgument();
        if (arg == null || arg.trim().isEmpty()) {
            return new Response(false, "ошибка: укажите вид правления (DESPOTISM, DEMOCRACY, etc.)");
        }
        common.Government gov;
        try {
            gov = common.Government.valueOf(arg.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return new Response(false, "ошибка: недопустимый вид правления. Доступные: DESPOTISM, DEMOCRACY, ARISTOCRACY, OLIGARCHY, COMMUNISM");
        }
        boolean isRemoved = this.collectionManager.removeAllByGovernment(gov);

        if(isRemoved){
            Response response = new Response(true, "успешно удалены города по виду правления");
            return response;
        }
        else{
            Response response = new Response(false, "удалить по виду правления невозможно");
            return response;
        }
    }
    @Override
    /**
     * @return имя команды
     */
    public String getName(){
        return "remove_all_by_government";
    }

    @Override
    /**
     * @return описание команды
     */
    public String getDescription(){
        return "удаляет все города по виду правления";
    }

}
