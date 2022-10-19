import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 22.09.2021
 * 17. ClassLoaders
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class FolderClassLoader extends ClassLoader {
    private String folderName;

    public FolderClassLoader(String folderName) {
        this.folderName = folderName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            String pathToClass = folderName + "/" + name + ".class";
            try (InputStream inputStream = new FileInputStream(pathToClass)){
                byte[] bytes = new byte[inputStream.available()];
                int bytesCount = inputStream.read(bytes);
                return defineClass(name, bytes, 0, bytesCount);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
