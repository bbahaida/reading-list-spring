package com.bahaida.readinglist.controllers;

import com.bahaida.readinglist.persistence.domain.Book;
import com.bahaida.readinglist.persistence.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
public class HomeController {

    private BookRepository bookRepository;

    @Autowired
    public HomeController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader, Model model){
        Collection<Book> books = bookRepository.findByReader(reader);
        if (books != null)
            model.addAttribute("books", books);
        return "index";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book){
        if (book != null){
            book.setReader(reader);
            bookRepository.save(book);
        }
        return "redirect:/{reader}";
    }
}
