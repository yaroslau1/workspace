package by.teachmeskills.robot;

import by.teachmeskills.robot.hands.SonyHand;
import by.teachmeskills.robot.hands.SumsungHand;
import by.teachmeskills.robot.hands.ToshibaHead;
import by.teachmeskills.robot.heads.SonyHead;
import by.teachmeskills.robot.heads.SumsungHead;
import by.teachmeskills.robot.legs.SonyLeg;
import by.teachmeskills.robot.legs.SumsungLeg;
import by.teachmeskills.robot.legs.ToshibaLeg;

public class Run {
    public static void main(String[] args) {
        /*
        Создать по 3 реализации(Sony, Toshiba, Samsung) каждой запчасти(IHead, IHand, ILeg)
        Класс SonyHead является примером реализацией головы от Sony.
        Создайте 3 робота с разными комплектующими.
        Например у робота голова и нога от Sony а, рука от Samsung.
        У всех роботов вызовите метод action.
        Среди 3-х роботов найдите самого дорогого.
        */
    	SonyHead sonyHead = new SonyHead(100);
    	SumsungHead sumsungHead = new SumsungHead(120);
    	ToshibaHead toshibaHead = new ToshibaHead(80);
    	
    	SonyHand sonyHand = new SonyHand(50);
    	SumsungHand sumsungHand = new SumsungHand(40);
    	ToshibaHead toshibaHand = new ToshibaHead(60);
    	
    	SonyLeg sonyLeg = new SonyLeg(20);
    	SumsungLeg sumsungLeg = new SumsungLeg(40);
    	ToshibaLeg toshibaLeg = new ToshibaLeg(50);
    	
    	Robot roboChaki = new Robot(sonyHead, toshibaHand, sumsungLeg);
    	roboChaki.action();
    	System.out.println(roboChaki.getPrice());
    	System.out.println(roboChaki.getHand());


    }
}
