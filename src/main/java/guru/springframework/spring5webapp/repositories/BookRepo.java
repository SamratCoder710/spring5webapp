package guru.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.spring5webapp.models.Book;

public interface BookRepo extends CrudRepository<Book,Long>{
    
}
