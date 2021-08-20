package com.bookapp.client;

import java.util.List;
import java.util.Scanner;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;

public class MainUser {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		BookServiceImpl bookImplt= new BookServiceImpl();
		int select=0;
		
		System.out.println("Enter Number 1 to get all books \n"
				+ "Enter Number 2 to get book by Book Id \n"
				+ "Enter Number 3 to get book by Author \n"
				+ "Enter Number 4 to get book by Category \n"
				+ "Enter Number 5 to get book by less price \n");
		 select = sc.nextInt();
		 
		 switch(select) {
			case 1:
				try {
					List <Book> allBooks=bookImplt.getAllBooks();
					if(allBooks== null) {
						System.out.println("Sorry!!!Currently Books Are Not Available");
					}
					else
					{
						for(Book book:allBooks) {
							System.out.println(book);
							System.out.println();
						}
					}
				}catch(BookNotFoundException e){
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					System.out.println("Enter Book Id: ");
					int bookId= sc.nextInt();
					Book b= bookImplt.getBookById(bookId);
					if(b!= null) {
						System.out.println(b);
					}
				}catch(BookNotFoundException e){
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
					System.out.println("Enter Author Name: ");
					sc.nextLine();
					String authorName= sc.next();
					List<Book>authorBook= bookImplt.getBooksByAuthor(authorName);
					if(authorBook!= null) {
						for(Book book: authorBook) {
							System.out.println(book);
							System.out.println();
						}
						
					}
				}catch(BookNotFoundException e){
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				try {
					System.out.println("Enter Book Category: ");
					sc.nextLine();
					String category= sc.next();
					List<Book>categoryList= bookImplt.getBooksByCategory(category);
					if(categoryList!= null) {
						for(Book book: categoryList) {
						System.out.println(book);
						System.out.println();
						}
					}
				}catch(BookNotFoundException e){
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				try {
					System.out.println("Enter Book Price: ");
					sc.nextLine();
					double price= sc.nextDouble();
					List<Book> priceList= bookImplt.getBooksByLessPrice(price);
					if(priceList!= null) {
						for(Book book: priceList) {
							System.out.println(book);
							System.out.println();
						}
						
					}
				}catch(BookNotFoundException e){
					System.out.println(e.getMessage());
				}
				break;
			default:
				System.out.println("Invalid Choice");
		 }
		 
		 System.out.println("------Thank You-------");
		 sc.close();
	}
	

}
