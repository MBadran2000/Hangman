package eg.edu.alexu.csd.datastructure.hangman.cs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Hangmantest {

	@Test
	void test() {//test all functions
		Hangman hangman = new Hangman();
		hangman.setDictionary(hangman.readFile("dictionary.txt"));
		hangman.secretWord = hangman.selectRandomSecretword();
		hangman.setMaxWrongGuesses(5);
		char in ='z';
		try {
			hangman.guess(in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	void test1() throws Throwable {//test all functions
		Hangman hangman = new Hangman();
		hangman.setDictionary(hangman.readFile("dictionary.txt"));
		hangman.secretWord = hangman.selectRandomSecretword();
		hangman.secretWord="zoo";
		hangman.setMaxWrongGuesses(5);
		char in ='Z';
			assertEquals(hangman.guess(in),"z--") ;
		in ='f';
			assertEquals(hangman.guess(in),"z--") ;
		in ='o';
			assertEquals(hangman.guess(in),"zoo") ;
			
	}
	@Test
	void test2() throws Throwable {//test all functions
		Hangman hangman = new Hangman();
		hangman.setDictionary(hangman.readFile("dictionary.txt"));
		hangman.secretWord = hangman.selectRandomSecretword();
		hangman.secretWord="germany";
		hangman.setMaxWrongGuesses(3);
		char in ='b';
			assertEquals(hangman.guess(in),"-------") ;
		in ='A';
			assertEquals(hangman.guess(in),"----a--") ;
		in ='o';
			assertEquals(hangman.guess(in),"----a--") ;
		in ='e';
			assertEquals(hangman.guess(in),"-e--a--") ;
		in ='g';
			assertEquals(hangman.guess(in),"ge--a--") ;
		in ='z';
			assertEquals(hangman.guess(in),null) ;
			
	}

}
