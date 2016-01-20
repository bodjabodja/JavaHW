package JavaPro.Lesson1;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Богдан on 14.01.2016.
 */
class Container{
    private String s = "default";
    public Container(String text){
        s = text;
    }
    @SaveTo
    public void save(String path) throws IOException {
        FileWriter wr = new FileWriter(path);
        wr.write(this.s);
        wr.flush();
    }


}

public class AnotTask2 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {


        Class<?> cls = Container.class;
        Method[] meth = cls.getDeclaredMethods();
        for (Method m : meth) {
            if (m.isAnnotationPresent(SaveTo.class)) {
                Container container = new Container("Hello!");
                m.invoke(container,m.getAnnotation(SaveTo.class).path());
                System.out.println("Printing done");
            }
            else {
                System.out.println("There is a problem");
            }

        }
    }
}