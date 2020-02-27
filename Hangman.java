package eg.edu.alexu.csd.datastructure.hangman.cs;
import java.io.*;

public class Hangman implements IHangman{
	String[] dictionary;
	int counter;//counter of number of guesses user have
	String secretWord;
	char[] outputWord;//will use this array to print the output to user 
	final int noWordsRead = 100;//number of words to read from file
	public String[] readFile(String fileName)  {//function to read file to words array
		String[] words = new String [noWordsRead];
		FileReader fileReader;
		try {
			fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			int i;
			for(i=0;i<noWordsRead;i++) {
					try {
						words[i] = bufferedReader.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return words;

	}
	public void setDictionary(String[] words) {//will set dictionary  using read file function
		dictionary = words;
	}
	
	public String selectRandomSecretword() {
		int x = (int) (noWordsRead*Math.random());
		String Word = dictionary[x];
		outputWord = new char[30];
		for(int i =0;i<30;i++) {//prepare the array which i will printed to the user
			outputWord[i]='-';
		}
		return Word;
	}
	
	public String guess(Character c) throws Exception{
		String Output ="";
		int i,rightLetter=0;
		c = Character.toLowerCase(c);
		for(i=0;i<secretWord.length();i++) {//test if secret word is a buggy word
			if(!Character.isLetter(secretWord.charAt(i)))
				throw new Exception("buggy word");
		}
		if(counter == 0)
			return null;
		
		for(i=0;i<secretWord.length();i++) {//test every letter in secret word if it equal c
			if(c == secretWord.charAt(i)) {
				outputWord[i]=c;
				rightLetter =1;//if there then it a right letter
			}
		}
		if(rightLetter==0)//if not then decrease counter
			counter--;
		if(counter==0)//if counter = 0 user made max no of wrong guesses
			return null;
		Output="";
		for(i=0;i<secretWord.length();i++)
			Output+=outputWord[i];//change array to string as function require a string ouput
		return Output;
	}
	
	public void setMaxWrongGuesses(Integer max) {
		counter = max;
	}
}
