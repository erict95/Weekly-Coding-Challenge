package octal;

// Write a program to convert a decimal number to its octal equivalent.
public class Octal {
	public static void main(String[] args) {
		convert(1);
		convert(7);
		convert(8);
		convert(63);
		convert(127);
	}

	public static int convert(int input) {
		int count = 0;
		int octal = 0;
		System.out.println("The octal of " + input + " is =");
		while (input / (Math.pow(8, count)) > 7) {
			++count;
		}
		for (; count >= 0; count--) {
			octal = (octal * 10) + (int) (input / Math.pow(8, count));
			input = (int) (input % Math.pow(8, count));
		}
		System.out.println(octal);
		return input;
	}
}
