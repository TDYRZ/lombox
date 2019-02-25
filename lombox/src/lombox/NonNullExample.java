package lombox;

import java.awt.print.Book;

import lombok.NonNull;

public class NonNullExample extends Book {
	private String name;

	public NonNullExample(@NonNull Book book) {
		System.out.println("asd"); 
	}
}
