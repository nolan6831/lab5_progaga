package server.utils;

import common.Request;
import common.Response;
import server.commands.*;
import java.util.HashMap;

/**
 * управляет командами
 */
public class CommandManager {
    private HashMap<String, Command> commands;

    /**
     * создаёт менеджер команд
     */
    public CommandManager(){
        this.commands = new HashMap<>();
    }

    /**
     * регистрирует команду
     * @param commandName имя команды
     * @param command команда
     */
    public void register(String commandName, Command command){
        this.commands.put(commandName, command);
    }
    /**
     * получает карту команд
     * @return карта команд
     */
    public java.util.HashMap<String, Command> getCommands() {
        return commands;
    }
    /**
     * выполняет команду
     * @param request запрос
     * @return результат выполнения
     */
    public Response executeCommand(Request request){
        String name = request.getCommandName();
        Command command = this.commands.get(name);
        Response response;

        if (command == null){
            response = new Response(false, "неизвестная команда");
        }
        else{
            response = command.execute(request);

        }
        return response;
    }
}
