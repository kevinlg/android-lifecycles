package com.example.android.lifecycles.my_solution;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;

public class MyChronometerViewModel extends ViewModel {

    @Nullable
    private Long mStartTime;

    @Nullable
    public Long getStartTime() {
        return mStartTime;
    }

    public void setStartTime(final long startTime) {
        this.mStartTime = startTime;
    }
}
