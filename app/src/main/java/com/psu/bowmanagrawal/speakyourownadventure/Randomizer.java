package com.psu.bowmanagrawal.speakyourownadventure;

/**
 * Created by caseybowman on 11/29/15.
 */
public class Randomizer {

    // Returns a random number between the range of the two input numbers.
    // The order of the parameters does not matter.
    public static int getNum(int min, int max) {
        int range = Math.abs(max - min) + 1;
        return ((int) (Math.random() * range)) + (min <= max ? min : max);
    }
}
