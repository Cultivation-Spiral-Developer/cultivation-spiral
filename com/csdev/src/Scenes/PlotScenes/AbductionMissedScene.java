package Scenes.PlotScenes;

import Scenes.Scene;

import java.math.BigInteger;

import static Game.Game.*;

public class AbductionMissedScene extends Scene {

    public AbductionMissedScene() {
        super(getGoalLevel(6, false) > 0 ? 8 : 5);
        fillSceneData();
        fillEmptyData();
        dayEnd = true;
        associatedEvent = PlotEvent.ABDUCTIONMISSED;
    }

    private void fillSceneData() {
        if (getGoalLevel(6, false) > 0) {
            tracks[0] = Music.SILENCE;
            backgrounds[0] = "dorm";
            if (currentPlaythrough.weeklyActions[weekDayNumber()][5].baseCost.compareTo(BigInteger.ZERO) < 0) {
                screens[0].attach("The next morning, you're woken up by a phone call.  ");
            } else {
                screens[0].attach("You get home as the sun begins to rise.  But before you can get settled in, you receive a phone call.  ");
            }
            screens[0].attach("It's " + DuMont() + ".  What could " + heShe(2) + " want to talk to you about?");

            backgrounds[1] = "callingMansion";
            characters[1] = new String[]{"", "dumont"};
            emotions[1] = new String[]{"", "Sad"};
            screens[1].attach("\"I have bad news.  You might want to sit down.\"\n\n", 2);
            screens[1].attach("For " + himHer(2) + " to say that as soon as you pick up, it really must be something serious.\n\n");
            screens[1].attach("\"It's about your friend, " + fullName(5) + ".\"\n\n", 2);
            screens[1].attach("You've mentioned " + Tanaka() + " to " + DuMont() + " in passing before.  But why would " + DuMont() + " be calling you about " + himHer(5) + "?");

            emotions[2] = new String[]{"", "Neutral"};
            tracks[2] = Music.REPORTING;
            screens[2].attach("\"On " + hisHer(5) + " way home from class yesterday, " + heShe(5) + " was abducted.\"\n\n", 2);
            screens[2].attach("It takes a moment for " + DuMont() + "'s words to settle in.  " + Tanaka() + " had asked you to walk " + himHer(5) + " home yesterday.  ");
            if (getGoalLevel(1, false) > 3) {
                screens[2].attach("But with how much time you've been spending together lately, skipping one afternoon didn't seem like a big deal.\n\n");
            } else if (getGoalLevel(1, false) == 3) {
                screens[2].attach("But now that " + heShe(5) + "'s made it clear that " + heShe(5) + "'s not really interested in you, you didn't take " + himHer(5) + " seriously.\n\n");
            } else {
                screens[2].attach("But you've been busy with other things, so you didn't take " + himHer(5) + " up on it.\n\n");
            }
            screens[2].attach("\"Are you alright?\"\n\n", 2);
            screens[2].attach("You're pretty sure that you're alright.  But what about " + Tanaka() + "?  Who took " + himHer(5) + "?  Are they demanding a ransom?");

            emotions[3] = new String[]{"", "Uncomfy"};
            screens[3].attach("\"There hasn't been any ransom demand.  The identity of the abductors is unknown.  I did hire somebody to look into it overnight...\"\n\n", 2);
            screens[3].attach("And?\n\n");
            screens[3].attach("\"It doesn't look good.  Whoever they were, they fled the country, and they probably took " + Tanaka() + " with them.  They could be anywhere in the world by now.  The police have already pretty much given up.\"\n\n", 2);
            screens[3].attach("What about " + DuMont() + "?  Has " + heShe(2) + " given up?  Can " + heShe(2) + " hire some more investigators to try and track " + Tanaka() + " down?\n\n");
            screens[3].attach("\"... I'm sorry.\"", 2);

            emotions[4] = new String[]{"", "Sad"};
            screens[4].attach("\"There are dozens of abductions every year in this city alone.  If I made a habit of trying to solve them all myself, then I'd have bankrupted myself years ago, and the two of us never would have met.\"\n\n", 2);
            screens[4].attach("Then why is " + DuMont() + " even calling you about this?\n\n");
            screens[4].attach("\"I just thought you should hear about it from me first.\"", 2);

            emotions[5] = new String[]{"", "Uncomfy"};
            screens[5].attach("Well, " + DuMont() + "'s help might not be necessary.  You're making some money of your own right now.  It's not even close to " + DuMont() + "'s fortune, but ");
            if (getGoalLevel(1, false) > 3) {
                screens[5].attach(Tanaka() + " needs your help.  ");
            } else if (getGoalLevel(1, false) == 3) {
                screens[5].attach("even if " + Tanaka() + " doesn't actually care about you, leaving " + himHer(5) + " at the mercy of whoever abducted " + himHer(5) + " would be pretty cold.  ");
            } else {
                screens[5].attach("leaving " + Tanaka() + " at the mercy of whoever abducted " + himHer(5) + " would be pretty cold.  ");
            }
            screens[5].attach("There ought to be something you can do.\n\n");
            screens[5].attach("\"About that...  I can put you in touch with the same fixer I hired last night to look into the situation.  " + HeShe(3) + "'s already told me that " + heShe(3) + "'d be willing to continue " + hisHer(3) + " investigation for the right price.\"\n\n", 2);
            screens[5].attach("If that price was too high for " + DuMont() + ", then it's hard to imagine that you'll be able to afford it anytime soon.\n\n");
            screens[5].attach("\"I expect that the price " + heShe(3) + "'ll quote for you is quite a bit lower than the one " + heShe(3) + " quoted for me.\"", 2);

            emotions[6] = new String[]{"", "Neutral"};
            screens[6].attach("\"" + HeShe(3) + "'s a friend, and I've put my life in " + hisHer(3) + " hands more than once.  Frankly, I wouldn't recommend spending your savings chasing after someone who might already be beyond saving.  But if you're going to do it anyway, then you might as well use it to hire the person with the best chance of success.\"\n\n", 2);
            screens[6].attach(DuMont() + " thinks you should just write " + Tanaka() + " off as a lost cause?\n\n");
            screens[6].attach("\"You can't stop every tragedy.  It's important to focus your resources on the people you can actually save.\"", 2);

            backgrounds[7] = "dorm";
            characters[7] = new String[0];
            screens[7].attach("You talk with " + DuMont() + " a bit more, and " + heShe(2) + " tells you everything " + heShe(2) + " was able to find out about the abduction.  " + DuMont() + " also gives you the contact information for the fixer.  Apparently " + heShe(3) + "'s a regular at " + DuMont() + "'s nightclub");
            if (getAttributeLevel(2, false).compareTo(BigInteger.valueOf(3)) > 0) {
                screens[7].attach(", and you probably already have enough money to get " + hisHer(3) + " attention.  It's up to you to decide whether to approach " + himHer(3) + ".\n\n");
            } else {
                screens[7].attach(", so as soon as you have the money, it'll be as simple as approaching " + himHer(3) + " there.\n\n");
            }
            screens[7].attach("Afterward, you lay down on your bed for awhile and think about " + Tanaka() + ".  What should you do now?");
        } else {
            tracks[0] = Music.SILENCE;
            backgrounds[0] = "dorm";
            if (currentPlaythrough.weeklyActions[weekDayNumber()][5].baseCost.compareTo(BigInteger.ZERO) < 0) {
                screens[0].attach("The next morning, you're woken up by a phone call.  ");
            } else {
                screens[0].attach("You get home as the sun begins to rise.  But before you can get settled in, you receive a phone call.  ");
            }
            screens[0].attach("It's one of your acquaintances from " + Tanaka() + "'s group of admirers.  You aren't really close with " + himHer(-1) + ", so it's surprising to get a call like this.");

            screens[1].attach(HeShe(-1) + " tells you what happened, but the words don't register at first.  It seems like this must just be some sort of stupid prank.  You almost hang up on " + himHer(-1) + ".\n\n");
            screens[1].attach("But " + hisHer(-1) + " serious tone of voice eventually gets it across to you.  This isn't a joke.");

            tracks[2] = Music.REPORTING;
            screens[2].attach(Tanaka() + " was abducted on " + hisHer(5) + " way home from class yesterday.\n\n");
            screens[2].attach(HeShe(5) + " had asked you to walk " + himHer(5) + " home.  ");
            if (getGoalLevel(1, false) > 3) {
                screens[2].attach("But with how much time you've been spending together lately, skipping one afternoon didn't seem like a big deal.\n\n");
            } else if (getGoalLevel(1, false) == 3) {
                screens[2].attach("But now that " + heShe(5) + "'s made it clear that " + heShe(5) + "'s not really interested in you, you didn't take " + himHer(5) + " seriously.\n\n");
            } else {
                screens[2].attach("But you've been busy with other things, so you didn't take " + himHer(5) + " up on it.\n\n");
            }
            screens[2].attach("Could you have stopped this from happening?");

            screens[3].attach("Apparently " + Tanaka() + "'s admirers are all going to pool their resources and try to hire a private investigator or something to track " + himHer(5) + " down.  There's been some talk of searching online, or perhaps even using the dark web, but their consensus is that it'd be better to meet someone face-to-face in order to judge whether they seem competent and trustworthy enough.  And fortunately, there seems to be a good place to do just that.\n\n");
            screens[3].attach("Over on the bad side of town, there's a nightclub which is known as a notorious gathering hub for individuals who operate in the gray areas of the law.  It wouldn't even be surprising if the people who abducted " + Tanaka() + " were actually regulars there.  In order to catch them, it might be necessary to descend to their level.");

            screens[4].attach("At this moment, some of " + Tanaka() + "'s most fervent fans are emptying their bank accounts and taking out loans.  You don't really have the financial leverage to do something like that.  But now that you know where everybody will be gathering, maybe there's some other way for you to help.");
        }
    }
}
