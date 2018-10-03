package by.teachmeskills.robot.legs;

public class SonyLeg implements ILeg {
	
	private int price;
	
	public SonyLeg() {
		
	}
	
	public SonyLeg(int price) {
		this.price = price;
	}

	public void step() {
		System.out.println("Sony stepped!");
		
	}

	public int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

}
