package Scenes.PlotScenes;

import Scenes.Scene;

import static Game.Game.*;

public class MetropolisInvasionScene extends Scene {

    public MetropolisInvasionScene() {
        super(9);
        fillSceneData();
        fillEmptyData();
        loopEnd = true;
        associatedEvent = PlotEvent.METROPOLISINVASION;
    }

    private void fillSceneData() {
        backgrounds[0] = "black";
        if (getGoalLevel(28, true) > 0) {
            screens[0].attach("It's December 28th, the last day before the Lunar Syndicate's planned coup.  In the end, you weren't able to finalize a foolproof plan for " + Tanaka() + " to fake " + hisHer(5) + " own death, but ");
            if (getGoalLevel(1, true) >= 4) {
                screens[0].attach(heShe(5) + " still seems to have been bolstered by the knowledge that " + Artemis() + " shouldn't be able to find you, let alone retaliate against you, even if " + heShe(17) + " does find out about " + Tanaka() + "'s desertion.  ");
            } else {
                screens[0].attach(heShe(5) + " says that you really helped " + himHer(5) + " work up the courage to go through with the idea.  ");
            }
            screens[0].attach(HeShe(5) + " plans to just keep " + hisHer(5) + " eyes open and look for an opportunity to slip away from the Syndicate during the fighting.\n\n");
            screens[0].attach("As for your part, it's time to leave the city.  " + Tanaka() + " will have an easier time escaping if " + heShe(5) + " doesn't have a non-Syndicate civilian like you accompanying " + himHer(5) + ".  Your things are already packed, and you and " + Tanaka() + " have planned a rendezvous point a few towns away.  All that's left is to rent a car and load it with your luggage.\n\n");
        } else {
            screens[0].attach("As far as you knew, this was just supposed to be another regular day.  You had planned on going about your regular business, looking forward to a new year in this new city, continuing your meteoric rise to wealth and success\n\n");
        }
        screens[0].attach("But before the sun has even completely risen, the sound of distant explosions tells you that something has gone horribly wrong.");

        backgrounds[1] = "coup";
        tracks[1] = Music.SILENCE;
        screens[1].attach("The city is under attack.  Foreign soldiers and their war machines move through the streets, clearing each building in turn.  Members of the local police and military are disarmed and taken into custody, along with other 'persons of interest' and anybody unable to present their identification to the soldiers.  The entire city is being locked down.\n\n");
        if (getGoalLevel(28, true) > 0) {
            screens[1].attach("Without a doubt, this is the coup that was supposed to happen on the 30th.  Was " + Artemis() + "'s information wrong?");

            screens[2].attach("You don't have time for idle questions.  ");
        } else {
            screens[1].attach("This is obviously some sort of coup.  The soldiers' vehicles are equipped with loudspeakers which broadcast an announcement that they're here to assist the 'legitimate' government in keeping the peace.  The message is spoiled somewhat by the sounds of sporadic gunfire echoing across the city.");

            screens[2].attach("It shouldn't have anything to do with you, but unfortunately, you're in the wrong place at the wrong time.  ");
        }
        screens[2].attach("By the time you realize what's happening, there are already soldiers on the street outside.  If you try to go outside and make a run for freedom, you'll just be shot.  You can only wait helplessly until they make their way to your building.\n\n");
        screens[2].attach("When the soldiers arrive, they check your papers and immediately find them suspicious.  Because you're such a recent arrival to this city, there's not much to prove that you're really who you say you are.  It must look like you're hiding your true identity.\n\n");
        screens[2].attach("They take you at gunpoint to a makeshift detention center.");

        backgrounds[3] = "black";
        screens[3].attach("As you wait for them to realize that you're no threat to the new regime, the days turn into weeks and then months.");

        screens[4].attach("The conditions in the detention center are poor.  You don't get much food, and they make the prisoners perform hard labor in order to keep them too busy to plot escape.  The soldiers keeping watch seem to lack a sense of empathy, and because you're a foreigner, even the other prisoners are reluctant to talk with you.\n\n");
        screens[4].attach("All the while, you hear scattered rumors about what's happening outside.  It sounds like the whole world is being engulfed by war.  Entire cities are being wiped off the map.  As long as you're stuck in here, you have no way of verifying which of those rumors are fact and which are fiction.\n\n");
        screens[4].attach("But you're smart and strong.  It doesn't take long before you start to pick up the language of the invaders as well.  You're able to build a stockpile of improvised tools in an out-of-the-way corner of the detention camp.  A plan to break out begins to come together.");

        screens[5].attach("However, one day, you wake to find that your body is no longer obeying your commands.  You open your eyes, but all you can see is darkness.\n\n");
        screens[5].attach("At first, the soldiers just think that you're pretending to be sick in order to get out of your daily hard labor.  But it soon becomes clear that you really do lack the strength to even lift your head.  After a discussion with their superiors, they decide to throw you in a solitary cell and just wait to see if you recover on your own.\n\n");
        screens[5].attach("One soldier grabs you by the shoulders and another grabs you by the feet, and together, they haul you to the other side of the detention center.");

        screens[6].attach("\"Another one dying of exhaustion?  If we're gonna work 'em all to death, it'd make more sense to just shoot 'em and get it over with.\"\n\n");
        screens[6].attach("\"No, it's definitely not exhaustion.  I saw this one in the work yard the other day, " + heShe(-1) + " was holding up fine.\"\n\n");
        screens[6].attach("The soldiers engage in idle speculation about your fate, and you don't even have the strength to speak up.  You don't have any idea about what's wrong with you, either.  Are you going to die?  It seems like you are.");

        screens[7].attach("\"If some weird disease breaks out among the prisoners, then maybe I should file for a transfer to the front lines.  At least the combat pay would be nice.\"\n\n");
        screens[7].attach("\"Why do you need combat pay?  You'll just spend it all on superchats.\"\n\n");
        screens[7].attach("\"Hey, those superchats are money well spent.  " + fullName(8) + " is the light of my life.\"\n\n");
        screens[7].attach("They make light banter with each other, seemingly unbothered by the act of carrying a soon-to-be corpse.  Even as they talk, it becomes more and more difficult to make out the words.  Your ears are beginning to fail just like your eyes.");

        screens[8].attach("The only consolation is that it's not a painful death.  Every single one of your senses is fading away.  The world feels unreal.\n\n");
        screens[8].attach("By the time the soldiers stop walking, you're already gone.");
    }
}
