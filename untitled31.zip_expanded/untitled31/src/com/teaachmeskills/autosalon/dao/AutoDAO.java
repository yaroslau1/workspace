package com.teaachmeskills.autosalon.dao;

import com.teaachmeskills.autosalon.entity.Auto;

/**
 * Created by TMS on 24.04.2018.
 */
public interface AutoDAO {
    Auto[] getAutos();
    Auto[] getAutos(String marka);
    void addAuto(Auto auto);
}
