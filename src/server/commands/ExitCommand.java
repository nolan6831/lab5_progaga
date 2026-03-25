package server.commands;

import common.Request;
import common.Response;

/**
 * регистрирует на серверной части выход. сам выход происходит на стороне клиента
 * @return true в любом случае
 * {@ClientRun}. происходит выход на стороне клиента
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
