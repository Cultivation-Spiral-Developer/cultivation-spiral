package Scenes.PlotScenes;

import Scenes.Scene;

import java.math.BigInteger;

import static Game.Game.*;

public class CollegeTownDestructionScene extends Scene {

    public CollegeTownDestructionScene() {
        super(10);
        fillSceneData();
        fillEmptyData();
        loopEnd = true;
        associatedEvent = PlotEvent.COLLEGETOWNDESTRUCTION;
    }

    private void fillSceneData() {
        tracks[0] = Music.SILENCE;
        backgrounds[0] = "black";
        if (currentPlaythrough.weeklyActions[(weekDayNumber()+6)%7][5] != null && currentPlaythrough.weeklyActions[(weekDayNumber()+6)%7][5].baseCost.compareTo(BigInteger.ZERO) < 0) {
            screens[0].attach("You sleep well, full of plans for tomorrow.  But unbeknownst to you, fate has something else in store.  By the time you wake up, it's already too late.\n\n");
        } else {
            screens[0].attach("You stay up through the night, working to achieve what's important to you.  But unbeknownst to you, fate has something else in store.  By the time the sun comes up, it's already too late.\n\n");
        }
        screens[0].attach("As you walk down the street, a sudden commotion catches your attention.  When you follow everyone's gaze toward the horizon, it's plain to see why.  The dark shape rising up above the skyline is beyond your comprehension.\n\n");
        screens[0].attach("What is it?  Some sort of atmospheric phenomenon?  An optical illusion?  It's hard to believe that something so large could be a real, physical entity.");

        screens[1].attach("And it keeps growing.  Or maybe it's just getting closer.\n\n");
        screens[1].attach("The people around you are beginning to panic and run for cover, but you find yourself entranced.  You can't help but try to wrap your head around whatever it is you're seeing.  It's hard to tell at this distance, but it seems to be mechanical in nature.\n\n");
        screens[1].attach("As you watch, lines of brilliant lights along the structure flare to life.");

        sounds[2] = Effect.GROWL;
        backgrounds[2] = "elohim2";
        screens[2].attach("It's a ship.  That seems to be the best way to describe it.  A ship that's even larger than a city.\n\n");
        screens[2].attach("Who could have made something at such a large scale?  And for what purpose?  What's it doing here?\n\n");
        screens[2].attach("The glowing lines along the sides of the ship grow brighter, and a possible answer enters your head.  Are those some sort of weapon?");

        sounds[3] = Effect.EXPLOSION;
        backgrounds[3] = "elohim3";
        screens[3].attach("They are.  Bright beams of light lance down toward the skyline below.  But before they can strike, something intercepts them.\n\n");
        screens[3].attach("You can only describe it as a force field.  At least the giant ship is understandable as something that could be built with a big enough investment of industrial effort.  But this is on another level entirely.  ");
        if (getGoalLevel(18, false) > 0) {
            screens[3].attach("The energy shield is clearly centered around The Tower, but even with everything " + Heilig() + " has said about the advanced technology there, it's hard to believe that projecting some sort of hard light dome around the city is something they can do.\n\n");
        } else {
            screens[3].attach("It seems like you've gotten yourself caught in the middle of a war where both sides have access to some incredible technology.\n\n");
        }
        screens[3].attach("Whatever's actually going on here, it looks like you'll at least be safe for the moment.");

        sounds[4] = Effect.EXPLOSION;
        backgrounds[4] = "elohim2";
        screens[4].attach("But then, with the next blast from the huge ship, the energy shield flickers and fails.  Maybe you aren't safe at all.\n\n");
        screens[4].attach("It's only now that you realize that watching the clash between these advanced technologies was probably not the most mindful use of your time.  Was there something else you could have done to prepare for what's about to happen next?\n\n");
        screens[4].attach("By now, it's too late.  The lines of energy alongside the ship begin to brighten one more time.");

        sounds[5] = Effect.EXPLOSION;
        backgrounds[5] = "black";
        screens[5].attach("This time, they score a direct hit on the city.  The shockwave spreads outward, causing the buildings to collapse like a house of cards.  A rumble from up above is the only warning you have before you're caught up in the destruction.\n\n");
        screens[5].attach("A heavy impact knocks you down to the ground.");

        screens[6].attach("You briefly lose consciousness.  When you wake up, you find that you're trapped.  Everything is dark.  When you try to move your arms, they're blocked by layers of broken concrete.\n\n");
        screens[6].attach("But you can't just stay here and wait for rescue.  You can feel water flowing from a broken pipe or something, running down your torso and pooling around your legs.  If you don't get out of here now, then you might drown.\n\n");
        screens[6].attach("However, when you try to sit up, a white-hot spike of pain shoots through your whole body, and you start to choke on the water that abruptly starts to gush into your mouth.  It has an awful, metallic taste.\n\n");
        screens[6].attach("That's what makes you realize that it's not some broken water pipe that's soaking you.  It's your own blood.");

        screens[7].attach("You realize that you're going to die.  ");
        if (dietRoutine() == RoutineElements.CANCERJUICE) {
            screens[7].attach("Even 'cancer juice' can't save you from this kind of catastrophic damage.  You're feeling hotter and hotter, steam beginning to rise from your wounds.\n\n");
            screens[7].attach(Heilig() + " warned you about this.  When an injury is bad enough, the waste heat from the nanomachines trying to repair your body becomes so intense that it causes burns.  And as they try to repair the burns, they'll grow even hotter and cause more burns in turn.\n\n");
            screens[7].attach("At least you'll probably pass out from blood loss before you burst into flames.  Already, you can feel your consciousness starting to grow hazy.");
        } else {
            screens[7].attach("With how the pain in your torso is starting to build up, maybe that's a mercy.  In the moment before you lost consciousness, you saw tons upon tons of debris falling toward you.  It's probably better to bleed out quickly than to slowly die of suffocation or starvation.\n\n");
            screens[7].attach("And yet you can't help but try to think of something you could do to stem the bleeding and survive long enough to be rescued.  It isn't easy to give up.\n\n");
            screens[7].attach("But it's futile.  Your legs won't listen to you, your arms are pinned in place, and your consciousness is beginning to grow hazy.");
        }

        screens[8].attach("You find yourself wondering whether anyone else was lucky enough to avoid getting killed like this.  " + Yumeno() + " was probably too busy gaming to even notice that anything was happening before the blast hit.  And... this is a weekend, so " + Hashimoto() + " was probably sleeping.  It's unlikely that either of them had a chance to escape.\n\n");
        if (getGoalLevel(6, false) > 0) {
            screens[8].attach("What about " + DuMont() + "?  " + HisHer(2) + " mansion is some distance from the city center.  ");
            if (getGoalLevel(13, false) > 0 || getGoalLevel(21, false) > 0) {
                screens[8].attach("And " + Jackal() + "?  " + HeShe(3) + "'s good at thinking on " + hisHer(3) + " feet.  ");
                if (simulatedRelationships[4].compareTo(BigInteger.ZERO) > 0) {
                    screens[8].attach("And " + Heilig() + "...  The Tower seemed to be prepared for this.  ");
                }
                screens[8].attach("Hopefully they managed to get away.\n\n");
            } else {
                screens[8].attach("Hopefully " + heShe(2) + " managed to get away.\n\n");
            }
        }
        if (currentPlaythrough.personStatus[5] == Locale.COLLEGETOWN) {
            screens[8].attach("And " + Tanaka() + "...  Maybe it would have been better to let " + himHer(5) + " be abducted.  What an absurd thought.");
        } else if (getGoalLevel(28, false) > 0) {
            screens[8].attach("At least you know that " + Tanaka() + " is relatively safe.  Maybe it's lucky that " + heShe(5) + " got abducted after all.");
        } else if (getGoalLevel(14, false) > 0) {
            screens[8].attach("And " + Tanaka() + "...  You were so close to being able to rescue " + himHer(5) + ".  But at least you know that " + heShe(5) + " wasn't caught up in this.");
        } else {
            screens[8].attach("Is " + Tanaka() + " safe?");
        }

        screens[9].attach("In any case, it's all out of your hands now.  There's nothing more you can do.  It's an oddly comforting thought.  You finally get to rest.");
    }
}
