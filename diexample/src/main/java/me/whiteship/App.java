package me.whiteship;

import me.whiteship.di.ContainerService;

import java.lang.reflect.InvocationTargetException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        AccountService accountService = ContainerService.getObject(AccountService.class);
        accountService.join();
    }
}
