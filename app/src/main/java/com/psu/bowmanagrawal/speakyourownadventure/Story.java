package com.psu.bowmanagrawal.speakyourownadventure;

import java.util.ArrayList;

/**
 * Created by caseybowman on 11/28/15.
 */
public class Story {
    private ArrayList<String> obstacles;
    private ArrayList<String> locations;
    private boolean stillGoing;
    private int [] actions = {0, 0, 0, 0}; // Fight, Talk, Run, and Garbage
    final private int MAX_OBSTACLES_PASSED = 4;

    public Story() {
        this.obstacles = new ArrayList<String>();
        this.locations = new ArrayList<String>();
        this.stillGoing = true;
    }

    public void setOver() {
        this.stillGoing = false;
    }

    public boolean isStillGoing() {
        return this.stillGoing;
    }

    public int getMaxObstaclesPassed() {
        return this.MAX_OBSTACLES_PASSED;
    }

    public void addObstacle(String obstacle) {
        this.obstacles.add(obstacle);
    }

    public void addLocation(String location) { this.locations.add(location); }

    public int getObstacleListLen() {
        return this.obstacles.size();
    }

    public int getLocationListLen() {
        return this.locations.size();
    }

    public boolean checkObstacleInList(String obstacle) {
        if(obstacles.size() == 0) {
            return false;
        } else {
            if (this.obstacles.contains(obstacle)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean checkLocationInList(String location) {
        if(locations.size() == 0) {
            return false;
        } else {
            if (this.locations.contains(location)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public void addAction(String action) {
        switch(action) {
            case "fight":
                this.actions[0] += 1;
                break;
            case "talk":
                this.actions[1] += 1;
                break;
            case "run":
                this.actions[2] += 1;
                break;
            case "garbage":
                this.actions[3] += 1;
                break;
        }
    }

    public String mostActionTaken() {
        int actionIndex = 0;
        int mostTallies = this.actions[0];
        String action = "";

        for(int i=1; i<this.actions.length; i++) {
            if(mostTallies < this.actions[i]) {
                mostTallies = this.actions[i];
                actionIndex = i;
            }
        }

        switch (actionIndex) {
            case 0:
                return "fight";
            case 1:
                return "talk";
            case 2:
                return  "run";
            case 3:
                return "garbage";
            default:
                return "";
        }
    }

    public String getObstacle(int index) {
        return this.obstacles.get(index);
    }

    public String getLocation(int index) { return this.locations.get(index); }
}
