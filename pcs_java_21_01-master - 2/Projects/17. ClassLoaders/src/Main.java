public class Main {

    public static void main(String[] args) throws Exception {
        FolderClassLoader folderClassLoader = new FolderClassLoader("C:\\Users\\Marsel\\Desktop\\Classes");
        System.out.println(String.class.getClassLoader());
        System.out.println(User.class.getClassLoader());

        Class<?> exampleClass = Class.forName("Example", true, folderClassLoader);
        System.out.println(exampleClass.getClassLoader());
        System.out.println(exampleClass.getDeclaredMethods().length);
    }
}
