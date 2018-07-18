package bookstore.controller;

import bookstore.dao.BookDao;
import bookstore.model.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerTest {

    @Mock
    private BookDao bookDao;

    @InjectMocks
    private BookController bookController;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
    }

    @Test
    public void getAllBooks() throws Exception {
////        when(bookDao.getAllBooks()).thenReturn(new ArrayList<>());
//        ModelAndView mav = bookController.getAllBooks();
//        verify(bookDao).getAllBooks();
        this.mockMvc.perform(get("/"));
    }

    @Test
    public void addBookTest () {

    }
}