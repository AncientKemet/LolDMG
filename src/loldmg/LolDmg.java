/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loldmg;

import constant.Region;
import constant.staticdata.ChampData;
import constant.staticdata.ItemListData;
import dto.Static.ChampionList;
import dto.Static.ItemList;
import java.io.FileNotFoundException;
import java.io.IOException;
import loldmg.Code.ItemUtils;
import loldmg.GUI.LoadingFrame;
import loldmg.GUI.MainFrame;
import main.java.riotapi.RiotApi;
import main.java.riotapi.RiotApiException;

/**
 *
 * @author Robert
 */
public class LolDmg implements
        java.io.Serializable {

    public static ChampionList championList;
    public static ItemList itemList;

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        RiotApi api = new RiotApi("e445f0eb-c76f-456e-b255-22931dcf8fef");
        api.setRegion(Region.EUNE);
        try {
            final LoadingFrame loadingFrame = new LoadingFrame();

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    loadingFrame.setVisible(true);
                }
            });
            

                championList = api.getDataChampionList(Region.NA, null, null, true, ChampData.ALL);
                itemList = api.getDataItemList(null, null, ItemListData.ALL);
                        

            ItemUtils.allItems = sort.getaditems(itemList);

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    loadingFrame.dispose();
                    new MainFrame().setVisible(true);
                }
            });

            /*for (String key : champList.getData().keySet()) {
             Champion champ =  champList.getData().get(key);
             System.out.println("Item["+key+"] :"+champ.getTags());
             }*/
        } catch (RiotApiException ex) {
            ex.printStackTrace();
        }
    }

}
