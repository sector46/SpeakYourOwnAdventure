package com.psu.bowmanagrawal.speakyourownadventure;

import java.util.ArrayList;

/**
 * Created by caseybowman on 11/28/15.
 */
public class Story {
    private ArrayList<String> obstacles;
    private String [] completedObstacles;

    private int maxStoryLength;

    public Story() {
        this.obstacles = new ArrayList<String>();
        this.maxStoryLength = 10;
    }

    public void addObstacle(String obstacle) {
        this.obstacles.add(obstacle);
    }

    public int getObstacleListLen() {
        return this.obstacles.size();
    }

    public String getObstacle(int index) {
        return this.obstacles.get(index);
    }
}
