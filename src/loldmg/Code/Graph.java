/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loldmg.Code;

import dto.Static.Champion;
import dto.Static.ChampionSpell;
import dto.Static.Item;
import java.util.ArrayList;
import java.util.List;
import loldmg.Code.Interfaces.GraphInterface;
import static loldmg.Code.dmg_calculation.dmgafterdefence;

/**
 *
 * @author Robert
 */
public class Graph {

   static boolean debug = true;


    public static int rotationdmg(Champion attacker, Champion target, List<ChampionSpell> rotation,ArrayList<Item> purchasedItems, int level) {
        double damage = 0;
        
        if (rotation != null) {
            if (debug) {
                System.out.println(attacker.getName() + " vs " + target.getName());
            }

            damage = 0;
            for (int k = 0; k < rotation.size(); k++) {

                if (rotation.get(k).getVars() == null) {
                    damage += dmgafterdefence(attacker.getStats().getAttackdamage() + attacker.getStats().getAttackdamageperlevel() * level, target.getStats().getArmor() + target.getStats().getArmorperlevel() * level, 0, 0);
                }
            }
            if (debug) {
                System.out.println("dmg = " + damage);
            }
            return (int) (Math.round(damage));

        }
        return (0);
    }

    public static int rotationdps(Champion attacker, Champion target, List<ChampionSpell> rotation,ArrayList<Item> purchasedItems, int level) {
        double damage = 0;
        if (rotation != null) {
            if (debug) {
                System.out.println(attacker.getName() + " vs " + target.getName());
            }

            damage = 0;

            for (int k = 0; k < rotation.size(); k++) {

                if (rotation.get(k).getVars() == null) {
                    damage += dmgafterdefence(attacker.getStats().getAttackdamage() + attacker.getStats().getAttackdamageperlevel() * level, target.getStats().getArmor() + target.getStats().getArmorperlevel() * level, 0, 0) * (0.625 / (1 - attacker.getStats().getAttackspeedoffset())) * (1 + (attacker.getStats().getAttackspeedperlevel() * level / 100));
                }
            }
            if (debug) {
                System.out.println("dmg = " + damage);
            }
            return (int) (Math.round(damage));

        }
        return(0);

    }

}
