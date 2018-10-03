package by.teachmeskills.robot.heads;

public class SumsungHead implements IHead {

	private int price;

	public SumsungHead () {

	}

	public SumsungHead (int price) {
		this.price = price;
	}

	public void speek() {
		System.out.println("Hello from Sumsung!");

	}

	public int getPrice() {

		return price;
	}

}
