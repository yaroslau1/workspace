package by.teachmeskills.robot.hands;

public class SumsungHand implements IHand{
	
	private int price;
	
	public SumsungHand() {
		
	}
	
	public SumsungHand(int price) {
		this.price = price;
	}

	public void upHand() {
		System.out.println("Sumsung hand up");
		
	}

	public int getPrice() {
		
		return price;
	}

}
