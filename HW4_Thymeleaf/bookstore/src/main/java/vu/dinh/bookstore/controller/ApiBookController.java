package vu.dinh.bookstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vu.dinh.bookstore.model.Book;
import vu.dinh.bookstore.repository.Dao;

@RestController
@RequestMapping("/book")
public class ApiBookController {
    @Autowired
    private Dao<Book> bookDao;

    @GetMapping
    public ResponseEntity<?> listAll(){
        List<Book> result = bookDao.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id){
        Optional<Book> resutlId = bookDao.get(id);
        return ResponseEntity.ok(resutlId);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestParam int id, @RequestParam String title, @RequestParam String description){
        Book newBook = new Book(id, title, description);
        bookDao.add(newBook);
        List<Book> listBook = bookDao.getAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(listBook);
    }

    @PutMapping("")
    public ResponseEntity<List<Book>> updateBook(@RequestParam int id, @RequestParam String title, @RequestParam String description){
     Book newBook = new Book(id, title, description);
     bookDao.update(newBook);
     List<Book> listBook = bookDao.getAll();
     return ResponseEntity.status(HttpStatus.OK).body(listBook);
    }
   
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Book>> deleteBook(@PathVariable int id){
      bookDao.deleteById(id);
      List<Book> listBook = bookDao.getAll();
      return ResponseEntity.status(HttpStatus.OK).body(listBook);
    }
}
