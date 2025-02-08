package Scenes;

import Game.Game;

import java.io.Serial;
import java.io.Serializable;
import java.util.Arrays;

public class Scene implements Serializable {
    @Serial
    private static final long serialVersionUID = 4L;

    public boolean loopEnd;
    public boolean dayEnd = false;
    public int associatedGoalIndex;
    public int associatedGoalTier;
    public Game.PlotEvent associatedEvent;

    public Game.WindowContents[] screens;
    public String[] backgrounds;
    public String[][] characters;
    public String[][] outfits;
    public String[][] emotions;
    public Game.Music[] tracks;
    public Game.Effect[] sounds;
    public Game.Modifier[][] modifiers;

    public Scene(int length) {
        screens = new Game.WindowContents[length];
        backgrounds = new String[length];
        characters = new String[length][0];
        outfits = new String[length][0];
        emotions = new String[length][0];
        tracks = new Game.Music[length];
        sounds = new Game.Effect[length];
        modifiers = new Game.Modifier[length][0];

        for (int i = 0; i < length; i++) {
            screens[i] = new Game.WindowContents();
            backgrounds[i] = "";
        }
    }

    /**
     * Checks for equality by comparing the contents of this Scene to another.
     * @param other The other Scene to compare
     * @return True if both contain the same contents, otherwise false.
     */
    public boolean equals(Scene other) {
        return other != null
                && loopEnd == other.loopEnd
                && dayEnd == other.dayEnd
                && associatedGoalIndex == other.associatedGoalIndex
                && associatedGoalTier == other.associatedGoalTier
                && associatedEvent == other.associatedEvent
                && Arrays.equals(screens, other.screens, (o1, o2) -> o1.equals(o2) ? 0 : -1)
                && Arrays.equals(backgrounds, other.backgrounds)
                && Arrays.deepEquals(characters, other.characters)
                && Arrays.deepEquals(outfits, other.outfits)
                && Arrays.deepEquals(emotions, other.emotions)
                && Arrays.equals(tracks, other.tracks)
                && Arrays.equals(sounds, other.sounds)
                && Arrays.deepEquals(modifiers, other.modifiers);
    }

    /**
     * Fills missing background, character, outfit, and emotion data with data from prior elements.
     */
    protected void fillEmptyData() {
        String storedBackground = null;
        String[] storedCharacters = new String[0];
        String[] storedOutfits = new String[0];
        String[] storedEmotions = new String[0];

        for (int i = 0; i < screens.length; i++) {
            if (backgrounds[i] == null || backgrounds[i].isEmpty()) {
                backgrounds[i] = storedBackground;
            } else {
                storedBackground = backgrounds[i];
            }
            if ((characters[i] == null || characters[i].length == 0) && emotions[i] != null && emotions[i].length == storedEmotions.length) {
                characters[i] = storedCharacters;
                if (emotions[i].length == 0) {
                    emotions[i] = storedEmotions;
                }
            } else {
                storedCharacters = characters[i];
                storedEmotions = emotions[i];
            }
            if (outfits[i] == null || outfits[i].length == 0) {
                outfits[i] = storedOutfits;
            } else {
                storedOutfits = outfits[i];
            }
        }
    }
}
