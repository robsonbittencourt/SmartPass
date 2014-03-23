package check;

import static type.PasswordStrengthType.STRONG;
import static type.PasswordStrengthType.WEAK;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.Password;
import type.PasswordStrengthType;

public class PasswordCheckDictionary extends PasswordCheck {

	private static final String DICTIONARY_PATH = "C:\\Desenvolvimento\\workspaces\\SmartPass\\WebContent\\resource\\dictionary.txt";

	public PasswordCheckDictionary(double weight) {
		super(weight);
	}

	public PasswordStrengthType checkPasswordStrength(Password password) {
		ArrayList<String> dictionary = getDictionaryWords();
		
		if (dictionary.contains(password.getPassword()))
			return WEAK;
	
		return STRONG;
	}

	public ArrayList<String> getDictionaryWords() {
		ArrayList<String> dictionary = new ArrayList<String>();
		
		try {
			String word;
			BufferedReader reader = new BufferedReader(new FileReader(DICTIONARY_PATH));
			while ((word = reader.readLine()) != null) {
				dictionary.add(word);
			}
			reader.close();
		} catch (IOException e) {
			
		}
		return dictionary;
	}
	
	@Override
	public String getCheck() {
		return "Dictionary";
	}
	
}
