package arithmetic;

/**
 * 二分查找
 *
 * @author kelvinchung
 */
public class BinarySearchTest {

    public static void main(String[] args) {

    }

    public static int binarySearchTest(int[] arr, int data) {

        int low = 0;
        int height = arr.length;
        while (low <= height) {
            int mid = low + (height - low / 2);
            if (arr[mid] < data) {
                low = mid + 1;
            } else if (arr[mid] == data) {
                return mid;
            }else {
                height = mid - 1;
            }
        }
        return -1;
    }

}
