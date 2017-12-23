package com.mc.uniteroute_refactor_mvp.mvp.model.response;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/12/21.
 */

public class CarInfo implements Serializable{
    private String manufacturersId;
    private String manufacturers;
    private String manufacturersSimpleName;

    @Override
    public String toString() {
        return "carInfo{" +
                "manufacturersId='" + manufacturersId + '\'' +
                ", manufacturers='" + manufacturers + '\'' +
                ", manufacturersSimpleName='" + manufacturersSimpleName + '\'' +
                '}';
    }

    public String getManufacturersId() {
        return manufacturersId;
    }

    public void setManufacturersId(String manufacturersId) {
        this.manufacturersId = manufacturersId;
    }

    public String getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(String manufacturers) {
        this.manufacturers = manufacturers;
    }

    public String getManufacturersSimpleName() {
        return manufacturersSimpleName;
    }

    public void setManufacturersSimpleName(String manufacturersSimpleName) {
        this.manufacturersSimpleName = manufacturersSimpleName;
    }

}
