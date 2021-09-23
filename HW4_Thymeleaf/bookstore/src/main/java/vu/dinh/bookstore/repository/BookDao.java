package vu.dinh.bookstore.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import vu.dinh.bookstore.model.Book;

@Component
public class BookDao implements Dao<Book> {
    List<Book> listBook = new ArrayList<>();

    public BookDao() {
        try {
          File file = ResourceUtils.getFile("classpath:static/book.json");
          ObjectMapper mapper = new ObjectMapper();
          listBook.addAll(mapper.readValue(file, new TypeReference<List<Book>>() {
          }));
          listBook.forEach(System.out::println);
        } catch (IOException e) {
          System.out.println(e.getMessage());
        }
      }
    @Override
    public List<Book> getAll() {
        // TODO Auto-generated method stub
        return listBook;
    }

    @Override
    public Optional<Book> get(int id) {
        // TODO Auto-generated method stub
        return listBook.stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public void add(Book book) { // ???
        // TODO Auto-generated method stub
        //co che tu tang
        int id;
        if (listBook.isEmpty()) {
            id = 1;
        } else {
            Book lastBook = listBook.get(listBook.size()-1);
            id = lastBook.getId() + 1;
        }
        book.setId(id);
        listBook.add(book);
    }

    @Override
    public void update(Book book) {
        // TODO Auto-generated method stub
       get(book.getId()).ifPresent(existbook -> {
            existbook.setTitle(book.getTitle());
            existbook.setDescription(book.getDescription());
       });
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        get(id).ifPresent(existId -> listBook.remove(existId));
    }

}
