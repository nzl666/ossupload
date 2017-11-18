package cc.suyu.utils;

import java.util.Random;

public class MathRand {
    public static String getCode () {
        String code ="";
        Random random =new Random();
        for (int i = 0;i < 6; i++) {
                Integer num = random.nextInt(10);
                code+=num;
        }
        return code;
    }

    public static void main(String[] args) {
        for(int i = 0;i<2000;i++){
            String num = MathRand.getCode();
            if(num.length()>4){
                System.out.println(num);
            }

        }
    }
}
