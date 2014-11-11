/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loldmg.Code;

import dto.Static.Champion;
import dto.Static.ChampionSpell;
import java.util.List;
import loldmg.Code.Interfaces.GraphInterface;
import static loldmg.Code.dmg_calculation.dmgafterdefence;

/**
 *
 * @author Robert
 */
public class Graph  {

    boolean debug = true;

    public void Update() {
        for (int level = 0; level < 18; level++) {

        }
    }

    public void rotationdmg(Champion attacker, Champion target, List<ChampionSpell> rotation,GraphInterface graphInterface) {
        double damage = 0;
        if (rotation != null) {
            if (debug) {
                System.out.println(attacker.getName() + " vs " + target.getName());
            }

            for (int i = 0; i < 18; i++) {
                damage=0;
                for (int k = 0; k < rotation.size(); k++) {
                    
                    if (rotation.get(k).getVars() == null) {
                        damage += dmgafterdefence(attacker.getStats().getAttackdamage() + attacker.getStats().getAttackdamageperlevel() * i, target.getStats().getArmor() + target.getStats().getArmorperlevel() * i, 0, 0);
                    }
                }
                graphInterface.NewData((int) Math.round(damage),i);
                if (debug) {
                            System.out.println("dmg = " + damage);
                        }
            }
        }
    }
        public void rotationdps(Champion attacker, Champion target, List<ChampionSpell> rotation,GraphInterface graphInterface) {
        double damage = 0;
        if (rotation != null) {
            if (debug) {
                System.out.println(attacker.getName() + " vs " + target.getName());
            }

            for (int level = 0; level < 18; level++) {
                damage=0;

                for (int k = 0; k < rotation.size(); k++) {
                    
                    if (rotation.get(k).getVars() == null) {
                        damage += dmgafterdefence(attacker.getStats().getAttackdamage() + attacker.getStats().getAttackdamageperlevel() * level, target.getStats().getArmor() + target.getStats().getArmorperlevel() * level, 0, 0)*(0.625 / (1 - attacker.getStats().getAttackspeedoffset()))*(1+(attacker.getStats().getAttackspeedperlevel() * level / 100));
                    }
                }
                graphInterface.NewData((int) Math.round(damage),level);
                if (debug) {
                            System.out.println("dmg = " + damage);
                        }
            }
        }
    }

}
