/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loldmg.Code;

import dto.Static.Champion;
import dto.Static.ChampionSpell;
import java.util.List;
import loldmg.Code.Interfaces.DPSInterface;
import loldmg.Code.Interfaces.GraphInterface;

/**
 *
 * @author Robert
 */
public class AADPSGraph implements DPSInterface {

    @Override
    public float GetAADPS(Champion attacker, BonusStats attackerStats, Champion target, BonusStats targetStats, int level) {
            double baseDmg = attacker.getStats().getAttackdamage() + attacker.getStats().getAttackdamageperlevel() * level;
            
            double baseAttackSpeed = 0.625 / (1 - attacker.getStats().getAttackspeedoffset());
            baseDmg *= baseAttackSpeed + ((attackerStats.AS + baseAttackSpeed *(attacker.getStats().getAttackspeedperlevel() * level) / 100));
            
            double damage = dmg_calculation.dmgafterdefence(baseDmg + attackerStats.AD, target.getStats().getArmor() + target.getStats().getArmorperlevel() * level, attackerStats.ARM_FLAT_PEN, attackerStats.ARM_PER_PEN);
            return (float) damage;
    }

}
