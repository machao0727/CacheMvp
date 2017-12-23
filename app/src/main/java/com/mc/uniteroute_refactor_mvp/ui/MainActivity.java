package com.mc.uniteroute_refactor_mvp.ui;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mc.uniteroute_refactor_mvp.R;
import com.mc.uniteroute_refactor_mvp.base.BaseActivity;
import com.mc.uniteroute_refactor_mvp.base.annotation.MCActivityFeature;
import com.mc.uniteroute_refactor_mvp.mvp.controller.MainController;
import com.mc.uniteroute_refactor_mvp.mvp.model.response.CarInfo;
import com.mc.uniteroute_refactor_mvp.mvp.model.response.model;
import com.mc.uniteroute_refactor_mvp.mvp.presenter.MainPresenter;

import java.util.List;

import butterknife.Bind;

@MCActivityFeature(layout = R.layout.activity_main)
public class MainActivity extends BaseActivity implements MainController.View {
    @Bind(R.id.btn_carInfo)
    Button btn_carInfo;
    @Bind(R.id.text_carInfo)
    TextView text_carInfo;

    @Bind(R.id.btn_carModel)
    Button btn_carModel;
    @Bind(R.id.text_carModel)
    TextView text_carModel;

    private MainPresenter presenter;

    @Override
    protected void initPresenter() {
        presenter = new MainPresenter(this);
    }

    @Override
    public void initData() {
        btn_carInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getCarInfoItem(getApplicationContext());
            }
        });
        btn_carModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.getCarInfoModel(getApplicationContext());
            }
        });
    }

    @Override
    public void initView() {

    }

    @Override
    public void showCarInfoItem(List<CarInfo> carInfos) {
        text_carInfo.setText(carInfos.toString());
    }

    @Override
    public void showCarInfoError(String throwable) {
        text_carInfo.setText(throwable);
    }

    @Override
    public void showCarModelItem(List<model> models) {
        text_carModel.setText(models.toString());
    }

    @Override
    public void showCarModelError(String throwable) {
        text_carModel.setText(throwable);
    }
}
