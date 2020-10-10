package com.example.demo;

public class tetsSting1 {

    /**
     * 备份
     * @param content
     * @param frontNum
     * @param endNum
     * @param str
     * @return
     */
    public static String replaceString2Star(String content, int frontNum, int endNum, char str) {
        if (content == null || content.trim().isEmpty())
            return content;
        char[] cardChar = content.toCharArray();
        int len = content.length();
        if (frontNum >= len || frontNum < 0 || endNum >= len || endNum < 0 || frontNum + endNum >= len){
            if(len <= frontNum + endNum && len>frontNum && len>endNum){
                for (int j = frontNum-1; j < len-1; j++) {
                    cardChar[j] = str;
                }
                return new String(cardChar);
            }else if(len<=frontNum){
                for (int j = frontNum-len; j < len; j++) {
                    if(j!=0){
                        cardChar[j] = str;
                    }
                }
                return new String(cardChar);
            }else if(len<=endNum){
                for (int j = endNum-len; j < len; j++) {
                    if(j!=0){
                        cardChar[j] = str;
                    }
                }
                return new String(cardChar);
            }
        }
        int beginIndex = frontNum;
        int endIndex = len - endNum;
        for (int j = beginIndex; j < endIndex; j++) {
            cardChar[j] = str;
        }
        return new String(cardChar);
    }

}
