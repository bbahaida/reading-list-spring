package com.bahaida.readinglist.persistence.repositories;

import com.bahaida.readinglist.persistence.domain.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader,String> {
}
