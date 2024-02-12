package data.structures.algorithm.leetcode.array.dynamicproce;

import data.structures.algorithm.datastructure.newstudy.array.utils.ArrayUtils;

import java.util.Arrays;

/**
 * 下降路径最小和 II : <a href="https://leetcode.cn/problems/minimum-falling-path-sum-ii/description/">...</a>
 * 给你一个 n x n 整数矩阵 grid ，请你返回 非零偏移下降路径 数字和的最小值。
 * 非零偏移下降路径 定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
 * @author starrysky
 */
public class DescendingPathMinSum2 {
    /**
     * method
     * @param grid 矩阵方格
     * @return 返回下降路径最小和
     */
    public int minFallingPathSum(int[][] grid) {

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        int n = 3;
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = Integer.MAX_VALUE;
            }
        }
        System.out.println(d[1][1]);
        System.out.println(d[1][2]);
        System.out.println(Arrays.toString(d));
    }
}
