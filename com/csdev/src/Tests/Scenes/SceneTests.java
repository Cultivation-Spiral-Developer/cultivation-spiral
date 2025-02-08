package Tests.Scenes;

import Game.Game;
import Scenes.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class SceneTests {
    @Test
    void equals_oneNull_returnsFalse() {
        var scene = new Scene(1);
        assertFalse(scene.equals(null));
    }

    @Test
    void equals_differentLength_returnsFalse() {
        var scene1 = new Scene(1);
        var scene2 = new Scene(2);
        assertFalse(scene1.equals(scene2));
    }

    @Test
    void equals_differentBoldContents_returnsFalse() {
        var scene1 = new Scene(1);
        scene1.screens[0] = new Game.WindowContents();
        scene1.screens[0].attach("TEST", 1, false);

        var scene2 = new Scene(1);
        scene2.screens[0] = new Game.WindowContents();
        scene2.screens[0].attach("TEST", 1, true);

        assertFalse(scene1.equals(scene2));
    }

    @Test
    void equals_differentColorContents_returnsFalse() {
        var scene1 = new Scene(1);
        scene1.screens[0] = new Game.WindowContents();
        scene1.screens[0].attach("TEST", 1, false);

        var scene2 = new Scene(1);
        scene2.screens[0] = new Game.WindowContents();
        scene2.screens[0].attach("TEST", 2, false);

        assertFalse(scene1.equals(scene2));
    }

    @Test
    void equals_differentTextContents_returnsFalse() {
        var scene1 = new Scene(1);
        scene1.screens[0] = new Game.WindowContents();
        scene1.screens[0].attach("TEST", 1, false);

        var scene2 = new Scene(1);
        scene2.screens[0] = new Game.WindowContents();
        scene2.screens[0].attach("TEST2", 1, false);

        assertFalse(scene1.equals(scene2));
    }

    @Test
    void equals_sameContents_returnsTrue() {
        var scene1 = new Scene(1);
        scene1.screens[0] = new Game.WindowContents();
        scene1.screens[0].attach("TEST", 1, true);
        scene1.backgrounds[0] = "TEST";
        scene1.loopEnd = false;

        var scene2 = new Scene(1);
        scene2.screens[0] = new Game.WindowContents();
        scene2.screens[0].attach("TEST", 1, true);
        scene2.backgrounds[0] = "TEST";
        scene2.loopEnd = false;

        assertTrue(scene1.equals(scene2));
    }
}
