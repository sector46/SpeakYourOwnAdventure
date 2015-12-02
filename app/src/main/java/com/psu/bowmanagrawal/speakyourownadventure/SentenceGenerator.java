package com.psu.bowmanagrawal.speakyourownadventure;

import android.widget.Switch;

/**
 * Created by caseybowman on 11/28/15.
 */
public class SentenceGenerator {

    public static String genIntroduction(Story story, Scene scene, boolean isIntro) {
        scene.genNewScene(story);
        String returnStr = "";
        Location location = scene.getLocation();
        Enemy enemy = scene.getEnemy();
        int randNum;

        if(isIntro){
            returnStr += "You find yourself " + location.getPreposition() + location.getRandAdjective() + location.getName() + ".";
        } else {
            returnStr += "A bright, white light shines down upon you. You realize you are " + location.getPreposition() +
                         location.getRandAdjective() + location.getName() + ".";
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

    public static String genSentences(Story story, Scene scene) {
        String returnStr = "";
        String enemy = scene.getEnemy().getName();
        String action = scene.getAction();
        String input = scene.getInput();

        returnStr += "";

        switch(enemy) {
            case "rock":
                switch (action){
                    case "fight":
                        returnStr += "You decided to " + input + " the rock, which wasn't the brightest of ideas because " +
                                     "you end up hurting yourself in the process. You could try a different method of approaching " +
                                     "the rock, but why not continue doing what you're doing? I mean, you've come this far, why not " +
                                     "finish what you started? ";
                        break;
                    case "talk":
                        returnStr += "You decided to " + input + " to the rock. This resulted in you looking like a crazy " +
                                     "person interacting with a rock. Congratulations. Are you hoping to accomplish something " +
                                     "by befriending a rock?";
                        break;
                    case "run":
                        returnStr += "You decided to " + input + " away from the rock. It's not like you needed to get involved with " +
                                     "the rock anyway. ";
                        if(story.getObstacleListLen() < story.getMaxObstaclesPassed()) {
                            story.setOver();
                            returnStr += SentenceGenerator.genEnd(story);
                        } else {
                            scene.genNewScene(story);
                        }

                        break;
                    case "garbage":
                        returnStr += ". I'm not sure what " + input + " would do, but it seemed to have " +
                                     " a profound effect on the rock because the rock just exploded. ";
                        break;
                }
                break;
            case "bear":
                switch (action){
                    case "fight":
                        returnStr += "You decided to " + input + " the bear. Its eyes grew wide and swelled as tears burst from ." +
                                     "the bear's face. How could you do that to such a gentle creature? Are you proud of yourself? " +
                                     "With your embarrassingly bad etiquette for greetings established, you must come to a decision " +
                                     "about what to do with the crying bear. ";
                        break;
                    case "talk":
                        returnStr += "";
                        break;
                    case "run":
                        returnStr += "You decided to " + input + "away from the bear. ";
                        break;
                    case "garbage":
                        returnStr += "You decided to " + input + " at the bear. It showed its appreciation of your action by " +
                                     "slightly trying to murder you. ";
                        break;
                }
                break;
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
                break;
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
                break;
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
                break;
            case "wall":
                switch (action){
                    case "fight":
                        returnStr += "Trying to " + input + " a wall? But why? the wall just retaliates by using " +
                                     "Issac Newton's third law of motion: for every action, there is an equal and " +
                                     "opposite reaction. Hopefully you learn to not attack every wall you meet in " +
                                     "the future. For now, the wall is still there and you have a decision to make. ";
                        break;
                    case "talk":

                        break;
                    case "run":

                        break;
                    case "garbage":

                        break;
                }
                break;
            case "puppy":
                switch (action){
                    case "fight":
                        returnStr += "As you move closer to " + input + " the puppy, its adorable face curls into one " +
                                     "of the most horrifying snarls you've ever seen. Seriously, this puppy has anger issues. ";
                        break;
                    case "talk":

                        break;
                    case "run":

                        break;
                    case "garbage":

                        break;
                }
                break;
        }

        if(story.isStillGoing()) {
            returnStr += "What do you do?";
        }

        return returnStr;
    }

    public static String genEnd(Story story) {
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

        returnStr += ", you encounter a bright light, which takes you home. ";

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
