package srpfacadelab;

import java.util.List;

public class itemUser {
    private final IGameEngine gameEngine;

    public itemUser(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    public void useItem(Item item, RpgPlayer rpgPlayer) {
        if (item.getName().equals("Stink Bomb")) {
            List<IEnemy> enemies = rpgPlayer.gameEngine.getEnemiesNear(rpgPlayer);

            for (IEnemy enemy : enemies) {
                enemy.takeDamage(100);
            }
        }
    }
}