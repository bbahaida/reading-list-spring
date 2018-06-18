package com.bahaida.readinglist.controllers;

import com.bahaida.readinglist.persistence.domain.Book;
import com.bahaida.readinglist.persistence.domain.Reader;
import com.bahaida.readinglist.persistence.repositories.BookRepository;
import com.bahaida.readinglist.persistence.repositories.ReaderRepository;
import com.bahaida.readinglist.properties.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/")
public class HomeController {

    private BookRepository bookRepository;
    private ReaderRepository readerRepository;
    private ApplicationProperties applicationProperties;



    @Autowired
    public HomeController(BookRepository bookRepository, ReaderRepository readerRepository, ApplicationProperties applicationProperties) {
        this.bookRepository = bookRepository;
        this.readerRepository = readerRepository;
        this.applicationProperties = applicationProperties;
    }

    @GetMapping(value = "/login")
    public String login(Model model){
        model.addAttribute("appName", applicationProperties.getAppName());
        return "auth/login";
    }

    @GetMapping
    public String readersBooks(Reader reader, Model model){
        Collection<Book> books = bookRepository.findByReader(reader);
        if (books != null)
            model.addAttribute("books", books);
        return "index";
    }

    @PostMapping
    public String addToReadingList(Reader reader, Book book){
        if (book != null){
            book.setReader(reader);
            bookRepository.save(book);
        }
        return "redirect:/{reader}";
    }
}
