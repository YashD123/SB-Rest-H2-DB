package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.binding.Book;

@RestController
public class BookRestController {
	
	@GetMapping(value="/book/{isbn}",produces = "application/json")
	public Book getBookInfo(@PathVariable("isbn") String isbn)
	
	{
		Book b = new Book(isbn,"spring",300.00,"Rod Johnson");
		Link withRel =
				WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(BookRestController.class).getClass()).
				withRel("All-Books");

				b.add(withRel);
				return b;
	}
	
	
	
	@GetMapping(value="/books",produces = "application/json")
	public List<Book> getAllBooks()
	{
		Book b1 = new Book("ISBN001","Spring",300.00,"Red Johnson");
		Book b2 = new Book("ISBN002","Polity",500.00,"M Lakshmikant");
		Book b3 = new Book("ISBN003","History",250.00,"Bipin Chandra");
		
		List<Book>  books = new ArrayList<Book>();
		books.add(b1);
		books.add(b2);
		books.add(b3);
		return books;
		
	}

}
