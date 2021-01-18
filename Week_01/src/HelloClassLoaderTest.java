import java.lang.reflect.Method;

// HelloClassLoader的测试类
public class HelloClassLoaderTest {
    public static void main(String[] args) throws Exception {
        // 创建自定义类加载器
        HelloClassLoader helloClassLoader = new HelloClassLoader("/Users/lijunfeng/IdeaProjects/Geekbang/JAVA-01/Week_01/src/Hello.xlass");
        Class<?> helloClazz = helloClassLoader.findClass("Hello");
        // 创建实例对象
        Object helloObject = helloClazz.newInstance();
        // 获取方法
        Method hello = helloClazz.getDeclaredMethod("hello");
        hello.invoke(helloObject);
    }

}
