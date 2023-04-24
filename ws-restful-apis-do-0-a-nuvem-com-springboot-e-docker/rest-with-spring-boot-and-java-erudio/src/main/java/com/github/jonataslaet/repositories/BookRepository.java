package com.github.jonataslaet.repositories;

import com.github.jonataslaet.entities.Book;
import com.github.jonataslaet.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
