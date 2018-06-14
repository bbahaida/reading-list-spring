package com.bahaida.readinglist.persistence.repositories;

import com.bahaida.readinglist.persistence.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface BookRepository extends JpaRepository<Book,Long> {
    Collection<Book> findByReader(String reader);
}
