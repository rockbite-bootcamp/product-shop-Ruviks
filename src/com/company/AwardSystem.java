package com.company;

import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class AwardSystem implements Observer {
    private HashMap<Integer,Integer> awardset = new HashMap<Integer, Integer>();
    private static volatile AwardSystem instance = new AwardSystem();
    private   AwardSystem(){
        awardset.put(1,5);
        awardset.put(2,10);
    }
    public static AwardSystem getInstance() {
        return instance;
    }

    @Override
    public void update(Observable o, Object arg) {
        ShopManager manager = (ShopManager) o;
        int award=getaward(manager.user.getBuyCount());
        System.out.println(manager.user.getName() +" has earned "+award +" Cash");
    }
    private  int getaward(int buyCount){
        Integer award=awardset.get(buyCount);
        if(award!=null) return  award;
        return  0;

    }
}
