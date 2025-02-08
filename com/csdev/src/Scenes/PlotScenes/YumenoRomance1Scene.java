package Scenes.PlotScenes;

import Scenes.Scene;

import static Game.Game.*;

public class YumenoRomance1Scene extends Scene {

    public YumenoRomance1Scene() {
        super(20);
        fillSceneData();
        fillEmptyData();
        associatedEvent = PlotEvent.YUMENOROMANCE1;
    }

    private void fillSceneData() {
        backgrounds[0] = "cleaner";
        tracks[0] = Music.SILENCE;
        screens[0].attach("Coming back home without " + Tanaka() + " wasn't an easy decision.  Even if " + heShe(5) + "'s not in too much immediate danger, " + heShe(5) + "'s still effectively a prisoner of the Lunar Syndicate.  Without your help, it's hard to believe that " + heShe(5) + "'ll be able to escape from a group like that on " + hisHer(5) + " own.\n\n");
        screens[0].attach("The Lunar Syndicate is an enormous, dangerous group of criminals whose leader seems almost omniscient.  That's half the reason you came back here.  It's clear that you don't yet have the skills or the resources necessary to go up against an enemy like that.  And the best way to get those skills and resources is to come back to a place where you have friends to help you out.\n\n");
        screens[0].attach("But that's only half the reason.  The other half is that you care about the people here, too.  There's more to your life than just " + Tanaka() + ".");

        screens[1].attach("Patching up your relationship with " + Yumeno() + " wasn't too hard.  " + HeShe(1) + " was angry at you for leaving the city to chase after " + Tanaka() + ", but apparently that was just because " + heShe(1) + " was worried for your sake.  Now that you're back, all's well that ends well.\n\n");
        boolean found = false;
        if (currentPlaythrough.weeklyActions[weekDayNumber()][0] == Action.HOMELANDING) {
            screens[1].attach("You've already filled " + himHer(1) + " in on the details of your brief adventure in the Metropolis.  " + HeShe(1) + " was quiet as you explained the nature of the group that abducted " + Tanaka() + " and your plans for dealing with them.  By the time you were done, it had already gotten late.  You're heading off to bed to get some sleep, and then maybe you'll have time to play some video games with " + Yumeno() + " early tomorrow morning, for old time's sake.");
        } else {
            screens[1].attach("Everything has been normal between the two of you since then.  You and " + Yumeno() + " have just enjoyed a pleasant evening together.");
        }

        backgrounds[2] = "black";
        screens[2].attach("However, not long after you climb into your bed in " + Yumeno() + "'s guest room, you hear footsteps outside your door.  You were already starting to drift off to sleep, so you don't immediately make the connection that it must be " + Yumeno() + ".\n\n");
        screens[2].attach("There's a quiet clicking sound.  Is that the door opening?  Maybe " + Yumeno() + " forgot something in this room, and " + heShe(1) + "'s trying to take it out of here without waking you.  That sounds plausible.  So, you should probably just pretend you don't notice " + himHer(1) + ".\n\n");
        screens[2].attach("Then, the room returns to silence.  Did " + Yumeno() + " leave without you being able to hear " + himHer(1) + "?  Or maybe the noise you heard was " + himHer(1) + " leaving, and you just didn't notice the sound of " + himHer(1) + " coming into the room.  Either way, it seems like you should go back to trying to get to sleep.  Your groggy mind starts to slow down again.\n\n");
        screens[2].attach("It's only when you feel the mattress sink under somebody else's weight that you fully wake up.");

        backgrounds[3] = "yumenoh1";
        tracks[3] = Music.MOMENTS;
        screens[3].attach("It's " + Yumeno() + ".  " + HeShe(1) + "'s in your bed.  Why is " + heShe(1) + " in your bed?\n\n");
        screens[3].attach("\"To seduce you, obviously.\"\n\n", 1);
        screens[3].attach(HeShe(1) + "'s smiling, but " + hisHer(1) + " tone is dead serious.  This isn't a joke.");

        screens[4].attach("Just a moment ago, you were starting to fall asleep.  This is way too sudden.  Your brain can't keep up.  Shouldn't " + Yumeno() + " slow down a little?\n\n");
        screens[4].attach("\"Why should I slow down?  It seems like your body is all ready to go.\"\n\n", 1);
        screens[4].attach(Yumeno() + " presses " + hisHer(1) + " hand down against your crotch.  ");
        if (currentPlaythrough.ownGender != Gender.FEMALE) {
            screens[4].attach("The unfamiliar sensation of being touched down there by somebody else is quickly causing you to get hard.  You feel the urge to push your hips against " + hisHer(1) + " hand.\n\n");
            screens[4].attach("But isn't this backwards?  You and " + Yumeno() + " don't have this kind of relationship, at least not yet.  " + Yumeno() + " hasn't ever said " + heShe(1) + " was interested in you.  Well, you might have had your suspicions, but for " + himHer(1) + " to just jump straight into your bed like this...\n\n");
            screens[4].attach("\"Yeah, I'm completely in love with you.  And I could tell that you were starting to want me, too.\"", 1);

            backgrounds[5] = "yumenoh2";
            screens[5].attach("\"But you wouldn't make the first move.  I really, really wanted you to make the first move.\"\n\n", 1);
            screens[5].attach("If you hadn't been so busy lately, then maybe you actually would have made the first move.  But romance has been the last thing on your mind.\n\n");
            screens[5].attach("\"Right.  You've been thinking about " + Tanaka() + ".  How to find " + Tanaka() + ".  How to rescue " + Tanaka() + ".  " + Tanaka() + " this, " + Tanaka() + " that.\"\n\n", 1);
            screens[5].attach("A note of irritation enters " + Yumeno() + "'s voice, and the pressure from " + hisHer(1) + " hand increases, almost to the point of becoming painful.");

            backgrounds[6] = "yumenoh1";
            screens[6].attach("\"I'm going to make you forget all about " + Tanaka() + ".\"\n\n", 1);
            screens[6].attach("It seems like " + Yumeno() + " might be assuming too much.  You aren't actually in a relationship with " + Tanaka() + ".  You're just helping " + himHer(5) + " because " + heShe(1) + "'s a friend.\n\n");
            screens[6].attach("\"Really?  Well, that's fine too, I suppose.\"", 1);

            screens[7].attach("When " + Yumeno() + " didn't seem to hold a grudge against you for leaving " + himHer(1) + " behind to go to the Metropolis, the natural assumption was that it wasn't actually a big deal to " + himHer(1) + ".  But even if " + heShe(1) + " doesn't hate you for it, " + heShe(1) + " isn't willing to let it go, either.  You might have actually broken " + hisHer(1) + " heart.\n\n");
            screens[7].attach("There's no need for " + himHer(1) + " to go this far.  If " + heShe(1) + " doesn't want to do this, then-\n\n");
            screens[7].attach("\"But I do want to do this.  I should have done it from the very start.  They say that the quickest way to ", 1);
            if (currentPlaythrough.ownGender == Gender.MALE) {
                screens[7].attach("a man's ", 1);
            } else {
                screens[7].attach("someone's ", 1);
            }
            screens[7].attach("heart is through " + hisHer(-1) + " stomach, but the truth is that you need to aim a little bit lower.\"", 1);

            backgrounds[8] = "yumenoh3";
            screens[8].attach("When " + Yumeno() + " releases your cock from your pants, it's already fully erect.  " + Yumeno() + "'s hair was spilling over onto your lap, and when your shaft rises up through it, the silky texture feels pleasant against the sensitive skin.\n\n");
            screens[8].attach("You're about to try to say something, but your mind goes blank when " + Yumeno() + " closes " + hisHer(1) + " fingers around your cock.  " + HeShe(1) + " immediately starts to move " + hisHer(1) + " hand up and down, using " + hisHer(1) + " own hair to stimulate you.  It feels amazing.  Has " + Yumeno() + " done this before?\n\n");
            screens[8].attach("\"Nope.  But as soon as you said you were flying back here, I sat down and spent fifteen straight hours watching amateur porn.  I wanted to make sure I'd be able to make you feel good.\"\n\n", 1);
            screens[8].attach(Yumeno() + " was planning on ambushing you in bed like this from the very start?\n\n");
            screens[8].attach("\"That's right.  Ever since you left, I've been spending every moment thinking about how I could have done things better.\"", 1);

            screens[9].attach("\"And now it's paying off, right?  Doesn't it feel good?\"\n\n", 1);
            screens[9].attach("You have to admit that it does.  You wouldn't normally think that watching porn would make somebody good at the real thing, but " + Yumeno() + " must have gone out of " + hisHer(1) + " way to look for uncut videos where the guy actually gets brought naturally to orgasm.\n\n");
            screens[9].attach("The mental image of " + Yumeno() + " going on a porn binge is pretty amusing.  But knowing " + Yumeno() + ", " + heShe(1) + " wasn't watching them for " + hisHer(1) + " own gratification at all.  As always, " + hisHer(1) + " focus is intense.\n\n");
            screens[9].attach("And even as " + heShe(1) + " strokes your cock, " + hisHer(1) + " technique is only improving.  " + HeShe(1) + " seems to be judging your reactions and adjusting " + hisHer(1) + " movements accordingly.  Your cock is rising from its half-erection all the way to full mast.");

            screens[10].attach("\"It feels better than when you play with yourself, right?\"\n\n", 1);
            screens[10].attach("Judging from " + hisHer(1) + " expression, " + heShe(1) + " already knows the answer.\n\n");
            screens[10].attach("\"It's funny.  You've been attached to this thing for your whole life, but I'm still better at using it than you are.\"\n\n", 1);
            screens[10].attach("As always, " + Yumeno() + " picks up new skills quickly.\n\n");
            screens[10].attach("\"It helps when the controls are so responsive.  I've never been the biggest fan of joystick games, but this one is pretty fun.\"", 1);

            screens[11].attach(HeShe(1) + " really is enjoying this.  Now that you're fully erect and almost ready to burst, " + heShe(1) + "'s deliberately slowing down " + hisHer(1) + " movements, holding you on the edge.  " + HeShe(1) + "'ll start pumping " + hisHer(1) + " hand up and down faster for just a few strokes, then slow down again just when you feel like you're about to burst.\n\n");
            screens[11].attach("\"I'm gonna make it feel so good that you can't go back to just using your own hand.  I'll make it so you can't live without me.\"\n\n", 1);
            screens[11].attach("Even when " + Yumeno() + " is at " + hisHer(1) + " most competitive, it's rare for " + himHer(1) + " to gloat like this.  Maybe you can't complain, since you're the one getting pleasured right now.");

            backgrounds[12] = "yumenoh4";
            screens[12].attach("But at the same time, you probably shouldn't let " + himHer(1) + " get too full of " + himHer(1) + "self.  " + HeShe(1) + "'s still a beginner, after all.\n\n");
            screens[12].attach("\"Huh?\"\n\n", 1);
            screens[12].attach("It's true, isn't it?  After all, " + heShe(1) + " still hasn't made you cum even once.");

            backgrounds[13] = "yumenoh5";
            screens[13].attach("Without warning, " + Yumeno() + " takes your tip into " + hisHer(1) + " mouth and starts to stroke at top speed.  Your hips involuntarily jerk upward, but " + heShe(1) + " holds you down with " + hisHer(1) + " elbows, furiously milking your cock while " + hisHer(1) + " tongue swirls around the opening.\n\n");
            screens[13].attach("You couldn't hold back even if you wanted to.  During all that time spent slowly stroking your cock, the anticipation was gradually building up.  And now, all of that desire is coming back at once.  " + Yumeno() + "'s hand is a blur, the individual strokes merging into a continuous stream of pleasure.");

            screens[14].attach("You feel it starting to come out, drawn toward the repetitive movements of " + Yumeno() + "'s tongue.  " + HeShe(1) + " seems to sense it too, and the rhythm of " + hisHer(1) + " stroking changes, as if pulling the semen out of you.  Your mind goes blank as your hips jerk upward one last time.\n\n");
            screens[14].attach(Yumeno() + " is just a moment too slow in pulling " + hisHer(1) + " face back away from your cock.");

            backgrounds[15] = "yumenoh6";
            screens[15].attach("It takes a moment for you to regain your senses.  It looks like most of your load ended up on the bed and yourself, but " + Yumeno() + " didn't escape entirely unscathed.\n\n");
            screens[15].attach("\"Wow!  This stuff tastes really bad!\"\n\n", 1);
            screens[15].attach("Apparently it doesn't bother " + himHer(1) + " that much, though.  " + HisHer(1) + " tone is full of the pure joy of discovering something new.");

            screens[16].attach(Yumeno() + " smiles down at you.  " + HeShe(1) + " looks very satisfied.\n\n");
            screens[16].attach("\"I'm gonna keep getting better and better at this.  I hope you're ready.\"\n\n", 1);
            screens[16].attach("It seems like " + heShe(1) + "'s taken it as a challenge.  If it means feeling even more pleasure than this, though, that might not be a bad thing.\n\n");
            screens[16].attach("But in the meantime, maybe it's your turn to see how well you can pleasure " + Yumeno() + " in turn.");

            sounds[17] = Effect.RUSTLE;
            characters[17] = new String[]{"yumeno"};
            emotions[17] = new String[]{"Scared"};
            backgrounds[17] = "cleaner";
            screens[17].attach("\"Oh, n-no, that's alright!  I-I'm completely fine!\"\n\n", 1);
            screens[17].attach(Yumeno() + " hurriedly gets up and backs away from the bed.  It's surprising.  " + HeShe(1) + " was so bold a moment earlier, but now " + heShe(1) + "'s flipped right back to being shy.  What's wrong?\n\n");
            screens[17].attach("\"W-Well, it's getting late, so...  Maybe another time.\"", 1);

            emotions[18] = new String[]{"Happy"};
            screens[18].attach("\"I had a really good time, though.  And tomorrow morning...  Hehe, I have some more things I want to try, so look forward to it!  Good night!\"\n\n", 1);
            screens[18].attach(Yumeno() + " vanishes out the door, leaving you to try to figure out what just happened.  Apparently " + heShe(1) + " isn't a fan of cuddling in the afterglow, either.");

            characters[19] = new String[0];
            screens[19].attach("Apparently " + Yumeno() + " is your girlfriend now.  On further reflection, that's actually kind of a nice thought.  " + HeShe(1) + " has a strange way of showing " + hisHer(1) + " affection, but you can deal with that.\n\n");
            screens[19].attach("In the future, though, it might be better not to talk about " + Tanaka() + " too much in front of " + himHer(1) + ".  And as for what will happen once it's time for you to go to the Metropolis...  Well, you can cross that bridge when you get there.\n\n");
            screens[19].attach("For now, you feel just about ready to go to sleep.  All the other issues can wait for tomorrow.");
        }
    }
}
