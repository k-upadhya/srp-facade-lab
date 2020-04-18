package srpfacadelab;

public class itemPickUpper {
    private final IGameEngine gameEngine;

    public itemPickUpper(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    public boolean pickUpItem(Item item, RpgPlayer rpgPlayer) {
        int weight = rpgPlayer.calculateInventoryWeight();
        if (weight + item.getWeight() > rpgPlayer.getCarryingCapacity())
            return false;

        if (item.isUnique() && rpgPlayer.checkIfItemExistsInInventory(item))
            return false;

        // Don't pick up items that give health, just consume them.
        if (item.getHeal() > 0) {
            rpgPlayer.setHealth(rpgPlayer.getHealth() + item.getHeal());

            if (rpgPlayer.getHealth() > rpgPlayer.getMaxHealth())
                rpgPlayer.setHealth(rpgPlayer.getMaxHealth());

            if (item.getHeal() > 500) {
                rpgPlayer.gameEngine.playSpecialEffect("green_swirly");
            }

            return true;
        }

        if (item.isRare()) {
            if (item.isUnique())
                rpgPlayer.gameEngine.playSpecialEffect("blue_swirly");
            else
                rpgPlayer.gameEngine.playSpecialEffect("cool_swirly_particles");
        }

        rpgPlayer.inventory.add(item);

        rpgPlayer.calculateStats();

        return true;
    }


}