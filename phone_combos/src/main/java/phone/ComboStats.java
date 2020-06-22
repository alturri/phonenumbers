package phone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ComboStats {

	private int count;
	
	private List<String> combinations = new ArrayList<>();
		
	public ComboStats(List<String> combinations, int count) {
		this.combinations = combinations;
		this.count = count;		
	}
    
	public List<String> getList() {
		return combinations;
	}
	
	public int getCount() {
		return count;
	}
}