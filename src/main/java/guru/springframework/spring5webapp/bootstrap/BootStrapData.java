package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.models.Author;
import guru.springframework.spring5webapp.models.Book;

import guru.springframework.spring5webapp.repositories.AuthorRepo;
import guru.springframework.spring5webapp.repositories.BookRepo;

@Component
public class BootStrapData implements CommandLineRunner {
    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;

    public BootStrapData(BookRepo bookRepo, AuthorRepo authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author("Prem","Chand");
        Book book = new Book("Kafan","121212");
        author.getBooks().add(book);
        book.getAuthors().add(author);
        bookRepo.save(book);
        authorRepo.save(author);

        Author author1 = new Author("Kali","Das");
        Book book1 = new Book("Meghaduta","989898");
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        bookRepo.save(book1);
        authorRepo.save(author1);

        System.out.println("BootStrap data initialized ...");
        System.out.println("Books count"+bookRepo.count());



    }



}
