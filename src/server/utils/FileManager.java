package server.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import common.City;
import common.Coordinates;
import common.Human;
import common.Climate;
import common.Government;
import common.StandardOfLiving;

import java.io.*;
import java.util.Vector;

/**
 * читает и записывает коллекцию в файл
 */
public class FileManager {
    private final String filePath;
    private final XStream xstream;

    /**
     * @param filePath путь к файлу
     */
    public FileManager(String filePath) {
        this.filePath = filePath;
        this.xstream = new XStream();

        xstream.addPermission(NoTypePermission.NONE);
        xstream.allowTypes(new Class[]{
                City.class,
                Coordinates.class,
                Human.class,
                Climate.class,
                Government.class,
                StandardOfLiving.class,
                Vector.class
        });

        xstream.alias("city", City.class);
        xstream.alias("coordinates", Coordinates.class);
        xstream.alias("human", Human.class);
        xstream.alias("climate", Climate.class);
        xstream.alias("government", Government.class);
        xstream.alias("standardOfLiving", StandardOfLiving.class);
    }

    /**
     * читает коллекцию из файла
     * @return коллекция из файла
     */
    public Vector<City> readCollection() {
        Vector<City> collection = new Vector<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder xmlContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                xmlContent.append(line);
            }
            if (xmlContent.length() == 0) {
                return collection;
            }
            Object obj = xstream.fromXML(xmlContent.toString());
            if (obj instanceof Vector) {
                collection = (Vector<City>) obj;
            }
        } catch (FileNotFoundException e) {
        } catch (IOException | com.thoughtworks.xstream.XStreamException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
        return collection;
    }


    /**
     * записывает коллекцию в файл
     * @param collection коллекция для записи
     * @throws IOException ошибка записи
     */
    public void writeCollection(Vector<City> collection) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            String xml = xstream.toXML(collection);
            writer.write(xml);
        }
    }
}