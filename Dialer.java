package chat_Bot;

import java.util.ArrayList;
import java.util.Scanner;

public class Dialer {
	Scanner scan = new Scanner(System.in);
	StackClass<Integer> process = new StackClass<>();
	public void display() {
		System.out.println("Select the Language!");
		System.out.println("1. English");
		System.out.println("2. Tamil");
		System.out.println("3. Hindi");
		System.out.println("4. Exit");
		System.out.println("Enter : ");
		int choose = 0;
		try {
			choose = scan.nextInt();
		} catch (Exception e) {
			System.out.println("Invalid input.");
			return;
		}
		int count = 0;
		while (choose < 1 || choose > 4) {
			System.out.println("Invalid.");
			System.out.println(" re-enter : ");
			choose = scan.nextInt();
			count++;
			if (count == 3)
				return;
		}
		
		switch (choose) {
		case 1:
			english();
			menu();
			break;
		case 2:
			tamil();
			menu();
			break;
		case 3:
			hindi();
			menu();
			break;
		case 4:
			thankYou();
			return;
		}
	}

	public void tamil() {
		System.out.println("<*< Vanakkam >*>");
	}

	public void hindi() {
		System.out.println("<**< Namaste >**>");
	}

	public void english() {
		System.out.println("<***< Welcome >***>");
	}

	public void menu() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("0. Back menu");
		System.out.println("1. Recharge details.");
		System.out.println("2. Recharge issues.");
		System.out.println("3. Set callerTune.");
		System.out.println("4. Exit.");
		int choose = 0;
		try {
			choose = scan.nextInt();
		} catch (Exception e) {
			System.out.println("Invalid input.");
			return;
		}
		process.push(choose);
		selections(choose);
	}

	public void selections(int choose) {
		switch (choose) {
		case 0:
			back();
			break;
		case 1:
			rechargeDetails();
			menu();
			break;
		case 2:
			rechargeIssue();
			menu();
			break;
		case 3:
			setCallerTune();
			menu();
			break;
		case 4:
			thankYou();
			return;
		}
	}
	
	public void back() {
		if(process.index < 1)return;
		process.pop();
		selections(process.pop());
	}

	public void rechargeDetails() {
		System.out.println("Topup -100rs - UnLimited Validity");
		System.out.println("Recharge - 149rs - 28days Validity - UnLimited talkTime ");
		System.out.println("Recharge - 99rs - 28days Validity - Caller Tune");
	}

	public void rechargeIssue() {
		System.out.println("Enter the Phone number : ");
		Long phNo = scan.nextLong();
		System.out.println("Booked issue.");
	}

	public void setCallerTune() {
		System.out.println("Enter the movie Name :");
		String movie = scan.nextLine();
		scan.next();
		System.out.println("Enter the Song Name :");
		String song = scan.nextLine();
		scan.next();
	}

	public void thankYou() {
		System.out.println("Thank You.");
	}

	public static void main(String[] args) {
		Dialer customer = new Dialer();
		customer.display();
	}
}
// stack implementation
class StackClass<T> {
	ArrayList<T> stackArray = new ArrayList<>();
	int index = -1;
	
	void push(T add){
		stackArray.add(add);
		index++;
	}
	
	T pop() {
		if(!isEmpty())throw new IllegalStateException();
		return stackArray.get(index--);
	}
	
	T peek() {
		if(!isEmpty())throw new IllegalStateException();
		return stackArray.get(index);
	}
	
	boolean isEmpty() {
		if(index < 0)return false;
		return true;
	}
}
