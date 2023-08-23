package com.Eya.Exam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.Eya.Exam.models.Book;
import com.Eya.Exam.models.Library;
import com.Eya.Exam.models.User;
import com.Eya.Exam.services.BookService;
import com.Eya.Exam.services.LibraryService;
import com.Eya.Exam.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookServ;
	@Autowired
	private LibraryService libServ;
	@Autowired
	private UserService UserServ;
	
	// DISPLAY ROUTE - READ ALL
	// DISPLAY ROUTE - READ ALL
	@GetMapping("/books")
	public String home(Model m, HttpSession session) {
		// grab the user id from session
		 Long userId = (Long) session.getAttribute("user_id");
		 // ROUTE GUARD
		 if(userId == null) {
			 return "redirect:/login";
		 }else {
		List<Book> allTheBooks = bookServ.allBooks();
		m.addAttribute("booksList", allTheBooks);
		return "home.jsp";
		}
	}
	// DISPLAY ROUTE - FORM
	@GetMapping("/books/new")
	public String create(@ModelAttribute("book") Book book,
						Model m) {
		// grab the libs list
		List<Library> libsList = libServ.alllibs();
		m.addAttribute("libsList",libsList);
		return "create.jsp";
	}
	
	// ACTION ROUTE - Process Form
	@PostMapping("/books")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result,
							Model m,HttpSession session) {
		
		if (result.hasErrors()) {
			List<Book> allTheBooks = bookServ.allBooks();
			m.addAttribute("booksList", allTheBooks);
			return "create.jsp";
		} else {
			// save the book
			//1. grab the current user's ID from Session
			Long userID = (Long) session.getAttribute("user_id");
			
			//2. fetch the user from the DB
			User currentUser  = UserServ.findOne(userID);
			System.out.println(currentUser);
			//3. setAuthor to be the the current user
			book.setAuthor(currentUser);
			Book newBook = bookServ.createBook(book);
			return "redirect:/books";
		}
	}
	
	// Display Route - Edit form
	
	@GetMapping("books/{id}/edit")
	public String editPage(@PathVariable("id") Long id, Model model) {
		 
		// find that book with provided id
		Book thisBook = bookServ.findBook(id);
		// pass thisBook to the jsp page 
		model.addAttribute("book",thisBook);
		return "edit.jsp";
	}
	
	@PutMapping("/books/{id}/edit")
	public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result , HttpSession session,
			@PathVariable("id")Long bookID) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			// if 0 errors update the book 
			//1 grab the current user's ID from session
			Long userID =(Long) session.getAttribute("user_id");
			// 2 fetch the user from the db
			User currentUser = UserServ.findOne(userID);
			// 3 setAuther to be the current user
			book.setAuthor(currentUser);
			// =======Fetch the library object ========
			// grab the book from db
			Book thisBook = bookServ.findBook(bookID);
			// grab the oldlibrary from thisBook
			Library OgLibrary = thisBook.getLibrary();
			//set the ogLibrary to the updated book
			book.setLibrary(OgLibrary);
			// save the updated book
			bookServ.updateBook(book);
			return "redirect:/books";
		}
	}
	
	// DELETE
	
	@DeleteMapping("/books/{id}")
	public String delete(@PathVariable("id") Long id) {
		bookServ.deleteBook(id);
		return "redirect:/books";
	}
}