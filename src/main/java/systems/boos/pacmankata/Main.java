package systems.boos.pacmankata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("Initial Game State");
        logger.info("==================");
        String stateDisplay = new GameState(1, 1).toString();
        logger.info(stateDisplay);
    }
}