package by.teachmeskills.robot.hands;

public class SonyHand implements IHand{
	
	private int price;
	
	public SonyHand() {
		
	}
	
	public SonyHand(int price) {
		this.price = price;
	}

	public void upHand() {
		System.out.println("Sony hand up");
		
	}

	public int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

}
