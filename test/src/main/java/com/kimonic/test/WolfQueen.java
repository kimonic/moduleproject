package com.kimonic.test;

import com.kimonic.utilsmodule.utils.LUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * * ===============================================================
 * name:             WolfQueen
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/4/12
 * method:
 * <p>
 * <p>
 * description：八皇后问题，是一个古老而著名的问题，是回溯算法的典型案例。
 * 该问题是国际西洋棋棋手马克斯·贝瑟尔于1848年提出：在8×8格的国际象棋上摆放八个皇后，
 * 使其不能互相攻击，即任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。
 * <p>
 * 可行性方案最终呈现镜面对称,max为偶数时即为前一半列数的可行性方案的两倍
 * max为奇数时,需要单独计算中间列的可行性方案数
 * history：
 * *==================================================================
 */

public class WolfQueen {
    /**
     * 一共有多少个皇后（此时设置为8皇后在8X8棋盘，可以修改此值来设置N皇后问题,max*max棋盘）
     */
    int max = 8;
    /**
     * 该数组保存结果，第一个皇后摆在array[0]列，第二个摆在array[1]列
     * 其数组位置本身即为行数
     */
    int[] array = new int[max];
    /**
     * 存储所有的可行方案
     */
    private List<int[]> list;


    public WolfQueen() {
        list = new ArrayList<>();
        check(0);//求解所有可行方案
        if (list.size() > 0) {
            print();
        }

    }

    /**
     * n代表当前是第几个皇后
     *
     * @param n 行数
     *          皇后n在array[n]列第几行的第几列
     */
    private void check(int n) {
        //终止条件是最后一行已经摆完，由于每摆一步都会校验是否有冲突，所
        // 以只要最后一行摆完，说明已经得到了一个正确解
        if (n == max) {
            //递归结束条件,满足后递归结束
            list.add(array.clone());
            return;
        }
        //从第一列开始放值，然后判断是否和本行本列本斜线有冲突，如果OK，就进入下一行的逻辑
        for (int i = 0; i < max; i++) {
            array[n] = i;

//            if (n == 0 && i > max / 2) {//max为偶数时使用镜面对称计算总可行方法数,
//                                          为奇数时需要单独计算中间列的可执行方法数
//                break;
//            }

//            if (n == 行数 && i !=列数) {//单独计算某行某列的可执行方案
//                continue;
//            }
            if (judge(n)) {//如果一直为false,则本行无法摆放,那么代表无可行方案,则回溯
                check(n + 1);
            }
        }

    }


    /**
     * 判断是否符合摆放规则
     *
     * @param n 当前要摆放的行数
     * @return 是否符合
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] ||//列数相同,不符合
                    (n - i) == Math.abs(array[n] - array[i])) {//斜线位置,不符合
                return false;
            }
        }
        return true;
    }

    /**
     * 可行方案镜面对称
     * print------logflag--??first??--1-----4
     * print------logflag--??first??--2-----8
     * print------logflag--??first??--3-----16
     * print------logflag--??first??--4-----18
     * print------logflag--??first??--5-----18
     * print------logflag--??first??--6-----16
     * print------logflag--??first??--7-----8
     * print------logflag--??first??--8-----4
     */
    private void print() {

        int count = 0;
        int first = list.get(0)[0];
        for (int i = 0; i < list.size(); i++) {
            StringBuilder result = new StringBuilder();
            int length = list.get(i).length;
            if (first == list.get(i)[0]) {
                count++;
                if (i == list.size() - 1) {
                    LUtils.e(WolfQueen.class, "logflag--??first??--" + (first + 1) + "-----" + count);
                }
            } else {
                LUtils.e(WolfQueen.class, "logflag--??first??--" + (first + 1) + "-----" + count);
                first = list.get(i)[0];
                count = 1;
            }
            for (int j = 0; j < length; j++) {
                if (j < length - 1) {
                    result.append((list.get(i)[j] + 1)).append(" ---");
                } else {
                    result.append((list.get(i)[j] + 1));
                }
            }
            LUtils.e(WolfQueen.class, "logflag---" + result.toString());
        }

        LUtils.e(WolfQueen.class, "logflag--count-" + list.size());

    }



}