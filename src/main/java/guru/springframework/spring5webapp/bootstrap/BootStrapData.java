package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.models.Author;
import guru.springframework.spring5webapp.models.Book;
import guru.springframework.spring5webapp.models.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepo;
import guru.springframework.spring5webapp.repositories.BookRepo;
import guru.springframework.spring5webapp.repositories.PublishRepo;

@Component
public class BootStrapData implements CommandLineRunner {
    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;
    private final PublishRepo publishRepo;

    public BootStrapData(BookRepo bookRepo, AuthorRepo authorRepo, PublishRepo publishRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.publishRepo = publishRepo;
    }

    @Override
    public void run(String... args) throws Exception {
    	Publisher publisher = new Publisher();
    	publisher.setName("Six Sigma");
    	publisher.setAddressLine1("New york Street");
    	publisher.setCity("NYC");
    	publisher.setZip(123121L);
    	
    	publishRepo.save(publisher);
        System.out.println("Publisher count:"+publishRepo.count());
    	
        Author author = new Author("Prem","Chand");
        Book book = new Book("Kafan","121212");
        author.getBooks().add(book);
        book.getAuthors().add(author);
        authorRepo.save(author);
        bookRepo.save(book);
        
        Author author1 = new Author("Kali","Das");
        Book book1 = new Book("Meghaduta","989898");
        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        book1.setPublisher(publisher);

    	publisher.getBooks().add(book1);
        authorRepo.save(author1);
        bookRepo.save(book1);
        publishRepo.save(publisher);
        
        System.out.println("BootStrap data initialized ...");
        System.out.println("Books count:"+bookRepo.count());
        



    }



}
