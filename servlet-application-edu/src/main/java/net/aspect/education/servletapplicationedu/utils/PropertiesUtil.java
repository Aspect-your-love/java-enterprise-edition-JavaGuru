package net.aspect.education.servletapplicationedu.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public final class PropertiesUtil {
    /*Ассоциативный массив (наследуется от Hashtable) для наших .properties*/
    private static final Properties PROPERTIES = new Properties();
    /*Блок статической инициализации.
    * Нужен для того, чтобы мы могли загрузить
    * файл со свойствами. Используем
    * утилитарный метод.*/
    static {
        loadProperties();
    }

    private PropertiesUtil(){

    }

    /*Получаем поток ввода из файла, который находится в ресурсной директории.
    * За счёт .getResourceAsStream(String "path"), мы можем читать
    * то, что находится в ресурсной директории*/
    private static void loadProperties() {
        try (InputStream resourceAsStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            /*Загружаем в наше статическое поле PROPERTIES полученные свойства,
            * передав ему поток ввода*/
            PROPERTIES.load(resourceAsStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key){
        return PROPERTIES.getProperty(key);
    }
}
