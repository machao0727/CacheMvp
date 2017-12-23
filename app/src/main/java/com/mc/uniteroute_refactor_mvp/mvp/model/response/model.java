package com.mc.uniteroute_refactor_mvp.mvp.model.response;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/11/28.
 */
public class model implements Serializable {
    private String modelsId;
    private String models;
    private String modelsSimpleName;

    @Override
    public String toString() {
        return "model{" +
                "modelsId='" + modelsId + '\'' +
                ", models='" + models + '\'' +
                ", modelsSimpleName='" + modelsSimpleName + '\'' +
                '}';
    }

    public String getModelsId() {
        return modelsId;
    }

    public void setModelsId(String modelsId) {
        this.modelsId = modelsId;
    }

    public String getModels() {
        return models;
    }

    public void setModels(String models) {
        this.models = models;
    }

    public String getModelsSimpleName() {
        return modelsSimpleName;
    }

    public void setModelsSimpleName(String modelsSimpleName) {
        this.modelsSimpleName = modelsSimpleName;
    }
}
