package HomeWork;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RunTest {
    public static void run(Class C) {
        List<Method> methods = new ArrayList<>();
        Method[] classMethods = C.getDeclaredMethods();


        for (Method cm : classMethods) {
            if(cm.isAnnotationPresent(Test.class)){
                methods.add(cm);
            }
        }

        methods.sort(Comparator.comparingInt((Method n) -> {
            return n.getAnnotation(Test.class).priority();
        }));

        for (Method cm : classMethods) {
            if(cm.isAnnotationPresent(BeforeSuite.class)){
                if(methods.size() > 0 && methods.get(0).isAnnotationPresent(BeforeSuite.class)) {
                    throw new RuntimeException("@BeforeSuite annotation method > 1");
                }
                methods.add(0, cm);
            }
        }

        for (Method cm : classMethods) {
            if(cm.isAnnotationPresent(AfterSuite.class)) {
                if(methods.size() > 0 && methods.get(methods.size() - 1).isAnnotationPresent(AfterSuite.class)) {
                    throw new RuntimeException("@AfterSuite annotation method > 1");
                }
                methods.add(cm);
            }
        }
        for (Method cm : methods){
            try {
                cm.invoke(null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
