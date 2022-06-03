package com.company.helpers;

import java.util.Collections;

public final class Helpers {

    private Helpers() {
    }

    public static boolean boolStringCheck(String ans) {
        String[] truths = {"yes", "y", "true", "t"};
        ans = ans.toLowerCase();
        for (String string : truths) {
            if (ans == string) {
                return true;
            }
        }
        return false;
    }
}
