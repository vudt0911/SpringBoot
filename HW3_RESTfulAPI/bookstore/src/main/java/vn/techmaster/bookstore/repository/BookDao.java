package vn.techmaster.bookstore.repository;

import java.util.List;
import java.util.Optional;
import vn.techmaster.bookstore.model.Book;

public class BookDao extends Dao<Book> {

  public BookDao() {
    collections.add(new Book(1, "Không gia đình", "Chú bé Remy lang thang theo gánh xiếc của bác Vitaly"));
    collections.add(new Book(2, "Cuốn theo chiều gió", "Nội chiến Hoa kỳ, cuộc tình giữa Red Butler và Ohara"));
    collections.add(new Book(3, "Cô bé bán diêm", "Cô bé cô đơn giữa đêm giáng sinh"));
    collections.add(new Book(4, "Nàng bạch tuyết và 7 chú lùn", "Nàng bạch tuyết da trắng mắt nâu"));
  }

  @Override
  public List<Book> getAll() {
    return collections;
  }

  @Override
  public Optional<Book> get(int id) {
    // TODO Auto-generated method stub
    for (Book book : collections) {
      if (book.getId() == id) {
        return Optional.of(book);
      }
    }
    //return collections.stream().filter(p -> (p.getId() == id)).findFirst();
   return null; 
  }

  @Override
  public void add(Book t) {
    // TODO Auto-generated method stub
    collections.add(t);
  }

  @Override
  public void update(Book t) {
    // TODO Auto-generated method stub
    Optional<Book> findBook = collections.stream().filter(p -> (p.getId() == t.getId())).findFirst();
    if (findBook.isPresent()) {
      Book book = findBook.get();
      int index = collections.indexOf(book);
      collections.set(index, t);
    } else {
      collections.add(t);
    }
  }

  @Override
  public void deleteByID(int id) {
    // TODO Auto-generated method stub
    Optional<Book> findBook = collections.stream().filter(p -> (p.getId() == id)).findFirst();
    if (findBook.isPresent()) {
      Book book = findBook.get();
      collections.remove(book);
    }
  }

  @Override
  public void delete(Book t) {
    // TODO Auto-generated method stub
  }  
}