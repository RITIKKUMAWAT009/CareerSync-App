package com.example.careersync;

import com.example.careersync.model.UserT;

public class Constants {
    public static String MESSAGE = "";
    private static UserT userT;


    public static UserT getUserT() {
        return userT;
    }

    public static void setUserT(UserT userT) {
        Constants.userT = userT;
    }
}
