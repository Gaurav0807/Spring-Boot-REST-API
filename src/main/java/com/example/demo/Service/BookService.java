package com.example.demo.Service;

import java.util.List;
import com.example.demo.entity.*;

public interface BookService {


	public List<Book> getBooks();

	public Book getBooks(int id);

	public Book addBook(Book c);

	public Book updateBook(Book c);

	public void deleteBook(int id);
}
