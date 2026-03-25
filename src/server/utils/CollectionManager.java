package server.utils;

import common.City;

/**
 * управляет коллекцией городов
 */
public class CollectionManager {
    private java.util.Vector<City> collection;
    private java.time.LocalDateTime creationDate;
    private Long currentId;
    private Long maxId = 0L;


    /**
     * создаёт менеджер коллекции
     * @param collection коллекция городов
     */
    public CollectionManager(java.util.Vector<City> collection){
        this.collection = collection;
        this.creationDate = java.time.LocalDateTime.now();
        for (int i = 0; i < collection.size(); i++) {
            City currentCity = collection.get(i);
            if (currentCity.getId() > maxId) {
                maxId = currentCity.getId();
            }
        }
        this.currentId = maxId + 1;
    }

    /**
     * получает коллекцию городов
     * @return коллекция городов
     */
    public java.util.Vector<City> getCollection(){
        return this.collection;
    }

    /**
     * устанавливает коллекцию
     * @param collection коллекция городов
     */
    public void setCollection(java.util.Vector<City> collection){
        this.collection = collection;
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
     * возвращает информацию о коллекции
     * @return информация о коллекции
     */
    public String info(){
        return "вектор: " + this.collection.getClass().getName() +
                "\nдата создания: " + this.creationDate.toString() +
                "\nколичество элементов: " + this.collection.size();
    }

    /**
     * показывает коллекцию
     * @return строковое представление коллекции
     */
    public String show() {
        if (collection.isEmpty()) {
            return "Коллекция пуста.";
        }
        StringBuilder result = new StringBuilder();
        for (City city : collection) {
            result.append(city.toString()).append("\n");
        }
        return result.toString();
    }

    /**
     * добавляет город в коллекцию
     * @param city город для добавления
     */
    public void add(City city){
        city.setId(currentId);
        currentId = currentId + 1;
        city.setCreationDate(java.time.LocalDateTime.now());
        this.collection.add(city);
    }

    /**
     * обновляет город по id
     * @param id идентификатор города
     * @param newCity новый город
     * @return true если обновлён
     */
    public boolean updateId(Long id, City newCity){
        for (int i = 0; i < this.collection.size(); i++){
            City currentCity = this.collection.get(i);
            if (currentCity.getId().equals(id)){
                newCity.setId(currentCity.getId());
                newCity.setCreationDate(currentCity.getCreationDate());
                this.collection.set(i,newCity);
                return true;
            }
        }
        return false;
    }

    /**
     * удаляет город по id
     * @param id идентификатор города
     * @return true если удалён
     */
    public boolean removeById(Long id){
        for (int i = 0; i < this.collection.size(); i++){
            City currentCity = this.collection.get(i);
            if (currentCity.getId().equals(id)){
                this.collection.remove(i);
                return true;
            }
        }
        return false;

    }

    /**
     * очищает коллекцию
     */
    public void clear(){
        this.collection.clear();
    }

    /**
     * удаляет первый элемент
     * @return true если удалён
     */
    public boolean removeFirst(){
        if (!this.collection.isEmpty()){
            this.collection.remove(0);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * переворачивает коллекцию
     * @return true если отсортировано
     */
    public boolean reorder(){
        java.util.Collections.reverse(this.collection);
        return true;
    }

    /**
     * удаляет города по виду правления
     * @param government вид правления
     * @return true если удалены города
     */
    public boolean removeAllByGovernment(common.Government government){
        boolean isRemoved = false;
        for (int i = this.collection.size() - 1; i>= 0; i--){
            City currentCity = this.collection.get(i);
            if (currentCity.getGovernment() == government){
                this.collection.remove(i);
                isRemoved = true;
            }
        }
        return isRemoved;
    }

    /**
     * группирует города по id
     * @return сгруппированные города по id
     */
    public String groupCountingById(){
        String result = "";

        for (int i = 0; i < this.collection.size();i++){
            City currentCity = this.collection.get(i);
            result = result + "группы по ID " + currentCity.getId() + " \n";
        }
        return result;
    }

    /**
     * фильтрует города по началу имени
     * @param name начало имени города
     * @return отфильтрованные города
     */
    public String filterStartsWithName(String name){
        String result = "";

        for (int i = 0; i < this.collection.size(); i++){
            City currentCity = this.collection.get(i);
            if (currentCity.getName() != null && currentCity.getName().startsWith(name)){
                result = result + currentCity.toString() + "\n";
            }
        }
        if (result.isEmpty()){
            return "найдено ничего";
        }
        return result;
    }
}

