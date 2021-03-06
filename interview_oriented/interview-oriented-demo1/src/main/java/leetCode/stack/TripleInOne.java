package leetCode.stack;

/**
 * @author kelvinchung
 * <p>
 * 03.01. 三合一
 * 三合一。描述如何只用一个数组来实现三个栈。
 * <p>
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 * 输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 * 输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 */
public class TripleInOne {
        //定义一个数组栈
        private int[] stack;
        //定义一个头指针的数组
        private int[] top;

        public TripleInOne(int stackSize) {
            //定义三栈合一
            stack = new int[stackSize * 3];
            // 三个栈的头结点
            top = new int[3];

            //分别赋值第一次的头结点
            // 栈0 top[0] = 0;
            // 栈1 top[1] = 1;
            // 栈2 top[2] = 2;
            for (int i = 0; i < 3; i++) {
                top[i] = i;
            }
        }

        public void push(int stackNum, int value) {
            //判断是否添加满了
            if (top[stackNum] < stack.length) {
                //赋值
                stack[top[stackNum]] = value;
                //头结点+3
                top[stackNum] = top[stackNum] + 3;
            }
        }

        public int pop(int stackNum) {

            //判断是否为空
            if (isEmpty(stackNum)) {
                return -1;
            }
            //原本的top[stackNum]减3
            top[stackNum] = top[stackNum] - 3;

            //返回
            return stack[(top[stackNum])];


        }

        public int peek(int stackNum) {
            //判断是否为空
            if (isEmpty(stackNum)) {
                return -1;
            }
            //把下标给它但是不改变原来的top[stackNum]
            int index = top[stackNum] - 3;
            return stack[index];
        }

        public boolean isEmpty(int stackNum) {
            //判断这个栈是否为空
            if (top[stackNum] -3 < 0) {
                return true;
            }
            return false;
        }

    public static void main(String[] args) {
        TripleInOne t = new TripleInOne(3);
        t.push(0, 1);
        t.push(0, 2);
        t.pop(0);
        t.pop(0);
    }
}
