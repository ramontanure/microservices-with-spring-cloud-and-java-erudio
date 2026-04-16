package br.com.ramontanure.repository;

import br.com.ramontanure.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
