package service;

import java.util.Arrays;
import java.util.Random;

import util.RSA;
import model.User;

public class Encryption {
	
	private String [] foo = new String[100];
	
	private static final int minSize = 20;
	private static final int maxSize = 120;
	private static final int sMaxSize = 235;
	private static final int sMinSize = 64;
//	private static final String alpha = "abcdefghijklmnopqrstuvwxyz1234567890";
	private static final String alpha = "1234567890";
	private int keyIndex;
	
	public Encryption(String randomLoc, User u) { 
		
		int targetIndex = getHashValue(randomLoc);
		foo[targetIndex] = generateRandomLoc();
		
		foo[getHashValue(foo[targetIndex])] = u.getRsaInstance().getD() + "." + u.getRsaInstance().getN();
		
		for(int i = 0; i < 100; i++)
			if((i != (getHashValue(foo[targetIndex]))) && i!= targetIndex)
				foo[i] = generateRandomString();
		
		
		
	}

	public String [] get() {
		return foo;
	}

	public void set(String [] foo) {
		this.foo = foo;
	}
	
	private String generateRandomLoc() { 
		
		Random r = new Random();
		
		String keyLoc = "";
		keyIndex = r.nextInt(100);
		
		while(getHashValue(keyLoc) <= keyIndex)
			keyLoc += alpha.charAt(r.nextInt(alpha.length()));
		System.out.println("Hash : " + keyLoc);
		System.out.println("HashValue : " + getHashValue(keyLoc));
		return keyLoc;
		
	}
	
	private String generateRandomString() { 
		
		Random r = new Random();
		int rLength =  r.nextInt((sMaxSize - sMinSize) + 1) + sMinSize;
		String rString = "";
		while(rString.length() < rLength)
			rString += alpha.charAt(r.nextInt(alpha.length()));
		
		return rString;
	}
	
	private int getHashValue(String s) {
		
		int hashValue = 0;
		for(byte i : s.getBytes())
			hashValue += (i%10);
		return hashValue;
	}
	
	public static void main(String [] args) { 
		
		User u = new User(Users.generateUserId(), "5ela", "mk1993328");
		u.setRsaInstance(new RSA(1024));
		Encryption e = new Encryption("abcde", u);
		
		
		System.out.println(Arrays.toString(e.get()));
		System.out.println(e.get()[25]);
		System.out.println(e.get()[e.getHashValue(e.get()[25])]);
		
	}
}