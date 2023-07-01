package writeGame;
import java.util.Scanner;
public class main {
    public static void main(String[] args) 
    { 
        controller controll = new controller();
        gameMaker Maker = new gameMaker();
        
        Maker.start();
        
        
       controll.game();

    
    }
}
