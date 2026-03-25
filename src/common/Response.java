package common;

/**
 * результат выполнения команды
 * @param success успех выполнения
 * @param message сообщение
 */
public class Response implements java.io.Serializable {
    private boolean success;
    private String message;

    public Response(boolean success, String message){
        this.success = success;
        this.message = message;
    }

    public boolean getSuccess(){
        return this.success;
    }

    public void setSuccess(boolean success){
        this.success = success;
    }

    public String getMessage(){
        return this.message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
