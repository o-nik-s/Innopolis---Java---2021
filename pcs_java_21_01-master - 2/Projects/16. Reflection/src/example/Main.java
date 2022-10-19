package example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
	    Class<User> userClass = User.class;

        Field[] fields = userClass.getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field.getType() + " " + field.getName());
        }

        Method[] methods = userClass.getDeclaredMethods();

        for (Method method : methods) {
            System.out.println(method.getReturnType() + " " + method.getName());
        }

        Constructor<User>[] userConstructors = (Constructor<User>[]) userClass.getConstructors();

        for (Constructor<User> constructor : userConstructors) {
            System.out.println(constructor.getParameterTypes().length);
        }
    }
}
