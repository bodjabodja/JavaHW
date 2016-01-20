package JavaPro.Lesson1;
import java.lang.reflect.*;
import java.lang.annotation.*;

/**
 * Created by Богдан on 13.01.2016.
 */


//@Anot2(param1 = 2,param2 = 5)

class Calc{
    @Anot1(param1 =2, param2=7)
    public int sum(int param1, int param2){
        return param1+param2;
    }
}
public class AnotTask1 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {


        Calc calc = new Calc();
        Class<?> cls = calc.getClass();

        Method[] methods = cls.getDeclaredMethods();

        for (Method m : methods) {
            if (m.isAnnotationPresent(Anot1.class)) {
                Anot1 an = m.getAnnotation(Anot1.class);
                int res = (Integer) m.invoke(calc, an.param1(), an.param2());
                System.out.println("result annotation method is "+res);
            }


        }

    }
}