package com.psu.bowmanagrawal.speakyourownadventure;

/**
 * Created by caseybowman on 11/27/15.
 *
 * Defaults to 10 scenes per story
 */
public class Scene {
    private String obstacle;
    private Location location;
    private Enemy enemy;
    private String prevSceneAction;

    public Scene() {
        this.location = Location.getRandLocation();
        this.enemy = Enemy.getRandEnemy();
        this.obstacle = "";
        this.prevSceneAction = "";
    }
    public Scene(String action) {
        this.prevSceneAction = action;

    }

    public void genScene() {
        this.location = Location.getRandLocation();
        this.enemy = Enemy.getRandEnemy();
        this.obstacle = "";
        this.prevSceneAction = "";
    }

    public void genNewScene() {
        this.location = Location.getRandLocation();
        this.enemy = Enemy.getRandEnemy();
        this.obstacle = "";
        this.prevSceneAction = "";
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
}
