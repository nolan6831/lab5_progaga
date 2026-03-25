package server.utils;

import common.City;

public class CollectionManager {
    private java.util.Vector<City> collection;
    private java.time.LocalDateTime creationDate;
    private Long currentId;
    private Long maxId = 0L;


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

    public java.util.Vector<City> getCollection(){
        return this.collection;
    }

    public void setCollection(java.util.Vector<City> collection){
        this.collection = collection;
    }

    public java.time.LocalDateTime getCreationDate(){
        return this.creationDate;

    }

    public void setCreationDate(java.time.LocalDateTime creationDate){
        this.creationDate = creationDate;
    }

    public String info(){
        return "вектор: " + this.collection.getClass().getName() +
                "\nдата создания: " + this.creationDate.toString() +
                "\nколичество элементов: " + this.collection.size();
    }

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

    public void add(City city){ // needs and argument
        city.setId(currentId);
        currentId = currentId + 1;
        city.setCreationDate(java.time.LocalDateTime.now());
        this.collection.add(city);
    }

    public boolean updateId(Long id, City newCity){ // needs an argument and an element
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

    public boolean removeById(Long id){ // needs an argument
        for (int i = 0; i < this.collection.size(); i++){
            City currentCity = this.collection.get(i);
            if (currentCity.getId().equals(id)){
                this.collection.remove(i);
                return true;
            }
        }
        return false;

    }

    public void clear(){
        this.collection.clear();
    }

    public boolean removeFirst(){
        if (!this.collection.isEmpty()){
            this.collection.remove(0);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean reorder(){
        java.util.Collections.reverse(this.collection);
        return true;
    }

    public boolean removeAllByGovernment(common.Government government){ // needs an argument
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

    public String groupCountingById(){
        String result = "";

        for (int i = 0; i < this.collection.size();i++){
            City currentCity = this.collection.get(i);
            result = result + "группы по ID " + currentCity.getId() + " \n";
        }
        return result;
    }

    public String filterStartsWithName(String name){ // needs an argument
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

