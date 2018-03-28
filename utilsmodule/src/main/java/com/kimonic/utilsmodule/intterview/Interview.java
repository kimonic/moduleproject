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
 * description：  练习题类
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
     * <p>
     * abc-b acb-b bac-b bca-b acb-b cba-b
     * b-abc b-acb b-bac b-bca b-acb b-cba
     * <p>
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

    /**
     * 001.fragment的生命周期
     */
    private void aaa() {
        /**
         * Fragment每个生命周期方法的意义、作用（注意红色的不是生命周期方法）：
         setUserVisibleHint()：设置Fragment可见或者不可见时会调用此方法。在该方法里面可以通过调用getUserVisibleHint()获得Fragment的状态是可见还是不可见的，如果可见则进行懒加载操作。
         onAttach()：执行该方法时，Fragment与Activity已经完成绑定，该方法有一个Activity类型的参数，代表绑定的Activity，这时候你可以执行诸如mActivity = activity的操作。
         onCreate()：初始化Fragment。可通过参数savedInstanceState获取之前保存的值。
         onCreateView()：初始化Fragment的布局。加载布局和findViewById的操作通常在此函数内完成，但是不建议执行耗时的操作，比如读取数据库数据列表。
         onActivityCreated()：执行该方法时，与Fragment绑定的Activity的onCreate方法已经执行完成并返回，在该方法内可以进行与Activity交互的UI操作，所以在该方法之前Activity的onCreate方法并未执行完成，如果提前进行交互操作，会引发空指针异常。
         onStart()：执行该方法时，Fragment由不可见变为可见状态。
         onResume()：执行该方法时，Fragment处于活动状态，用户可与之交互。
         onPause()：执行该方法时，Fragment处于暂停状态，但依然可见，用户不能与之交互。
         onSaveInstanceState()：保存当前Fragment的状态。该方法会自动保存Fragment的状态，比如EditText键入的文本，即使Fragment被回收又重新创建，一样能恢复EditText之前键入的文本。
         onStop()：执行该方法时，Fragment完全不可见。
         onDestroyView()：销毁与Fragment有关的视图，但未与Activity解除绑定，依然可以通过onCreateView方法重新创建视图。通常在ViewPager+Fragment的方式下会调用此方法。
         onDestroy()：销毁Fragment。通常按Back键退出或者Fragment被回收时调用此方法。
         onDetach()：解除与Activity的绑定。在onDestroy方法之后调用。

         Fragment生命周期执行流程（注意红色的不是生命周期方法）：
         Fragment创建：setUserVisibleHint()->onAttach()->onCreate()->onCreateView()->onActivityCreated()->onStart()->onResume()；
         Fragment变为不可见状态（锁屏、回到桌面、被Activity完全覆盖）：onPause()->onSaveInstanceState()->onStop()；
         Fragment变为部分可见状态（打开Dialog样式的Activity）：onPause()->onSaveInstanceState()；
         Fragment由不可见变为活动状态：onStart()->OnResume()；
         Fragment由部分可见变为活动状态：onResume()；
         退出应用：onPause()->onStop()->onDestroyView()->onDestroy()->onDetach()（注意退出不会调用onSaveInstanceState方法，因为是人为退出，没有必要再保存数据）；
         Fragment被回收又重新创建：被回收执行onPause()->onSaveInstanceState()->onStop()->onDestroyView()->onDestroy()->onDetach()，重新创建执行onAttach()->onCreate()->onCreateView()->onActivityCreated()->onStart()->onResume()->setUserVisibleHint()；
         横竖屏切换：与Fragment被回收又重新创建一样。
         */
    }


    /**
     * 002.事件分发机制，以及涉及到的设计模式
     */

    private void aab() {
/**
 * Touch事件分发中只有两个主角:ViewGroup和View。Activity的Touch事件事实上是调用它内部的
 * ViewGroup的Touch事件，可以直接当成ViewGroup处理。

 View在ViewGroup内，ViewGroup也可以在其他ViewGroup内，这时候把内部的ViewGroup当成View来分析。

 ViewGroup的相关事件有三个：onInterceptTouchEvent、dispatchTouchEvent、onTouchEvent。View的相
 关事件只有两个：dispatchTouchEvent、onTouchEvent。

 先分析ViewGroup的处理流程：首先得有个结构模型概念：ViewGroup和View组成了一棵树形结构，
 最顶层为Activity的ViewGroup，下面有若干的ViewGroup节点，
 每个节点之下又有若干的ViewGroup节点或者View节点，依次类推


 当一个Touch事件(触摸事件为例)到达根节点，即Acitivty的ViewGroup时，它会依次下发，下发的过程是调用子
 View(ViewGroup)的dispatchTouchEvent方法实现的。简单来说，就是ViewGroup遍历它包含着的子View，
 调用每个View的dispatchTouchEvent方法，而当子View为ViewGroup时，又会通过调用ViwGroup的dispatchTouchEvent方
 法继续调用其内部的View的dispatchTouchEvent方法。上述例子中的消息下发顺序是这样的：①-②-⑤-⑥-⑦-③-④。
 dispatchTouchEvent方法只负责事件的分发，它拥有boolean类型的返回值，当返回为true时，顺序下发会中断。
 在上述例子中如果⑤的dispatchTouchEvent返回结果为true，那么⑥-⑦-③-④将都接收不到本次Touch事件。

 一般情况下，我们不该在普通View内重写dispatchTouchEvent方法，因为它并不执行分发逻辑。
 当Touch事件到达View时，我们该做的就是是否在onTouchEvent事件中处理它。

 那么，ViewGroup的onTouchEvent事件是什么时候处理的呢？当ViewGroup所有的子View都返回false时，
 onTouchEvent事件便会执行。由于ViewGroup是继承于View的，
 它其实也是通过调用View的dispatchTouchEvent方法来执行onTouchEvent事件。



 在目前的情况看来，似乎只要我们把所有的onTouchEvent都返回false，就能保证所有的子控件都响应本次Touch事件了。
 但必须要说明的是，这里的Touch事件，只限于Acition_Down事件，即触摸按下事件,而Aciton_UP和Action_MOVE却
 不会执行。事实上，一次完整的Touch事件，应该是由一个Down、一个Up和若干个Move组成的。Down方式通过
 dispatchTouchEvent分发，分发的目的是为了找到真正需要处理完整Touch请求的View。当某个View或者
 ViewGroup的onTouchEvent事件返回true时，便表示它是真正要处理这次请求的View，之后的Aciton_
 UP和Action_MOVE将由它处理。
 当所有子View的onTouchEvent都返回false时，这次的Touch请求就由根ViewGroup，即Activity自己处理了。
 ViewGroup还有个onInterceptTouchEvent，看名字便知道这是个拦截事件。这个拦截事件需要分两种情况来说明：

 1.假如我们在某个ViewGroup的onInterceptTouchEvent中，将Action为Down的Touch事件返回true，
 那便表示将该ViewGroup的所有下发操作拦截掉，这种情况下，mTarget会一直为null，
 因为mTarget是在Down事件中赋值的。由于mTarge为null，该ViewGroup的onTouchEvent事件被执行。
 这种情况下可以把这个ViewGroup直接当成View来对待。

 2.假如我们在某个ViewGroup的onInterceptTouchEvent中，将Acion为Down的Touch事件都返回false，
 其他的都返回True，这种情况下，Down事件能正常分发，若子View都返回false，那mTarget还是为空，
 无影响。若某个子View返回了true，mTarget被赋值了，在Action_Move和Aciton_UP分发到该ViewGroup时，
 便会给mTarget分发一个Action_Delete的MotionEvent，同时清空mTarget的值，
 使得接下去的Action_Move(如果上一个操作不是UP)将由ViewGroup的onTouchEvent处理。

 情况一用到的比较多，情况二个人还未找到使用场景。

 从头到尾总结一下：

 1.Touch事件分发中只有两个主角:ViewGroup和View。ViewGroup包含onInterceptTouchEvent、
 dispatchTouchEvent、onTouchEvent三个相关事件。View包含dispatchTouchEvent、
 onTouchEvent两个相关事件。其中ViewGroup又继承于View。

 2.ViewGroup和View组成了一个树状结构，根节点为Activity内部包含的一个ViwGroup。

 3.触摸事件由Action_Down、Action_Move、Aciton_UP组成，其中一次完整的触摸事件中，
 Down和Up都只有一个，Move有若干个，可以为0个。

 4.当Acitivty接收到Touch事件时，将遍历子View进行Down事件的分发。
 ViewGroup的遍历可以看成是递归的。分发的目的是为了找到真正要处理本次完整触摸事件的View，
 这个View会在onTouchuEvent结果返回true。

 5.当某个子View返回true时，会中止Down事件的分发，同时在ViewGroup中记录该子View。
 接下去的Move和Up事件将由该子View直接进行处理。由于子View是保存在ViewGroup中的，
 多层ViewGroup的节点结构时，上级ViewGroup保存的会是真实处理事件的View所在的ViewGroup对象:
 如ViewGroup0-ViewGroup1-TextView的结构中，TextView返回了true，它将被保存在ViewGroup1中，
 而ViewGroup1也会返回true，被保存在ViewGroup0中。当Move和UP事件来时，
 会先从ViewGroup0传递至ViewGroup1，再由ViewGroup1传递至TextView。

 6.当ViewGroup中所有子View都不捕获Down事件时，将触发ViewGroup自身的onTouch事件。
 触发的方式是调用super.dispatchTouchEvent函数，即父类View的dispatchTouchEvent方法。
 在所有子View都不处理的情况下，触发Acitivity的onTouchEvent方法。

 7.onInterceptTouchEvent有两个作用：1.拦截Down事件的分发。2.中止Up和Move事件向目标View传递，
 使得目标View所在的ViewGroup捕获Up和Move事件。
 * 从 Android 源码 发现设计模式
 前面已经写过了事件的分发机制，以及源码的分析了。每当用户接触到了屏幕的时候，
 Android会将对应的事件包装成一个事件从对象ViewTree的顶部从上到下的开始分发传递。
 而在ViewGroup中，ViewGroup中执行事件的派发分发是通过dispatchTouchEvent。

 在这个方法中，我们可以很清楚的看到ViewGroup就会遍历所有的子View。拿到子View的时候，
 源码中做了几个判断，判断这个子View是否符合条件。如果不满足则直接选取下一个子View。
 拿到符合条件的子View，那么将调用 dispatchTransformedTouchEvent 这个方法。
 在dispatchTransformedTouchEvent方法中就调用了child.dispatchTouchEvent(event)。

 从上源码中可以的知到最重要的一点就是，ViewGroup的事件投递的递归调用就类似一个责任链，
 不断的从子View中寻找能处理这个事件的子View，一旦找到了这个责任者，
 那么将由这个责任者持有并且消费这个事件。从View中的 onTouchEvent
 方法的返回值可以很清楚的看到这一点，当onTouchEvent 返回 false 代表 ，
 那么意味着这个不是该事件的负责人，当返回了true，此时会持有这个事件，并不向外再传递了。

 责任链模式 介绍
 从ViewGroup对于事件的分发来说，一个传递给一个，形成了一个链子，最后从链子中找到一
 个来处理这个事件。把这种形式抽象出来，其实就是责任链模式，我们把多个节点首尾相连所构成
 的模式称为链。对于这种构成，把每一个节点都看做一个对象，每个对象拥有不同的处理逻辑，然
 后将一个责任从链子的首端出发，沿着链子依次传递给每个节点的对象，直到有个对象处理这个责任。

 责任链模式 定义
 使多个对象都有机会处理请求，从而避免了请求的发送者和接收者之间的耦合关系。
 将这些对象连成一条链，并沿着这条链传递该请求，直到有对象处理他为止。

 责任链模式 使用场景
 使用场景就和ViewGroup一样，多个对象处理一个请求，但是具体由哪个对象处理，是动态决定的。

 * 责任链模式：

 优点：显而易见，可以对链中请求者和处理者关系解耦，提高了代码的灵活性。

 缺点：每次处理都要从头开始遍历，如果处理者太多牌，那么遍历必然会影响性能。
 */
    }

    /**
     * 003.
     * onMeasure的测量模式与特点
     */
    private void aac() {
        /**
         *1. onMeasure什么时候会被调用
           onMeasure方法的作用时测量空间的大小，什么时候需要测量控件的大小呢？我们举个栗子，
         做饭的时候我们炒一碗菜，炒菜的过程我们并不要求知道这道菜有多少分量，只有在菜做熟了
         我们要拿个碗盛放的时候，我们才需要掂量拿多大的碗盛放，这时候我们就要对菜的分量进行估测。
           而我们的控件也正是如此，创建一个View(执行构造方法)的时候不需要测量控件的大小，
         只有将这个view放入一个容器（父控件）中的时候才需要测量，而这个测量方法就是父控件唤起调用的。
         当控件的父控件要放置该控件的时候，父控件会调用子控件的onMeasure方法询问子控件：
         “你有多大的尺寸，我要给你多大的地方才能容纳你？”，然后传入两个参数
         （widthMeasureSpec和heightMeasureSpec），这两个参数就是父控件告诉子控件可获得的空间
         以及关于这个空间的约束条件（好比我在思考需要多大的碗盛菜的时候我要看一下碗柜里最大的碗有多大，
         菜的分量不能超过这个容积，这就是碗对菜的约束），子控件拿着这些条件就能正确的测量自身的宽高了。
         2. onMeasure方法执行流程
           上面说到onMeasure方法是由父控件调用的，所有父控件都是ViewGroup的子类，
         ViewGroup是一个抽象类，它里面有一个抽象方法onLayout，这个方法的作用就是摆放它所有的子控件
         （安排位置），因为是抽象类，不能直接new对象，所以我们在布局文件中可以使用View但是不能直接使用
         ViewGroup。

           在给子控件确定位置之前，必须要获取到子控件的大小（只有确定了子控件的大小才能正确的确定上
         下左右四个点的坐标），而ViewGroup并没有重写View的onMeasure方法，也就是说抽象类ViewGroup没有
         为子控件测量大小的能力，它只能测量自己的大小。但是既然ViewGroup是一个能容纳子控件的容器，
         系统当然也考虑到测量子控件的问题，所以ViewGroup提供了三个测量子控件相关的方法
         (measuireChildren\measuireChild\measureChildWithMargins)，只是在ViewGroup中没有调用它们，
         所以它本身不具备为子控件测量大小的能力，但是他有这个潜力哦。

           为什么都有测量子控件的方法了而ViewGroup中不直接重写onMeasure方法，
         然后在onMeasure中调用呢？因为不同的容器摆放子控件的方式不同，比如RelativeLayout，
         LinearLayout这两个ViewGroup的子类，它们摆放子控件的方式不同，有的是线性摆放，
         而有的是叠加摆放，这就导致测量子控件的方式会有所差别，所以ViewGroup就干脆不直接测量子控件，
         他的子类要测量子控件就根据自己的布局特性重写onMeasure方法去测量。这么看来ViewGroup提供的三个
         测量子控件的方法岂不是没有作用？答案是NO，既然提供了就肯定有作用，这三个方法只是按照一种
         通用的方式去测量子控件，很多ViewGruop的子类测量子控件的时候就使用了
         ViewGroup的measureChildxxx系列方法；还有一个作用就是为我们自定义ViewGroup提供方便咯，
         自定义ViewGroup我会在以后的博客中专门探讨，这里就不大费篇章了。

           测量的时候父控件的onMeasure方法会遍历他所有的子控件，挨个调用子控件的measure方法，
         measure方法会调用onMeasure，然后会调用setMeasureDimension方法保存测量的大小，
         一次遍历下来，第一个子控件以及这个子控件中的所有子控件都会完成测量工作；

         然后开始测量第二个子控件…；最后父控件所有的子控件都完成测量以后会调用
         setMeasureDimension方法保存自己的测量大小。值得注意的是，这个过程不只执行一次，
         也就是说有可能重复执行，因为有的时候，一轮测量下来，父控件发现某一个子控件的尺寸不符合要求，
         就会重新测量一遍。

         从源码中我们知道，MeasureSpec其实就是尺寸和模式通过各种位运算计算出的一个整型值，
         它提供了三种模式，还有三个方法（合成约束、分离模式、分离尺寸）。
         我们得到了这三种模式对应的意思和布局文件中的参数值的对应关系
         （父控件填充屏幕MATCH_PARENT的情况，如果其他情况，请参考下面getChildMeasureSpec方法的结果）：

         约束	布局参数	值	说明
         UNSPECIFIED(未指定)		0	父控件没有对子控件施加任何约束，
         子控件可以得到任意想要的大小（使用较少）。

         EXACTLY(完全)	match_parent/具体宽高值	1073741824
         父控件给子控件决定了确切大小，子控件将被限定在给定的边界里而忽略它本身大小。
         特别说明如果是填充父窗体，说明父控件已经明确知道子控件想要多大的尺寸了
         （就是剩余的空间都要了）栗子：碗柜最大的碗就这么大，菜有多少都只能盛到这个最大的碗里，
         盛不下的我就管不了了（吃掉或者倒掉）

         AT_MOST(至多)	wrap-content	-2147483648	子控件至多达到指定大小的值。
         包裹内容就是父窗体并不知道子控件到底需要多大尺寸（具体值），
         需要子控件自己测量之后再让父控件给他一个尽可能大的尺寸以便让内容全部显示
         但不能超过包裹内容的大小栗子：碗柜有各种大小的碗，菜少就拿小碗放，
         菜多就拿大碗放，但是不能浪费碗的容积，要保证碗刚好盛满菜

          measureChildren 就是遍历所有子控件挨个测量，最终测量子控件的方法就是measureChild
         和measureChildWithMargins 了，我们先了解几个知识点：

         measureChildWithMargins跟measureChild的区别就是父控件支不支持margin属性
           支不支持margin属性对子控件的测量是有影响的，比如我们的屏幕是1080x1920的，
         子控件的宽度为填充父窗体，如果使用了marginLeft并设置值为100；
         在测量子控件的时候，如果用measureChild，计算的宽度是1080，
         而如果是使用measureChildWithMargins，计算的宽度是1080-100 = 980。

         怎样让ViewGroup支持margin属性？
           ViewGroup中有两个内部类ViewGroup.LayoutParams和ViewGroup. MarginLayoutParams，
         MarginLayoutParams继承自LayoutParams ，这两个内部类就是VIewGroup的布局参数类，
         比如我们在LinearLayout等布局中使用的layout_width\layout_hight等以“layout_ ”
         开头的属性都是布局属性。在View中有一个mLayoutParams的变量用来保存这个View的所有布局属性。

         LayoutParams和MarginLayoutParams 的关系：
         LayoutParams 中定义了两个属性（现在知道我们用的layout_width\layout_hight的来头了吧？）：
         MarginLayoutParams 是LayoutParams的子类，它当然也延续了layout_width\layout_hight 属性
         ，但是它扩充了其他属性：

         为什么LayoutParams 类要定义在ViewGroup中？
           大家都知道ViewGroup是所有容器的基类，一个控件需要被包裹在一个容器中，这个容器必须提供一种规则控制子控件的摆放，比如你的宽高是多少，距离那个位置多远等。所以ViewGroup有义务提供一个布局属性类，用于控制子控件的布局属性。

         为什么View中会有一个mLayoutParams 变量？
           我们在之前学习自定义控件的时候学过自定义属性，我们在构造方法中，初始化布局文件中的属性值，我们姑且把属性分为两种。一种是本View的绘制属性，比如TextView的文本、文字颜色、背景等，这些属性是跟View的绘制相关的。另一种就是以“layout_”打头的叫做布局属性，这些属性是父控件对子控件的大小及位置的一些描述属性，这些属性在父控件摆放它的时候会使用到，所以先保存起来，而这些属性都是ViewGroup.LayoutParams定义的，所以用一个变量保存着。

         怎样让ViewGroup支持margin属性？
         ②. getChildMeasureSpec方法
           measureChildWithMargins跟measureChild 都调用了这个方法，
         其作用就是通过父控件的宽高约束规则和父控件加在子控件上的宽高布局参数生成一个子控件的约束。

         我们知道View的onMeasure方法需要两个参数（父控件对View的宽高约束），
         这个宽高约束就是通过这个方法生成的。有人会问为什么不直接拿着子控件的宽高参数去测量子控件呢？
         打个比方，父控件的宽高约束为wrap_content，而子控件为match_perent，是不是很有意思，
         父控件说我的宽高就是包裹我的子控件，我的子控件多大我就多大，而子控件说我的宽高填充父窗体，
         父控件多大我就多大。最后该怎么确定大小呢？所以我们需要为子控件重新生成一个新的约束规则。
         只要记住，子控件的宽高约束规则是父控件调用getChildMeasureSpec方法生成。

         getChildMeasure方法代码不多，也比较简单，就是几个switch将各种情况考虑后生成一个子控件的新的宽高约束，
         这个方法的结果能够用一个表来概括：

         父控件的约束规则	子控件的宽高属性	子控件的约束规则	说明
         EXACTLY（父控件是填充父窗体，或者具体size值）	具体的size（20dip）/MATCH_PARENT
         EXACTLY	子控件如果是具体值，约束尺寸就是这个值，模式为确定的；子控件为填充父窗体，
         约束尺寸是父控件剩余大小，模式为确定的。
         WRAP-CONTENT	AT_MOST	子控件如果是包裹内容，约束尺寸值为父控件剩余大小 ，模式为至多
         AT_MOST（父控件是包裹内容）	具体的size（20dip）	EXACTLY	子控件如果是具体值，
         约束尺寸就是这个值，模式为确定的；
         MATCH_PARENT/WRAP_CONTENT	AT_MOST	子控件为填充父窗体或者包裹内容 ，
         约束尺寸是父控件剩余大小 ，模式为至多
         UNSPECIFIED（父控件未指定）	具体的size（20dip）	EXACTLY	子控件如果是具体值，
         约束尺寸就是这个值，模式为确定的；
         MATCH_PARENT/WRAP_CONTENT	UNSPECIFIED	子控件为填充父窗体或者包裹内容 ，约束尺寸0，模式为未指定

         进行了上面的步骤，接下来就是在measureChildWithMarginsh或者measureChild中
         调用子控件的measure方法测量子控件的尺寸了。

         ③. View的onMeasure
           View中onMeasure方法已经默认为我们的控件测量了宽高，我们看看它做了什么工作：


         从源码我们了解到：

         如果View的宽高模式为未指定，他的宽高将设置为android:minWidth/Height =”“值与背景宽高值中较大的一个；
         如果View的宽高 模式为 EXACTLY （具体的size ），最终宽高就是这个size值；
         如果View的宽高模式为EXACTLY （填充父控件 ），最终宽高将为填充父控件；
         如果View的宽高模式为AT_MOST （包裹内容），最终宽高也是填充父控件。
         也就是说如果我们的自定义控件在布局文件中，只需要设置指定的具体宽高，或者MATCH_PARENT 的情况，我们可以不用重写onMeasure方法。

         但如果自定义控件需要设置包裹内容WRAP_CONTENT ，我们需要重写onMeasure方法，为控件设置需要的尺寸；默认情况下WRAP_CONTENT 的处理也将填充整个父控件。

         ④. setMeasuredDimension
           onMeasure方法最后需要调用setMeasuredDimension方法来保存测量的宽高值，如果不调用这个方法，可能会产生不可预测的问题。


         这篇博客我们学习了onMeasure方法测量控件大小的流程，以及里面执行的一些细节，总结一下知识点：

         测量控件大小是父控件发起的
         父控件要测量子控件大小，需要重写onMeasure方法，然后调用measureChildren或者measureChildWithMargin方法
         on Measure方法的参数是通过getChildMeasureSpec生成的
         如果我们自定义控件需要使用wrap_content，我们需要重写onMeasure方法
         测量控件的步骤：
         父控件onMeasure->measureChildren`measureChildWithMargin->getChildMeasureSpec->
         子控件的measure->onMeasure->setMeasureDimension->
         父控件onMeasure结束调用setMeasureDimension`保存自己的大小
         这篇博客的内容比较简单，稍微有点绕的就是getChildMeasureSpec这个方法，
         我们可以结合我们平时写布局的经验，去推导约束规则，只要理解之后就不会感觉绕了。
         可能我写得不是很清楚，如果有什么建议欢迎留言，如果认为对你有帮助，那就点个赞呗~

         */

        }

    /**
004.
     线程间通信和进程间通信*/
    private void aad(){
/**
 * 当一个程序第一次启动的时候，Android会启动一个LINUX进程和一个主线程。
 * 默认的情况下，所有该程序的组件都将在该进程和线程中运行。
 * 同时，Android会为每个应用程序分配一个单独的LINUX用户。Android会尽量保留一个正在运行进程，
 * 只在内存资源出现不足时，Android会尝试停止一些进程从而释放足够的资源给其他新的进程使用，
 * 也能保证用户正在访问的当前进程有足够的资源去及时地响应用户的事件。线程是进程的有机组成部分，
 * 是CPU调度的基础。一般情况下，都有主线程和其他线程之分，只有主线程才可以刷新UI。
 * 应用程序启动后，将创建ActivityThread 主线程。

 不同包名的组件可以一定的方式运行在同一个进程中。

 一个Activity启动后，至少会有3个线程。一个主线程和2个binder线程。

 1.安卓线程间通信的方式有以下几种
 1）共享变量（内存）

 2）管道

 3）handle机制

 runOnUiThread(Runnable)

 view.post(Runnable)

 android 进程内的消息驱动机制---Handler,MessageQueue,Runnable,Looper

 Looper和Message的处理机制:首先在主线程中创建了一个handler对象,
 目的是为了处理从子线程发送过来的消息,然后当子线程有发送消息的需求时会使用Message对象,
 消息首先会被存储在Message queue消息队列中,主线程还有一个Looper消息轮询器,会循环遍历消息队列中的消息,
 当发现消息的时候会发送消息给handler处理(更新ui等操作),handler调用handleMessage处理完后将Message
 置为null以便回收.



 2进程间的通信
 进程间的通信：

 bind机制（IPC->AIDL)

 linux级共享内存

 boradcast

 Activity之间可以通过intent来传递数据



 3.安卓结束进程几种方式

 1)使用ActivityManager中的restartPackage(String packname)方法,这里清单文件里面要配置权限

 2)android.os.process.killProcess(int pid)只能终止本程序的进程

 3)System.exit()

 4)在android2.2版本之后则不能再使用restartPackage()方法，
 而应该使用killBackgroundProcesses()方法,同时应该配置权限

 5)利用反射调用forceStopPackage来结束
 Method forceStopPackage = am.getClass().getDeclaredMethod("forceStopPackage", String.class);
 forceStopPackage.setAccessible(true);
 forceStopPackage.invoke(am, yourpkgname);
 配置文件中需要添加定义：
 android:sharedUserId="android.uid.system"
 　　另外需要再在配置文件添加权限：
 <uses-permission android:name="android.permission.FORCE_STOP_PACKAGES"></uses-permission>
 6)使用Linux指令kill -9

 7)退出到主屏幕

 由于应用程序之间不能共享内存。在不同应用程序之间交互数据（跨进程通讯），在android SDK中提供了4种用于跨进程通讯的方式。这4种方式正好对应于android系统中4种应用程序组件：Activity、Content Provider、Broadcast和Service。其中Activity可以跨进程调用其他应用程序的Activity；Content Provider可以跨进程访问其他应用程序中的数据（以Cursor对象形式返回），当然，也可以对其他应用程序的数据进行增、删、改操 作；Broadcast可以向android系统中所有应用程序发送广播，而需要跨进程通讯的应用程序可以监听这些广播；Service和Content Provider类似，也可以访问其他应用程序中的数据，但不同的是，Content Provider返回的是Cursor对象，而Service返回的是Java对象，这种可以跨进程通讯的服务叫AIDL服务。





 Activity

 Activity的跨进程访问与进程内访问略有不同。虽然它们都需要Intent对象，

 但跨进程访问并不需要指定Context对象和Activity的 Class对象，
 而需要指定的是要访问的Activity所对应的Action（一个字符串）。
 有些Activity还需要指定一个Uri（通过 Intent构造方法的第2个参数指定）。

 在android系统中有很多应用程序提供了可以跨进程访问的Activity，例如，

 下面的代码可以直接调用拨打电话的Activity。

 Intent callIntent = new  Intent(Intent.ACTION_CALL, Uri.parse("tel:12345678" );
 startActivity(callIntent);



 Content Provider

 Android应用程序可以使用文件或SqlLite数据库来存储数据。
 Content Provider提供了一种在多个应用程序之间数据共享的方式（跨进程共享数据）。
 应用程序可以利用Content Provider完成下面的工作

 1. 查询数据
 2. 修改数据
 3. 添加数据
 4. 删除数据

 虽然Content Provider也可以在同一个应用程序中被访问，但这么做并没有什么意义。
 Content Provider存在的目的向其他应用程序共享数据和允许其他应用程序对数据进行增、删、改操作。
 Android系统本身提供了很多Content Provider，例如，音频、视频、联系人信息等等。
 我们可以通过这些Content Provider获得相关信息的列表。这些列表数据将以Cursor对象返回。
 因此，从Content Provider返回的数据是二维表的形式。



 广播（Broadcast）
 广播是一种被动跨进程通讯的方式。当某个程序向系统发送广播时，
 其他的应用程序只能被动地接收广播数据。这就象电台进行广播一样，
 听众只能被动地收听，而不能主动与电台进行沟通。
 在应用程序中发送广播比较简单。只需要调用sendBroadcast方法即可。
 该方法需要一个Intent对象。通过Intent对象可以发送需要广播的数据。





 Service


 1.利用AIDL Service实现跨进程通信

 这是我个人比较推崇的方式，因为它相比Broadcast而言，虽然实现上稍微麻烦了一点，
 但是它的优势就是不会像广播那样在手机中的广播较多时会有明显的时延，甚至有广播发送不成功的情况出现。

 注意普通的Service并不能实现跨进程操作，实际上普通的Service和它所在的应用处于同一个进程中，
 而且它也不会专门开一条新的线程，因此如果在普通的Service中实现在耗时的任务，需要新开线程。

 要实现跨进程通信，需要借助AIDL(Android Interface Definition Language)。
 Android中的跨进程服务其实是采用C/S的架构，因而AIDL的目的就是实现通信接口。


 */
    }



    /**

     005.ArrayList删除元素*/
    private void aae(){
        /**
         * Arraylist删除一个元素,有两种方法
         1.按下标删除  如:
         list.remove(0),
         list.remove(list.size() -1);

         2.按元素删除 如:
         list.remove(list.get(0)) 删除第一个元素
         list.remove(list.get(list.size()-1)) 删除最后一个元素

         删除后list的大小会改变,注意在for循环中remove时的陷阱
         */
    }

    /**

     006.写出你认为最优的懒汉式单例模式*/

    private void aaf(){
        /**
         * 懒汉模式：

         class Singleton {
         private volatile static Singleton singleton;
         private Singleton (){}
         public static Singleton getSingleton() {
         if (singleton == null) {
         synchronized (Singleton.class) {
         if (singleton == null) {
         singleton = new Singleton();
         }
         }
         }
         return singleton;
         }


         饿汉模式：
         [java] view plain copy
         /**
         * 懒汉式单例模式改进
         * 实现延迟加载，缓存
         * Lazy initialization holder class
         * 这个模式综合运用了java的类级内部类和多线程缺省同步锁的知识
         * @author qian.xu
         *
         *//**
        public class MySingleton2a {
            /**
             * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
             * 没有绑定的关系，而且只有被调用到才会装载，从而实现了延迟加载
             * @author qian.xu
             *
             *//**
            private static class Singleton{
                /**
                 * 静态初始化器，用JVM来保证线程安全
                 *//**
                private static MySingleton2a singleton = new MySingleton2a();

                static {
                    System.out.println("---->类级的内部类被加载");
                }
                private Singleton(){
                    System.out.println("---->类级的内部类构造函数被调用");
                }
            }
            //私有化构造函数
            private MySingleton2a(){
                System.out.println("-->开始调用构造函数");
            }
            //开放一个公有方法，判断是否已经存在实例，有返回，没有新建一个在返回
            public static MySingleton2a getInstance(){
                System.out.println("-->开始调用公有方法返回实例");
                MySingleton2a s1 = null;
                s1 = Singleton.singleton;
                System.out.println("-->返回单例");
                return s1;
            }
        }

         饿汉式:
         public class Singleton{
         private static Singleton singleton = new Singleton ();
         private Singleton (){}
         public static Singleton getInstance(){return singletion;}
         }

         懒汉式:
         public class Singleton{
         private static Singleton singleton = null;
         public static synchronized synchronized getInstance(){
         if(singleton==null){
         singleton = new Singleton();
         }
         return singleton;
         }
         }

         比较:
         饿汉式是线程安全的,在类创建的同时就已经创建好一个静态的对象供系统使用,以后不在改变
         懒汉式如果在创建实例对象时不加上synchronized则会导致对对象的访问不是线程安全的
         推荐使用第一种
         从实现方式来讲他们最大的区别就是懒汉式是延时加载,
         他是在需要的时候才创建对象,而饿汉式在虚拟机启动的时候就会创建,

         饿汉式无需关注多线程问题、写法简单明了、能用则用。但是它是加载类时创建实例（上面有个朋友写错了）、
         所以如果是一个工厂模式、缓存了很多实例、那么就得考虑效率问题，
         因为这个类一加载则把所有实例不管用不用一块创建。
         懒汉式的优点是延时加载、缺点是应该用同步（想改进的话现在还是不可能，比如double-check）、
         其实也可以不用同步、看你的需求了，多创建一两个无引用的废对象其实也没什么大不了。
         */
    }
    /**

     007.activity意外退出时信息的储存与恢复，onCreate正常进入时的判断。*/
    private void aag(){
        /**
         * 首先从这种情况下Activity的生命周期说起，当横竖屏切换时，Activity会被销毁，
         *
         * onPause,onStop,onDestory均会被调用，但是由于Activity是异常情况下终止的，
         * 所以系统会调用onSaveInstanceState方法对Activity的状态进行保存，该方法在onStop之前调用，
         * 与onPause没有既定的时序关系。当Activity被重新创建后，系统会调用onRestoreInstanceState,
         * 将之前onSaveInstanceState保存的数据Bundle传递给onRestoreInstanceState和onCreate方法，
         * 因此我们可以通过onRestoreInstanceState和onCreate方法判读Activity是否被重建了，如果被重建了，
         * 那么我们就可以取出之前保存的数据并进行恢复，onRestoreInstanceState的调用时机在onStart之后。
         * 需要注意的是：在正常情况下Activity的创建和销毁不会调用onSaveInstanceState和
         * onRestoreInstanceState方法。
         *
         * 如何防止Activity重建
         不仅仅当屏幕方向切换时会重建Activity，当系统配置发生改变的时候Activity都会被重建，例如用户插入外接键盘，运营商改变，界面模式（例如开启夜间模式）等都会导致Activity重建。如果我们不希望当系统配置发生变化界面重建，那么我们需要在AndroidManifest.xml中对Activity的configChange属性进行配置。例如我们不希望屏幕旋转时重建，则需要如下设置：

         android:configChanges="orientation"
         1
         当有多个属性时，用|进行分隔。

         虽然configChanges可以配置的选项有很多，但是我们使用比较多的有：

         orientation：屏幕方向发生了改变，例如横竖屏切换；
         locale：设备的本地位置发生了改变，例如切换了系统语言；
         keyboard：键盘类型发生了改变，例如插入了外接键盘；
         keyboardHidden：键盘的可访问性发生了改变，例如移除了外接键盘；

         注意：如果当我们的minSdkVersion和targetSdkVersion有一个大于13时，
         为了防止旋转屏幕时Activity重启，我们还需要加上screenSize。
         */
    }

    /**

     008.谈谈性能优化*/
    private void aah(){
        /**
         * 稳定（内存溢出、崩溃）
         流畅（卡顿）
         耗损（耗电、流量）
         安装包（APK瘦身）

         一、稳定——内存优化

         由于Android应用的沙箱机制，每个应用所分配的内存大小是有限度的，
         内存太低就会触发LMK——Low Memory Killer机制，就会出现闪退现象。
         先搞懂java的内存是如何分配和回收的，问题就迎刃而解了。

         相关文章：
         Java 垃圾回收器的GC机制，看这一篇就够了
         Android 内存泄漏常见案例及分析
         知道内存是如何分配和内存回收机制后，就算对内存优化有一点的认识和掌握了。
         使用分析工具
         Memory Monitor 工具：
         它是Android Studio自带的一个内存监视工具，它可以很好地帮助我们进行内存实时分析。
         通过点击Android Studio右下角的Memory Monitor标签，打开工具可以看见较浅蓝色代表free的内存，
         而深色的部分代表使用的内存从内存变换的走势图变换，可以判断关于内存的使用状态，
         例如当内存持续增高时，可能发生内存泄漏；当内存突然减少时，可能发生GC等。
         Memory Analyzer工具：
         MAT 是一个快速，功能丰富的 Java Heap 分析工具，通过分析 Java 进程的内存快照 HPROF 分析，
         从众多的对象中分析，快速计算出在内存中对象占用的大小，查看哪些对象不能被垃圾收集器回收，
         并可以通过视图直观地查看可能造成这种结果的对象。

         LeakCanary工具：
         简单，傻瓜式操作。这个工具是在Github开源的，是Square公司出品的，
         不是有一句话嘛，Square出品必属精品，https://github.com/square/leakcanary我们可以在Gradle里引用它。
         Android Lint 工具：
         是Android Sutido种集成的一个Android代码提示工具，它可以给你布局、
         代码提供非常强大的帮助。如果在布局文件中写了三层冗余的LinearLayout布局，
         就会在编辑器右边看到提示。当然这个是一个简单的举例，Lint的功能非常强大，
         大家应该养成写完代码查看Lint的习惯，这不仅让你及时发现代码种隐藏的一些问题，
         更能让你养成良好的代码风格，要知道，这些Lint提示可都是Google大牛们汗水合智慧的结晶。
         稳定性建议
         影响稳定性的原因很多，比如内存使用不合理、代码异常场景考虑不周全、代码逻辑不合理等，
         都会对应用的稳定性造成影响。其中最常见的两个场景是：Crash 和 ANR，
         这两个错误将会使得程序无法使用。所以做好Crash监控，把崩溃信息、
         异常信息收集记录起来，以便后续分析;合理使用主线程处理业务，不要在主线程中做耗时操作，
         防止ANR程序无响应发生。


         二、流畅——交互优化
         交互是与用户体验最直接的方面，交互场景大概分为四个部分：UI 绘制、应用启动、页面跳转、
         事件响应，如图：


         四个方面大致归为如下两类：
         界面绘制：主要原因是绘制的层级深、页面复杂、刷新不合理，
         由于这些原因导致卡顿的场景更多出现在 UI 和启动后的初始界面以及跳转到页面的绘制上。
         数据处理：导致这种卡顿场景的原因是数据处理量太大，一般分为三种情况，
         一是数据在处理 UI 线程，二是数据处理占用 CPU 高，导致主线程拿不到时间片，
         三是内存增加导致 GC 频繁，从而引起卡顿。


         总结原因：我们知道Android的绘制步骤是：：Measure、Layout、Draw，所以布局的层级越深、
         元素越多、耗时也就越长。还有就是Android 系统每隔 16ms 发出 VSYNC 信号，触发对
         UI 进行渲染，如果每次渲染都成功，这样就能够达到流畅的画面所需的 60FPS。
         如果某个操作花费的时间是 24ms ，系统在得到 VSYNC 信号时就无法正常进行正常渲染，
         这样就发生了丢帧现象。那么用户在 32ms 内看到的会是同一帧画面，无法在 16ms 完成渲染，
         最终引起刷新不及时。两个根本原因：


         绘制任务太重，绘制一帧内容耗时太长。

         主线程太忙，根据系统传递过来的 VSYNC 信号来时还没准备好数据导致丢帧。



         建议1：布局优化
         在Android种系统对View进行测量、布局和绘制时，都是通过对View数的遍历来进行操作的。
         如果一个View数的高度太高就会严重影响测量、布局和绘制的速度。Google也在其API文档中建
         议View高度不宜哦过10层。现在版本种Google使用RelativeLayout替代LineraLayout作为默认根布局，
         目的就是降低LineraLayout嵌套产生布局树的高度，从而提高UI渲染的效率。
         布局复用，使用<include>标签重用layout；
         提高显示速度，使用<ViewStub>延迟View加载；
         减少层级，使用<merge>标签替换父级布局；
         注意使用wrap_content，会增加measure计算成本；

         删除控件中无用属性；

         建议2：绘制优化
         过度绘制是指在屏幕上的某个像素在同一帧的时间内被绘制了多次。在多层次重叠的 UI 结构中，
         如果不可见的 UI 也在做绘制的操作，就会导致某些像素区域被绘制了多次，从而浪费了多余的
         CPU 以及 GPU 资源。所以避免过度绘制：
         布局上的优化。移除 XML 中非必须的背景，移除 Window 默认的背景、按需显示占位背景图片

         自定义View优化。使用 canvas.clipRect()来帮助系统识别那些可见的区域，只有在这个区域内才会被绘制。


         建议3：启动优化
         UI 布局。应用一般都有闪屏页，优化闪屏页的 UI 布局，可以通过 Profile GPU Rendering 检测丢帧情况。

         启动加载逻辑优化。可以采用分布加载、异步加载、延期加载策略来提高应用启动速度。

         数据准备。数据初始化分析，加载数据可以考虑用线程初始化等策略。

         建议4：刷新优化
         减少刷新次数；
         缩小刷新区域；
         建议5：动画优化
         在实现动画效果时，需要根据不同场景选择合适的动画框架来实现。
         有些情况下，可以用硬件加速方式来提供流畅度。

         三、节省——耗电优化
         在移动设备中，电池的重要性不言而喻，没有电什么都干不成。对于操作系统和设备开发商来说，

         耗电优化一致没有停止，去追求更长的待机时间，而对于一款应用来说，并不是可以忽略电量使用问题
         ，特别是那些被归为“电池杀手”的应用，最终的结果是被卸载。因此，应用开发者在实现需求的同时，
         需要尽量减少电量的消耗。

         在 Android5.0 以前，在应用中测试电量消耗比较麻烦，也不准确，5.0 之后专门引入了一
         个获取设备上电量消耗信息的 API:Battery Historian。Battery Historian 是一款由
         Google 提供的 Android 系统电量分析工具，和Systrace 一样，是一款图形化数据分析工具

         ，直观地展示出手机的电量消耗过程，通过输入电量分析文件，显示消耗情况，最后提供一些

         可供参考电量优化的方法。

         除此之外，还有一些常用方案可提供：

         计算优化，避开浮点运算等。

         避免 WaleLock 使用不当。

         使用 Job Scheduler。


         四、APK瘦身
         应用安装包大小对应用使用没有影响，但应用的安装包越大，
         用户下载的门槛越高，特别是在移动网络情况下，用户在下载应用时，
         对安装包大小的要求更高，因此，减小安装包大小可以让更多用户愿意下载和体验产品。

         常用应用安装包的构成，如图所示：







         从图中我们可以看到：



         assets文件夹。存放一些配置文件、资源文件，assets不会自动生成对应的 ID，
         而是通过 AssetManager 类的接口获取。

         res。res 是 resource 的缩写，这个目录存放资源文件，会自动生成对应的 ID 并映射到
         .R 文件中，访问直接使用资源 ID。

         META-INF。保存应用的签名信息，签名信息可以验证 APK 文件的完整性。

         AndroidManifest.xml。这个文件用来描述 Android 应用的配置信息，
         一些组件的注册信息、可使用权限等。

         classes.dex。Dalvik 字节码程序，让 Dalvik 虚拟机可执行，一般情况下
         ，Android 应用在打包时通过 Android SDK 中的 dx 工具将 Java 字节码转换为 Dalvik 字节码。

         resources.arsc。记录着资源文件和资源 ID 之间的映射关系，用来根据资源 ID 寻找资源。



         减少安装包大小的常用方案

         代码混淆。使用proGuard 代码混淆器工具，它包括压缩、优化、混淆等功能。

         资源优化。比如使用 Android Lint 删除冗余资源，资源文件最少化等。

         图片优化。比如利用 AAPT 工具对 PNG 格式的图片做压缩处理，降低图片色彩位数等。

         避免重复功能的库，使用 WebP图片格式等。

         插件化。比如功能模块放在服务器上，按需下载，可以减少安装包大小。




         小结：
         最后说一句，性能优化是一个非常具有挑战性的工作，上面列出很多分析内存、
         优化内存的方法，但是真正优化工作远不止这么简单，这里只是列举了一些入门的方法，
         而要进行完美的内存优化、内存分析绝非一日之功，需要开发者深厚的技术功底合耐心。




         */
    }
    /**
     009.JS的交互理解吗？平时工作用的多吗，项目中是怎么与Web交互的？*/
    private void aai(){
        /**
         *
         * js代码与Java代码互相调用
         * 在onpagestart()时,
         * 过滤加载的url,根据指定的字段进行相关的操作
         *一点小建议

         如果你的项目中有很多或者一定数量的JS交互，建议写一个有返回值的接口。然后通过JSON参数来进行控制。
         内部制定一个解析协议，根据JSON的数据来决定要做什么事，避免大量定义接口 ，也避免构建太多的实例消耗资源
         */
    }

    /**

     010.MVC -> MVP -> MVVM 这样变化的原因，MVP的不足，MVVM为什么代替了MVP*/
    private void aaj(){
        /**
         * MVC优缺点
         优点
         首先最重要的一点是多个视图能共享一个模型，同一个模型可以被不同的视图重用，
         大大提高了代码的可重用性。
         由于MVC的三个模块相互独立，在其中改变一个，其他两个可以保持不变，
         这样可以把耦合降得很低，这样可以使开发人员可以只关注整个系统中的某一层
         控制器提高了应用程序的灵活性和可配置型。
         控制器可以用来连接不同的模型和视图去完成用户的需求，
         这样控制器可以为构造应用程序提供强有力的手段

         缺点
         增加了系统结构的实现的复杂性
         视图与控制器之间的联系过于紧密，视图如果没有控制器的存在，
         能够做的事情少之又少，这样视图就很难独立应用了
         视图对模型的数据的访问效率过低，因为之间需要多次的调用
         View无法组件化，View依赖于特定的Model，如果需要把这个View抽出来用在下
         一个应用程序复用就比较困难了
         *
         *
         *  MVP优缺点
         MVP的优点
         便于测试。Presenter对View是通过接口进行，在对Presenter进行不依赖UI环境的单元测试的时候。
         可以通过Mock一个View对象，这个对象只需要实现了View的接口即可。
         然后依赖注入到Presenter中，单元测试的时候就可以完整的测试Presenter应用逻辑的正确性。
         这里根据上面的例子给出了Presenter的单元测试样例。
         View可以进行组件化。在MVP当中，View不依赖Model。这样就可以让View从特定的业务场景中脱离出来，
         可以说View可以做到对业务完全无知。它只需要提供一系列接口提供给上层操作。
         这样就可以做到高度可复用的View组件。
         MVP的缺点
         代码量会一些，实现的难度也会增加一些
         *
         *
         * MV-VM优缺点
         优点

         提高可维护性。解决了MVP大量的手动View和Model同步的问题，提供双向绑定机制。提高了代码的可维护性。
         简化测试。因为同步逻辑是交由Binder做的，View跟着Model同时变更，所以只需要保证Model的正确性，
         View就正确。大大减少了对View同步更新的测试。

         缺点
         过于简单的图形界面不适用，或说牛刀杀鸡。
         对于大型的图形应用程序，视图状态较多，ViewModel的构建和维护的成本都会比较高
         数据绑定的声明是指令式地写在View的模版当中的，这些内容是没办法去打断点debug的。


         * 前言
         做客户端开发、前端开发，大致都应该听说过这么几个名词MVC、MVP、MVVM，
         这些架构的思想大多是为了解决界面应用程序复杂的逻辑问题。同时这些框架的核心目的在于，
         职责分离，不同的层次要做不同的事情。

         无论是哪种MV**系列，都涉及到了Model和View，如果单纯的只有Model和View，
         他们是没有办法一起协同工作的，所以就有了各种MV..的设计模式。

         MVXX模式：
         MVC
         MVP
         MVVM

         这三种架构模式都是现在比较流行的，在不同的项目中，可能采用不同的架构模式，
         今天我们就围绕着这三种架构模式的试用场景介绍一下他们的概念，以及异同。

         MVC
         MVC(Model-View-Controller),Model:逻辑模型，View:视图模型，Controller控制器。
         简单说这就是一种设计应用程序的思想，目的在于将业务逻辑、数据、界面分离，
         将业务逻辑聚集到一个部件里面，在改进或者想要定制界面及用户交互时，
         不需要重写编写业务逻辑。Controller和View都依赖Model层，Controller和View相互依赖。
         操作的过程：用户在界面上进行操作(例如手机屏幕)，这个时候View会捕捉到用户的操作，
         然后将这个操作的处理权利交给Controller，Controller会对来自View的数据进行预处理，
         决定调用哪个Model的接口，然后由Model执行相应的逻辑，当Model变更之后，
         再利用观察者模式通知View，View通过观察者模式收到Model的消息之后，向Model请求最新的数据，
         然后更新页面，如下图：
         看似没有什么特别的地方，但是由几个需要特别关注的关键点：

         View是把控制权交移给Controller，Controller执行应用程序相关的应用逻辑
         （对来自View数据进行预处理、决定调用哪个Model的接口等等）。

         Controller操作Model，Model执行业务逻辑对数据进行处理。但不会直接操作View，
         可以说它是对View无知的。

         View和Model的同步消息是通过观察者模式进行，
         而同步操作是由View自己请求Model的数据然后对视图进行更新。

         需要特别注意的是MVC模式的精髓在于第三点：Model的更新是通过观察者模式告知View的，
         具体表现形式可以是Pub/Sub或者是触发Events。而网上很多对于MVC的描述都没有强调这一点。
         通过观察者模式的好处就是：不同的MVC三角关系可能会有共同的Model，
         一个MVC三角中的Controller操作了Model以后，两个MVC三角的View都会接受到通知，
         然后更新自己。保持了依赖同一块Model的不同View显示数据的实时性和准确性。
         我们每天都在用的观察者模式，在几十年前就已经被大神们整合到MVC的架构当中。


         MVP
         Model(Model View Presenter),Model:逻辑模型，View:视图模型，Presenter:接口。

         关于MVP的定义：
         - MVC的演化版本，让Model和View完全解耦
         - 代码清晰，不过增加了很多类
         MVP中的P，是Presenter的含义，和MVC比较类似，都是将用户对View的操作交付给Presenter，
         Presenter会执行相应的逻辑，在这过程中会操作Model，当Model执行完业务逻辑之后，
         同样是通过观察者模式把自己的结果传递出去，不过不是告诉View，而是告诉Presenter，
         Presenter得到消息后，通过View的接口更新页面。
         在Android中，我们的View可能仅仅就是个布局文件，它能做的事情少之又少，
         真正与布局文件进行数据绑定操作的事Activity，所以这样做就使Activity即像View又像Controller。

         应用了MVP之后：
         - View:对应Activity，负责View的绘制以及与用户交互
         - Model:业务逻辑和实体模型
         - Presenter:负责完成View与Model之间的交互




         MVP与MVC区别
         如下图所示：
         MVVM
         MVVM是Model-View-ViewModel的简写，MVVM是思想上的一种变革，也可以看成是MVP的一种变革，
         它是将"数据模型数据双向绑定"的思想作为核心，因此在View和Model之间便不需要我们写联系了，
         我们在修改数据的时候视图就可以发生变化，我们在修改视图的时候数据也是会发生变化的，
         可以在一定程度上提高我们的开发效率的。

         调用关系

         MVVM的调用关系和MVP一样。但是，在ViewModel当中会有一个叫Binder，
         或者是Data-binding engine的东西。以前全部由Presenter负责的View和Model之间数据
         同步操作交由给Binder处理。你只需要在View的模版语法当中，指令式地声明View上的显
         示的内容是和Model的哪一块数据绑定的。当ViewModel对进行Model更新的时候，Binder会自
         动把数据更新到View上去，当用户对View进行操作（例如表单输入），Binder也会自动
         把数据更新到Model上去。这种方式称为：Two-way data-binding，双向数据绑定。
         可以简单而不恰当地理解为一个模版引擎，但是会根据数据变更实时渲染。
         也就是说，MVVM把View和Model的同步逻辑自动化了。以前Presenter负责的View和
         Model同步不再手动地进行操作，而是交由框架所提供的Binder进行负责。只需要告诉Binder，
         View显示的数据对应的是Model哪一部分即可。

         Android官方推出的MVVM的DataBinding，便是一个双向绑定的库。

         */
    }
    /**

     011.MVC的情况下怎么把Activity的C和V抽离*/
    private void aak(){
        /**
         * MVC与android分别对应内容如下：
         　　1、模型层（model）：对数据库的操作、对网络等的操作都应该在model里面处理，
         对业务计算等操作也是必须放在的该层的。
         　　2、视图层（view）：一般采用xml文件进行界面的描述，使用的时候可以非常方便的引入，
         在android中也可以使用javascript+html等的方式作为view层，
         这里需要进行java和javascript之间的通信，android提供了它们之间非常方便的通信实现。
         　　3、控制层（controller）：android的控制层通常在acitvity，
         不要直接在acitivity中写代码，要通过activity交割model业务逻辑层处理，
         这样做的另外一个原因是android中的acitivity的响应时间是5s，如果耗时的操作放在这里，
         程序就很容易被回收掉。
         　　提示：mvc是model,view,controller的缩写，mvc包含三个部分：
         　　1、模型（model）对象：是应用程序的主体部分，所有的业务逻辑都应该写在该层。
         　　2、视图（view）对象：是应用程序中负责生成用户界面的部分。
         也是在整个mvc架构中用户唯一可以看到的一层，接收用户的输入，显示处理结果。
         　　3、控制器（control）对象：是根据用户的输入，
         控制用户界面数据显示及更新model对象状态的部分，控制器更重要的一种导航功能，想用用户出发的相关事件，交给m处理。
         */
    }

    /**
     012.各个网络框架之间的差异和优缺点，网络框架代替进化的原因*/
    private void aal(){
        /**
         * Volley
         既然在android2.2之后不建议使用Http Client，那么有没有一个库是android2.2及以下版本使用Http Client，
         而android2.3及以上版本使用HttpUrlConnection的呢，答案是肯定的，
         就是Volley,它是android开发团队在2013年Google I/O大会上推出了一个新的网络通信框架

         Volley可以说是把AsyncHttpClient和Universal-Image-Loader的优点集于了一身，
         既可以像AsyncHttpClient一样非常简单地进行HTTP通信，
         也可以像Universal-Image-Loader一样轻松加载网络上的图片。除了简单易用之外，
         Volley在性能方面也进行了大幅度的调整，它的设计目标就是非常适合去进行数据量不大，
         但通信频繁的网络操作，而对于大数据量的网络操作，比如说下载文件等，Volley的表现就会非常糟糕

         特点
         Volley的优势在于处理小文件的http请求；
         在Volley中也是可以使用Okhttp作为传输层
         Volley在处理高分辨率的图像压缩上有很好的支持；
         NetworkImageView在GC的使用模式上更加保守，在请求清理上也更加积极，
         networkimageview仅仅依赖于强大的内存引用，并当一个新请求是来自ImageView或ImageView离开屏幕时
         会清理掉所有的请求数据。

         okHttp
         okhttp 是一个 Java 的 HTTP+SPDY 客户端开发包，同时也支持 Android。需要Android 2.3以上。

         特点
         OKHttp是Android版Http客户端。非常高效，支持SPDY、连接池、GZIP和 HTTP 缓存。
         默认情况下，OKHttp会自动处理常见的网络问题，像二次连接、SSL的握手问题。
         如果你的应用程序中集成了OKHttp，Retrofit默认会使用OKHttp处理其他网络层请求。
         从Android4.4开始HttpURLConnection的底层实现采用的是okHttp.

         Retrofit
         特点
         性能最好，处理最快
         使用REST API时非常方便；
         传输层默认就使用OkHttp；
         支持NIO；
         拥有出色的API文档和社区支持
         速度上比volley更快；
         如果你的应用程序中集成了OKHttp，Retrofit默认会使用OKHttp处理其他网络层请求。
         默认使用Gson
         https://www.cnblogs.com/changyaohua/p/4992987.html
         */
    }

    /**
     013.图片缓存框架的差异和优缺点，有没有比Glide更好的图片加载框架？*/
    private void aam(){
        /**
         *为什么图片加载我首先想到Glide，图片加载框架用了不少，从afinal框架的afinalBitmap，
         * Xutils的BitmapUtils，老牌框架universalImageLoader,著名开源组织square的picasso,
         * google推荐的glide到FaceBook推出的fresco。
         * 这些我前前后后都体验过，那么面对这么多的框架，该如何选择呢？下面简单分析下我的看法。
         afinal和Xuils在github上作者已经停止维护了，开源社区最新的框架要属KJFramework，
         不过这种快速开发框架看似很好用，功能也应有尽有，小型项目也罢，大型项目我不是很推荐，
         这样做项目的耦合度太高，一旦出现停止维护，而新的问题不断增加，没人处理就麻烦了。

         在glide和fresco还未出来的时候，当时最火的莫过于universalImageLoader和picasso了，
         当时觉得universalImageLoader配置相对picasso麻烦，虽然提供了各种配置，
         但是没有实践过，根本不知道如何配置，还不如都采用默认配置
         ，就选择了picasso作为图片加载框架，用了近一年的时间，没有太大的问题，
         且使用简单，或许是因为之前的项目太过于简单，周期也并不是很长，还有使用eclipse开发，
         一个很大的问题一直都没有暴露出来，换上了最新的Android Studio可以清晰的看到各种性能相关的监控，
         如cpu还有内存监控，终于知道了之前做的项目都那么的卡顿的罪魁祸首，
         picasso加载稍微大一点的图片就特别耗内存，通常一个listView或者顶部滑动广告栏都含有多张图片，
         这使得做出的页面只要含图片较多就异常卡顿（之前的时候还把它归结为测试机不好），
         知道这一点后我就有点想把picasso给替换掉，但这一次我不能那么粗心。

         测试了picasso，glide，universalImageLoader，fresco这四个框架，测试内容大概有以下几项，
         内存测试，大图片测试，小图片测试，本地图片，网络图片当然还结合官方文档体验其特色功能，
         内存测试中，glide，universalImageLoader，fresco表现都非常优秀，picasso这一点上实在是太糟糕了，
         小图片差别也不是很大，稍微大点图片内存消耗就要比其他高出几倍，这一点上证明了我的猜想，
         picasso不能再用了，下面一项项分析其他框架，在高于2M左右大图测试中fresco的表现则和picasso
         一样直接神马都不显示，项目中要实现大图预览功能，这点上是不行的，接着看universalImageLoader
         和glide在这几项测试中成绩都很好，到底该如何选择呢？

         因为我项目之前用的picasso，glide从用法上几乎就是另一个picasso，
         从picasso转移到glide相对改动较少，还有一点就是这个项目是google在维护，
         我也能给它更多的信任，相比较universalImageLoader，glide可以支持gif和短视频，
         后期也需要用到，这里不得不谈一下glide优秀的缓存机制了，glide图片缓存默认使用RGB565相当
         于ARGB8888可以节省不少的空间，支持与activity，fragment，application生命周期的联动，
         更智能管理图片请求当然还有其他的扩展更多可以看 glide介绍 当然，glide的方法数量
         比universalImageLoader多了1000多个，遇到64k问题的会比较关注这个。

         刚才只是掠过fresco，其实我对他的期待还是蛮大的，因为刚出来还有居多不稳定的地方，里
         面存在着大量吸引着我的功能，支持webps格式（和jpg一样都是有损压缩格式，
         webps相同质量图片更节省空间），支持渐进式jpeg，可以轻松的定制image的各种属性，
         支持多图请求和图片复用，并支持手势缩放和旋转等等，更多介绍 fresco，
         当然，实际用的时候并没有那么好，很多功能都有待完善。

         还有一点细节的地方要注意的，最好不要直接拿来用，至少经过自己简单的封装，
         而不是直接在项目中使用，一个简单的例子，后期图片过多，可能需要另外配置一台机器单独存放图片，
         主机地址做成可配置，可不要因为一个简单的需求又要加班了
         */
    }

    /**

     项目框架里有没有Base类，BaseActivity和BaseFragment这种封装导致的问题，以及解决方法

     框架里是怎样实现MVC的

     Reftofit用过没有，注解实现的好处？

     项目中的的界面既然是基于View的，有没有动画的处理？

     为什么不推荐软引用，软引用在dvm上的垃圾回收机制和jvm上一样吗？

     LRUCache的删除条件，LRU是什么意思(最近最少使用算法)

     启动页缓存设计 白屏问题(manifest中主题样式        <item name="android:windowBackground">@null</item>
     )

     网络图片怎么加载？Glide如何确定图片加载完毕

     项目框架中对多View的支持？

     Http的request和response的协议组成

     RecyclerView和ListView相比有哪些好处，为什么ListView被RecyclerView代替？

     公司B
     Service的源码

     Handler的实现，Looper怎么终止。

     项目是MVC，那根据自己负责的项目讲下Model、View、Controller层

     问了下昼夜模式、多语种、屏幕适配的问题，追问了下，
     如果要关闭昼夜模式功能怎么办？很多类的话，一个个去关吗？

     有没有接触过JNI和NDK？

     ListView的错位问题原因以及如何处理？

     如何设计一个抽奖系统，比如满200抽20，满500抽50
     */


}
