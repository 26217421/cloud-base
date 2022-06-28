package com.wbw.cloud.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 校验工具类
 * @author wbw
 * @date 2022-6-26 16:43
 */
public class CheckUtil {

    public static String[] KEYBOARD_SLOPE_ARR = {
            "!qaz", "1qaz", "@wsx","2wsx", "#edc", "3edc", "$rfv", "4rfv", "%tgb", "5tgb",
            "^yhn", "6yhn", "&ujm", "7ujm", "*ik,", "8ik,", "(ol.", "9ol.", ")p;/", "0p;/",
            "+[;.", "=[;.",  "_pl,", "-pl,", ")okm", "0okm", "(ijn", "9ijn", "*uhb", "8uhb",
            "&ygv", "7ygv", "^tfc", "6tfc", "%rdx","5rdx", "$esz","4esz"
    };
    public static String[] KEYBOARD_HORIZONTAL_ARR = {
            "01234567890-=",
            "!@#$%^&*()_+",
            "qwertyuiop[]",
            "QWERTYUIOP{}",
            "asdfghjkl;'",
            "ASDFGHJKL:",
            "zxcvbnm,./",
            "ZXCVBNM<>?",
    };

    public static String DEFAULT_SPECIAL_CHAR="!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    public static String SPECIAL_CHAR = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

    public static boolean checkPassword(String password) {
        return checkContainDigit(password);
    }


    /**
     * 检测密码中字符长度
     * @param password            密码字符串
     * @return  符合长度要求 返回true
     */
    public static boolean checkPasswordLength(String password, String minNum, String maxNum) {
        boolean flag =false;
        if (StringUtils.isBlank(maxNum))  {
            minNum = StringUtils.isBlank(minNum) ? "0":minNum;
            if (password.length() >= Integer.parseInt(minNum)) {
                flag = true;
            }
        } else {
            minNum = StringUtils.isBlank(minNum) ? "0":minNum;
            if (password.length() >= Integer.parseInt(minNum) &&
                    password.length() <= Integer.parseInt(maxNum)) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 检测字符串中是否包含数字
     * @param password  密码字符串
     * @return  包含数字 返回true
     */
    public static boolean checkContainDigit(String password) {
        char[] chPass = password.toCharArray();
        boolean flag = false;
        int numCount = 0;

        for (char pass : chPass) {
            if (Character.isDigit(pass)) {
                numCount++;
            }
        }
        if (numCount >= 1){
            flag = true;
        }
        return flag;
    }

    /**
     * 检测字符串中是否包含字母（不区分大小写）
     * @param password 密码字符串
     * @return  包含字母 返回true
     */
    public static boolean checkContainCase(String password) {
        char[] chPass = password.toCharArray();
        boolean flag = false;
        int charCount = 0;

        for (char pass : chPass) {
            if (Character.isLetter(pass)) {
                charCount++;
            }
        }
        if (charCount >= 1) {
            flag = true;
        }
        return flag;
    }


    /**
     * 检测字符串中是否包含小写字母
     * @param password   密码字符串
     * @return  包含小写字母 返回true
     */
    public static boolean checkContainLowerCase(String password) {
        char[] chPass = password.toCharArray();
        boolean flag = false;
        int charCount = 0;

        for (char pass : chPass) {
            if (Character.isLowerCase(pass)) {
                charCount++;
            }
        }
        if (charCount >= 1) {
            flag = true;
        }
        return flag;
    }


    /**
     * 检测密码中是否包含大写字母
     * @param password  密码字符串
     * @return  包含大写字母 返回true
     */
    public static boolean checkContainUpperCase(String password) {
        char[] chPass = password.toCharArray();
        boolean flag = false;
        int charCount = 0;

        for (int i = 0; i < chPass.length; i++) {
            if (Character.isUpperCase(chPass[i])) {
                charCount++;
            }
        }
        if (charCount >= 1) {
            flag = true;
        }
        return flag;
    }


    /**
     * 检测字符串中是否包含特殊符号
     * @param password            密码字符串
     * @return  包含特殊符号 返回true
     */
    public static boolean checkContainSpecialChar(String password) {
        char[] chPass = password.toCharArray();
        boolean flag = false;
        int specialCount = 0;

        for (char pass : chPass) {
            if (SPECIAL_CHAR.indexOf(pass) != -1) {
                specialCount++;
            }
        }

        if (specialCount >= 1){
            flag = true;
        }
        return flag;
    }


    /**
     * 键盘规则匹配器 横向连续检测
     * @param password            密码字符串
     * @return  含有横向连续字符串 返回true
     */
    public static boolean checkLateralKeyboardSite(String password, int repetitions, boolean isLower) {
        String tPassword = password;
        //将所有输入字符转为小写
        tPassword = tPassword.toLowerCase();
        int n = tPassword.length();
        /*
         * 键盘横向规则检测
         */
        boolean flag;

        for(int i = 0; i+ repetitions <=n; i++) {
            String str = tPassword.substring(i, i+ repetitions);
            String distinguishStr = password.substring(i, i+ repetitions);

            for (String configStr : KEYBOARD_HORIZONTAL_ARR) {
                String revOrderStr = new StringBuffer(configStr).reverse().toString();

                //检测包含字母(区分大小写)
                if (isLower) {
                    //考虑 大写键盘匹配的情况
                    String upperStr = configStr.toUpperCase();
                    if ((configStr.contains(distinguishStr)) || (upperStr.contains(distinguishStr))) {
                        flag = true;
                        return flag;
                    }
                    //考虑逆序输入情况下 连续输入
                    String revUpperStr = new StringBuffer(upperStr).reverse().toString();
                    if ((revOrderStr.contains(distinguishStr)) || (revUpperStr.contains(distinguishStr))) {
                        return true;
                    }
                } else {
                    if (configStr.contains(str)) {
                        return true;
                    }
                    //考虑逆序输入情况下 连续输入
                    if (revOrderStr.contains(str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }




    /**
     * 物理键盘，斜向连接校验， 如1qaz,4rfv, !qaz,@WDC,zaq1 返回true
     * @param password	字符串
     * @param repetitions	重复次数
     * @param isLower		是否区分大小写 true:区分大小写， false:不区分大小写
     * @return boolean    如1qaz,4rfv, !qaz,@WDC,zaq1 返回true
     */
    public static boolean checkKeyboardSlantSite(String password, int repetitions, boolean isLower) {
        String tPassword = password;
        tPassword = tPassword.toLowerCase();
        int n = tPassword.length();

        /*
         * 键盘斜线方向规则检测
         */
        for(int i = 0; i+ repetitions <=n; i++) {
            String str = tPassword.substring(i, i+ repetitions);
            String distinguishStr = password.substring(i, i+ repetitions);
            for (String configStr : KEYBOARD_SLOPE_ARR) {
                String revOrderStr = new StringBuffer(configStr).reverse().toString();
                //检测包含字母(区分大小写)
                if (isLower) {
                    //考虑 大写键盘匹配的情况
                    String upperStr = configStr.toUpperCase();
                    if ((configStr.contains(distinguishStr)) || (upperStr.contains(distinguishStr))) {
                        return true;
                    }
                    //考虑逆序输入情况下 连续输入
                    String revUpperStr = new StringBuffer(upperStr).reverse().toString();
                    if ((revOrderStr.contains(distinguishStr)) || (revUpperStr.contains(distinguishStr))) {
                        return true;
                    }
                } else {
                    if (configStr.contains(str)) {
                        return true;
                    }
                    //考虑逆序输入情况下 连续输入
                    if (revOrderStr.contains(str)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 评估a-z,z-a这样的连续字符,
     * @param password	字符串
     * @param repetitions	连续个数
     * @param isLower		是否区分大小写 true:区分大小写， false:不区分大小写
     * @return boolean    含有a-z,z-a连续字符串 返回true
     */
    public static boolean checkSequentialChars(String password, int repetitions, boolean isLower) {
        String tPassword = password;
        int normalCount;
        int reversedCount;
        //检测包含字母(区分大小写)
        if (!isLower) {
            tPassword = tPassword.toLowerCase();
        }
        int n = tPassword.length();
        char[] pwdCharArr = tPassword.toCharArray();

        for (int i = 0; i+ repetitions <=n; i++) {
            normalCount = 0;
            reversedCount = 0;
            for (int j = 0; j< repetitions -1; j++) {
                if (pwdCharArr[i+j+1]-pwdCharArr[i+j]==1) {
                    normalCount++;
                    if(normalCount == repetitions -1){
                        return true;
                    }
                }

                if (pwdCharArr[i+j]-pwdCharArr[i+j+1]==1) {
                    reversedCount++;
                    if(reversedCount == repetitions -1){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     *
     * 验证键盘上是否存在多个连续重复的字符， 如！！！！, qqqq, 1111, ====, AAAA返回true
     * @param password	字符串
     * @param repetitions	重复次数
     * @return boolean    返回类型
     */
    public static boolean checkSequentialSameChars(String password, int repetitions) {
        int n = password.length();
        char[] pwdCharArr = password.toCharArray();
        int count;
        for (int i = 0; i+ repetitions <=n; i++) {
            count=0;
            for (int j = 0; j< repetitions -1; j++) {
                if(pwdCharArr[i+j] == pwdCharArr[i+j+1]) {
                    count++;
                    if (count == repetitions -1){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
