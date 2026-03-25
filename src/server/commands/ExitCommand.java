package server.commands;

import common.Request;
import common.Response;

/**
 * выход из программы
 * @param request запрос
 * @return результат выхода
 */
public class ExitCommand implements Command{

    @Override
    public Response execute(Request request){
        return new Response(true, "выход из программы");
    }

    @Override
    public String getName(){return "exit";}

    @Override
    public String getDescription(){return "выходит из программы";}

}
