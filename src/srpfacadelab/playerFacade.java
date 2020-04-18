package srpfacadelab;

import java.util.ArrayList;
import java.util.List;

public class playerFacade {
    public static final int MAX_CARRYING_CAPACITY = 1000;
    private final IGameEngine gameEngine;
    private List<Item> inventory;

    private itemPickUpper pickUpper;
    private itemUser user;

    // How much the player can carry in pounds
    private int carryingCapacity;

    public playerFacade(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
        inventory = new ArrayList<Item>();
        carryingCapacity = MAX_CARRYING_CAPACITY;

        pickUpper = new itemPickUpper(gameEngine);
        user = new itemUser(gameEngine);
    }

    public boolean pickUpItem(Item item, RpgPlayer p) {
        return pickUpper.pickUpItem(item, p);
    }

    public void useItem(Item item, RpgPlayer p) {
        user.useItem(item, p);
    }

}
