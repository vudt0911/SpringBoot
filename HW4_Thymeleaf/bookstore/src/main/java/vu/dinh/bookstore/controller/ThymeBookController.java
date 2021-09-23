package vu.dinh.bookstore.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vu.dinh.bookstore.model.Book;
import vu.dinh.bookstore.repository.Dao;
import vu.dinh.bookstore.request.DeleteRequest;

@Controller
@RequestMapping("/thyme")
public class ThymeBookController {
    @Autowired
    Dao<Book> bookDaoThyme;

    @GetMapping
    public String listAllThyme(Model model){
        model.addAttribute("books", bookDaoThyme.getAll());
        return "listbook";
    }

    @GetMapping(value = "/{id}")
    public String getBookByIDThyme(Model model, @PathVariable("id") int id){
        Optional<Book> resutlIdThyme = bookDaoThyme.get(id);
        model.addAttribute("book", resutlIdThyme.get());
        return "book";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("book", new Book()); //tao doi tuong book rong de truyen vao th:object="*{book}"
        return "form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("book") Book book, BindingResult result){
        if (result.hasErrors()) {
            return "form";
        } 
        if (book.getId()>0) {
            bookDaoThyme.update(book); // Neu co truong hop id  co nghia la edit book
        }else {             // neu id == 0 co nghia book lan dau duoc add
            bookDaoThyme.add(book);
        }
        return "redirect:/thyme";
    }

    @GetMapping("/update/{id}")
    public String updateBook(@PathVariable int id, Model model){
        Optional<Book> book = bookDaoThyme.get(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
        }
        return "form";
    }

    @PostMapping("/delete")
    public String deleteById(@ModelAttribute DeleteRequest request, BindingResult result){
        if (!result.hasErrors()) {
            bookDaoThyme.deleteById(request.getId());
        }
        return "redirect:/thyme";
    }
}
