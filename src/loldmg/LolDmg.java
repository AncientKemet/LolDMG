/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loldmg;

import constant.Region;
import constant.staticdata.ChampData;
import constant.staticdata.ItemData;
import constant.staticdata.ItemListData;
import dto.Static.Champion;
import dto.Static.ChampionList;
import dto.Static.ChampionSpell;
import dto.Static.ItemList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import loldmg.Code.Graph;
import main.java.riotapi.RiotApi;
import main.java.riotapi.RiotApiException;

/**
 *
 * @author Robert
 */
public class LolDmg {

    public static ChampionList championList;
    public static ItemList itemList;
    static boolean debug = true;

    public static void main(String[] args) {
        RiotApi api = new RiotApi("e445f0eb-c76f-456e-b255-22931dcf8fef");
        api.setRegion(Region.NA);
        try {

            championList = api.getDataChampionList(Region.NA, null, null, true, ChampData.ALL);
            itemList = api.getDataItemList(null, null, ItemListData.ALL);

            /*for (String key : championList.getData().keySet()) {
             Champion champ =  championList.getData().get(key);
             System.out.println("Item["+key+"] :"+champ.getName());
             }*/
        } catch (RiotApiException ex) {
            ex.printStackTrace();
        }
        if(debug)System.out.println(championList.getData().get("80").getName());
        if (debug) {
            List <ChampionSpell> temp = new ArrayList<ChampionSpell>();
            ChampionSpell aa =new ChampionSpell();
            temp.add(0, aa);
            
            Graph lucvpant=new Graph(championList.getData().get("80"), championList.getData().get("80"),temp);
        }
    }

}
