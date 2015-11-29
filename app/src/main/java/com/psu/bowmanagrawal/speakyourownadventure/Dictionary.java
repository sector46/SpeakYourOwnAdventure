package com.psu.bowmanagrawal.speakyourownadventure;

/**
 * Created by caseybowman on 11/28/15.
 */
public class Dictionary {
    private static String [] FIGHT = {
            "fight",
            "punch",
            "kick",
            "spit",
            "scratch",
            "swat"};

    private static String [] TALK = {
            "talk",
            "shout",
            "whisper",
            "gesture",
            "moan",
            "cry",
            "laugh"};

    private static String [] RUN = {
            "run",
            "walk",
            "climb",
            "jump",
            "crawl",
            "swim",
            "swing"};

    /*
    * 0 is an empty string or ""
    * 1-3 matches one of the three major types of verb usage
    * 4 matches everything else, also known as garbage
     */
    public static int whichActionType(String userInput) {
        if (userInput.equals("")) {
            return 0;
        }
        for (String word : FIGHT) {
            if (userInput.equals(word)) {
                return 1;
            }
        }
        for (String word : TALK) {
            if (userInput.equals(word)) {
                return 2;
            }
        }
        for (String word : RUN) {
            if (userInput.equals(word)) {
                return 3;
            }
        }
        return 4;
    }
}
