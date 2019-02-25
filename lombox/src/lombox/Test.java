package lombox;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import com.sun.org.apache.bcel.internal.generic.NEW;

import lombok.Cleanup;
import lombok.val;
import lombok.extern.java.Log;
import sun.management.counter.Variability;
@Log
public class Test {
	
	public static void main(String[] args) {
		//@ToString π”√
		 Book book=new Book();
		 book.setName("www");
		 boolean b=book.equals(book);
		 int hashCode=book.hashCode();
		 System.out.println(book.toString());
		 System.out.println(b);
		 System.out.println(hashCode);
		 log.severe("Something's wrong here");
	}
}
