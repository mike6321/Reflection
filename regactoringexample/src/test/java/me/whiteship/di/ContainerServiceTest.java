package me.whiteship.di;

import me.whiteship.Book;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.assertNotNull;
public class ContainerServiceTest {

    @Test
    public void getObject_BookRepository() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
        assertNotNull(bookRepository);
    }

    @Test
    public void getObject_BookService() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        BookService bookService = ContainerService.getObject(BookService.class);
        assertNotNull(bookService);
        assertNotNull(bookService.bookRepository);
    }

}
