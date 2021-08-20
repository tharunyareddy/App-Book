package com.bookapp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;



public class BookServiceImpl implements BookService {

	@Override
	public Book getBookById(int id) throws BookNotFoundException {
		boolean check= false;
		List <Book > allBooks= showBooks();
		for(Book book: allBooks )
		{
			if(book.getBookId()== id) {
				check=true;
				return book;
			}
		}
		if(!check) {
		throw new BookNotFoundException("Sorry!!! Book is not available");
		}
		return null;
	}

	@Override
	public List<Book> getBooksByAuthor(String author) throws BookNotFoundException {
		boolean check= false;
		List <Book > allBooks= showBooks();
		ArrayList <Book> getBookByAuthor= new ArrayList<>();
		for(Book book: allBooks )
		{
			if(book.getAuthor().equals(author)) {
				check= true;
				getBookByAuthor.add(book);
			}
		}
		if(!check) {
			throw new BookNotFoundException("Sorry!!!Book is not available with this author name");
		}
		return getBookByAuthor;
	}

	@Override
	public List<Book> getBooksByCategory(String category) throws BookNotFoundException {
		boolean check= false;
		List <Book > allBooks= showBooks();
		ArrayList <Book> getBookByCategory= new ArrayList<>();
		for(Book a: allBooks )
		{
			if(a.getCategory().equals(category)) {
				check= true;
				getBookByCategory.add(a);
			}
		}
		if(!check) {
			throw new BookNotFoundException("Sorry!!!Book is not available with this category");
		}
		return getBookByCategory;
	}

	@Override
	public List<Book> getAllBooks() throws BookNotFoundException {
		List <Book > allBooks= showBooks();
		return allBooks;
	}

	@Override
	public List<Book> getBooksByLessPrice(double price) throws BookNotFoundException {
		boolean check= false;
		List <Book > allBooks= showBooks();
		ArrayList <Book> getBookByLess= new ArrayList<>();
		for(Book a: allBooks )
		{
			if(a.getPrice()< price) {
				check= true;
				getBookByLess.add(a);
			}
		}
		if(!check) {
			throw new BookNotFoundException("No Book at this price");
		}
		return getBookByLess;
	}
	
	public List<Book> showBooks(){
		return Arrays.asList(new Book("Sherlock Holmes","Arthur Conan Doyle","Fiction",1200, 1),
				new Book("MahaBharata","Vyasa","Poetry",110, 2),
				new Book("Pokhran","","Fiction",1900, 3)
				,new Book("One Indian Girl","Chetan Bhagat","Fiction",200, 4),
				new Book("The Girl in Room 105","Bhagat","Fiction",5000, 5),
				new Book("Turning Points","Abdul Kalam","Biography",100, 6)
				
				);
	}
	
}
