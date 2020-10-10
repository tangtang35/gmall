package com.example.demo;

public class testString {

    /**
     * 对字符加星号处理：除前面几位和后面几位外，其他的字符以星号代替
     *
     * @param content
     *            传入的字符串
     * @param frontNum
     *            保留前面字符的位数
     * @param endNum
     *            保留后面字符的位数
     * @return 带星号的字符串
     */
    public static String replaceString2Star(String content, int frontNum, int endNum, char str) {
        if (content == null || content.trim().isEmpty()){
            return content;
        }
        char[] cardChar = content.toCharArray();
        int totalLength = content.length();
        //取余
        int surplus = totalLength % 2;
        //取模
        int model = Math.floorMod(totalLength, 2);
        //情况1：字符长度大于前后保留字符：正常脱敏
        if(totalLength > frontNum + endNum){
            for (int j = frontNum; j < totalLength-endNum; j++) {
                cardChar[j] = str;
            }
        //情况2：字符长度小于前后保留字符
        }else if(surplus == 0){
            //如果长度是偶数，则覆盖中间2位：1234--->1**4
            if(totalLength!=2){
                for (int j = totalLength/2-1; j <= totalLength/2; j++) {
                    cardChar[j] = str;
                }
            }else{
                //如果字符长度为2，要做特殊处理：张三--->张*
                for (int j = totalLength/2; j <= totalLength/2; j++) {
                    cardChar[j] = str;
                }
            }
            return new String(cardChar);
        }else if(surplus > 0){
            //如果长度是奇数数，则覆盖中间1位：123--->1*4
            if(totalLength!=1){
                for (int j = totalLength/2; j <= totalLength/2; j++) {
                    cardChar[j] = str;
                }
            }else{
                //如果字符长度为1，要做特殊处理：张--->*
                cardChar[0] = str;
            }
        }
        return new String(cardChar);
    }
    public static void main(String[] arg) {
        testString ss = new testString();

        System.out.println("5-5-*");

        String a12 = "";
        String a112 = ss.replaceString2Star(a12,2,2,'*');
        System.out.println("脱敏前="+a12+"----脱敏后="+a112);


        String a1 = "1";
        String a11 = ss.replaceString2Star(a1,2,2,'*');
        System.out.println("脱敏前="+a1+"----脱敏后="+a11);

        String a2 = "12";
        String a22 = ss.replaceString2Star(a2,2,2,'*');
        System.out.println("脱敏前="+a2+"----脱敏后="+a22);

        String a3 = "123";
        String a33 = ss.replaceString2Star(a3,2,2,'*');
        System.out.println("脱敏前="+a3+"----脱敏后="+a33);

        String a4 = "1234";
        String a44 = ss.replaceString2Star(a4,2,2,'*');
        System.out.println("脱敏前="+a4+"----脱敏后="+a44);

        String a5 = "12345";
        String a55 = ss.replaceString2Star(a5,2,2,'*');
        System.out.println("脱敏前="+a5+"----脱敏后="+a55);

        String a6 = "123456";
        String a66 = ss.replaceString2Star(a6,2,2,'*');
        System.out.println("脱敏前="+a6+"----脱敏后="+a66);

        String a7 = "1234567";
        String a77 = ss.replaceString2Star(a7,2,2,'*');
        System.out.println("脱敏前="+a7+"----脱敏后="+a77);

        String a8 = "12345678";
        String a88= ss.replaceString2Star(a8,2,2,'*');
        System.out.println("脱敏前="+a8+"----脱敏后="+a88);

        String a9 = "123456789987654321";
        String a99 = ss.replaceString2Star(a9,1,2,'*');
        System.out.println("脱敏前="+a9+"----脱敏后="+a99);


        /*System.out.println("2-2-*");
        String a1 = "1";
        String a11 = ss.replaceString2Star(a1,2,2,'*');
        System.out.println("脱敏前="+a1+"----脱敏后="+a11);

        String a2 = "12";
        String a22 = ss.replaceString2Star(a2,2,2,'*');
        System.out.println("脱敏前="+a2+"----脱敏后="+a22);

        String a3 = "123";
        String a33 = ss.replaceString2Star(a3,2,2,'*');
        System.out.println("脱敏前="+a3+"----脱敏后="+a33);

        String a4 = "1234";
        String a44 = ss.replaceString2Star(a4,2,2,'*');
        System.out.println("脱敏前="+a4+"----脱敏后="+a44);

        String a5 = "12345";
        String a55 = ss.replaceString2Star(a5,2,2,'*');
        System.out.println("脱敏前="+a5+"----脱敏后="+a55);*/


        /*System.out.println("3-5-*");
        String a1 = "1";
        String a11 = ss.replaceString2Star(a1,3,5,'*');
        System.out.println("脱敏前="+a1+"----脱敏后="+a11);

        String a2 = "12";
        String a22 = ss.replaceString2Star(a2,3,5,'*');
        System.out.println("脱敏前="+a2+"----脱敏后="+a22);

        String a3 = "123";
        String a33 = ss.replaceString2Star(a3,3,5,'*');
        System.out.println("脱敏前="+a3+"----脱敏后="+a33);

        String a4 = "1234";
        String a44 = ss.replaceString2Star(a4,3,5,'*');
        System.out.println("脱敏前="+a4+"----脱敏后="+a44);

        String a5 = "12345";
        String a55 = ss.replaceString2Star(a5,3,5,'*');
        System.out.println("脱敏前="+a5+"----脱敏后="+a55);

        String a6 = "123456";
        String a66 = ss.replaceString2Star(a6,3,5,'*');
        System.out.println("脱敏前="+a6+"----脱敏后="+a66);

        String a7 = "1234567";
        String a77 = ss.replaceString2Star(a7,3,5,'*');
        System.out.println("脱敏前="+a7+"----脱敏后="+a77);

        String a8 = "12345678";
        String a88= ss.replaceString2Star(a8,3,5,'*');
        System.out.println("脱敏前="+a8+"----脱敏后="+a88);

        String a9 = "123456789";
        String a99 = ss.replaceString2Star(a9,3,5,'*');
        System.out.println("脱敏前="+a9+"----脱敏后="+a99);*/

        /*System.out.println("1-5-*");
        String a1 = "1";
        String a11 = ss.replaceString2Star(a1,1,5,'*');
        System.out.println("脱敏前="+a1+"----脱敏后="+a11);

        String a2 = "12";
        String a22 = ss.replaceString2Star(a2,1,5,'*');
        System.out.println("脱敏前="+a2+"----脱敏后="+a22);

        String a3 = "123";
        String a33 = ss.replaceString2Star(a3,1,5,'*');
        System.out.println("脱敏前="+a3+"----脱敏后="+a33);

        String a4 = "1234";
        String a44 = ss.replaceString2Star(a4,1,5,'*');
        System.out.println("脱敏前="+a4+"----脱敏后="+a44);

        String a5 = "12345";
        String a55 = ss.replaceString2Star(a5,1,5,'*');
        System.out.println("脱敏前="+a5+"----脱敏后="+a55);

        String a6 = "123456";
        String a66 = ss.replaceString2Star(a6,1,5,'*');
        System.out.println("脱敏前="+a6+"----脱敏后="+a66);

        String a7 = "1234567";
        String a77 = ss.replaceString2Star(a7,1,5,'*');
        System.out.println("脱敏前="+a7+"----脱敏后="+a77);

        String a8 = "12345678";
        String a88= ss.replaceString2Star(a8,1,5,'*');
        System.out.println("脱敏前="+a8+"----脱敏后="+a88);

        String a9 = "123456789";
        String a99 = ss.replaceString2Star(a9,1,5,'*');
        System.out.println("脱敏前="+a9+"----脱敏后="+a99);*/

        /*System.out.println("1-2-*");
        String a6 = "1";
        String a66 = ss.replaceString2Star(a6,1,2,'*');
        System.out.println("脱敏前="+a6+"----脱敏后="+a66);

        String a7 = "12";
        String a77 = ss.replaceString2Star(a7,1,2,'*');
        System.out.println("脱敏前="+a7+"----脱敏后="+a77);

        String a8 = "123";
        String a88 = ss.replaceString2Star(a8,1,2,'*');
        System.out.println("脱敏前="+a8+"----脱敏后="+a88);

        String a9 = "1234";
        String a99 = ss.replaceString2Star(a9,1,2,'*');
        System.out.println("脱敏前="+a9+"----脱敏后="+a99);

        String a10 = "12345";
        String a100 = ss.replaceString2Star(a10,1,2,'*');
        System.out.println("脱敏前="+a10+"----脱敏后="+a100);*/
    }
}
