package common;

/**
 * результат выполнения команды
 */
public class Response implements java.io.Serializable {
    private boolean success;
    private String message;

    /**
     * создаёт ответ
     * @param success успех выполнения
     * @param message сообщение
     */
    public Response(boolean success, String message){
        this.success = success;
        this.message = message;
    }

    /**
     * получает успех выполнения
     * @return успех выполнения
     */
    public boolean getSuccess(){
        return this.success;
    }

    /**
     * устанавливает успех выполнения
     * @param success успех выполнения
     */
    public void setSuccess(boolean success){
        this.success = success;
    }

    /**
     * получает сообщение
     * @return сообщение
     */
    public String getMessage(){
        return this.message;
    }

    /**
     * устанавливает сообщение
     * @param message сообщение
     */
    public void setMessage(String message){
        this.message = message;
    }
}
