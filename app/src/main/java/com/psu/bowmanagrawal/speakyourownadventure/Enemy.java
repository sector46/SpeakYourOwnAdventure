package com.psu.bowmanagrawal.speakyourownadventure;

/**
 * Created by caseybowman on 11/29/15.
 */
public class Enemy {
    private String name;
    private String [] adjectives;
    private boolean completed;

    public Enemy(String name) {
        this.name = name;
        this.completed = false;
    }

    public static Enemy getRandEnemy() {
        int randomNum = Randomizer.getNum(0,5);
        Enemy enemy;
        switch(randomNum) {
            case 0:
                enemy = new Enemy("rock");
                return enemy;
            case 1:
                enemy = new Enemy("bear");
                return enemy;
            case 2:
                enemy = new Enemy("squirrel");
                return enemy;
            case 3:
                enemy = new Enemy("clown");
                return enemy;
            case 4:
                enemy = new Enemy("swordsman");
                return enemy;
            case 5:
                enemy = new Enemy("wall");
                return enemy;
/*            case 6:
                adjectives = new String [] {"dark", "damp", "creepy", "old"};
                enemy = new Enemy("puppy", adjectives, 3, false, true, true, true);
                return enemy; */
            default:
                return null;
        }
    }

    public String getName() {
        return name;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public void setCompleted() {
        this.completed = true;
    }
}
