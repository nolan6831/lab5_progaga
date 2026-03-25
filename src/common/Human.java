package common;

/**
 * человек (губернатор)
 */
public class Human implements java.io.Serializable {
    private Long height; //Значение поля должно быть больше 0

    /**
     * создаёт человека
     * @param height рост
     */
    public Human(Long height) {
        this.height = height;
    }

    /**
     * получает рост
     * @return рост
     */
    public Long getHeight(){
        return this.height;
    }

    /**
     * устанавливает рост
     * @param height рост
     */
    public void setHeight(Long height){
        this.height = height;
    }
    @Override
    public String toString() {
        return height == null ? "Human{height=null}" : String.format("Human{height=%d}", height);
    }
}
