package com.kimonic.utilsmodule.intterview;

/**
 * * ===============================================================
 * name:             Interview
 * guide:
 * author：          kimonik
 * version：          1.0
 * date：             2018/3/9
 * method:
 * <p>
 * <p>
 * description：
 * history：
 * *==================================================================
 */

public class Interview {
    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */
    public static boolean find(int[][] array, int target) {
        if (array == null) {
            return false;
        }
        int rows = array.length;//
        int columns = array[0].length;
        int row = 0;
        int column = columns - 1;
        while (row < rows && column >= 0) {//从每一维度的最大值开始查询
            int temp = array[row][column];
            if (target == temp) {
                return true;
            } else if (target > temp) {//行加1
                row++;
                if (row < rows) {
                    column = array[row].length - 1;//每行的值不固定
                } else {
                    return false;
                }
            } else if (target < temp) {//列减一
                column--;
            }
        }
        return false;
    }

    /**
     * 请实现一个函数，将一个字符串中的空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */

    public String replaceSpace(StringBuffer str) {
//        if (str == null) return null;
//        return str.toString().replace(" ", "%20");

        if (str == null) {
            return null;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                str.replace(i, i + 1, "%20");
            }
        }
        return str.toString();
    }
//    /**
//     * 输入一个链表，从尾到头打印链表每个节点的值。
//     */
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        Stack<Integer> stack = new Stack<>();
//        while (listNode != null) {
//            stack.push(listNode.val);
//            listNode = listNode.next;
//        }
//
//        ArrayList<Integer> list = new ArrayList<>();
//        while (!stack.isEmpty()) {
//            list.add(stack.pop());
//        }
//        return list;
//    }

//    /**
//     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果
//     * 中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
//     * 则重建二叉树并返回。
//     */
//
//
//    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
//        if (pre == null || in == null) {
//            return null;
//        }
//        int len = pre.length;
//        if (len == 0) {
//            return null;
//        }
//        int val = pre[0];
//        int rootPositionInLDR = -1;
//        TreeNode root = new TreeNode(val);
//        for (int i = 0; i < len; i++) {
//            if (in[i] == val) {
//                rootPositionInLDR = i;
//            }
//        }
//        if (rootPositionInLDR == -1) {
//            return null;
//        }
//        // rebulid left child tree
//        int leftChildTreeNum = rootPositionInLDR;
//        int[] leftPre = new int[leftChildTreeNum];
////      for (int i = 0; i < leftChildTreeNum; i++) {
////          leftPre[i] = pre[i + 1];
////      }
//        System.arraycopy(pre,1,leftPre,0,leftChildTreeNum);
//
//
//        int[] leftIn = new int[leftChildTreeNum];
////      for (int i = 0; i < leftChildTreeNum; i++) {
////          leftIn[i] = in[i];
////      }
//        System.arraycopy(in,0,leftIn,0,leftChildTreeNum);
//        root.left = rebuildBinaryTree(leftPre, leftIn);
//
//
//
//        // rebulid right child tree
//        int rightChildTreeNum = len - rootPositionInLDR - 1;
//        int[] rightPre = new int[rightChildTreeNum];
//        System.arraycopy(pre,rootPositionInLDR + 1,rightPre,0,rightChildTreeNum);
////      for (int i = 0; i < rightChildTreeNum; i++) {
////          rightPre[i] = pre[i + rootPositionInLDR + 1];
////      }
//        int[] rightIn = new int[rightChildTreeNum];
////      for (int i = 0; i < rightChildTreeNum; i++) {
////          rightIn[i] = in[i + rootPositionInLDR + 1];
////      }
//        System.arraycopy(in,rootPositionInLDR + 1,rightIn,0,rightChildTreeNum);
//        root.right = rebuildBinaryTree(rightPre, rightIn);
//        return root;
////        if (pre == null || in == null) {
////            return null;
////        }
////
////        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<Integer, Integer>();
////        for (int i = 0; i < in.length; i++) {
////            map.put(in[i], i);
////        }
////        return preIn(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
////    }
////
////    public TreeNode preIn(int[] p, int pi, int pj, int[] n, int ni, int nj, java.util.HashMap<Integer, Integer> map) {
////
////        if (pi > pj) {
////            return null;
////        }
////        TreeNode head = new TreeNode(p[pi]);
////        int index = map.get(p[pi]);
////        head.left = preIn(p, pi + 1, pi + index - ni, n, ni, index - 1, map);
////        head.right = preIn(p, pi + index - ni + 1, pj, n, index + 1, nj, map);
////        return head;
//    }

//    /**
//     * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
//     */
//    Stack<Integer> stack1 = new Stack<Integer>();
//    Stack<Integer> stack2 = new Stack<Integer>();
//
//    public void push(int node) {
//        stack1.push(node);
//    }
//
//    public int pop() {
//        while(!stack1.isEmpty()){
//            stack2.push(stack1.pop());
//        }
//        int first=stack2.pop();
//        while(!stack2.isEmpty()){
//            stack1.push(stack2.pop());
//        }
//        return first;
//    }

    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     */
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int i = 0;
        int a = array[i];
        while (i < array.length - 1 && array[i] <= array[i + 1]) {
            i++;
        }
        int j = i + 1;
        if (j == array.length) {
            j = 0;
        }
        return array[j];

//        if (array.length == 1) {
//            return array[0];
//        }
//
//        for (int i = 0; i < array.length - 1; i++) {
//            if (array[i] > array[i + 1]) {
//                return array[i + 1];
//            } else {
//                if (i == array.length - 2) {
//                    return array[0];
//                }
//            }
//        }
//
//        return 0;

    }

    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
     * n<=39
     * 1、1、2、3、5、8、13、21、34
     */
    public int Fibonacci(int n) {
        if (n > 39 || n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        int sum = 0;
        int first = 1;
        int second = 1;
        for (int i = 0; i < n - 2; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * 台阶每加一步,相当于却一步时跳一步,这一种方式加缺两步时跳两步这一种中方式
     * 斐波那契数列  1 2 3 5 8 13
     * 因为内一个位置只有两种方式,所以前后放置同一个元素时会重复
     * a-abc abc-a
     * abc-a acb-a bac-a bca-a acb-a cba-a
     * a-abc a-acb a-bac  a-acb
     *
     * abc-b acb-b bac-b bca-b acb-b cba-b
     * b-abc b-acb b-bac b-bca b-acb b-cba
     *
     * abc-c acb-c bac-c bca-c acb-c cba-c
     * a-bca a-cba
     */
    public int JumpFloor(int target) {
        if (target < 1) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        int floorAfter = 2;
        int floorBefore = 1;
        int floorN = 0;
        for (int i = 3; i <= target; i++) {
            floorN = floorAfter + floorBefore;
            floorBefore = floorAfter;
            floorAfter = floorN;
        }
        return floorN;

    }


}
