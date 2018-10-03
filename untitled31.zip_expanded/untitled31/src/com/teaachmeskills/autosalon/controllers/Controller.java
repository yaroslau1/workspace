package com.teaachmeskills.autosalon.controllers;

import com.teaachmeskills.autosalon.dao.AutoDAO;
import com.teaachmeskills.autosalon.dao.AutoHardCodeDAO;
import com.teaachmeskills.autosalon.entity.Auto;

/**
 * Created by TMS on 24.04.2018.
 */
public class Controller {
    private AutoDAO dao = new AutoHardCodeDAO();

    public Auto[] getAutos(){
        return dao.getAutos();
    }

    public Auto[] getAutos(String marka){
        return dao.getAutos(marka);
    }

    public void addAuto(Auto auto){
        if(auto.getSpeed() >= 200){
            auto.setPrice(auto.getPrice() + 1000);
        }
        dao.addAuto(auto);

    }
}
