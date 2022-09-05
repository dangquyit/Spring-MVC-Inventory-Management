package test;

import java.sql.Timestamp;
import java.util.Date;

public class Main {
	
	public static void main(String[] args) {
		Timestamp timestamp = new Timestamp(new Date().getTime());
				Date date = new Date(timestamp.getTime());
				System.out.println(date);
				System.out.println(new Date());
				if(date.equals(new Date())) {
					System.out.println("bang nhau");
				}
	}
}
