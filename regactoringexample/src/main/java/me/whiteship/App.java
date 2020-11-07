package me.whiteship;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        // 1. 타입을 가져오는 방법
        Class<Book> bookClass = Book.class;

//        // 2. 타입을 가져오는 방법
        Book book = new Book();
//        Class<? extends Book> aClass = book.getClass();
//
//        // 3. 타입을 가져오는 방법
//        Class<?> aClass1 = Class.forName("me.whiteship.Book");

        Arrays.stream(bookClass.getFields()).forEach(System.out::println);
        Arrays.stream(bookClass.getFields()).forEach(f ->{
                int modifier = f.getModifiers();
            System.out.println(f);
            System.out.println(Modifier.isPrivate(modifier));
            System.out.println(Modifier.isStatic(modifier));
            System.out.println(f.getDeclaredAnnotations());

        });
        /*public 연산자만 가져옴*/


        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            try {
                f.setAccessible(true);
                System.out.printf("%s %s \n",f, f.get(book));

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        System.out.println("method");
        Arrays.stream(bookClass.getMethods()).forEach(System.out::println);
        Arrays.stream(bookClass.getMethods()).forEach(method -> {
            int modifier = method.getModifiers();

        });


        Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);


        System.out.println(MyBook.class.getSuperclass());

        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);


        /*Annotion 확인*/
        Arrays.stream(Book.class.getAnnotations()).forEach(System.out::println);

        Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println);

        Arrays.stream(MyBook.class.getDeclaredAnnotations()).forEach(System.out::println);


        Arrays.stream(Book.class.getDeclaredFields()).forEach(f->{
            Arrays.stream(f.getAnnotations()).forEach(a->{
                if (a instanceof MyAnnotion){
                    MyAnnotion myAnnotion = (MyAnnotion) a;
                    System.out.println(myAnnotion.value());
                    System.out.println(myAnnotion.number());
                }
            });
        });



        /*****************************************/
        Class<?> bookClass2 = Class.forName("me.whiteship.Book2");
        Constructor<?> constructor = bookClass2.getConstructor(String.class);
        Book2 book2 = (Book2) constructor.newInstance("myBook2");
        System.out.println(book2);


        Field a = Book2.class.getDeclaredField("A");
        System.out.println(a.get(null));

        a.set(null,"AAAA");
        System.out.println(a.get(null));

        Field b = Book2.class.getDeclaredField("B");
        b.setAccessible(true);
        System.out.println(b.get(book2));

        b.set(book2,"BBBBB");
        System.out.println(b.get(book2));

        Method c = Book2.class.getDeclaredMethod("c");
        c.invoke(book2);

        Method sum = Book2.class.getDeclaredMethod("sum", int.class, int.class);
        int invoke = (int) sum.invoke(book2,1,2);
        System.out.println(invoke);
    }
}
