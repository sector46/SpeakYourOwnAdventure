package com.psu.bowmanagrawal.speakyourownadventure;

/**
 * Created by caseybowman on 11/27/15.
 *
 * Defaults to a max of 10 scenes per story
 */
public class Scene {
    private String obstacle;
    private Location location;
    private Enemy enemy;
    private String action;
    private String input;

    public Scene() {
        this.location = null;
        this.enemy = null;
        this.obstacle = "";
        this.action = "";
        this.input = "";
    }

    public void genNewScene(Story story) {
        this.location = Location.getRandLocation();
        this.enemy = Enemy.getRandEnemy();
        while(story.checkObstacleInList(this.enemy.getName())) {
            this.enemy = Enemy.getRandEnemy();
        }
        while(story.checkLocationInList(this.location.getName())) {
            this.location = Location.getRandLocation();
        }
        story.addObstacle(this.enemy.getName());
        story.addLocation(this.location.getName());
        this.obstacle = "";
        this.action = "";
        this.input = "";
    }

    public void genLocation() {
        this.location = Location.getRandLocation();
    }

    public void genEnemy() {
        this.enemy = Enemy.getRandEnemy();
    }

    public Location getLocation() {
        return this.location;
    }

    public Enemy getEnemy() {
        return this.enemy;
    }

    public String getAction() {
        return this.action;
    }

    public void setAction(String input) {
        this.input = input;
        this.action = Dictionary.whichActionType(input);
    }

    public String getInput() {
        return this.input;
    }
}
