package server.commands;

import common.Request;
import common.Response;

/**
 * интерфейс команды
 * @return результат выполнения
 */
public interface Command {
    Response execute(Request request);
    String getName();
    String getDescription();
}
