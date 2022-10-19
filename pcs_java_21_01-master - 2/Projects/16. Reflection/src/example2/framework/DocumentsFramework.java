package example2.framework;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 22.09.2021
 * 16. Reflection
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class DocumentsFramework {
    public <T> T generate(Class<T> documentClass, Object ... args) {
        List<Class<?>> argsTypes = new ArrayList<>();

        for (Object arg : args) {
            argsTypes.add(arg.getClass());
        }

        Class<?>[] argsTypesAsArray = new Class[argsTypes.size()];
        argsTypes.toArray(argsTypesAsArray);

        try {
            Constructor<T> documentConstructor = documentClass.getConstructor(argsTypesAsArray);
            T document = documentConstructor.newInstance(args);
            processDefaultValue(document);
            return document;
        } catch (ReflectiveOperationException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private <T> void processDefaultValue(T document) {
        Class<T> documentClass = (Class<T>) document.getClass();
        Field[] fields = documentClass.getDeclaredFields();

        for (Field field : fields) {
            DefaultValue defaultValue = field.getAnnotation(DefaultValue.class);

            if (defaultValue != null) {
                String value = defaultValue.value();
                try {
                    field.setAccessible(true);
                    field.set(document, value);
                } catch (IllegalAccessException e) {
                    throw new IllegalStateException(e);
                }
            }
        }
    }
}
