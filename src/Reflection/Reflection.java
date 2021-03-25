package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Reflection {
    public static void main(String[] args) {
        NotSoPrivate test = new NotSoPrivate(1);

        try {
            Class c = test.getClass();

            Field[] fields= c.getDeclaredFields();
            for (Field field: fields) {
                field.setAccessible(true);
                System.out.println(field.get(0));
            }

            Method[] methods = c.getDeclaredMethods();
            for (Method method : methods){
                method.setAccessible(true);
                System.out.println(method.invoke(test));
            }

            Constructor<NotSoPrivate>[] constructors = c.getConstructors();
            for (Constructor<NotSoPrivate> constructor: constructors) {
                System.out.println(Arrays.toString(constructor.getParameterTypes()));
            }

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}

class NotSoPrivate {
    private static final int id = 42;
    private static final String secure = "secret";

    public NotSoPrivate(int a) {
    }

    private void print(){
        System.out.println(id + secure);
    }
}