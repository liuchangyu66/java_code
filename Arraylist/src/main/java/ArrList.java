import javax.swing.plaf.PanelUI;
import java.util.Arrays;

//模拟实现一个java类
public class ArrList {
    public int[] arr;
    public int usedSize;
    //这里我们定义一个顺序表，默认容量为DEFAULTSIZE，实际大小为usedsize.
    public static final int DEFAULTSIZE=10;
    public ArrList(){
        this.arr=new int[DEFAULTSIZE];
    }
    /*获取顺序表长度
    usedSize存储的就是当前顺序表的长度，直接返回即可。*/
    public int size() {
        return this.usedSize;
    }
    /*顺序表是否为空
    此方法我们只想在顺序表内部使用，所以定义为private.*/
    /*Java默认给变量赋值
    在定义变量的时候，如果定义后没有给变量赋值，
    则Java在运行时会自动给变量赋值。
    赋值原则是整数类型int、byte、short、long的自动赋值为0，
    带小数点的float、double自动赋值为0.0，
    boolean的自动赋值为false，其他各供引用类型变量自动赋值为null。*/
    private boolean isEmpty() {
        return this.arr == null;
    }
    /*顺序表是否为满
    此方法我们只想在顺序表内部使用，所以我们定义为private.*/
    private boolean isFull() {
        //如果数组所放元素大于等于数组长度，那么数组满了
        return this.size() >= this.arr.length;
    }
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    //末尾新增元素
    public void add(int data) throws NullException{
        //1.数组为空，报空异常
        if (this.isEmpty()){
            throw new NullException("数组为空");
        }
        //2.数组满了，就先扩容
        if(isFull()){
            this.arr= Arrays.copyOf(arr,2*this.arr.length);
        }
        //3.新增
        this.arr[this.usedSize]=data;
        //4.元素加一
        this.usedSize++;
    }
    //指定位置新增元素
    public void add(int pos, int data) throws RuntimeException,IndexException{
        //1.判断数组是否为空
        if(isEmpty()) {
            throw new NullException("数组为空");
        }
        //2.判断新增位置是否合法,抛数组越界异常
        if(pos < 0 || pos > this.arr.length) {
            throw new IndexException("数组越界");
        }
        //3.判断数组是否已满，进行扩容
        if(isFull()) {
            this.arr = Arrays.copyOf(arr,2 * this.arr.length);
        }
        //4.进行新增
        for (int i = this.usedSize - 1; i >= pos; i--) {
            this.arr[i+1] = this.arr[i];
        }
        this.arr[pos] = data;
        this.usedSize++;
    }
    //判断是否包含某元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(toFind == this.arr[i]) {
                return true;
            }
        }
        return false;
    }
    //查找某个元素对应的位置(找索引)
    public int indexOf(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(toFind == this.arr[i]) {
                return i;
            }
        }
        return -1;
    }
    //获取 pos 位置的元素
    public int get(int pos) throws IndexException{
        //判断pos位置是否合法
        if(pos < 0 || pos >= this.usedSize) {
            throw new IndexException("输入pos位置数组越界");
        }else {
            return this.arr[pos];
        }
    }
    //给 pos 位置的元素赋值
    public void set(int pos, int value) throws NullException,IndexException{
        if(isEmpty()) {
            throw new NullException("数组为空");
        }
        //2.判断新增位置是否合法,抛数组越界异常
        if(pos < 0 || pos >= this.arr.length) {
            throw new IndexException("数组越界");
        }
        this.arr[pos] = value;
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove) throws NullException{
        if(isEmpty()) {
            throw new NullException("数组为空");
        }
        int ret = indexOf(toRemove);
        if(ret == -1) {
            System.out.println("不存在此数");
            return;
        }
        if(ret != -1) {
            for (int i = ret; i < this.usedSize - 1; i++) {
                this.arr[i] = this.arr[i+1];
            }
        }
        this.usedSize++;
    }
    //清空顺序表
    public void clear() {
        this.usedSize = 0;
        //如果为引用类型
//        for (int i = 0; i < size(); i++) {
//            this.arr[i] = null;
//        }
//        this.usedSize = 0;
    }
}

