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
            "swat",
            "smash",
            "crush",
            "backhand",
            "bite",
            "hit",
            "tackle",
            "assault",
            "struggle"
    };

    private static String [] TALK = {
            "talk",
            "shout",
            "whisper",
            "gesture",
            "moan",
            "cry",
            "laugh",
            "gossip",
            "gloat",
            "communicate",
            "argue",
            "lecture",
            "persuade",
            "chat"
    };

    private static String [] RUN = {
            "run",
            "walk",
            "climb",
            "jump",
            "crawl",
            "swim",
            "swing",
            "sprint",
            "escape",
            "slide",
            "gallop",
            "skip",
            "stroll",
            "saunter",
            "dash",
            "charge",
            "march"
    };

    /*
    * 0 is an empty string or ""
    * 1-3 matches one of the three major types of verb usage
    * 4 matches everything else, also known as garbage
     */
    public static String whichActionType(String userInput) {
        if (userInput.equals("")) {
            return "Null";
        }
        for (String word : FIGHT) {
            if (userInput.equals(word)) {
                return "fight";
            }
        }
        for (String word : TALK) {
            if (userInput.equals(word)) {
                return "talk";
            }
        }
        for (String word : RUN) {
            if (userInput.equals(word)) {
                return "run";
            }
        }
        return "garbage";
    }
}
