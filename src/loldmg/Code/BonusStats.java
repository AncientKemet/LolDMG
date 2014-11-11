/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loldmg.Code;

import dto.Static.BasicDataStats;

/**
 *
 * @author Robert
 */
public class BonusStats {

    public double AD = 0;
    public double AP = 0;
    public double AS = 0;
    public double ARM = 0;
    public double CRIT = 0;
    public double ARM_PER_PEN = 0;
    public double ARM_FLAT_PEN = 0;
    public double MR = 0;

    public void addstats(BasicDataStats data) {
        AD += data.getFlatPhysicalDamageMod();
        AP += data.getFlatMagicDamageMod();
        AS += data.getFlatAttackSpeedMod();
        ARM += data.getFlatArmorMod();
        CRIT += data.getFlatCritChanceMod();
        ARM_PER_PEN += data.getrPercentArmorPenetrationMod();
        ARM_FLAT_PEN += data.getrFlatArmorPenetrationMod();
        MR += data.getFlatSpellBlockMod();//<-weird
    }

    public void substats(BasicDataStats data) {
        AD -= data.getFlatPhysicalDamageMod();
        AP -= data.getFlatMagicDamageMod();
        AS -= data.getFlatAttackSpeedMod();
        ARM -= data.getFlatArmorMod();
        CRIT -= data.getFlatCritChanceMod();
        ARM_PER_PEN -= data.getrPercentArmorPenetrationMod();
        ARM_FLAT_PEN -= data.getrFlatArmorPenetrationMod();
        MR -= data.getFlatSpellBlockMod();//<-weird
    }
}
