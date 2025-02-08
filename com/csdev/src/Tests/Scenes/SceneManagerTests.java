package Tests.Scenes;

import Game.Game;
import Scenes.SceneManager;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

// TODO: expand these to cover differences in scenes based on game progression
// May need to wait until after refactor of game state management for easier testing.
public class SceneManagerTests {
    static Game game;
    static SceneManager sceneManager;

    @BeforeAll
    static void setup() {
        game = new Game();
        sceneManager = new SceneManager();
    }

    @Test
    void getPlotScene_ABDUCTIONMISSED_returnsValidScene() {
        var plotEvent = Game.PlotEvent.ABDUCTIONMISSED;

        var scene = sceneManager.getPlotScene(plotEvent);

        assertSceneHasFilledScreens(scene, 5);
        assertEquals(plotEvent, scene.associatedEvent);
        assertFalse(scene.loopEnd);
        assertTrue(scene.dayEnd);

        var gameScene = Game.getPlotScene(plotEvent);
        assertTrue(scene.equals(gameScene));
    }

    @Test
    void getPlotScene_COLLEGETOWNDESTRUCTION_returnsValidScene() {
        var plotEvent = Game.PlotEvent.COLLEGETOWNDESTRUCTION;

        var scene = sceneManager.getPlotScene(plotEvent);

        assertSceneHasFilledScreens(scene, 10);
        assertEquals(plotEvent, scene.associatedEvent);
        assertTrue(scene.loopEnd);
        assertFalse(scene.dayEnd);

        var gameScene = Game.getPlotScene(plotEvent);
        assertTrue(scene.equals(gameScene));
    }

    @Test
    void getPlotScene_HELINTRO_returnsValidScene() {
        var plotEvent = Game.PlotEvent.HELINTRO;

        var scene = sceneManager.getPlotScene(plotEvent);

        assertSceneHasFilledScreens(scene, 5);
        assertEquals(plotEvent, scene.associatedEvent);
        assertTrue(scene.loopEnd);
        assertFalse(scene.dayEnd);

        var gameScene = Game.getPlotScene(plotEvent);
        assertTrue(scene.equals(gameScene));
    }

    @Test
    void getPlotScene_METROPOLISINVASION_returnsValidScene() {
        var plotEvent = Game.PlotEvent.METROPOLISINVASION;

        var scene = sceneManager.getPlotScene(plotEvent);

        assertSceneHasFilledScreens(scene, 9);
        assertEquals(plotEvent, scene.associatedEvent);
        assertTrue(scene.loopEnd);
        assertFalse(scene.dayEnd);

        var gameScene = Game.getPlotScene(plotEvent);
        assertTrue(scene.equals(gameScene));
    }

    @Test
    void getPlotScene_HASHIMOTOROMANCE1_returnsValidScene() {
        var plotEvent = Game.PlotEvent.HASHIMOTOROMANCE1;

        var scene = sceneManager.getPlotScene(plotEvent);

        assertSceneHasFilledScreens(scene, 33);
        assertEquals(plotEvent, scene.associatedEvent);
        assertFalse(scene.loopEnd);
        assertFalse(scene.dayEnd);

        var gameScene = Game.getPlotScene(plotEvent);
        assertTrue(scene.equals(gameScene));
    }

    @Test
    void getPlotScene_YUMENOROMANCE1_returnsValidScene() {
        var plotEvent = Game.PlotEvent.YUMENOROMANCE1;

        var scene = sceneManager.getPlotScene(plotEvent);

        assertSceneHasFilledScreens(scene, 20);
        assertEquals(plotEvent, scene.associatedEvent);
        assertFalse(scene.loopEnd);
        assertFalse(scene.dayEnd);

        var gameScene = Game.getPlotScene(plotEvent);
        assertTrue(scene.equals(gameScene));
    }

    static void assertSceneHasFilledScreens(Scenes.Scene scene, int count) {
        assertNotNull(scene);
        assertEquals(count, scene.screens.length);

        for (var screen : scene.screens) {
            assertNotNull(screen);
            assertNotNull(screen.texts);
            assertTrue(screen.texts.length > 0);
        }
    }
}
