package com.psu.bowmanagrawal.speakyourownadventure;

import android.widget.Switch;

/**
 * Created by caseybowman on 11/28/15.
 */
public class SentenceGenerator {

    public static String genIntroduction(Scene scene) {
        String returnStr = "";
        Location location = scene.getLocation();
        Enemy enemy = scene.getEnemy();
        int randNum = Randomizer.getNum(0,1);
        switch (randNum) {
            case 0:
                returnStr = "You find yourself " + location.getPreposition() + location.getRandAdjective() + location.getName() + ".";
                break;
            case 1:
                returnStr = "You find yourself " + location.getPreposition() + location.getRandAdjective() + location.getName() + ".";
                break;
        }

        // Creating the setting
        if(location.getName().equals("woods")) {
            returnStr += " Looking around, you see trees in every direction. Unfortunately, you can't see very far due to the dense " +
                         "fog that reduces your sight to around twenty meters in front of yourself.";

        } else if(location.getName().equals("jungle")) {
            returnStr += " You immediately feel the mugginess and heat of the surroundings and start to break out in a sweat.";

        } else if(location.getName().equals("volcano")) {
            returnStr += " The smell of sulfur and smoke fills the air. It is hard for you to breathe, but you somehow manage " +
                         "to fill your lungs with just enough oxygen to keep yourself from passing out.";

        } else if(location.getName().equals("lake")) {
            returnStr += " Clear, greenish-blue water fills the lake, giving off a serene feeling. It's peaceful and quiet here. Too quiet.";

        } else if(location.getName().equals("beach")) {
            returnStr += " You can feel the soft sand under your feet and smell the salt in the air. You hear waves from the ocean " +
                         "crashing upon the shoreline.";

        } else if(location.getName().equals("plains")) {
            returnStr += " High grass that extends beyond your waist tickles your hands and arms as you wade through the seemingly endless " +
                         "sea of green.";

        } else if(location.getName().equals("castle")) {
            returnStr += " Darkness surrounds you, with the only sources of light coming from the dimly lit candles on the walls.";

        }

        // Introducing an enemy
        randNum = Randomizer.getNum(0,3);
        switch (randNum) {
            case 0:
                returnStr += " In front of you, you see a " + enemy.getName() + ".";
                break;
            case 1:
                returnStr += " Not too far off from where you are, you see a " + enemy.getName() + ".";
                break;
            case 2:
                returnStr += " In the distance, you see a " + enemy.getName() + ".";
                break;
            case 3:
                returnStr += " Behind you, you hear a noise, only to turn around to see a " + enemy.getName() + ".";
                break;
        }

        returnStr += " What do you do?";
        return returnStr;
    }

    public String genSentences(Scene scene) {
        String returnStr = "";
        String enemy = scene.getEnemy().getName();
        String action = scene.getAction();
        String input = scene.getInput();

        returnStr += "You decided to ";

        switch(enemy) {
            case "rock":
                switch (action){
                    case "fight":
                        returnStr += action + " the rock, which wasn't the brightest of ideas because " +
                                     "you end up hurting yourself in the process.";
                        break;
                    case "talk":
                        returnStr += action + " to the rock. This resulted in you looking like a crazy " +
                                     "person interacting with a rock. Congratulations.";
                        break;
                    case "run":
                        returnStr += action + " away from the rock.";
                        break;
                    case "garbage":
                        returnStr += ". I'm not sure what " + action + " would do, but it seemed to have " +
                                     " a profound effect on the rock because the rock just exploded.";
                        break;
                }
                break;
            case "bear":
                switch (action){
                    case "fight":

                        break;
                    case "talk":

                        break;
                    case "run":

                        break;
                    case "garbage":

                        break;
                }
            case "squirrel":
                switch (action){
                    case "fight":

                        break;
                    case "talk":

                        break;
                    case "run":

                        break;
                    case "garbage":

                        break;
                }
            case "clown":
                switch (action){
                    case "fight":

                        break;
                    case "talk":

                        break;
                    case "run":

                        break;
                    case "garbage":

                        break;
                }
            case "swordsman":
                switch (action){
                    case "fight":

                        break;
                    case "talk":

                        break;
                    case "run":

                        break;
                    case "garbage":

                        break;
                }
            case "wall":
                switch (action){
                    case "fight":

                        break;
                    case "talk":

                        break;
                    case "run":

                        break;
                    case "garbage":

                        break;
                }
            case "puppy":
                switch (action){
                    case "fight":

                        break;
                    case "talk":

                        break;
                    case "run":

                        break;
                    case "garbage":

                        break;
                }
        }

        return returnStr;
    }

    public String genEnd(Story story) {
        String returnStr = "After defeating";
        int obstacleListLen = story.getObstacleListLen();

        if(obstacleListLen < 2) {
            returnStr += " a " + story.getObstacle(0);
        } else if(obstacleListLen < 3) {
            returnStr += " a " + story.getObstacle(0) + " and a " + story.getObstacle(1);
        } else {
            returnStr += " a ";
            for(int i=0; i<obstacleListLen-1; i++) {
                returnStr += story.getObstacle(i) + ", ";
            }
            returnStr += "and a " + story.getObstacle(obstacleListLen-1);
        }

        returnStr += ", you encounter a bright light, which takes you home.";

        returnStr += "THE END";

        return returnStr;
    }
    /*
    if(location.getName().equals("woods")) {
            returnStr += " Looking around, you see a ";

        } else if(location.getName().equals("jungle")) {


        } else if(location.getName().equals("volcano")) {


        } else if(location.getName().equals("lake")) {


        } else if(location.getName().equals("beach")) {


        } else if(location.getName().equals("plains")) {


        } else if(location.getName().equals("castle")) {


        }
     */

}
