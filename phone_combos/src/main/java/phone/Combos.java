package phone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Combos {

	private String phoneNumber;
	
	private List<String> combinations = new ArrayList<>();
	
	private Map<String, List<String>> innerCombinations = new HashMap<>();
	
	public Combos(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		
		calc();
	}

	{
		innerCombinations.put("1", Arrays.asList("1"));
		innerCombinations.put("2", Arrays.asList("A", "B", "C", "2"));
		innerCombinations.put("3", Arrays.asList("D", "E", "F", "3"));
		innerCombinations.put("4", Arrays.asList("G", "H", "I", "4"));
		innerCombinations.put("5", Arrays.asList("J", "K", "L", "5"));
		innerCombinations.put("6", Arrays.asList("M", "N", "O", "6"));
		innerCombinations.put("7", Arrays.asList("P", "Q", "R", "S", "7"));
		innerCombinations.put("8", Arrays.asList("T", "U", "V", "8"));
		innerCombinations.put("9", Arrays.asList("W", "X", "Y", "Z", "9"));
		innerCombinations.put("0", Arrays.asList("0"));
	}

	public void calc() {
		if (allNumeric(phoneNumber) && (phoneNumber.length() == 7 || phoneNumber.length() == 10)) {
			combinations = innerCalc(0);			
		} else { 
			if (!allNumeric(phoneNumber)) {
			    throw new InvalidPhoneNumberException(phoneNumber + " must be composed (exclusively) of digits.");
			} else {		
			    throw new InvalidPhoneNumberException("The number of digits (" + phoneNumber.length() + ") must be 7 or 10 instead.");		
			}
		}
	}
	
	private List<String> innerCalc(int position) {
		if (position == phoneNumber.length() - 1) {
			return innerCombinations.get(Character.toString(phoneNumber.charAt(position)));
		} else {
			List<String> keySpecificCombinations = innerCombinations.get(Character.toString(phoneNumber.charAt(position)));
			
			List<String> result = new ArrayList<String>();
			
			List<String> suffixes = innerCalc(++position);
			
			for (String prefix : keySpecificCombinations) {
				for (String suffix : suffixes) {
					result.add(prefix + suffix);
				}
			}
			
			return result;
		}
	}
	
    private static boolean allNumeric(String s) {
        IntStream is = s.chars();

        return is.allMatch(Character::isDigit);
    }
    
	public List<String> getList() {
		return combinations;
	}
	
	//  TODO:  consider whether to cache this, as traversing the List is O(n).
	public int getCount() {
		return combinations.size();
	}
}