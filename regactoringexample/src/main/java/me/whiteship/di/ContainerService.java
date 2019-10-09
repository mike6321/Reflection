package me.whiteship.di;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ContainerService {

//    public static <T> T getObject(Class<T> classType) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        return createInstance(classType);
//    }
    public static <T> T getObject(Class<T> classType) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        T instance = createInstance(classType);
        Arrays.stream(classType.getDeclaredFields()).forEach(field -> {
            if(field.getAnnotation(Inject.class) != null){
                Object fiieldInstance = createInstance(field.getType());
                field.setAccessible(true);
                try {
                    field.set(instance,fiieldInstance);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException();
                }
            }
        });
        return instance;
    }

    private static <T> T createInstance(Class<T> classType) {
        try {
            return classType.getConstructor(null).newInstance();
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);

        }
    }
}
