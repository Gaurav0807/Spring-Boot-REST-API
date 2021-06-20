package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.BookDao;
import com.example.demo.entity.Book;

@Service
public class BookServiceImpl implements BookService {
	
//	List<Book> list;
	
	@Autowired
	private BookDao bookDao;
	
	public BookServiceImpl()
	{
//		list = new ArrayList<>();
//		list.add(new Book(1,"Java Book","ABC"));
//		list.add(new Book(2,"Django","XYZ"));
	}

	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return bookDao.findAll();
	}

	@Override
	public Book getBooks(int id) {
	
		return bookDao.findById(id).get();
	}

	@Override
	public Book addBook(Book c) {
		bookDao.save(c);
		return c;
	}

	@Override
	public Book updateBook(Book c) {

		bookDao.save(c);
		return c;
	}

	@Override
	public void deleteBook(int id) {
		Book entity =bookDao.getOne(id);
		bookDao.delete(entity);
	}

}
