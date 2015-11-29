package com.psu.bowmanagrawal.speakyourownadventure;

/**
 * Created by caseybowman on 11/29/15.
 */
public class Location {
    private String name;
    private String [] adjectives;
    private String preposition;

    public Location(String name, String [] adjectives, String preposition) {
        this.name = name;
        this.adjectives = adjectives;
        this.preposition = preposition;
    }

    public static Location getRandLocation() {
        int randomNum = Randomizer.getNum(0,6);
        String [] adjectives;
        String preposition;
        Location location;
        switch(randomNum) {
            case 0:
                adjectives = new String [] {"dense", "", "", ""};
                preposition = "in the ";
                location = new Location("woods", adjectives, preposition);
                return location;
            case 1:
                adjectives = new String [] {"thick", "hot", "swampy", "hostile"};
                preposition = "in a ";
                location = new Location("jungle", adjectives, preposition);
                return location;
            case 2:
                adjectives = new String [] {"hot", "smoking", "", ""};
                preposition = "by a ";
                location = new Location("volcano", adjectives, preposition);
                return location;
            case 3:
                adjectives = new String [] {"clear", "", "", ""};
                preposition = "by a ";
                location = new Location("lake", adjectives, preposition);
                return location;
            case 4:
                adjectives = new String [] {"", "", "", ""};
                preposition = "on a ";
                location = new Location("beach", adjectives, preposition);
                return location;
            case 5:
                adjectives = new String [] {"wide", "open", "windy", "spacious"};
                preposition = "on some ";
                location = new Location("plains", adjectives, preposition);
                return location;
            case 6:
                adjectives = new String [] {"dark", "damp", "creepy", "old"};
                preposition = "in a ";
                location = new Location("castle", adjectives, preposition);
                return location;
            default:
                return null;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getRandAdjective() {
        int randNum = Randomizer.getNum(0,adjectives.length-1);
        return this.adjectives[randNum];
    }

    public String getPreposition() {
        return this.preposition;
    }
}
