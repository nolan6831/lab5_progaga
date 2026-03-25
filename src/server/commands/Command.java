package server.commands;

import common.Request;
import common.Response;

/**
 * интерфейс команды
 */
public interface Command {
    /**
     * выполняет команду
     * @param request запрос
     * @return результат
     */
    Response execute(Request request);
    /**
     * @return имя команды
     */
    String getName();
    /**
     * @return описание команды
     */
    String getDescription();
}
