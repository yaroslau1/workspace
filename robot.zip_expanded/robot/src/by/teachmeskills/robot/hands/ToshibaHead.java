package by.teachmeskills.robot.hands;

public class ToshibaHead implements IHand{
	
	private int price;
	
	public ToshibaHead() {
		
	}
	
	public ToshibaHead(int price) {
		this.price = price;
	}

	public void upHand() {
		System.out.println("Toshiba hand up");
		
	}

	public int getPrice() {
		
		return price;
	}

}
