package com.psu.bowmanagrawal.speakyourownadventure;

import android.widget.Switch;

/**
 * Created by caseybowman on 11/28/15.
 */
public class SentenceGenerator {

    public static String genIntroduction(Story story, Scene scene, boolean isIntro) {
        scene.genNewScene(story);
        String returnStr = "";
        Location location = scene.getLocation();
        Enemy enemy = scene.getEnemy();
        int randNum;

        if(isIntro){
            returnStr += "You find yourself " + location.getPreposition() + location.getRandAdjective() + location.getName() + ".";
        } else {
            returnStr += "Suddenly, a bright, white light shines down upon you and you realize you are " + location.getPreposition() +
                         location.getRandAdjective() + location.getName() + ".";
        }

        // Creating the setting
        if(location.getName().equals("woods")) {
            returnStr += " Looking around, you see trees in every direction. Unfortunately, you can't see very far due to the dense " +
                         "fog that reduces your sight to around twenty meters in front of yourself.";

        } else if(location.getName().equals("jungle")) {
            returnStr += " You immediately feel the mugginess and heat of the surroundings and start to break out in a sweat.";

        } else if(location.getName().equals("volcano")) {
            returnStr += " The smell of sulfur and smoke fills the air. It is hard for you to breathe, but you somehow manage " +
                         "to fill your lungs with just enough oxygen to keep yourself from passing out.";

        } else if(location.getName().equals("lake")) {
            returnStr += " Clear, greenish-blue water fills the lake, giving off a serene feeling. It's peaceful and quiet here. Too quiet.";

        } else if(location.getName().equals("beach")) {
            returnStr += " You can feel the soft sand under your feet and smell the salt in the air. You hear waves from the ocean " +
                         "crashing upon the shoreline.";

        } else if(location.getName().equals("plains")) {
            returnStr += " High grass that extends beyond your waist tickles your hands and arms as you wade through the seemingly endless " +
                         "sea of green.";

        } else if(location.getName().equals("castle")) {
            returnStr += " Darkness surrounds you, with the only sources of light coming from the dimly lit candles on the walls.";

        }

        // Introducing an enemy
        randNum = Randomizer.getNum(0,3);
        switch (randNum) {
            case 0:
                returnStr += " In front of you, you see a " + enemy.getName() + ". ";
                break;
            case 1:
                returnStr += " Not too far off from where you are, you see a " + enemy.getName() + ". ";
                break;
            case 2:
                returnStr += " In the distance, you see a " + enemy.getName() + ". ";
                break;
            case 3:
                returnStr += " Behind you, you hear a noise, only to turn around to see a " + enemy.getName() + ". ";
                break;
        }

        if(isIntro) {
            returnStr += "What do you do?";
        }
        return returnStr;
    }

    public static String genSentences(Story story, Scene scene) {
        String returnStr = "";
        String enemy = scene.getEnemy().getName();
        String action = scene.getAction();
        String input = scene.getInput();

        returnStr += "";

        story.addAction(action);

        switch(enemy) {
            case "rock":
                switch (action){
                    case "fight":
                        if(scene.getEnemy().isCompleted()) {
                            returnStr += "You decided to " + input + " the rock. If it wasn't broken before, it is now. In fact, " +
                                         "your '" + input + "' smashed the rock into dust. Satisfied, you start to move on. ";
                            returnStr += nextScene(story, scene);
                        } else {
                            returnStr += "You decided to " + input + " the rock, which wasn't the brightest of ideas because " +
                                    "you end up hurting yourself in the process. You could try a different method of approaching " +
                                    "the rock, but why not continue doing what you're doing? I mean, you've come this far, why not " +
                                    "finish what you started? ";
                            scene.getEnemy().setCompleted();
                        }
                        break;
                    case "talk":
                        if(scene.getEnemy().isCompleted()) {
                            returnStr += "Sometimes, choosing to " + input + " to a rock can pay off. This rock is now your little " +
                                         "buddy and he can follow you around by rolling and the power of magic (you just might be " +
                                         "schizophrenic at this point). And so, you set off walking ahead, with your new buddy " +
                                         "following closely at your heels. ";
                            returnStr += nextScene(story, scene);
                        } else {
                            returnStr += "You decided to " + input + " to the rock. This resulted in you looking like a crazy " +
                                    "person interacting with a rock. Congratulations. What are you hoping to accomplish " +
                                    "by befriending a rock? Well, your rock friend still looks like they could use some attention. ";
                            scene.getEnemy().setCompleted();
                        }
                        break;
                    case "run":
                        returnStr += "You decided to " + input + " away from the rock. It's not like you wanted to get involved with " +
                                     "the rock's problems anyway. It would've led you down the path of laziness, I'm sure. If you don't " +
                                     "get it, it's because it's a rock and rocks don't move. See, now the joke's ruined. ";

                        returnStr += nextScene(story, scene);
                        break;
                    case "garbage":
                        returnStr += "I'm not sure what " + input + " would do, but it seemed to have a profound effect on the " +
                                     "because the rock just exploded. Try not to worry about it too much. ";
                        returnStr += nextScene(story, scene);
                        break;
                }
                break;
            case "bear":
                switch (action){
                    case "fight":
                        if(scene.getEnemy().isCompleted()) {
                            returnStr += "You " + input + " the bear on the nose, the bear's only weak spot. This move gave the bear " +
                                         "a shock that sent it running for its mama. ";
                            returnStr += nextScene(story, scene);
                        } else {
                            returnStr += "You decided to " + input + " the bear. Its eyes grew wide and swelled as tears burst from ." +
                                    "the bear's face. How could you do that to such a gentle creature? Are you proud of yourself? " +
                                    "With your embarrassingly bad etiquette for greetings established, you must come to a decision " +
                                    "about what to do with the crying bear. ";
                            scene.getEnemy().setCompleted();
                        }
                        break;
                    case "talk":
                        returnStr += "When coming face-to-face with a wild bear, your first course of action should always be to " +
                                     input + " to the bear because, you know, introducing yourself to others is good social etiquette. " +
                                     "The bear puts on a top hat and monocle that were concealed and speaks with a British accent, " +
                                     "\"Tis' a most wonderful day, isn't it?\". You decide that was enough talking bear for one day and " +
                                     "give the bear a quick nod of acknowledgement as you set on your merry way. ";
                        returnStr += nextScene(story, scene);
                        break;
                    case "run":
                        if(scene.getEnemy().isCompleted()) {
                            returnStr += "When you start to " + input + ", the bear thinks of it as a game and joins in. You're trying to " +
                                         input + " away and the bear wants to " + input + " with you. ";
                            returnStr += nextScene(story, scene);
                        } else {
                            returnStr += "You decided to try and " + input + " away from the bear. However, you forget that you couldn't " +
                                         "outrun a snail because you haven't exercised in forever. Those triple-decker, bacon-layered, " +
                                         "burgers topped with an egg weren't doing you any favors either. In a split-second, you are right " +
                                         "in front of the bear again. ";
                            scene.getEnemy().setCompleted();
                        }
                        break;
                    case "garbage":
                        returnStr += "You decided to " + input + " at the bear. It showed its appreciation of your action by " +
                                     "slightly trying to murder you. You thought it was all over. ";
                        returnStr += nextScene(story, scene);
                        break;
                }
                break;
            case "squirrel":
                switch (action){
                    case "fight":
                        returnStr += "You tried to " + input + " the squirrel, but it was too darn fast for you. In the process, you " +
                                     "trip and knock yourself out. When you come to, a whole family of angry-looking squirrels are " +
                                     "looming over you. As one comes over to attack you, you cover your eyes. ";
                        returnStr += nextScene(story, scene);
                        break;
                    case "talk":
                        returnStr += "Attempting to " + input + " to the squirrel did nothing. The squirrel looked at you, looked at " +
                                     "an acorn, back to you, back to the acorn, back to you, and finally back to the acorn when it " +
                                     "decided to grab the acorn and scamper off with its prize, leaving you with the feeling of mild " +
                                     "amusement. ";
                        returnStr += nextScene(story, scene);
                        break;
                    case "run":
                        returnStr += "When you started to " + input + ", you almost felt silly, having to " + input + " away from such a " +
                                     "small creature. I use the word, 'almost' because it seemed that this was no ordinary squirrel. It must've " +
                                     "had a daily diet consisting of nothing but creatine because it had hilariously abnormally-sized muscles. " +
                                     "You thought you were going to be an unfortunate victim mauled by a monstrous squirrel when you felt the " +
                                     "pressure of its small, but powerful feet grab ahold of your shirt. ";
                        returnStr += nextScene(story, scene);
                        break;
                    case "garbage":
                        returnStr += "As soon as the word, '" + input + "' left your mouth, the squirrel fell over, motionless, but still breathing. " +
                                     "It seems that you've gained superpowers somewhere along your journey. Use them well before entering bright white " +
                                     "light because you'll lose them immediately. ";
                        returnStr += nextScene(story, scene);
                        break;
                }
                break;
            case "clown":
                switch (action){
                    case "fight":
                        returnStr += "You tried to " + input + " the clown, but every time you tried, your moves ended up making the clown laugh and " +
                                     "honk his squeaky nose, which just aggravated you more. Eventually you got a hold of him (still squeaking and " +
                                     "honking) and used a full-force " + input + " on him. Now satisfied, you start to walk away. ";
                        returnStr += nextScene(story, scene);
                        break;
                    case "talk":
                        returnStr += "Communicating with clowns is a next to impossible task. Or at least, trying to communicate with this particular " +
                                     "clown is impossible. Your attempts to " + input + " to the clown result in beeps, honks, and laughing, but no " +
                                     "actual intelligible conversation can be held with this individual. Eventually, you give up and the clown finally " +
                                     "speaks up and says in a cackling voice, \"They're watching!\" ";
                        returnStr += nextScene(story, scene);
                        break;
                    case "run":
                        returnStr += "Running from a creepy clown who you meet " + scene.getLocation().getPreposition() + scene.getLocation().getName() +
                                     " is probably the smartest thing you can do. You're out of there faster than you could say, \"stranger danger!\" ";
                        returnStr += nextScene(story, scene);
                        break;
                    case "garbage":
                        returnStr += "When you said, '" + input + "' to the clown, he sat down and got all quiet. He started talking in unrecognizable " +
                                     "mumbling before he pulled out a picture of his family from his wallet and started sobbing. Since you had no idea " +
                                     "why he was sobbing, or how saying '" + input + "' caused him to start sobbing, you believed that your only option " +
                                     "was to leave as quickly and quietly as possible. ";
                        returnStr += nextScene(story, scene);
                        break;
                }
                break;
            case "swordsman":
                switch (action){
                    case "fight":
                        returnStr += "Acting hostile towards the swordsman caused him to draw his blade. \"YOU THINK YOU CAN " + input.toUpperCase() +
                                     " ME?\" Acting aggressive was a bad idea, because it was about to cost you your head. ";
                        returnStr += nextScene(story, scene);
                        break;
                    case "talk":
                        returnStr += "You decided to " + input + " to the swordsman. Acting aggressive towards him would be a bad idea, but a " +
                                     input + " should be all right, right? Wrong. The swordsman started chasing after you, screaming at the top " +
                                     "of their lungs about how you offended them. The swordsman finally reached a close enough distance where he could " +
                                     "lop off your head with a single movement. ";
                        returnStr += nextScene(story, scene);
                        break;
                    case "run":
                        returnStr += "Immediately, you started to " + input + " as soon as you saw the swordsman. You have seen similar people before and " +
                                     "you knew that you should stay as far away from him as possible. The swordsman crouched for a moment, picked " +
                                     "off the ground, like he was tracking you, and started sprinting in your direction, hollering something that you " +
                                     "couldn't hear. Eventually, the swordsman caught up and cornered you (most likely due to your milkshake binges). " +
                                     "He held out his hand, giving you your wallet that you dropped, and left. ";
                        returnStr += nextScene(story, scene);
                        break;
                    case "garbage":
                        returnStr += "As the swordsman neared you, you blurted out, \"" + input + "\" and the swordsman nodded his head ever so slightly " +
                                     "and stated, \"Yes, I understand, my friend.\" You didn't know what you said, you just kept your head down and got " +
                                     "out of there as quickly as possible before the swordsman could turn around. ";
                        returnStr += nextScene(story, scene);
                        break;
                }
                break;
            case "wall":
                switch (action){
                    case "fight":
                        if(scene.getEnemy().isCompleted()) {
                            returnStr += "The wall must've had a weak spot or something because when you decided to " + input +
                                         " it, it crumbled almost immediately. Through the gaping hole, you spotted..." +
                                         "a whole other, even stronger wall! ";
                            returnStr += nextScene(story, scene);
                        } else {
                            returnStr += "Trying to " + input + " a wall? But why? the wall just retaliates by using " +
                                         "Issac Newton's third law of motion: for every action, there is an equal and " +
                                         "opposite reaction. Hopefully you learn to not attack every wall you meet in " +
                                         "the future. For now, the wall is still there and you have a decision to make. ";
                            scene.getEnemy().setCompleted();
                        }
                        break;
                    case "talk":
                        returnStr += "When you tried to " + input + " at the wall, you realized that it's like talking to the hand. Nothing would " +
                                     "be accomplished. ";
                        returnStr += nextScene(story, scene);
                        break;
                    case "run":
                        returnStr += "Attempting to " + input + " away from the wall was successful. What? Did you think the wall would follow you? ";
                        returnStr += nextScene(story, scene);
                        break;
                    case "garbage":
                        returnStr += "In your most professional magician voice, you exclaimed, \"" + input.toUpperCase() + "!\", to which the wall didn't " +
                                     "react to at first. But, behind the wall, crackling and grinding noise could be heard. The noises became louder and " +
                                     "louder until finally the wall opened up like a pair of bi-folding doors. You entered the opening slowly. ";
                        returnStr += nextScene(story, scene);
                        break;
                }
                break;
/*            case "puppy":
                switch (action){
                    case "fight":
                        returnStr += "As you move closer to " + input + " the puppy, its adorable face curls into one " +
                                     "of the most horrifying snarls you've ever seen. Seriously, this puppy has anger issues. ";
                        break;
                    case "talk":
                        returnStr += "";
                        returnStr += nextScene(story, scene);
                        break;
                    case "run":
                        returnStr += "";
                        returnStr += nextScene(story, scene);
                        break;
                    case "garbage":
                        returnStr += "";
                        returnStr += nextScene(story, scene);
                        break;
                }
                break;   */
        }

        if(story.isStillGoing()) {
            returnStr += "What do you do?";
        }

        return returnStr;
    }

    public static String nextScene(Story story, Scene scene) {
        if(story.getMaxObstaclesPassed() < story.getObstacleListLen() ) {
            story.setOver();
            return SentenceGenerator.genEnd(story);
        } else {
            scene.genNewScene(story);
            return genIntroduction(story, scene, false);
        }
    }


    // fight -> gladiator arena - since you have such an insatiable thirst for fighting, the aliens believed that you would love fighting in their arena for the rest of your days.
    // talk -> leading earth representative for alien meetings - Since you loved talking so much, the aliens thought that you would just jump at the chance to attend meetings all day, so they made you a intermediary between your planet and theirs
    // run -> giant hamster wheel that powers the white light mechanism - All the aliens saw you do during your travels was run. So, they figured that you would do best running on a giant hamster wheel generator that powers their machines
    // garbage -> Frankly, the aliens were just plain afraid of your mysteriousness, so they just sent you home.
    public static String genEnd(Story story) {
        String returnStr = ""; //"After defeating";
        String popularAction = story.mostActionTaken();

/*        if(obstacleListLen < 2) {
            returnStr += " a " + story.getObstacle(0);
        } else if(obstacleListLen < 3) {
            returnStr += " a " + story.getObstacle(0) + " and a " + story.getObstacle(1);
        } else {
            returnStr += " a ";
            for(int i=0; i<obstacleListLen-1; i++) {
                returnStr += story.getObstacle(i) + ", ";
            }
            returnStr += "and a " + story.getObstacle(obstacleListLen-1);
        }
*/
        returnStr += "Once more, a bright light shines down upon you and you see that you are in a bed surrounded by alien creatures. " +
                     "They notify you that you were being tested to see how you'd react to different situations. Based on the choices you made, " +
                     "the aliens tell you that you are ";

        switch(popularAction) {
            case "fight":
                returnStr += "being sent to their gladiator arena because you seem to have a warmongering personality. A bright light sends you " +
                             "to the arena, where you will spend the rest of your days fighting mysterious monsters and beings. ";
                break;
            case "talk":
                returnStr += "being sent to their council as a representative between your planet and theirs due to your attempts to negotiate " +
                             "your way through every situation where possible. A bright light sends you directly to one of the ongoing meetings, " +
                             "where you spend the rest of your days fighting policies with other alien races. ";
                break;
            case "run":
                returnStr += "being sent to one of their many giant hamster-wheel generators where you will spend the rest of your days powering " +
                             "their equipment because all you did was run away. A flash of bright light sends you to the wheel-O-power, which you " +
                             "pretty much every waking hour running on the wheel. ";
                break;
            case "garbage":
                returnStr += "being sent home because the aliens had no idea what you were doing. And that scared them. One flash of bright light " +
                             "later and you're sitting on your couch, watching the usual TV. ";
                break;
        }

        returnStr += "THE END";

        return returnStr;
    }
}
