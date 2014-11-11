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

/**
 *
 * @author Robert
 */
public class Graph extends dmg_calculation {

    int x;
    int y;
    int x_per_lvl = 3;
    int y_per_lvl = 1;
    boolean debug = true;

    static GraphInterface graphInterface;

    public void Update() {
        for (int level = 0; level < 18; level++) {

        }
    }

    public Graph(Champion attacker, Champion target, List<ChampionSpell> rotation) {
        double damage = 0;
        if (rotation != null) {
            if (debug) {
                System.out.println(attacker.getName() + " vs " + target.getName());
            }
            for (int k = 0; k < rotation.size(); k++) {
                if (rotation.get(k).getVars() == null) {
                    for (int i = 0; i < 18; i++) {
                        damage = dmgafterdefence(attacker.getStats().getAttackdamage() + attacker.getStats().getAttackdamageperlevel() * i, target.getStats().getArmor() + target.getStats().getArmorperlevel() * i, 0, 0);
                        // graphInterface.NewData(damage,i);
                        if (debug) {
                            System.out.println("dmg = " + damage);
                        }
                    }
                }
            }
        }
    }

}
