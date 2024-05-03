package class14;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
public class jUnit_AgentWeapon {
    public static void main (String[] args) {
        Agent ag007 = new Agent(500, 3);
        ag007.canDrive();
        ag007.canDrive();
    }
}

class Weapon {
    private final String name;
    private final int requiredLevel;
    private final double price;

    public Weapon(String name, int requiredLevel, double price) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public double getPrice() {
        return price;
    }
}

class Agent {
    private static int agentIdCounter = 1;

    private final String agentId;
    private double bank;
    private boolean isBanned;
    private boolean isDriving;
    private int level;

    public Agent(double initialBank, int initialLevel) {
        this.agentId = "Agent" + agentIdCounter++;
        this.bank = initialBank;
        this.isBanned = false;
        this.isDriving = false;
        this.level = initialLevel;
    }

    public String getAgentId() {
        return agentId;
    }

    public boolean canDrive() {
        boolean result = !(isDriving && isBanned);
        System.out.println(agentId + " canDrive() = " + result);
        assertTrue(result);
        return result;
    }


    public void levelUp() {
        if (!isBanned) {
            level++;
            System.out.println(agentId + " levelUp() to level " + level);
        } else {
            System.out.println(agentId + " levelUp() failed: Agent is banned.");
        }
    }

    public void ban() {
        isBanned = true;
        System.out.println(agentId + " ban()");
    }

    public void purchase(Weapon weapon) {
        int requiredLevel = weapon.getRequiredLevel();
        if (level >= requiredLevel) {
            double cost = weapon.getPrice();
            if (bank >= cost) {
                bank -= cost;
                System.out.println(agentId + " purchased " + weapon.getName() + " for " + cost + " units.");
            } else {
                System.out.println(agentId + " purchase of " + weapon.getName() + " failed: Insufficient funds.");
            }
        } else {
            System.out.println(agentId + " purchase of " + weapon.getName() + " failed: Insufficient level.");
        }
    }

    public double getBank() {
        return bank;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public boolean isDriving() {
        return isDriving;
    }

    public int getLevel() {
        return level;
    }
}
