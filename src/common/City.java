package common;

/**
 * город
 */
public class City implements java.io.Serializable, Comparable<City> {
    private Long id;
    private String name;
    private Coordinates coordinates;
    private java.time.LocalDateTime creationDate;
    private Double area;
    private Integer population;
    private float metersAboveSeaLevel;
    private Climate climate;
    private Government government;
    private StandardOfLiving standardOfLiving;
    private Human governor;

    /**
     * получает идентификатор
     * @return идентификатор
     */
    public Long getId() {
        return this.id;
    }

    /**
     * устанавливает идентификатор
     * @param newId идентификатор
     */
    public void setId(Long newId){
        this.id = newId;
    }

    /**
     * получает название города
     * @return название города
     */
    public String getName(){
        return this.name;
    }

    /**
     * устанавливает название города
     * @param name название города
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * получает координаты
     * @return координаты
     */
    public Coordinates getCoordinates(){
        return this.coordinates;
    }

    /**
     * устанавливает координаты
     * @param coordinates координаты
     */
    public void setCoordinates(Coordinates coordinates){
        this.coordinates = coordinates;
    }

    /**
     * получает дату создания
     * @return дата создания
     */
    public java.time.LocalDateTime getCreationDate(){
        return this.creationDate;
    }

    /**
     * устанавливает дату создания
     * @param creationDate дата создания
     */
    public void setCreationDate(java.time.LocalDateTime creationDate){
        this.creationDate = creationDate;
    }

    /**
     * получает площадь
     * @return площадь
     */
    public Double getArea(){
        return this.area;
    }

    /**
     * устанавливает площадь
     * @param area площадь
     */
    public void setArea(Double area){
        this.area = area;
    }

    /**
     * получает население
     * @return население
     */
    public Integer getPopulation(){
        return this.population;
    }

    /**
     * устанавливает население
     * @param population население
     */
    public void setPopulation(Integer population){
        this.population = population;
    }

    /**
     * получает высоту над уровнем моря
     * @return высота над уровнем моря
     */
    public float getMetersAboveSeaLevel(){
        return this.metersAboveSeaLevel;
    }

    /**
     * устанавливает высоту над уровнем моря
     * @param metersAboveSeaLevel высота над уровнем моря
     */
    public void setMetersAboveSeaLevel(float metersAboveSeaLevel){
        this.metersAboveSeaLevel = metersAboveSeaLevel;
    }

    /**
     * получает климат
     * @return климат
     */
    public Climate getClimate(){
        return this.climate;
    }

    /**
     * устанавливает климат
     * @param climate климат
     */
    public void setClimate(Climate climate){
        this.climate = climate;
    }

    /**
     * получает форму правления
     * @return форма правления
     */
    public Government getGovernment(){
        return this.government;
    }

    /**
     * устанавливает форму правления
     * @param government форма правления
     */
    public void setGovernment(Government government){
        this.government = government;
    }

    /**
     * получает уровень жизни
     * @return уровень жизни
     */
    public StandardOfLiving getStandardOfLiving(){
        return this.standardOfLiving;
    }

    /**
     * устанавливает уровень жизни
     * @param standardOfLiving уровень жизни
     */
    public void setStandardOfLiving(StandardOfLiving standardOfLiving){
        this.standardOfLiving = standardOfLiving;
    }

    /**
     * получает губернатора
     * @return губернатор
     */
    public Human getGovernor(){
        return this.governor;
    }

    /**
     * устанавливает губернатора
     * @param governor губернатор
     */
    public void setGovernor(Human governor){
        this.governor = governor;
    }

    /**
     * сравнивает города по имени
     * @param o другой город
     * @return результат сравнения
     */
    public int compareTo(City o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return String.format("City{id=%d, name='%s', coordinates=%s, creationDate=%s, area=%s, population=%d, metersAboveSeaLevel=%s, climate=%s, government=%s, standardOfLiving=%s, governor=%s}",
                id, name, coordinates, creationDate, String.valueOf(area), population, String.valueOf(metersAboveSeaLevel), climate, government, standardOfLiving, governor);
    }

}

