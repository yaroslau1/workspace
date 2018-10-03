package by.teachmeskills.robot.heads;

public class ToshibaHead implements IHead {

	private int price;

	public ToshibaHead() {

	}
	
	public ToshibaHead(int price) {
		this.price = price;
	}

	public void speek() {
		System.out.println("Hello from Toshiba");

	}

	public int getPrice() {
		return price;
	}

}
