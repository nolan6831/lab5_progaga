package server.commands;

import common.City;
import common.Response;
import common.Request;
import server.utils.CollectionManager;

public class UpdateIdCommand implements Command {
    private CollectionManager collectionManager;

    public UpdateIdCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(Request request){
        String arg = request.getStringArgument();
        if (arg == null || arg.trim().isEmpty()) {
            return new Response(false, "ошибка: укажите id для обновления");
        }
        Long id;
        try {
            id = Long.parseLong(arg.trim());
        } catch (NumberFormatException e) {
            return new Response(false, "ошибка: некорректный формат id");
        }
        City newCity = request.getCityArgument();
        Response result;
        boolean isUpdated = this.collectionManager.updateId(id,newCity);
        if(isUpdated){
            result = new Response(true, "id обновлен");
            return result;
        }
        else {
            result = new Response(false, "город с таким id не найден");
            return result;
        }
    }

    @Override
    public String getName(){
        return "update_id_command";
    }

    @Override
    public String getDescription(){
        return "обновляет id";
    }
}
