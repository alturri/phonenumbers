package phone;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/phones", produces = "application/json")
@CrossOrigin(origins = "*")
public class CombosController {
	
	private static final int PAGE_SIZE = 40;
	
	private String currentPhoneNumber;
	
	private Combos combos;
	
	@GetMapping("/combos")
	public ComboStats combos(@RequestParam("phoneNumber") String phoneNumber, @RequestParam("page") int page) {
		if (!phoneNumber.equals(currentPhoneNumber)) {			
			currentPhoneNumber = phoneNumber;
			combos = new Combos(currentPhoneNumber);			
		}
		
		//  Suppose this is the very first page for this phone number.  The user would not even had a chance of 
		//  selecting any of its page(s), to begin with.
		if (page == 0) {
			page = 1;
		}
		
		//  Note:  it may very well happen that fewer elements than PAGE_SIZE are returned:  for example, suppose the user
		//         had used '1111111111'.  In such a case, one would have only one phone number to return, as '1' does not map
		//         to any letter in the alphabet, just to itself.
		
		return new ComboStats(
			combos.getList().subList((page - 1) * PAGE_SIZE, Math.min(combos.getCount(), (page) * PAGE_SIZE)), combos.getCount());
	}
}