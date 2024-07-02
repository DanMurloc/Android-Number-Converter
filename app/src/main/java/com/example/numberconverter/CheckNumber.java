package com.example.numberconverter;

import java.util.ArrayList;
import java.util.List;

public class CheckNumber {
    private  CharSequence s="0";

    public CheckNumber(CharSequence s){
       this.s=s;
    }

    public CharSequence RemoteNumber() {
        List<CharSequence> yesconvertor = new ArrayList<>();
        boolean isNegative = false;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                yesconvertor.add(String.valueOf(currentChar));
            } else if (currentChar == '-' && i == 0) {
                isNegative = true;
            }
        }

        String[] arrstr = yesconvertor.stream()
                .map(CharSequence::toString)
                .toArray(String[]::new);
        StringBuilder sb = new StringBuilder();
        for (String str : arrstr) {
            sb.append(str);
        }

        if (isNegative) {
            sb.insert(0, '-');
        }

        return sb.toString();
    }

}
