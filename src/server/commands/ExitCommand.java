package server.commands;

import common.Request;
import common.Response;

/**
 * выход из программы
 */
public class ExitCommand implements Command{

    @Override
    /**
     * выполняет команду exit - завершает программу
     * @param request запрос
     * @return результат выхода
     */
    public Response execute(Request request){
        return new Response(true, "выход из программы");
    }

    @Override
    /**
     * @return имя команды "exit"
     */
    public String getName(){return "exit";}

    @Override
    /**
     * @return описание команды
     */
    public String getDescription(){return "выходит из программы";}

}
