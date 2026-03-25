package server.commands;

import common.Request;
import common.Response;
import server.utils.CommandManager;

/**
 * показывает справку по командам
 * @param request запрос
 * @return список команд
 */
public class HelpCommand implements Command {
    private final CommandManager commandManager;

    public HelpCommand(CommandManager commandManager) {
        this.commandManager = commandManager;
    }
    @Override
    public String getName() {
        return "help";
    }
    @Override
    public String getDescription() {
        return "Выводит информацию о доступных коммандах";
    }
    @Override
    public Response execute(Request request) {
        StringBuilder helpText = new StringBuilder("Доступные команды:\n");
        for (Command cmd : commandManager.getCommands().values()) {
            helpText.append("  ").append(cmd.getName())
                    .append(" - ").append(cmd.getDescription())
                    .append("\n");
        }
        return new Response(true, helpText.toString());
    }
}