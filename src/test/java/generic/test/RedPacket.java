package generic.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: zouyongqi
 * 红包算法
 * @Date: Created in 下午7:51 2018/10/24
 */
public class RedPacket {
    private static final float MINMONEY =0.01f;
    private static final float MAXMONEY =200f;

    private static final float TIMES = 2.1f;

    public static void main(String[] args) {

//        testRandom();
//        randomPack();
        float count = 0.0f;
        for(Float num : splitRedPackets(10000.00f, 55)) {
            System.out.println(num);
            count += num;

        }
        System.out.println(count);
//        runTest();


    }

    public static void runTest() {
        //输入红包金额
        System.out.println("please input a number");
        Scanner sc=new Scanner(System.in);
        //NUM:人数
        int num = sc.nextInt(),count = num,NUM=20;
        float[] index = new float[NUM];
        while(num-->0)
        {
//            RedPacketUtil util = new RedPacketUtil();
//            List<Float> temp = util.splitRedPackets(20, NUM);
            List<Float> temp = splitRedPackets(20, NUM);
            for(int i=0;i<temp.size();i++) {
                index[i]+=temp.get(i);
            }
        }
        for(int i=0;i<NUM;i++) {
            System.out.println("the number "+i+" can get "+(index[i]/count));
        }
    }

    public static void testRandom() {
        float num=10,N=1.9f;//开始将系数设为1.9
        int people=10;
        for(int i=0;i<10;i++)
        {
            System.out.println("the number"+people+" can get  "+ num/people*N);
            num=num-num/people*N;
            people--;
        }
        System.out.println("there remain"+num);
    }

    private static void  randomPack() {
        List<Float> list = new ArrayList<Float>();
        for (int i = 0; i <= 100; i++) {
            float randomNum = randomRedPacket(100.00f, 0.01f, 10.00f, 100);
            System.out.println(randomNum);
            list.add(randomNum);
        }
        float count = 0.0f;
        for (Float num : list) {
            count += num;
        }
        System.out.println("count: " + count);
    }

    private static boolean isRight(float  money,int count)
    {
        double avg = money/count;
        if(avg<MINMONEY){
            return false;
        }
        else if(avg>MAXMONEY)
        {
            return false;
        }
        return true;
    }

    private static float randomRedPacket(float money,float mins,float maxs,int count) {
        if(count==1) {
            return (float)(Math.round(money*100))/100;
        }
        if(mins == maxs) {
            return mins;//如果最大值和最小值一样，就返回mins
        }
        float max = maxs>money?money:maxs;
        float one = ((float)Math.random()*(max-mins)+mins);
        one = (float)(Math.round(one*100))/100;
        float moneyOther = money - one;
        if(isRight(moneyOther,count-1)) {
            return one;
        } else{
            //重新分配
            float avg = moneyOther / (count-1);
            if(avg<MINMONEY)
            {
                return randomRedPacket(money,mins,one,count);
            }else if(avg>MAXMONEY)
            {
                return randomRedPacket(money,one,maxs,count);
            }
        }
        return one;
    }

    public static List<Float> splitRedPackets(float money,int count)
    {
        if(!isRight(money,count))
        {
            return null;
        }
        List<Float> list = new ArrayList<Float>();
        float max = (float)(money*TIMES/count);

        max = max>MAXMONEY?MAXMONEY:max;
        for(int i=0;i<count;i++)
        {
            float one = randomRedPacket(money,MINMONEY,max,count-i);
            list.add(one);
            money-=one;
        }
        return list;
    }

}
