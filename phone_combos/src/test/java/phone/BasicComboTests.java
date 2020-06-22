package phone;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import java.math.BigInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicComboTests {
	
	@Test
	public void incorrectNumberOfDigits() {
		InvalidPhoneNumberException thrown = Assertions.assertThrows(InvalidPhoneNumberException.class, () -> {
			Combos combos = new Combos("111");
		});
	}
	
	/**
	 *  On a standard alpha-numeric telephone keypad, the digit 1 does not have corresponding letters associated with it.
	 */
	@Test
	public void veryBasicCount10Digits() {
		Combos combos = new Combos("1111111111");
		
		assertThat(combos.getCount(), equalTo(1));
	}
	
	/**
	 * This test checks that all the ten digits (0 - 9) are indeed represented correctly by the underlying program.
	 */
	@Test
	public void allTenDigits() {
		Combos combos = new Combos("1234567890");
		
		assertThat(combos.getCount(), equalTo(1 * 4 * 4 * 4 * 4 * 4 * 5 * 4 * 5 * 1));	
	}
	
	/**
	 * This test checks that particular entries are indeed present in the underlying representation and, conversely,
	 * that other entries are not present in the underlying representation (negative testing).
	 */
	@Test
	public void basicCount10Digits() {
		Combos combos = new Combos("2403866106");
		
		assertThat(combos.getCount(), equalTo(4 * 4 * 1 * 4 * 4 * 4 * 4 * 1 * 1 * 4));
		
		assertThat(combos.getList(), hasItems("240386610M"));
		assertThat(combos.getList(), hasItems("240386610N"));
		assertThat(combos.getList(), hasItems("240386610O"));
		assertThat(combos.getList(), not(hasItems("240386610A")));
		assertThat(combos.getList(), not(hasItems("240386610Z")));	
	}
	
	/**
	 *  On a standard alpha-numeric telephone keypad, the digit 7 has all of four letters associated with it.
	 */
	@Test
	public void tenDigitsWithAll7s() {
		Combos combos = new Combos("7777777777");
		
		assertThat(combos.getCount(), equalTo(new BigInteger("5").pow(10).intValue()));
	}
	
	/**
	 *  On a standard alpha-numeric telephone keypad, the digit 9 has all of four letters associated with it.
	 */
	@Test
	public void tenDigitsWithAll9s() {
		Combos combos = new Combos("9999999999");
		
		assertThat(combos.getCount(), equalTo(new BigInteger("5").pow(10).intValue()));
	}
	
	//
	
	/**
	 *  On a standard alpha-numeric telephone keypad, the digit 1 does not have corresponding letters associated with it.
	 */
	@Test
	public void veryBasicCount7Digits() {
		Combos combos = new Combos("1111111111");
		
		assertThat(combos.getCount(), equalTo(1));
	}
	
	@Test
	public void basicCount7Digits() {
		Combos combos = new Combos("2406106");
		
		assertThat(combos.getCount(), equalTo(4 * 4 * 1 * 4 * 1 * 1 * 4));
	}
	
	/**
	 *  On a standard alpha-numeric telephone keypad, the digit 7 has all of four letters associated with it.
	 */
	@Test
	public void sevenDigitsWithAll7s() {
		Combos combos = new Combos("7777777");
		
		assertThat(combos.getCount(), equalTo(new BigInteger("5").pow(7).intValue()));
	}
	
	/**
	 *  On a standard alpha-numeric telephone keypad, the digit 9 has all of four letters associated with it.
	 */
	@Test
	public void sevenDigitsWithAll9s() {
		Combos combos = new Combos("9999999");
		
		assertThat(combos.getCount(), equalTo(new BigInteger("5").pow(7).intValue()));
	}
}