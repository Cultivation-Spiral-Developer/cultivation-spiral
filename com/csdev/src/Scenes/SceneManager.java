package Scenes;

import Game.Game.PlotEvent;
import Scenes.PlotScenes.*;

public class SceneManager {

    public Scene getPlotScene(PlotEvent p) {
        return switch (p) {
            case ABDUCTIONMISSED -> new AbductionMissedScene();
            case COLLEGETOWNDESTRUCTION -> new CollegeTownDestructionScene();
            case HELINTRO -> new HelIntroScene();
            case METROPOLISINVASION -> new MetropolisInvasionScene();
            case HASHIMOTOROMANCE1 -> new HashimotoRomance1Scene();
            case YUMENOROMANCE1 -> new YumenoRomance1Scene();
            default -> throw new IllegalArgumentException("No scene exists for the given PlotEvent.");
        };
    }
}
