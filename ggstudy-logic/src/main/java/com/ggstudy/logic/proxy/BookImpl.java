package com.ggstudy.logic.proxy;

public class BookImpl implements IBook{

	@Override
	public void addBook(String bookName) {
		System.out.println(bookName);

	}

	@Override
	public void addBook1(String bookName) {
		System.out.println(bookName);
		// this.addBook(bookName);
	}

//	@Override
	public void addBook2(String bookName) {
		// TODO Auto-generated method stub

	}

}
