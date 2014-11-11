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
public class Graph {
    
    int x;
    int y;
    int x_per_lvl = 3;
    int y_per_lvl = 1;
    
    static GraphInterface graphInterface;
        
    public void Update()
    {
        for (int level = 0; level < 18; level++) {
            graphInterface.SetX("level");
            graphInterface.SetY("damage");
            graphInterface.NewData(x+x_per_lvl*level);
            graphInterface.NewData(y+y_per_lvl*level);
        }
    }

    public Graph(Champion champion, Champion target, List<ChampionSpell> spells) 
    {
    }
    
    
    
}
