package com.teaachmeskills.autosalon.dao;

import com.teaachmeskills.autosalon.entity.Auto;

/**
 * Created by TMS on 24.04.2018.
 */
public class AutoHardCodeDAO implements AutoDAO {
    private Auto[] autos = new Auto[2];

    public AutoHardCodeDAO() {
        autos[0] = new Auto("Audi", 250, 27500);
        autos[1] = new Auto("BMW", 280, 34750);
    }

    
    public Auto[] getAutos() {
        return autos;
    }

    
    public Auto[] getAutos(String marka) {
        int count = 0;
        for (int i = 0; i < autos.length; i++){
            if (marka.equalsIgnoreCase(autos[i].getMarka())){
                count ++;
            }
        }
        Auto result[] = new Auto[count];
        for (int i = 0, j = 0; i < autos.length; i++){
            if (marka.equalsIgnoreCase(autos[i].getMarka())){
                result[j] = autos[i];
                j++;
            }
        }
        return result;
    }

    
    public void addAuto(Auto auto) {
        Auto[] tmp = new Auto[autos.length + 1];
        for (int i = 0; i < autos.length; i++){
            tmp[i] = autos[i];
        }
        tmp[tmp.length - 1] = auto;
        autos = tmp;
    }
}
