package com.github.jonataslaet.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.github.jonataslaet.controllers.BookController;
import com.github.jonataslaet.data.vo.v1.BookVO;
import com.github.jonataslaet.entities.Book;
import com.github.jonataslaet.exceptions.ResourceNotFoundException;
import com.github.jonataslaet.repositories.BookRepository;
import java.util.List;
import java.util.logging.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  private final Logger logger = Logger.getLogger(BookService.class.getName());

  @Autowired
  BookRepository bookRepository;

  @Autowired
  private ModelMapper mapper;

  public BookVO findById(Long id) {
    logger.info("Finding one person!");
    BookVO bookVO = mapper.map(getBookById(id), BookVO.class);
    bookVO.add(linkTo(methodOn(BookController.class).getBookById(String.valueOf(id))).withSelfRel());
    return bookVO;
  }

  public List<BookVO> findAll() {
    logger.info("Finding all people!");
    return bookRepository.findAll().stream().map(book ->
        mapper.map(book, BookVO.class).add(linkTo(methodOn(BookController.class)
            .getBookById(String.valueOf(book.getId()))).withSelfRel())).toList();
  }

  public BookVO updateBook(Long bookId, BookVO updatedBook) {
    logger.info("Updating a person!");
    Book foundBookToBeUpdated = getBookById(bookId);

    foundBookToBeUpdated.setId(bookId);
    foundBookToBeUpdated.setAuthor(updatedBook.getAuthor());
    foundBookToBeUpdated.setLaunchDate(updatedBook.getLaunchDate());
    foundBookToBeUpdated.setPrice(updatedBook.getPrice());
    foundBookToBeUpdated.setTitle(updatedBook.getTitle());
    BookVO bookVO = mapper.map(bookRepository.save(foundBookToBeUpdated), BookVO.class);
    bookVO.add(linkTo(methodOn(BookController.class).getBookById(String.valueOf(bookVO.getId()))).withSelfRel());
    return bookVO;
  }

  public BookVO createBook(BookVO newBook) {
    logger.info("Create a person!");
    Book book = mapper.map(newBook, Book.class);
    BookVO bookVO = mapper.map(bookRepository.save(book), BookVO.class);
    bookVO.add(linkTo(methodOn(BookController.class).getBookById(String.valueOf(bookVO.getId()))).withSelfRel());
    return bookVO;
  }

  public void deleteBook(Long bookId) {
    logger.info("Delete a book!");
    getBookById(bookId);
    bookRepository.deleteById(bookId);
  }

  private Book getBookById(Long id) {
    return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No book found for this ID!"));
  }
}
