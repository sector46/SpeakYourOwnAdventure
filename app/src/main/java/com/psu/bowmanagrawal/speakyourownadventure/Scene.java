package com.psu.bowmanagrawal.speakyourownadventure;

/**
 * Created by caseybowman on 11/27/15.
 *
 * Defaults to 10 scenes per story
 */
public class Scene {
    private String obstacle;
    private Location location;
    private String prevSceneAction;

    public Scene() {
        this.location = Location.getRandLocation();
        this.obstacle = "";
        this.prevSceneAction = "";
    }
    public Scene(String action) {
        this.prevSceneAction = action;

    }

    public static Scene genScene() {
        return new Scene();
    }

    public static Scene genScene(String input) {
        return new Scene();
    }

    public void genLocation() {
        this.location = Location.getRandLocation();
    }

    public Location getLocation() {
        return location;
    }
}
