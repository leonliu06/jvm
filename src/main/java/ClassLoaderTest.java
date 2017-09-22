import java.io.IOException;
import java.io.InputStream;

/**
 * Created by li.liu on 2017/9/8.
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception{
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try{
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if(is == null){
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                }catch (IOException e){
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("ClassLoaderTest").newInstance();

        System.out.println(obj.getClass());
        System.out.println(obj instanceof ClassLoaderTest);

        ClassLoader a = obj.getClass().getClassLoader();
        ClassLoader b = ClassLoaderTest.class.getClassLoader();
        System.out.println(a);
        System.out.println(b);
    }
}
