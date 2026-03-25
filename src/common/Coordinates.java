package common;

/**
 * координаты города
 */
public class Coordinates implements java.io.Serializable {
    private int x;
    private Float y; //Максимальное значение поля: 709, Поле не может быть null

    /**
     * создаёт координаты
     * @param x координата X
     * @param y координата Y
     */
    public Coordinates(int x, Float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * получает координату X
     * @return координата X
     */
    public int getX(){
        return this.x;
    }

    /**
     * устанавливает координату X
     * @param x координата X
     */
    public void setX(int x){
        this.x = x;
    }

    /**
     * получает координату Y
     * @return координата Y
     */
    public Float getY(){
        return this.y;
    }

    /**
     * устанавливает координату Y
     * @param y координата Y
     */
    public void setY(Float y){
        this.y = y;
    }
    @Override
    public String toString() {
        return String.format("Coordinates{x=%d, y=%s}", x, y == null ? "null" : String.format("%.2f", y));
    }
}
