package by.teachmeskills.robot.legs;

public class ToshibaLeg implements ILeg{
	
	private int price;
	
	public ToshibaLeg() {
		
	}
	
	public ToshibaLeg(int price) {
		this.price = price;
	}

	public void step() {
		System.out.println("Toshiba stepped");
		
	}

	public int getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

}
