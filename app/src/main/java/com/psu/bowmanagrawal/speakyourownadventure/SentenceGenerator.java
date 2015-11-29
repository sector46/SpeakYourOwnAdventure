package com.psu.bowmanagrawal.speakyourownadventure;

/**
 * Created by caseybowman on 11/28/15.
 */
public class SentenceGenerator {

    public static String genIntroduction(Location location) {
        String returnStr = "";
        int randNum = Randomizer.getNum(0,1);
        switch (randNum) {
            case 0:
                returnStr = "You find yourself " + location.getPreposition() + location.getRandAdjective() + " " + location.getName() + ".";
            case 1:
                returnStr = "You find yourself " + location.getPreposition() + location.getRandAdjective() + " " + location.getName() + ".";
            default:

        }
        returnStr += " What do you do?";
        return returnStr;
    }
}
