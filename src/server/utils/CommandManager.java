package server.utils;

import common.Request;
import common.Response;
import server.commands.*;
import java.util.HashMap;

public class CommandManager {
    private HashMap<String, Command> commands;

    public CommandManager(){
        this.commands = new HashMap<>();
    }

    public void register(String commandName, Command command){
        this.commands.put(commandName, command);
    }
    public java.util.HashMap<String, Command> getCommands() {
        return commands;
    }
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
