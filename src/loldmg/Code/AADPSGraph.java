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
public class AADPSGraph {

    public AADPSGraph(Champion attacker, Champion target, GraphInterface graphInterface) {
        double damage = 0;
        for (int level = 1; level < 19; level++) {
            
            double baseDmg = attacker.getStats().getAttackdamage() + attacker.getStats().getAttackdamageperlevel() * level;
            
            
            double baseAttackSpeed = 0.625 / (1 - attacker.getStats().getAttackspeedoffset());

            //multiply base dmg by attackspeed
            baseDmg *= baseAttackSpeed + (baseAttackSpeed *(attacker.getStats().getAttackspeedperlevel() * level / 100));
            
            damage = dmg_calculation.dmgafterdefence(baseDmg, target.getStats().getArmor() + target.getStats().getArmorperlevel() * level, 0, 0);
            graphInterface.NewData(level, (int) damage);
        }
    }

}
