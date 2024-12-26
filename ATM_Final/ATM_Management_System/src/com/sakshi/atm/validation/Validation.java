package com.sakshi.atm.validation;

import com.sakshi.atm.entity.Card;

public class Validation {

    public static Boolean checkCardNo(String cardNo) {
        return cardNo.matches("\\d{16}");
    }

    public static Boolean checkPinNo(String pinNo, String string) {
        if (pinNo.equals(string.toString()) && pinNo.matches("\\d{4}")) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean checkCardStatus(String cardStatus) {
        return cardStatus.equals("active");
    }
}
