package com.psu.bowmanagrawal.speakyourownadventure;

/**
 * Created by caseybowman on 11/27/15.
 *
 * Defaults to 10 scenes per story
 */
public class SceneGenerator {
    private String obstacle;
    private String location;
    private String prevSceneAction;

    public SceneGenerator() {

    }
    public SceneGenerator(String action) {
        this.prevSceneAction = action;

    }
}
