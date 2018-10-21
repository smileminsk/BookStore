package bookstore.controller;

import bookstore.dao.BookDao;
import bookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

@Controller
public class BookController {

    @Qualifier("mysqlDao")
    @Autowired
    private BookDao bookDao;

    //Вывод списка книг
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getAllBooks() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("bList", bookDao.getAllBooks());

        return modelAndView;
    }


    //Отображение формы добавления книги
    @RequestMapping(value = "/addbookform", method = RequestMethod.GET)
    public ModelAndView addBookForm() {
        ModelAndView modelAndView = new ModelAndView("add_book");
        modelAndView.addObject("bookFromServer", new Book());

        return modelAndView;
    }


    //Добавление книги
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addBook(@ModelAttribute("bookFromServer") Book book,
                                @RequestParam("file") MultipartFile file) throws IOException {

        if (!book.getBookName().equals("") || !book.getBookAuthor().equals("")) {
            String fileName = file.getOriginalFilename();
            InputStream inputStream;

            if (file != null && !fileName.equals("")) {
                inputStream = file.getInputStream();
                book.setFileData(inputStream);
                book.setFileName(fileName);
            }

            bookDao.addBook(book);
            return new ModelAndView("redirect:/");
        } else return new ModelAndView("add_book");
    }


    //Скачивание книги
    @RequestMapping(value = "/dwn", method = RequestMethod.GET)
    @ResponseBody
    public void downloadBook(@RequestParam("bid") int id, HttpServletResponse resp) throws IOException {

        Book book = bookDao.getBookById(id);

        if (book.getFileData() != null) {
            InputStream is = book.getFileData();
            String fileName = book.getFileName();
            resp.setCharacterEncoding("UTF-8");
            resp.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
            byte[] bytes = new byte[4096];
            int bytesRead;
            while ((bytesRead = is.read(bytes)) != -1) {
                resp.getOutputStream().write(bytes, 0, bytesRead);
            }
            is.close();
        }
    }


    //Удаление книги
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public ModelAndView deleteBookById(@RequestParam("bid") int id) {
        bookDao.removeBook(id);
        return new ModelAndView("redirect:/");
    }

}
