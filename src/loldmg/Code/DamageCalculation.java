/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loldmg.Code;

import dto.Static.Champion;
import dto.Static.Item;
import java.util.ArrayList;
import java.util.List;
import static loldmg.Code.DamageReduction.dmgafterdefence;

/**
 *
 * @author Robert
 */
public class DamageCalculation {

    static boolean debug = false;

    public static int rotationdmg(Champion attacker, Champion target, List<Ability> rotation, ArrayList<Item> purchasedItems, int level) {
        double damage = 0;
        BonusStats itemstats = new BonusStats();
        for (int i = 0; i < purchasedItems.size(); i++) {
            itemstats.addstats(purchasedItems.get(i).getStats());
        }
        if (rotation != null) {
            if (debug) {
                System.out.println(attacker.getName() + " vs " + target.getName());
            }

            damage = 0;
            Ability currentability;
            for (int k = 0; k < rotation.size(); k++) {
                currentability = rotation.get(k);
                if (currentability.cancrit) {
                    double crit = itemstats.CRIT;
                    if (crit > 1) {
                        crit = 1;
                    }
                    damage += dmgafterdefence((1 + crit) * ((attacker.getStats().getAttackdamage() + attacker.getStats().getAttackdamageperlevel() * level + itemstats.AD) * currentability.TOTALADratio + currentability.BONUSADratio * itemstats.AD + currentability.ADdmg), target.getStats().getArmor() + target.getStats().getArmorperlevel() * level, itemstats.ARM_FLAT_PEN, itemstats.ARM_PER_PEN);
                    damage += dmgafterdefence(currentability.APdmg + currentability.APratio * itemstats.AP, target.getStats().getSpellblock() + target.getStats().getSpellblockperlevel() * level, itemstats.MR_FLAT_PEN, itemstats.MR_PER_PEN);
                } else {
                    damage += dmgafterdefence(((attacker.getStats().getAttackdamage() + attacker.getStats().getAttackdamageperlevel() * level + itemstats.AD) * currentability.TOTALADratio) + currentability.BONUSADratio * itemstats.AD + currentability.ADdmg, target.getStats().getArmor() + target.getStats().getArmorperlevel() * level, itemstats.ARM_FLAT_PEN, itemstats.ARM_PER_PEN);
                    damage += dmgafterdefence(currentability.APdmg + currentability.APratio * itemstats.AP, target.getStats().getSpellblock() + target.getStats().getSpellblockperlevel() * level, itemstats.MR_FLAT_PEN, itemstats.MR_PER_PEN);
                }
            }
            if (debug) {
                System.out.println("dmg = " + damage);
            }
            return (int) (Math.round(damage));

        }
        return (0);
    }

    public static int rotationdps(Champion attacker, Champion target, List<Ability> rotation, ArrayList<Item> purchasedItems, int level) {
        double damage ;
        BonusStats itemstats = new BonusStats();
        for (int i = 0; i < purchasedItems.size(); i++) {
            itemstats.addstats(purchasedItems.get(i).getStats());
        }
        if (rotation != null) {
            if (debug) {
                System.out.println(attacker.getName() + " vs " + target.getName());
            }

            damage = 0;

            for (int k = 0; k < rotation.size(); k++) {

                damage += dmgafterdefence(itemstats.CRIT * (attacker.getStats().getAttackdamage() + attacker.getStats().getAttackdamageperlevel() * level + itemstats.AD), target.getStats().getArmor() + target.getStats().getArmorperlevel() * level, 0, 0)
                        * (0.625 / (1 + attacker.getStats().getAttackspeedoffset())) * (1 + itemstats.AS / 100 + attacker.getStats().getAttackspeedperlevel() * level / 100);

            }
            if (debug) {
                System.out.println("dmg = " + damage);
            }
            return (int) (Math.round(damage));

        }
        return (0);

    }

}
