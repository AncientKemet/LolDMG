/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loldmg.Code.Interfaces;

import dto.Static.Champion;
import loldmg.Code.BonusStats;

/**
 *
 * @author Robert
 */
public interface DPSInterface {
    
    public float GetAADPS(Champion attacker, BonusStats attackerStats, Champion target, BonusStats targetStats, GraphInterface graphInterface, int level);
    
}
