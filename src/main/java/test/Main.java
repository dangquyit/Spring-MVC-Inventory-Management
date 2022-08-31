package test;

import com.junior.util.ConfigLoader;

public class Main {
	
	public static void main(String[] args) {
		System.out.println(ConfigLoader.getInstance());
		System.out.println(ConfigLoader.getInstance().getValue("upload.location"));
	}
}
