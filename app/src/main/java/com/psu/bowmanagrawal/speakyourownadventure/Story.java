package com.psu.bowmanagrawal.speakyourownadventure;

/**
 * Created by caseybowman on 11/28/15.
 */
public class Story {
    private String objective;
    private String [] obstacles;
    private String [] completedObstacles;

    private int maxStoryLength;

    public Story() {
        this.objective = "";
        this.maxStoryLength = 10;
    }

    public String getObjective() {
        return objective;
    }
}
