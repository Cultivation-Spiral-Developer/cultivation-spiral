package Scenes.PlotScenes;

import Scenes.Scene;

import static Game.Game.*;

public class HashimotoRomance1Scene extends Scene {

    public HashimotoRomance1Scene() {
        super(33);
        fillSceneData();
        fillEmptyData();
        associatedEvent = PlotEvent.HASHIMOTOROMANCE1;
    }

    private void fillSceneData() {
        backgrounds[0] = "dorm";
        screens[0].attach("Coming back home without " + Tanaka() + " wasn't an easy decision.  Even if " + heShe(5) + "'s not in too much immediate danger, " + heShe(5) + "'s still effectively a prisoner of the Lunar Syndicate.  Without your help, it's hard to believe that " + heShe(5) + "'ll be able to escape from a group like that on " + hisHer(5) + " own.\n\n");
        screens[0].attach("The Lunar Syndicate is an enormous, dangerous group of criminals whose leader seems almost omniscient.  That's half the reason you came back here.  It's clear that you don't yet have the skills or the resources necessary to go up against an enemy like that.  And the best way to get those skills and resources is to come back to a place where you have friends to help you out.\n\n");
        screens[0].attach("But that's only half the reason.  The other half is that you care about the people here, too.  There's more to your life than just " + Tanaka() + ".");

        characters[1] = new String[]{"hashimoto"};
        emotions[1] = new String[]{"Uncomfy"};
        screens[1].attach("Right now, you're filling " + Hashimoto() + " in on everything that happened.  There's a lot to talk about, so the two of you might not end up getting much sleep this morning.\n\n");
        screens[1].attach("\"You went through all of that for " + Tanaka() + "'s sake?  Honestly, I'm surprised you came back...\"\n\n", 0);
        screens[1].attach("Maybe it is surprising that you managed to come back.  If " + Tanaka() + " hadn't been there to trick the Syndicate soldiers into thinking you were on their side, then you might not have made it out alive.");

        emotions[2] = new String[]{"Neutral"};
        screens[2].attach("\"That's not what I meant.  I knew from the start that you'd find a way to rescue " + Tanaka() + ".  That's just the kind of person you are.  Even if they caught you, you would've pulled some sort of super spy shit to get out of there.\"\n\n", 0);
        screens[2].attach(Hashimoto() + " might be giving you too much credit.  But setting that aside, what was " + heShe(0) + " trying to get at?\n\n");
        screens[2].attach("\"I'm surprised that you even wanted to come back.  You're in love with " + Tanaka() + ", right?  Why else would you go that far for " + himHer(5) + "?\"\n\n", 0);
        screens[2].attach(Tanaka() + " needed help, and it looked like you might have the ability to provide it.  You can want to help somebody without being in love with " + himHer(5) + ".");

        emotions[3] = new String[]{"Surprise"};
        screens[3].attach("\"Are you serious?  Don't fuck with me, here.  There's a difference between 'helping' someone, like helping them move their stuff out of their ex's house or whatever, and... and tracking them halfway across the world to pick a fight with an international crime syndicate for their sake.  You get that, right?  Those are two very different things!\"\n\n", 0);
        screens[3].attach("It's true, though.  You might have had a crush on " + Tanaka() + " for awhile, but " + heShe(5) + "'s just a friend.\n\n");
        screens[3].attach("\"If you're willing to go that far for a 'friend', then just how far would you go for somebody you actually-\"", 0);

        emotions[4] = new String[]{"Uncomfy"};
        screens[4].attach(Hashimoto() + " suddenly pauses, a dejected expression flashing across " + hisHer(0) + " face.\n\n");
        screens[4].attach("\"Oh, wait.  I get it now.  There's somebody else, right?  If you've already got your heart set on another " + guyGirl(5) + ", then...\"\n\n", 0);
        screens[4].attach("No, that isn't it, either.  With how busy you've been lately, romance has been the last thing on your mind.");

        emotions[5] = new String[]{"Surprise"};
        screens[5].attach("\"Wait, th-then... you're still single?\"\n\n", 0);
        screens[5].attach("Of course you are.  With how you're travelling around the world and putting your life on the line, it's not like you have much choice.  It wouldn't be courteous to put your " + boyGirl(5) + "friend through something like that.  They'd never be able to know when you were going to come home, or if you were going to get yourself killed.\n\n");
        screens[5].attach("\"Oh... I see.\"", 0);

        emotions[6] = new String[]{"Neutral"};
        screens[6].attach(Hashimoto() + " seems to be taken aback at first, but " + heShe(0) + " recovers quickly.  The surprise on " + hisHer(0) + " face is replaced by annoyance.\n\n");
        screens[6].attach("\"Hold on.  That's bullshit.\"\n\n", 0);
        screens[6].attach(HeShe(0) + " disapproves of you being single?\n\n");
        screens[6].attach("\"It's not that.  I just don't like your reasons.  If you love someone, then being 'courteous' shouldn't matter.  Keeping your distance 'for their sake', that's what's bullshit.\"", 0);

        emotions[7] = new String[]{"Angry"};
        screens[7].attach("But if you do get involved with someone, and then you die, then you'll be putting that person through " + hisHer(5) + " " + boyGirl(-1) + "friend's death.  That would be painful.\n\n");
        screens[7].attach("\"More painful than never being in love in the first place!?  Not a fucking chance!\"\n\n", 0);
        screens[7].attach("It looks like this is turning into another debate.  Well, getting to enjoy this sort of thing again is part of why you wanted to come back home.  You had missed this.\n\n");
        screens[7].attach("\"Don't change the subject!  I want you to promise me right now, that if you ever fall in love with somebody, you're not gonna hold back just 'cause you're worried about dying.  You need to be honest, and come right out and say-\"", 0);

        emotions[8] = new String[]{"Uncomfy"};
        screens[8].attach(Hashimoto() + " abruptly pauses mid-word.\n\n");
        screens[8].attach("\"Shit.  It happened again.\"\n\n", 0);
        screens[8].attach("What's this, now?  What exactly happened?\n\n");
        screens[8].attach("\"It always goes like this.  The more I spend time with you, the more I look at my own life and see what I'm doing wrong.  It makes me feel like an idiot for not noticing it sooner.  ", 0);
        if (getGoalLevel(10, false) < 4) {
            screens[8].attach("It's what happened when I was just pointlessly fucking with people at the arcade.  ", 0);
        } else {
            screens[8].attach("It's what happened when I realized that there was no point in spending my nights spraying graffiti that would just get cleaned up in a few days.  ", 0);
        }
        screens[8].attach("And it's happening again now.\"", 0);

        emotions[9] = new String[]{"Frown"};
        modifiers[9] = new Modifier[]{Modifier.CLOSEUP};
        screens[9].attach(HeShe(0) + " steps closer to you.\n\n");
        screens[9].attach("\"Seriously, the more time we spend together, the more I... admire you.  You're everything that I want to be.\"\n\n", 0);
        screens[9].attach("It's rare for " + Hashimoto() + " to directly praise you like this.\n\n");
        screens[9].attach("\"Yeah, well, it's pretty fucking embarrassing.  But it's the truth.  You aren't just capable- I mean, the world is full of capable shitheads who are great at making things worse for everyone else.  It's the way that you use your abilities to help people.  You're... 'real'.  And I want to be 'real' like that too.\"\n\n", 0);

        emotions[10] = new String[]{"Neutral"};
        modifiers[10] = new Modifier[]{Modifier.CLOSEUP};
        tracks[10] = Music.SILENCE;
        screens[10].attach("What brought this on?  Wasn't " + Hashimoto() + " the one who said not to change the subject.\n\n");
        screens[10].attach("\"This is still the same subject.\"\n\n", 0);
        screens[10].attach("But weren't you talking about love?\n\n");
        screens[10].attach("\"Yeah.  And what I'm saying is that I'm... I'm completely in love with you.\"", 0);

        emotions[11] = new String[]{"Uncomfy"};
        modifiers[11] = new Modifier[]{Modifier.CLOSEUP};
        screens[11].attach("Oh.  So that's what this was about.\n\n");
        screens[11].attach("\"I'm not expecting you to love me back.  ", 0);
        if (currentPlaythrough.ownGender.presentation() == Gender.MALE && currentPlaythrough.personGenders[0].presentation() == Gender.FEMALE) {
            screens[11].attach("You probably haven't even been thinking of me as a girl.  ", 0);
        } else {
            screens[11].attach("I'm just a meathead, and you're some sort of supergenius.  ", 0);
        }
        screens[11].attach("But... I don't wanna be a hypocrite, so... I have to come out and say it.\"\n\n", 0);
        screens[11].attach(Hashimoto() + " managed to maintain eye contact for the love confession itself, but it seems like that was the limit of " + hisHer(0) + " nerve.  " + HeShe(0) + " trails off, " + hisHer(0) + " gaze wandering to the side.\n\n");
        screens[11].attach("And so, " + heShe(0) + "'s surprised when you step closer to " + himHer(0) + " in turn.");

        emotions[12] = new String[]{"Surprise"};
        modifiers[12] = new Modifier[]{Modifier.CLOSEUP};
        screens[12].attach(Hashimoto() + " is making a lot of assumptions.  ");
        if (currentPlaythrough.ownGender.presentation() == Gender.MALE && currentPlaythrough.personGenders[0].presentation() == Gender.FEMALE) {
            screens[12].attach("It's true that " + heShe(0) + " isn't exactly girly, but that's never been something you especially cared about.  And ");
        } else {
            screens[12].attach("Even if it's easy to make fun of " + himHer(0) + " sometimes, that doesn't mean you've been thinking of " + himHer(0) + " as an idiot.  After all, ");
        }
        if (getGoalLevel(27, false) > 0) {
            screens[12].attach("it was " + Hashimoto() + " who showed you the importance of living life like you might die tomorrow.  ");
        } else {
            screens[12].attach(Hashimoto() + " " + himHer(0) + "self taught you some of the skills you used to track down " + Tanaka() + ".  ");
        }
        screens[12].attach("If you're worthy of admiration, then " + Hashimoto() + " deserves credit for helping you reach that point.\n\n");
        screens[12].attach("\"Oh.\"\n\n", 0);
        screens[12].attach("Not to mention that " + Hashimoto() + " is worthy of admiration in " + hisHer(0) + " own right.  In the time you've known " + himHer(0) + ", " + heShe(0) + "'s shown an unflinching willingness to change and improve " + himHer(0) + "self.  " + HeShe(0) + " never lets " + himHer(0) + "self get complacent.  " + HeShe(0) + "'s always thinking about how " + heShe(0) + " can do better.");

        emotions[13] = new String[]{"Uncomfy"};
        modifiers[13] = new Modifier[]{Modifier.CLOSEUP};
        screens[13].attach("\"You aren't saying that just to be nice, are you?\"\n\n", 0);
        screens[13].attach(Hashimoto() + " is normally so headstrong.  Why is " + heShe(0) + " having trouble accepting your praise now?\n\n");
        screens[13].attach("\"It was easy to act tough back when you seemed like some dumbass who couldn't even throw a proper punch.  But now... it feels like you've gotten ahead of me.  I'm still stuck in my own head, trying to figure my own shit out, and you're out there making a difference to other people.\"\n\n", 0);
        screens[13].attach("Why should that matter?\n\n");
        screens[13].attach("\"Because your world is getting so much bigger than mine.  Is... Is spending time with me really what you want to be doing most right now?  Am I really enough to satisfy you?\"", 0);

        emotions[14] = new String[]{"Frown"};
        modifiers[14] = new Modifier[]{Modifier.CLOSEUP};
        screens[14].attach("Now that " + Hashimoto() + " has told you about " + hisHer(0) + " feelings, you're seeing everything in a new light.  It must have been painful for " + himHer(0) + " to watch you go, thinking that those feelings were completely unrequited.  If " + heShe(0) + " had said this to you before you left, would you have been able to bring yourself to leave the country and chase after " + Tanaka() + "?\n\n");
        screens[14].attach("It's true that you had only been thinking about " + Hashimoto() + " as a friend.  But now that the possibility of being more than that has come up... it sounds wonderful.  When you left for the Metropolis, you were worried that you might never see " + himHer(0) + " again.  From now on, the two of you should spend more time together.  Though, maybe there's no need to force it, since you could well end up spending your entire lives-\n\n");
        screens[14].attach("\"Stop.  That's not what I was asking.\"\n\n", 0);
        screens[14].attach("Despite " + hisHer(0) + " hesitation a moment ago, " + Hashimoto() + "'s voice is firm now.");

        emotions[15] = new String[]{"Uncomfy"};
        modifiers[15] = new Modifier[]{Modifier.CLOSEUP};
        screens[15].attach("\"If we could settle down and live a regular life together, that... that would be great, obviously.  But I don't want you to give up what you're doing now.  If you were the kind of " + guyGirl(-1) + " who would drop everything just to spend more time with me, I never would've fallen in love with you in the first place.\"\n\n", 0);
        screens[15].attach(Hashimoto() + " hesitates.  " + HeShe(0) + "'s having trouble meeting your gaze again.\n\n");
        screens[15].attach("\"And... I mean, even if you did drop everything, you never know what could happen.  It's not like it would actually guarantee that we'd have a chance to be happy together.\"", 0);

        emotions[16] = new String[]{"Closed"};
        modifiers[16] = new Modifier[]{Modifier.CLOSEUP};
        screens[16].attach("\"So... I'm just asking you about the here and now.  Is that enough for you?  I want to know that you won't have any regrets, even if one of us dies before we have a chance to live together as", 0);
        if (currentPlaythrough.ownGender.presentation() != currentPlaythrough.personGenders[0].presentation()) {
            screens[16].attach(" boyfriend and girlfriend.\"\n\n", 0);
        } else {
            screens[16].attach("... as lovers.\"\n\n", 0);
        }
        screens[16].attach("It seems backwards that " + Hashimoto() + " is the one insisting on making sure that you're okay with the idea of your " + boyGirl(0) + "friend dying at any time.  After all, you're the one who's actually risking your life on a regular basis.  But maybe that's just " + hisHer(0) + " way of showing that " + heShe(0) + " understands what " + heShe(0) + "'s getting into.\n\n");
        screens[16].attach("Or maybe it's because you still haven't formally conceded that " + Hashimoto() + " was right about it being better to come out with your feelings than to keep them bottled up for somebody else's sake.  When you're having a debate with a friend, it's important to let " + himHer(0) + " know when " + heShe(0) + "'s gotten through to you.\n\n");
        screens[16].attach("And " + Hashimoto() + " values actions over words, so there's really only one way to admit your defeat.  You bring your face closer to " + hisHers(0) + "...");

        characters[17] = new String[0];
        backgrounds[17] = "black";
        screens[17].attach("For all " + hisHer(0) + " self-deprecating talk earlier, " + Hashimoto() + " doesn't seem surprised in the slightest to feel your lips on " + hisHer(0) + " own.  " + HeShe(0) + " returns your kiss eagerly.\n\n");
        screens[17].attach("Considering how you first met, you never would've expected your relationship with " + Hashimoto() + " to end up like this.  But now that you're here, it feels surprisingly natural.  " + HisHer(0) + " tongue pushes against your lips, and you find yourself opening them so that you can explore each other's mouths.\n\n");
        screens[17].attach(HisHer(0) + " arms tighten around you.  It's been awhile since you've scuffled, so you had almost forgotten just how fit " + Hashimoto() + " is.  But with only a small grunt of effort, " + heShe(0) + " lifts you off your feet and pushes you down onto your bed.");

        sounds[18] = Effect.RUSTLE;
        screens[18].attach("Things are suddenly moving very fast.  While you were kissing, apparently " + Hashimoto() + " was already starting to get undressed.\n\n");
        screens[18].attach("And as " + heShe(0) + " climbs atop you, " + heShe(0) + " sheds the last of " + hisHer(0) + " clothes.  Normally, when " + Hashimoto() + " would come to take a nap at your place, " + heShe(0) + " would sleep with all " + hisHer(0) + " clothes on.  But now, as you look up at " + himHer(0) + ", you can see all of " + Hashimoto() + "'s body for the first time.");

        backgrounds[19] = "hashimotoh1";
        tracks[19] = Music.MOMENTS;
        screens[19].attach("It seems like " + Hashimoto() + "'s done holding back.  Does " + heShe(0) + " really not want to start with some foreplay or something?\n\n");
        screens[19].attach("\"I hate wasting time.  You know that.  So, let's just get to it.\"\n\n", 0);
        if (currentPlaythrough.ownGender != Gender.FEMALE) {
            screens[19].attach("You don't have any objections, but...");

            backgrounds[20] = "hashimotoh2";
            screens[20].attach(Hashimoto() + " presses " + hisHer(0) + " crotch down on yours, then frowns, shifting " + himHer(0) + "self left and right as if searching for something.\n\n");
            screens[20].attach("\"Hold on.  Why aren't you hard?  Am I doing something wrong?\"\n\n", 0);
            screens[20].attach("Well, the two of you have just been talking about death and stuff.  It's not exactly the most titillating subject.\n\n");
            screens[20].attach("\"Shit.  That's my bad.\"\n\n", 0);
            screens[20].attach("It should still work out eventually.  Maybe you can help make " + Hashimoto() + " feel good in the meantime?");

            screens[21].attach("\"No.  I've got something I wanna try.  How does this feel?\"\n\n", 0);
            screens[21].attach(Hashimoto() + " relaxes " + hisHer(0) + " legs, letting " + hisHer(0) + " weight press down on your crotch.  Then, " + heShe(0) + " starts to slide " + himHer(0) + "self forward and back.\n\n");
            screens[21].attach("You can feel " + himHer(0) + " rubbing against you through your pants.  It feels good, but more than that, the sight of " + hisHer(0) + " slit moving against you is mesmerizing.");

            screens[22].attach("Slowly but surely, you can feel your shaft starting to wake up.  But it's still a bit awkward to just lay here while " + Hashimoto() + " does all the work.  You aren't sure what you're supposed to be doing with your hands.\n\n");
            screens[22].attach("\"Just relax and enjoy it.  You don't always have to be 'doing something'.\"\n\n", 0);
            screens[22].attach("You never thought you'd hear " + Hashimoto() + " say something like that.\n\n");
            screens[22].attach("\"You know what I'm trying to say.  Just let me do this, alright?  I'm trying to focus.\"\n\n", 0);
            screens[22].attach("You do as " + Hashimoto() + " asks.  More and more, the sense of pressure between your legs is turning into surges of pleasure with every movement of " + Hashimoto() + "'s hips.  And then...");

            backgrounds[23] = "hashimotoh3";
            screens[23].attach("\"Looks like you're ready.\"\n\n", 0);
            screens[23].attach("Once " + heShe(0) + " feels your hardness underneath " + himHer(0) + ", " + Hashimoto() + " unzips your pants to let your cock out.  You're definitely ready.  ");
            if (currentPlaythrough.personGenders[0].presentation() == Gender.FEMALE) {
                screens[23].attach("But what about " + Hashimoto() + "?\n\n");
                screens[23].attach("\"I'm fine.  Let's just do it.\"\n\n", 0);
                screens[23].attach("Is " + heShe(0) + " really fine?  It looks like it's going to be a tight fit.");
            } else {
                screens[23].attach("But before you start, shouldn't you put on some lube or something?\n\n");
                screens[23].attach("\"Didn't bring any.  I wasn't planning on doing this.  But I'll be fine.\"\n\n", 0);
                screens[23].attach("Will " + heShe(0) + " really be fine?  ");
            }
            screens[23].attach(" Maybe it would be better to slow down and-");

            backgrounds[24] = "hashimotoh4";
            screens[24].attach(Hashimoto() + " slams " + hisHer(0) + " hips downward, and the jolt of pleasure causes your mind to blank out.  You reflexively drive yourself upward to meet " + himHer(0) + ", and you end up buried balls-deep inside.\n\n");
            screens[24].attach("\"Guh.  Ow.\"\n\n", 0);
            if (currentPlaythrough.personGenders[0] != Gender.MALE) {
                screens[24].attach(HeShe(0) + "'s bleeding, and " + heShe(0) + "'s obviously in pain.  ");
            } else {
                screens[24].attach("There's no way that this is feeling good for " + himHer(0) + ".  ");
            }
            screens[24].attach(HeShe(0) + " shouldn't be trying to act tough.  " + HeShe(0) + " should be giving you a chance to give some pleasure to " + himHer(0) + ", too.\n\n");
            screens[24].attach("\"Shut up.  I'm not doing this to feel good.\"", 0);

            screens[25].attach(HeShe(0) + " lifts " + hisHer(0) + " hips, and it feels like your cock is being sucked upward.  You're arching your back, your mind going blank again.  Inch by inch, your shaft slides out from the tight grip of " + Hashimoto() + "'s ");
            if (currentPlaythrough.personGenders[0] == Gender.MALE) {
                screens[25].attach("ass.\n\n");
            } else {
                screens[25].attach("lower lips.\n\n");
            }
            screens[25].attach("\"You're the one who needs to stop acting tough.  It feels good, right?\"\n\n", 0);
            screens[25].attach(HeShe(0) + " pushes " + hisHer(0) + " hips down, swallowing your shaft all the way to the base.\n\n");
            screens[25].attach("\"So stop fighting it.\"", 0);

            screens[26].attach(HeShe(0) + "'s right.  Even if you weren't caught in the iron grip of " + Hashimoto() + "'s thighs, you might not have the willpower to pull out.  The tight wetness sliding up and down your cock feels too good.\n\n");
            screens[26].attach("Whenever " + heShe(0) + " stops, you can briefly regain your sanity.  But then " + heShe(0) + " moves, and you're completely at " + hisHer(0) + " mercy.  " + HeShe(0) + " slides " + himHer(0) + " self down your shaft, and your body responds completely by reflex, driving it deep inside " + himHer(0) + ".  " + HeShe(0) + " slides back upward, and you feel like " + heShe(0) + "'s trying to suck you dry.\n\n");
            screens[26].attach("\"If you want to make it easier on me, then just cum right away.  Let it all out inside me.\"\n\n", 0);
            screens[26].attach(HeShe(0) + " punctuates " + hisHer(0) + " words with another movement of " + hisHer(0) + " hips.  At first, " + heShe(0) + " was going slowly enough that you had time to think in between each burst of pleasure.  But now " + heShe(0) + "'s starting to go faster.");

            screens[27].attach("Your hips move in unison.  At this rate, you really are going to cum.  You can't even gather your thoughts enough to speak.\n\n");
            screens[27].attach("\"Aah...\"\n\n", 0);
            screens[27].attach("But it seems like " + Hashimoto() + " might be starting to enjoy this, too.  That breathy sigh is the first sign you've seen that " + heShe(0) + "'s feeling any pleasure from this.\n\n");
            screens[27].attach(HisHer(0) + " movements are beginning to change.  At first, " + heShe(0) + " was very steady and deliberate, moving " + himHer(0) + "self all the way down your cock, then back up so that you'd almost slip out.  It felt great to have the entire length of your shaft stimulated like that, but it was still very clear that " + Hashimoto() + " was consciously thinking about every movement.");

            screens[28].attach("Now, though, " + hisHer(0) + " movements are becoming passionate, instinctive.  " + HeShe(0) + " takes you deep inside, then grinds forward and back, so that you repeatedly strike " + hisHer(0) + " deepest places.  " + HeShe(0) + " might be getting overwhelmed by the pleasure, too.\n\n");
            screens[28].attach("\"Go on... cum...!\"\n\n", 0);
            screens[28].attach("You'd like to see even more of that.  You'd like to make " + himHer(0) + " feel this good too, to the point that " + heShe(0) + "'ll stop thinking of this as something " + heShe(0) + "'s just doing to make you feel good...");

            backgrounds[29] = "hashimotoh5";
            screens[29].attach("But you can't hold back any longer.  Your movements become spasmic, going out of synch with " + Hashimoto() + ", as you reach your orgasm.  White-hot pleasure flashes through your lower body, and the next thing you know, you've gone completely limp with " + Hashimoto() + " atop you.\n\n");
            screens[29].attach("\"Haah... I did it.\"\n\n", 0);
            screens[29].attach(HeShe(0) + " certainly looks satisfied.");

            screens[30].attach("Was it good for " + Hashimoto() + " too?\n\n");
            screens[30].attach("\"Yeah.  Honestly, I expected it to hurt more, but it wasn't bad at all.\"\n\n", 0);
            screens[30].attach("It wasn't bad, but it seems like it wasn't exactly great, either.  " + Hashimoto() + " was so focused on your pleasure that " + heShe(0) + " didn't give you much of a chance to make " + himHer(0) + " feel good too.\n\n");
            screens[30].attach("Maybe you'll be able to do better next time.");

            backgrounds[31] = "black";
            screens[31].attach(Hashimoto() + " lays " + himHer(0) + "self down on the bed next to you.  Seems like you won't need to take turns sleeping on the couch anymore.\n\n");
            screens[31].attach("\"I hope you'll remember this when you're out there, doing the things you need to do.\"\n\n", 0);
            screens[31].attach("You definitely will.  And you'll be looking forward to coming home to " + Hashimoto() + ".\n\n");
            screens[31].attach("\"... Yeah.  So make sure you survive.  I'll do my best to survive, too.\"", 0);

            screens[32].attach(Hashimoto() + " ended up doing most of the work, but you're still pretty tired out, both emotionally and physically.  Fortunately, you had known that you wouldn't be getting much sleep this morning, with all the catching up you were going to do with " + Hashimoto() + ".  You sleep well, and you wake up feeling pretty good.\n\n");
            screens[32].attach("You may be " + Hashimoto() + "'s " + boyGirl(-1) + "friend now, but you don't really feel any different.  All your old reasons for wanting to save " + Tanaka() + " still stand.  But now, you have one more reason: " + Hashimoto() + " is expecting you to succeed.  You don't want to disappoint " + himHer(0) + ", do you?");
        } else {
            screens[19].attach("");
        }
    }
}
