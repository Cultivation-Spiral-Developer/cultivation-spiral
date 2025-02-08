package Scenes.PlotScenes;

import Scenes.Scene;

import java.math.BigInteger;

import static Game.Game.*;

public class HelIntroScene extends Scene {

    public HelIntroScene() {
        super(5);
        fillSceneData();
        fillEmptyData();
        loopEnd = true;
        associatedEvent = PlotEvent.HELINTRO;
    }

    private void fillSceneData() {
        backgrounds[0] = "black";
        screens[0].attach("You wake up in an unfamiliar place.  Wherever it is, your limbs are still immobilized.  In fact, you can't feel your body at all.\n\n");
        screens[0].attach("Wait, 'still' immobilized?  Were they immobilized before?  What were you doing, just now?  Something about... a crash?  An explosion?  Your memories are disorganized, and you can't find what you're looking for.\n\n");
        screens[0].attach("Somehow, you can't make your mind work.  When you have questions, you should be able to reason your way toward the answers.  But when you try to do that, everything seems to halt up, and you end up right back where you started.");

        characters[1] = new String[]{"hel"};
        outfits[1] = new String[]{"Shadowed"};
        emotions[1] = new String[]{"Grin"};
        modifiers[1] = new Modifier[]{Modifier.CLOSEUP};
        screens[1].attach("You realize that you're not alone here.\n\n");
        screens[1].attach("\"As I thought, you lived there as well.  Good.  This means that I don't need to change my established pattern.\"\n\n", 12);
        screens[1].attach("Is " + heShe(12) + " expecting you to answer?  You don't think you have a mouth right now.  For that matter, you aren't even sure if you have ears.  Instead of 'hearing' " + hisHer(12) + " voice, it feels more like someone else's thoughts are echoing inside your mind.");

        modifiers[2] = new Modifier[]{Modifier.CLOSEUP};
        emotions[2] = new String[]{"Grin"};
        screens[2].attach("\"This way, you should need no further encouragement.  You'll have more reason than most to be dissatisfied with how things always turn out.\"\n\n", 12);
        screens[2].attach("Is " + heShe(12) + "... happy?  Angry?  You don't have eyes, either, but you can tell.  " + HeShe(12) + "'s speaking through clenched teeth.\n\n");
        screens[2].attach("\"I will place my hopes on your shoulders.\"", 12);

        modifiers[3] = new Modifier[]{Modifier.CLOSEUP};
        emotions[3] = new String[]{"Grin"};
        screens[3].attach(HeShe(12) + "'s expecting something from you?  Why?  You don't even have a body anymore.  You're dead.  You can rest now.\n\n");
        screens[3].attach("\"Yes, I was right to choose you.  I think we'll get along quite well.  Do you want to rest?  Do you want to have peace?\"", 12);

        modifiers[4] = new Modifier[]{Modifier.CLOSEUP};
        emotions[4] = new String[]{"Grin"};
        screens[4].attach("\"Then wake up!  Cast aside the illusion of your humanity!  Slay the gods of this world!  Every last one of us!\"", 12);
    }
}
