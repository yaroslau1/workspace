package by.teachmeskills.robot.legs;

public class SumsungLeg implements ILeg{
	
	private int price;
	
	public SumsungLeg() {
		
	}
	
	public SumsungLeg(int price) {
		this.price = price;
	}

	public void step() {
		System.out.println("Sumsung stepped!");
		
	}

	public int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

}
