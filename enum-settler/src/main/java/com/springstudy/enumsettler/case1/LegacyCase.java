package com.springstudy.enumsettler.case1;

public class LegacyCase {

    public String toTableValue(String originValue) {
        if ("Y".equals(originValue)) {
            return "1";
        } else {
            return "0";
        }
    }

    public boolean toTable2Value(String originValue) {
        if ("Y".equals(originValue)) {
            return true;
        } else {
            return false;
        }
    }
}
