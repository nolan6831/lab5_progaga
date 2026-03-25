package common;

/**
 * запрос на выполнение команды
 * @param commandName имя команды
 * @param stringArgument аргумент строки
 * @param cityArgument объект города
 */
public class Request implements java.io.Serializable {
    private String commandName;
    private City cityArgument;
    private String stringArgument;

    public Request(String commandName){
        this.commandName = commandName;
        this.stringArgument = "";
        this.cityArgument = null;
    }

    public Request(String commandName, String stringArgument){
        this.commandName = commandName;
        this.stringArgument = stringArgument;
        this.cityArgument = null;
    }

    public Request(String commandName, String stringArgument, City cityArgument){
        this.commandName = commandName;
        this.stringArgument = stringArgument;
        this.cityArgument = cityArgument;
    }


    public String getCommandName(){
        return this.commandName;
    }

    public void setCommandName(String commandName){
        this.commandName = commandName;
    }

    public City getCityArgument(){
        return this.cityArgument;
    }

    public void setCityArgument(City cityArgument){
        this.cityArgument = cityArgument;
    }

    public String getStringArgument(){
        return this.stringArgument;
    }

    public void setStringArgument(String stringArgument){
        this.stringArgument = stringArgument;
    }
}
