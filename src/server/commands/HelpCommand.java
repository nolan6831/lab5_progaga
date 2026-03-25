package server.commands;

import common.Request;
import common.Response;
import server.utils.CommandManager;

/**
 * показывает справку по командам
 */
public class HelpCommand implements Command {
    private final CommandManager commandManager;

    /**
     * создаёт команду help
     * @param commandManager менеджер команд
     */
    public HelpCommand(CommandManager commandManager) {
        this.commandManager = commandManager;
    }
    @Override
    /**
     * @return имя команды "help"
     */
    public String getName() {
        return "help";
    }
    @Override
    /**
     * @return описание команды
     */
    public String getDescription() {
        return "Выводит информацию о доступных коммандах";
    }
    @Override
    /**
     * выводит справку - показывает все команды
     * @param request запрос
     * @return список команд
     */
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