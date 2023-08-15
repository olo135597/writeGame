package writeGame;

import writeGame.controller;
import java.util.Scanner;

public class gameMaker {
    public String turn;
    public String userName;

    public int distance;
    controller control = new controller();
    public enemy Goblin = new enemy();
    public player Link = new player();
    private String name;

    public gameMaker() {

    }

    public void desic() {
        control.decisionPhase(Link, Goblin);
    }

    public void makeCharacters() {

        Link.setName(userName);
        Link.setHealth(100);
        Link.setSpeed(20);
        Link.setRange(3);
        Link.setAttack(3);
        Link.setDefense(2);

        Goblin.setName("Bokoblin");
        Goblin.setHealth(30);
        Goblin.setSpeed(16);
        Goblin.setTribes("The tribe of the great Plateau");
        Goblin.setRange(1);
        Goblin.setAttack(4);
        Goblin.setDefense(1);

    }

    public void showStatsLink() {
        System.out.println("Your name: " + Link.getName());
        System.out.println("Your health: " + Link.getHealth());
        System.out.println("Your speed: " + Link.getSpeed());
        System.out.println("Your range: " + Link.getRange());

    }

    public void showStatsBokoblin() {
        System.out.println("Name: " + Goblin.getName());
        System.out.println("Health: " + Goblin.getHealth());
        System.out.println("Speed: " + Goblin.getSpeed());
        System.out.println("Tribe: " + Goblin.getTribes());
        System.out.println("Your range: " + Goblin.getRange());

    }

    public void introduction() {
        System.out.println(
                "In this programm you will play a short d&d story. You are a Swordsman trying to arrive at the main city of clover. But be careful, the land is full of monsters.");
    }

    public void start() {

        System.out.println("Bitte geben sie ihren Namen ein: ");

        userName = control.ReadLine();

        System.out.println(userName + ", du wirst dich jetzt ein Abenteuer stellen.");
        makeCharacters();
        System.out.println("Du bist ein Schwertkämpfer. Dies sind deine Stats:");
        showStatsLink();

        System.out.print(
                "Du willst zu Hyrule, die Region des Lebens und der Freude. Jedoch gibt bist du in einem Wald gelandet"
                        + " und du weisst nicht mehr wo du bist, aber du gibst nicht auf und suchst eine Person die dir den Weg zeigen kann. Aber was ist das! ");
        System.out.println("Enter drücken: ");
        Scanner myObj2 = new Scanner(System.in);
        String enter = myObj2.nextLine();
        System.out.println("Ein Bokoblin ist aufgetaucht!");
        System.out.println("Bokoblins sind Monster die machen was sie wollen. Sie sind klein laut und nervig");
        System.out.println(
                "Der Bokoblin shaut dich an und zuckt sein Kopf, er sieht dein Schwert und will es haben, es geht in Kampfposition");
        System.out.println("Stats vom Bokoblin: ");
        turn = control.ReadLine();
        showStatsBokoblin();

        System.out.println("Er ist in einer Distanz von 3");
        distance = 3;
        turn = control.ReadLine();
        control.battleSystem(Link, Goblin, distance);

    }

}
