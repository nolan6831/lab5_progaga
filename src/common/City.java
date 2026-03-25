package common;

/**
 * город
 * @param id идентификатор
 * @param name название
 * @param coordinates координаты
 */
public class City implements java.io.Serializable, Comparable<City> {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Double area; //Значение поля должно быть больше 0, Поле не может быть null
    private Integer population; //Значение поля должно быть больше 0, Поле не может быть null
    private float metersAboveSeaLevel;
    private Climate climate; //Поле может быть null
    private Government government; //Поле может быть null
    private StandardOfLiving standardOfLiving; //Поле не может быть null
    private Human governor; //Поле не может быть null

    public Long getId() {
        return this.id;
    }

    public void setId(Long newId){
        this.id = newId;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Coordinates getCoordinates(){
        return this.coordinates;
    }

    public void setCoordinates(Coordinates coordinates){
        this.coordinates = coordinates;
    }

    public java.time.LocalDateTime getCreationDate(){
        return this.creationDate;
    }

    public void setCreationDate(java.time.LocalDateTime creationDate){
        this.creationDate = creationDate;
    }

    public Double getArea(){
        return this.area;
    }

    public void setArea(Double area){
        this.area = area;
    }

    public Integer getPopulation(){
        return this.population;
    }

    public void setPopulation(Integer population){
        this.population = population;
    }

    public float getMetersAboveSeaLevel(){
        return this.metersAboveSeaLevel;
    }

    public void setMetersAboveSeaLevel(float metersAboveSeaLevel){
        this.metersAboveSeaLevel = metersAboveSeaLevel;
    }

    public Climate getClimate(){
        return this.climate;
    }

    public void setClimate(Climate climate){
        this.climate = climate;
    }

    public Government getGovernment(){
        return this.government;
    }

    public void setGovernment(Government government){
        this.government = government;
    }

    public StandardOfLiving getStandardOfLiving(){
        return this.standardOfLiving;
    }

    public void setStandardOfLiving(StandardOfLiving standardOfLiving){
        this.standardOfLiving = standardOfLiving;
    }

    /**
     *  Получает губернатора
    * @return получить имя губернатор. Объект Human
    */

    public Human getGovernor(){
        return this.governor;
    }

    public void setGovernor(Human governor){
        this.governor = governor;
    }

    public int compareTo(City o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {

        return String.format("City{id=%d, name='%s', coordinates=%s, creationDate=%s, area=%s, population=%d, metersAboveSeaLevel=%s, climate=%s, government=%s, standardOfLiving=%s, governor=%s}",
                id, name, coordinates, creationDate, String.valueOf(area), population, String.valueOf(metersAboveSeaLevel), climate, government, standardOfLiving, governor);
    }

}

