package rot13;
// Write a program to encrypt a message using the ROT13 technique.
public class ROT13 {
public static void main(String[]args) {
	rotate("adam");//nqnz
	rotate("A");
	rotate("z");
	rotate("? ");
	rotate("");
}
public static void rotate(String message) {
	System.out.println("original message: " + message);
	String newMessage = "";
	for (int x = 0; x < message.length(); x++) {
		char c = message.charAt(x);
		int a = c;
		if (!(a >= 65 && 90 >= a) && !(a >= 97 && 122 >= a)) {
			newMessage += (char)a;
			continue;
		}
		a += 13;
		System.out.println(a);
		if ((a >= 65 && 90 >= a) || (a >= 97 && 122 >= a)) {
		newMessage += (char)a;
		}
		else {
			a-=26;
			newMessage += (char)a;
		}
	}
	System.out.println("new message: " + newMessage);
}
}
