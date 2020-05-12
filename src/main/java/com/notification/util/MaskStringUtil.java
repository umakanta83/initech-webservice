package com.notification.util;


import java.util.Objects;
import java.util.regex.Pattern;

public class MaskStringUtil {

    public static void main(String[] args) throws Exception {

        String[] inputs = {
                "a@abc.com",
                "helloworld@gmail.com",
                "umakanta@yahoo.com",
                "1234567890",
                "123-567-8905",
                "uk@email.com",
                "1234 567 890",
                "123",
                "@email.com",
        };

        for (String str : inputs) {
            System.out.println(maskEmailAdrsOrMobNo(str, '*'));
        }


    }

    /*
     * This method will return the mask string for email or mobile no.
     * If it is email, it will mask first and last char of string before '@'
     * If it is phone no, it will mask the middle three digits.
     * If it is not valid email or phone no then it will return the string as it is.
     *
     *
     */
    public static String maskEmailAdrsOrMobNo(String str, char maskChar) {
        String maskStr = "";
        try {
            if (Objects.isNull(str)) {
                return maskStr;
            }
            if (isValidMail(str)) {
                maskStr = maskEmailAddress(str, maskChar);
            } else if (isValidPhoneNumber(str)) {
                maskStr = maskMobileNumber(str, maskChar);
            } else {
                maskStr = str;
            }
        } catch (Exception ex) {
            System.err.println("Error in masking string" + str + ":exception " + ex);
            maskStr = str;
        }
        return maskStr;
    }

    private static String maskEmailAddress(String strEmail, char maskChar)
            throws Exception {


        String[] parts = strEmail.split("@");

        //mask first part
        String strId = "";
        if (parts[0].length() < 4)
            strId = maskString(parts[0], 0, parts[0].length(), maskChar);
        else
            strId = maskString(parts[0], 1, parts[0].length() - 1, maskChar);

        //now append the domain part to the masked id part
        return strId + "@" + parts[1];
    }

    public static String maskMobileNumber(String strMobile, char maskChar)
            throws Exception {

        if (Objects.isNull(strMobile)) {
            return "";
        }
        int middle = middle(strMobile);
        return maskString(strMobile, middle - 1, middle + 2, maskChar);
    }

    private static int middle(String str) {
        int position;
        if (str.length() % 2 == 0) {
            position = str.length() / 2 - 1;
        } else {
            position = str.length() / 2;
        }

        return position;
    }

    private static String maskString(String strText, int start, int end, char maskChar)
            throws Exception {

        if (Objects.isNull(strText) || strText.equals(""))
            return "";

        if (start < 0)
            start = 0;

        if (end > strText.length())
            end = strText.length();

        if (start > end)
            throw new Exception("End index cannot be greater than start index");

        int maskLength = end - start;

        if (maskLength == 0)
            return strText;


        StringBuilder sbMaskString = new StringBuilder(maskLength);

        for (int i = 0; i < maskLength; i++) {
            sbMaskString.append(maskChar);
        }

        return strText.substring(0, start)
                + sbMaskString.toString()
                + strText.substring(start + maskLength);
    }

    private static boolean isValidMail(String email) {

        String EMAIL_STRING = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        return Pattern.compile(EMAIL_STRING).matcher(email).matches();

    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        boolean validPhNumber = false;
        // validate phone numbers of format "1234567890"
        if (phoneNumber.matches("\\d{10}"))
            validPhNumber = true;
            // validating phone number with -, . or spaces
        else if (phoneNumber.matches("\\d{3}[-\\.]\\d{3}[-\\.]\\d{4}"))
            validPhNumber = true;

        else if (phoneNumber.matches("\\(\\d{5}\\)-\\d{3}-\\d{3}"))
            validPhNumber = true;

        else if (phoneNumber.matches("\\(\\d{4}\\)-\\d{3}-\\d{3}"))
            validPhNumber = true;

        // return false if nothing matches the input


        return validPhNumber;

    }

}