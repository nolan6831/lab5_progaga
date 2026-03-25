package common;

/**
 * координаты города
 * @param x координата X
 * @param y координата Y
 */
public class Coordinates implements java.io.Serializable {
    private int x;
    private Float y; //Максимальное значение поля: 709, Поле не может быть null

    public Coordinates(int x, Float y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public void setX(int x){
        this.x = x;
    }

    public Float getY(){
        return this.y;
    }

    public void setY(Float y){
        this.y = y;
    }
    @Override
    public String toString() {
        return String.format("Coordinates{x=%d, y=%s}", x, y == null ? "null" : String.format("%.2f", y));
    }
}
