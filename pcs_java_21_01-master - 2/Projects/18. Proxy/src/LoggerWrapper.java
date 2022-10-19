import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.LocalDateTime;

/**
 * 22.09.2021
 * 18. Proxy
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class LoggerWrapper {

    private static class InputOutputInvocationHandler implements InvocationHandler {

        private final InputOutput original;

        public InputOutputInvocationHandler(InputOutput original) {
            this.original = original;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(LocalDateTime.now() + " был вызван " + method.getName() + " " + (args != null ? args[0] : ""));
            return method.invoke(original, args);
        }
    }

    public static InputOutput withLogger(InputOutput original) {
        ClassLoader classLoader = original.getClass().getClassLoader();
        Class<?>[] interfaces = original.getClass().getInterfaces();
        return (InputOutput)Proxy.newProxyInstance(classLoader, interfaces, new InputOutputInvocationHandler(original));
    }
}
