/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loldmg.Code;

import dto.Static.Champion;
import dto.Static.ChampionSpell;
import dto.Static.Item;
import java.util.ArrayList;
import java.util.List;
import static loldmg.LolDmg.itemList;

/**
 *
 * @author Robert
 */
public class ItemUtils {

    /**
     * this should do: purchase/complete new item if u complete new item u gotta
     * remove the original items.
     */
    public static Item[] allItems;
    ArrayList<Item> finalItems;
    int dps;
    public static int gold;
    static boolean debug = false;
    static List<Ability> rotation = new ArrayList<Ability>();

    public void PurchaseMaxItems(ArrayList<Item> purchasedItems, Champion myChamp, Champion target, int level, int cash) {
        int cashtemp;
        for (int i = 0; i < allItems.length; i++) {

            Item item = allItems[i];
            if (item.getDepth() == 1 || !purchasedItems.contains(item)) {
                if (item.getGold().getTotal() > 359) {

                    cashtemp = breakdowninit(item, purchasedItems, cash);

                    if (cashtemp != cash) {
                        if (debug) {
                            printitemlist(changeditems);
                        }
                        PurchaseMaxItems(changeditems, myChamp, target, level, cashtemp);
                    }
                }
            }
        }

        //calculate dps for each item
        int dps2 = DamageCalculation.rotationdmg(myChamp, target, rotation, purchasedItems, level);

        if (dps2 > dps) {
            //System.out.println("max curr dps= " + dps2);
            dps = dps2;
            finalItems = (ArrayList<Item>) purchasedItems.clone();
            gold = cash;

        }
        if (!purchasedItems.isEmpty()) {
            purchasedItems.remove(purchasedItems.size() - 1);
        }
    }

    public ArrayList<Item> FindBestItemsToPurchase(ArrayList<Item> currentItems, Champion myChamp, Champion target, int level, int currentGold) {

        Ability aa = new Ability();
        Ability spear = new Ability();
        Ability heartseaker = new Ability();
        spear.ADdmg = 80;
        spear.BONUSADratio = (float) 1.4;
        heartseaker.ADdmg = 320;
        heartseaker.BONUSADratio = (float) 3.6;
        aa.TOTALADratio = 1;
        rotation.add(aa);
        //rotation.add(spear);
        //rotation.add(heartseaker);

        PurchaseMaxItems(currentItems, myChamp, target, level, currentGold);
        System.out.println("build");
        for (Item item : finalItems) {
            System.out.println("" + item.getName());
        }
        return (finalItems);
    }
    static ArrayList<Item> changeditems;

    static int breakdown(Item combineditem, ArrayList<Item> currentItems, int maxcost) {

        int cost = combineditem.getGold().getBase();
        List<String> parts = combineditem.getFrom();

        boolean found;
        if (parts != null) {
            for (String part : parts) {
                if (debug) {
                    System.out.println("found part : " + itemList.getData().get(part).getName());
                }
                found = false;
                for (Item item : currentItems) {
                    if (itemList.getData().get(part) == item) {
                        currentItems.remove(item);
                        if (debug) {
                            System.out.println("managed to combine with : " + item.getName());
                        }
                        found = true;
                        break;
                    }
                }
                if (found == false) {
                    cost += breakdown(itemList.getData().get(part), currentItems, maxcost);
                    if (cost > maxcost) {
                        if (debug) {
                            System.out.println("not enough money");
                        }
                        break;
                    }
                }
            }
            if (debug) {
                System.out.println("combination cost of : " + combineditem.getName() + " = " + cost);
            }
            return (cost);
        } else {
            if (debug) {
                System.out.println("combination cost of : " + combineditem.getName() + " = " + cost);
            }
            return (cost);
        }
    }

    static int breakdowninit(Item combineditem, ArrayList<Item> currentItems, int money) {

        ArrayList<Item> currentItems2 = new ArrayList<>();
        for (Item temp : currentItems) {
            currentItems2.add(temp);
        }
        int finalcost = breakdown(combineditem, currentItems2, money);
        if (debug) {
            System.out.println("inital cost: " + combineditem.getGold().getTotal() + " , actual cost : " + finalcost);
        }
        if (finalcost < money && currentItems2.size() < 6) {
            currentItems2.add(combineditem);
            changeditems = currentItems2;
            if (debug) {
                System.out.println("buying sucess");
                printitemlist(changeditems);
            }

            return (money - finalcost);
        } else {
            return (money);
        }

    }

    static void printitemlist(ArrayList<Item> itemlist) {
        for (Item item : itemlist) {
            System.out.println("item in list : " + item.getName());
        }
    }

}
