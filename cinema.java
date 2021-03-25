import java.util.ArrayList;
import java.util.Scanner; 
import java.util.List;

public class cinema{
	static int board_size = 10;
	static List board = new ArrayList();
	static int price = 10;
	static boolean status = true;
	static String password = "ewrtygf";
	static void create_board() {
		for(int i = 0; i < board_size; i ++ )
		{
			List myList = new ArrayList();
			for(int j = 0; j < board_size + 1; j ++ ) {
				myList.add("E");
			}
			board.add(myList);
		}
	}
	public static void main(String[] args){
		create_board();
		System.out.println("Price per ticket is: " + Integer.toString(price));
		cinema x = new cinema();
		while (true) {
			Scanner choice = new Scanner(System.in);
			System.out.println("1: See ticket availability");
			System.out.println("2: Buy ticket");
			System.out.println("3: refund service");
			System.out.println("4: Quit");
			System.out.print("Please choose service type: ");
			int choice2 = choice.nextInt();
			if(choice2 == 1) {
				display();
				}
			else if(choice2 == 2) {
				x.buy_tickets();
				display();
				}
			else if(choice2 == 3) {
				x.refund_tickets();
				display();
				}
			else if(choice2 == 4) {
				System.out.println("Service ended");
				break;
				}
			else if(choice2 == 5);{
				Scanner y = new Scanner(System.in);
				System.out.print("Please enter admin password: ");
				String y2 = y.nextLine();
				if(y2.equals(password));{
					while(true){
						Scanner choice3 = new Scanner(System.in);
						System.out.println("1: Change price");
						System.out.println("2: Check price");
						System.out.println("3: Quit");
						System.out.print("Please choose service type: ");
						int choice4 = choice3.nextInt();
						if(choice4 == 3) {
							System.out.print("service ended");
							break;
							}
						else if(choice4 == 1) {
							Scanner new_price = new Scanner(System.in);
							System.out.println("New price: ");
							int new_price2 = new_price.nextInt();
							cinema x2 = new cinema();
							x2.change_price(new_price2);
							}
						else if(choice4 == 2) {
							System.out.println(price);
							}
						}
					}
				}
			}
		}
	static void display() {
		List temp = new ArrayList();
		String str = new String();
		System.out.println("| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |10 |");
		str += "|";
		for(int i = 0; i < board_size; i ++) {
			if(i != 9) {
				str += " ";
				str += Integer.toString(i + 1);
				str += " |";
			}
			else {
				str += "";
				str += Integer.toString(i + 1);
				str += " |";
			}
			for(int j = 0; j < board_size; j ++) {
				str += " ";
				temp = (List) board.get(i);
				str += temp.get(j);
				str += " |";
				}
			System.out.println(str);
			str = "|";
			}
	}
	public void update_board(int argu, int argu2) {
		List temp = new ArrayList();
		String temp2 = new String();
		outerloop:
		for(int i = 0; i < board_size; i ++) {
			for(int j = 0; j < board_size; j ++) {
				temp = (List) board.get(i);
				temp2 = (String) temp.get(j);
				
				if(i == argu && j == argu2 && temp2.equals("E")) {
					temp.set(j, "B");
					board.set(i, temp);
					System.out.println("Booking successful successful");
					status = true;
					break outerloop;
					}
				else if(temp2.equals("E") == false) {
					System.out.println("Place is already booked");
					status = false;
					break outerloop;
				}
			}
		}
	}
	public void buy_tickets() {
		cinema x = new cinema();
		Scanner no = new Scanner(System.in);
		System.out.println("please choose number of tickets");
		int no2 = no.nextInt() - 1;
		for(int i = 0; i != no2 + 1; i ++) {
			Scanner horizontal = new Scanner(System.in);
			System.out.println("please choose your row for ticket " + Integer.toString(i + 1));
			int horizontal2 = horizontal.nextInt() - 1;
			Scanner vertical = new Scanner(System.in);
			System.out.println("please choose your column for ticket " + Integer.toString(i + 1));
			int vertical2 = vertical.nextInt() - 1;
			x.update_board(vertical2, horizontal2);
			}
		if(status) {
			x.reciept(true, no2 + 1);
		}
	}
	public void update_board2(int argu, int argu2) {
		List temp = new ArrayList();
		String temp2 = new String();
		outerloop:
		for(int i = 0; i < board_size; i ++) {
			for(int j = 0; j < board_size; j ++) {
				temp = (List) board.get(i);
				temp2 = (String) temp.get(j);
				if(i == argu && j == argu2 && temp2.equals("B")) {
					temp.set(j, "E");
					board.set(i, temp);
					System.out.println("Refund successful");
					status = true;
					break outerloop;
					}
				else if(temp2.equals("B") == false) {
					System.out.println("Place is not booked");
					status = false;
					break outerloop;
				}
			}
		}
	}
	public void refund_tickets() {
		cinema x = new cinema();
		Scanner no = new Scanner(System.in);
		System.out.println("please choose number of tickets to refund");
		int no2 = no.nextInt() - 1;
		for(int i = 0; i != no2 + 1; i ++) {
			Scanner horizontal = new Scanner(System.in);
			System.out.println("please choose your row for refund ticket " + Integer.toString(i + 1));
			int horizontal2 = horizontal.nextInt() - 1;
			Scanner vertical = new Scanner(System.in);
			System.out.println("please choose your column for refund ticket " + Integer.toString(i + 1));
			int vertical2 = vertical.nextInt() - 1;
			x.update_board2(vertical2, horizontal2);
			}
		if(status) {
			x.reciept(false, no2 + 1);
		}
	}
	public void reciept(boolean argu, int number) {
		if(argu) {
			System.out.println(price);
			System.out.println(number);
			System.out.println("| tickets | price | total |");
			final int ticketlength = 9; 
			final int pricelength = 7;
			final int totallength = 7;
			String str1 = " ";
			String str2 = " ";
			String str3 = " ";
			if(Integer.toString(number).length() < ticketlength);{
				int number_missing = ticketlength - Integer.toString(number).length();
				str1 = " ".repeat(number_missing) + number;
			}
			if(Integer.toString(number*price).length() < pricelength);{
				int number_missing = pricelength - Integer.toString(number*price).length();
				str2 = " ".repeat(number_missing) + number*price;
			}
			if(Integer.toString((int) (number*price*1.07)).length() < totallength);{
				int number_missing = totallength - Integer.toString((int) (number*price*1.07)).length();
				int temp = number*price;
				int temp2 = (int) (temp*1.07);
				str3 = " ".repeat(number_missing) + (Integer.toString(temp2));
			}
			System.out.println("|" + str1 + "|" + str2 + "|" + str3 + "|");
		}	
		if(!argu) {
			System.out.println(price);
			System.out.println(number);
			System.out.println("| tickets | price | total |");
			final int ticketlength = 9; 
			final int pricelength = 7;
			final int totallength = 7;
			String str1 = " ";
			String str2 = " ";
			String str3 = " ";
			if(Integer.toString(number).length() < ticketlength);{
				int number_missing = ticketlength - Integer.toString(number).length();
				str1 = " ".repeat(number_missing) + number;
			}
			if(Integer.toString(number*price).length() < pricelength);{
				int number_missing = pricelength - Integer.toString(number*price).length();
				str2 = " ".repeat(number_missing) + number*price;
			}
			if(Integer.toString((int) (number*price*1.07)).length() < totallength);{
				int number_missing = totallength - Integer.toString((int) (number*price*1.07)).length();
				str3 = " ".repeat(number_missing) + (Integer.toString((int) (number*price*1.07)));
			}
			System.out.println("|" + str1 + "|" + str2 + "|" + str3 + "|");
		}
	}
	public void change_price(int new_price) {
		price = new_price;
		System.out.println("new price is: " + Integer.toString(price));
	}
}