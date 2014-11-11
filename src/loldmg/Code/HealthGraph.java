/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loldmg.Code;

import dto.Static.Champion;
import loldmg.Code.Interfaces.GraphInterface;

/**
 *
 * @author Robert
 */
public class HealthGraph {
    
    public HealthGraph(Champion target, GraphInterface graphInterface) {
        
        for (int level = 1; level < 19; level++) {
            double maxHealth = target.getStats().getHp();
            maxHealth += target.getStats().getHpperlevel() * level;
            graphInterface.NewData(level, (int) maxHealth);
        }
    }
    
}
