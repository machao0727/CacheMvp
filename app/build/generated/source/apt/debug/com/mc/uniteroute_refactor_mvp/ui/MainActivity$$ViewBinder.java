// Generated code from Butter Knife. Do not modify!
package com.mc.uniteroute_refactor_mvp.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainActivity$$ViewBinder<T extends com.mc.uniteroute_refactor_mvp.ui.MainActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131165219, "field 'btn_carInfo'");
    target.btn_carInfo = finder.castView(view, 2131165219, "field 'btn_carInfo'");
    view = finder.findRequiredView(source, 2131165308, "field 'text_carInfo'");
    target.text_carInfo = finder.castView(view, 2131165308, "field 'text_carInfo'");
    view = finder.findRequiredView(source, 2131165220, "field 'btn_carModel'");
    target.btn_carModel = finder.castView(view, 2131165220, "field 'btn_carModel'");
    view = finder.findRequiredView(source, 2131165309, "field 'text_carModel'");
    target.text_carModel = finder.castView(view, 2131165309, "field 'text_carModel'");
  }

  @Override public void unbind(T target) {
    target.btn_carInfo = null;
    target.text_carInfo = null;
    target.btn_carModel = null;
    target.text_carModel = null;
  }
}
