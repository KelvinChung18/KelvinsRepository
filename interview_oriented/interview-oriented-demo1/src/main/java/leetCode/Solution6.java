package leetCode;

/**
 * @author kelvinchung
 *
 * 01.07. 旋转矩阵
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * 不占用额外内存空间能否做到？
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 *  核心：
 *  原本
 *  i排 j列
 *  翻转后
 *  j排 倒数第i列
 *
 */
public class Solution6 {
    public static void rotate(int[][] matrix) {
        // 规定好了是 N*N
        int N = matrix.length;
        // 变换后
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[j][N - 1 - i] = matrix[i][j];
            }
        }
        // 如果这样写 原本那块内存空间就没了
        matrix = result;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                matrix[i][j] = result[i][j];
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(arr);
    }
}
