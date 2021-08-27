package creditCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreditCard {
	public static void main(String[] args) {
		System.out.println("Enter a number: ");
		Scanner scan = new Scanner(System.in);
		try {
			credit(scan.nextLong());
		}catch(Exception e)
		{
			System.out.println("Wrong number");
		}
	}

	/**
	 * 
	 * @param cNumber
	 * @return
	 * 
	 *  this method takes a number as an argument and returns true if the number 
	 *  is a valid credit card number
	 */
	public static String credit(Long cNumber) {
		String result = "The number sequence is invalid";
		if (cNumber.toString().length() >= 14 && cNumber.toString().length() <= 19) {
			System.out.println("The credit card number is: " + cNumber);
			long checkDigit = cNumber % 10;
			cNumber /= 10;
			if ((toArray(cNumber) % 10) == checkDigit)
				result = "This credit card is valid!";
			System.out.println("The check digit is: " + checkDigit);
			System.out.println("The sum is: " + toArray(cNumber));
			System.out.println("The sum digit is: " + toArray(cNumber) % 10);
			System.out.println(result);
			return result;
		}
		else
			System.out.println("Invalid input: " + cNumber);
			return result;
	}
	/**
	 * 
	 * @param cNumber
	 * @return
	 * 
	 *  this method takes a number as an argument and returns the sum of the credit card number sequence
	 *  after turning the argument into a reversed array
	 */
	public static long toArray(long cnumber) {
		List<Long> creditCard = new ArrayList<>();
		while (true) {
			if (cnumber == 0)
				break;
			creditCard.add(cnumber % 10);
			cnumber /= 10;
		}
		cnumber = doubling(creditCard);
		return cnumber;
	}
	/**
	 * 
	 * @param cNumber
	 * @return
	 * 
	 *  this method takes a Long ArrayList as an argument and returns the sum of the credit card number sequence
	 *  after doubling odd numbered indexes
	 */
	public static int doubling(List<Long> credit) {
		int total = 0;
		int y = 0;
		for (int x = 0; x < credit.size(); x += 2) {
			if ((credit.get(x) * 2) >=10) {
				long one = credit.get(x) * 2;
				long two = one % 10;
				one = (one / 10) + two;
				credit.set(x, one);
			}
			else
				credit.set(x, credit.get(x) * 2);
		}
		for (Long x : credit) {
			total += credit.get(y);
			y++;
		}
		return total;
	}

}
