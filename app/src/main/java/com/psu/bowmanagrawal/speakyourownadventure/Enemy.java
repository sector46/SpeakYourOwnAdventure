package com.psu.bowmanagrawal.speakyourownadventure;

/**
 * Created by caseybowman on 11/29/15.
 */
public class Enemy {
    private String name;
    private String [] adjectives;
    private boolean canFight;
    private boolean canTalk;
    private boolean canRun;
    private boolean canGarbage;

    public Enemy(String name, String [] adjectives, boolean canFight, boolean canTalk, boolean canRun, boolean canGarbage) {
        this.name = name;
        this.adjectives = adjectives;
        this.canFight = canFight;
        this.canTalk = canTalk;
        this.canRun = canRun;
        this.canGarbage = canGarbage;
    }

    public Enemy getEnemy() {
        int randomNum = Randomizer.getNum(0,6);
        String [] adjectives;
        Enemy enemy;
        switch(randomNum) {
            case 0:
                adjectives = new String [] {"dense", "", "", ""};
                enemy = new Enemy("rock", adjectives, false, false, true, true);
                return enemy;
            case 1:
                adjectives = new String [] {"thick", "hot", "swampy", "hostile"};
                enemy = new Enemy("bear", adjectives, true, true, false, true);
                return enemy;
            case 2:
                adjectives = new String [] {"hot", "smoking", "", ""};
                enemy = new Enemy("squirrel", adjectives, true, true, true, true);
                return enemy;
            case 3:
                adjectives = new String [] {"clear", "", "", ""};
                enemy = new Enemy("clown", adjectives, true, true, false, true);
                return enemy;
            case 4:
                adjectives = new String [] {"", "", "", ""};
                enemy = new Enemy("swordsman", adjectives, false, true, false, false);
                return enemy;
            case 5:
                adjectives = new String [] {"wide", "open", "windy", "spacious"};
                enemy = new Enemy("wall", adjectives, false, false, true, true);
                return enemy;
            case 6:
                adjectives = new String [] {"dark", "damp", "creepy", "old"};
                enemy = new Enemy("puppy", adjectives, true, true, true, true);
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
}
