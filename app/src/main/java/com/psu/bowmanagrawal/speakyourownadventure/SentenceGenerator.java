package com.psu.bowmanagrawal.speakyourownadventure;

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
            case 1:
                returnStr = "You find yourself " + location.getPreposition() + location.getRandAdjective() + location.getName() + ".";
            default:

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
            case 1:
                returnStr += " Not too far off from where you are, you see a " + enemy.getName() + ".";
            case 2:
                returnStr += " In the distance, you see a " + enemy.getName() + ".";
            case 3:
                returnStr += " Behind you, you hear a noise, only to turn around to see a " + enemy.getName() + ".";
        }
        
        returnStr += " What do you do?";
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
