package common;

/**
 * человек (губернатор)
 * @param height рост
 */
public class Human implements java.io.Serializable {
    private Long height; //Значение поля должно быть больше 0

    public Human(Long height) {
        this.height = height;
    }

    public Long getHeight(){
        return this.height;
    }

    public void setHeight(Long height){
        this.height = height;
    }
    @Override
    public String toString() {
        return height == null ? "Human{height=null}" : String.format("Human{height=%d}", height);
    }
}
