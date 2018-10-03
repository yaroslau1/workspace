package by.teachmeskills.robot.heads;

public class SonyHead implements IHead {
    private int price;

    public SonyHead(int price) {
        this.price = price;
    }

    public SonyHead() {
    }

 
    public void speek() {
        System.out.println("Hello from Sony");
    }


    public int getPrice() {
        return price;
    }
}
