package systems.boos.pacmankata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("Initial Game State");
        logger.info("==================");
        String gameStateReport = new GameState().toString();
        logger.info(gameStateReport);
    }
}