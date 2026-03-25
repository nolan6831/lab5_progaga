package common;

/**
 * запрос на выполнение команды
 */
public class Request implements java.io.Serializable {
    private String commandName;
    private City cityArgument;
    private String stringArgument;

    /**
     * создаёт запрос с именем команды
     * @param commandName имя команды
     */
    public Request(String commandName){
        this.commandName = commandName;
        this.stringArgument = "";
        this.cityArgument = null;
    }

    /**
     * создаёт запрос с аргументом
     * @param commandName имя команды
     * @param stringArgument аргумент строки
     */
    public Request(String commandName, String stringArgument){
        this.commandName = commandName;
        this.stringArgument = stringArgument;
        this.cityArgument = null;
    }

    /**
     * создаёт запрос с городом
     * @param commandName имя команды
     * @param stringArgument аргумент строки
     * @param cityArgument объект города
     */
    public Request(String commandName, String stringArgument, City cityArgument){
        this.commandName = commandName;
        this.stringArgument = stringArgument;
        this.cityArgument = cityArgument;
    }


    /**
     * получает имя команды
     * @return имя команды
     */
    public String getCommandName(){
        return this.commandName;
    }

    /**
     * устанавливает имя команды
     * @param commandName имя команды
     */
    public void setCommandName(String commandName){
        this.commandName = commandName;
    }

    /**
     * получает объект города
     * @return объект города
     */
    public City getCityArgument(){
        return this.cityArgument;
    }

    /**
     * устанавливает объект города
     * @param cityArgument объект города
     */
    public void setCityArgument(City cityArgument){
        this.cityArgument = cityArgument;
    }

    /**
     * получает аргумент строки
     * @return аргумент строки
     */
    public String getStringArgument(){
        return this.stringArgument;
    }

    /**
     * устанавливает аргумент строки
     * @param stringArgument аргумент строки
     */
    public void setStringArgument(String stringArgument){
        this.stringArgument = stringArgument;
    }
}
