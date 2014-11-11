package loldmg.Code;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class dmg_calculation {

    double dmgafterdefence(double damage, double defence, double defencepen, double defencepen_per) {
        double defenceleft = defence * (1 - defencepen_per) - defencepen;
        if (defenceleft >= 0) {
            return (damage * 100 / (defenceleft + 100));
        } else {
            return (damage * (2 - 100 / (100 - defenceleft)));
        }
    }

    double dps(double dmg, double cooldown) {
        return (dmg / cooldown);

    }


}
