package com.psu.bowmanagrawal.speakyourownadventure;

/**
 * Created by caseybowman on 11/29/15.
 */
public class Enemy {
    private String name;
    private String [] adjectives;
    private int healthPoints;
    private boolean passed;
    private boolean canFight;
    private boolean canTalk;
    private boolean canRun;
    private boolean canGarbage;

    public Enemy(String name, String [] adjectives, int healthPoints, boolean canFight, boolean canTalk, boolean canRun, boolean canGarbage) {
        this.name = name;
        this.adjectives = adjectives;
        this.healthPoints = healthPoints;
        this.canFight = canFight;
        this.canTalk = canTalk;
        this.canRun = canRun;
        this.canGarbage = canGarbage;
        this.passed = false;
    }

    public static Enemy getRandEnemy() {
        int randomNum = Randomizer.getNum(0,6);
        String [] adjectives;
        Enemy enemy;
        switch(randomNum) {
            case 0:
                adjectives = new String [] {"dense", "", "", ""};
                enemy = new Enemy("rock", adjectives, 1, false, false, true, true);
                return enemy;
            case 1:
                adjectives = new String [] {"thick", "hot", "swampy", "hostile"};
                enemy = new Enemy("bear", adjectives, 2, true, true, false, true);
                return enemy;
            case 2:
                adjectives = new String [] {"hot", "smoking", "", ""};
                enemy = new Enemy("squirrel", adjectives, 1, true, true, true, true);
                return enemy;
            case 3:
                adjectives = new String [] {"clear", "", "", ""};
                enemy = new Enemy("clown", adjectives, 3, true, true, false, true);
                return enemy;
            case 4:
                adjectives = new String [] {"", "", "", ""};
                enemy = new Enemy("swordsman", adjectives, 1, false, true, false, false);
                return enemy;
            case 5:
                adjectives = new String [] {"wide", "open", "windy", "spacious"};
                enemy = new Enemy("wall", adjectives, 1, false, false, true, true);
                return enemy;
            case 6:
                adjectives = new String [] {"dark", "damp", "creepy", "old"};
                enemy = new Enemy("puppy", adjectives, 3, false, true, true, true);
                return enemy;
            default:
                return null;
        }
    }

    public String getName() {
        return name;
    }

    public String getRandAdjective() {
        int randNum = Randomizer.getNum(0,adjectives.length-1);
        return adjectives[randNum];
    }

    public boolean canFight() {
        return this.canFight;
    }

    public boolean isCanTalk() {
        return this.canTalk;
    }

    public boolean isCanRun() {
        return this.canRun;
    }

    public boolean canGarbage() {
        return this.canGarbage;
    }

    public boolean isPassed() {
        return this.passed;
    }

    public int getHP() {
        return this.healthPoints;
    }

    public void decrementHP() {
        this.healthPoints -= 1;
        if (this.healthPoints < 1) {
            this.passed = true;
        }
    }

    public void setPassed() {
        this.passed = true;
    }
}
