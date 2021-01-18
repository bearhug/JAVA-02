
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

// ClassLoader方法
public class HelloClassLoader extends ClassLoader {
    // 类所在的路径
    private String classPath;

    public HelloClassLoader(String classPath) {
        this.classPath = classPath;
    }

    private byte[] readFileToByts(String classPath) {
        String fileName = classPath;
        File file = new File(fileName);
        try (InputStream in = new FileInputStream(file);
             ByteArrayOutputStream out = new ByteArrayOutputStream()){
            int i;
            while ((i = in.read()) != -1) {
                out.write(i);
            }
            return out.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = readFileToByts(classPath);
        for (int i = 0; i < bytes.length; i++) {
            byte temp = bytes[i];
            bytes[i] = (byte) (~temp);
        }
        return defineClass(name, bytes, 0, bytes.length);
    }
}
