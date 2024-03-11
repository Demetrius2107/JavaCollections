package org.hua.ArrayList;

public class MyArrayList {


    //存储数据的数组
    private Object[] elementData;

    //存储数组的个数
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList(){
        elementData = new Object[DEFAULT_CAPACITY];
    }

    //数据超出默认值时
    public MyArrayList(int capacity){
        if(capacity < 0){
            throw new RuntimeException("容器的容量不能设为负值");
        } else if(capacity == 0){
            elementData = new Object[DEFAULT_CAPACITY];
        } else {
            elementData = new Object[capacity];
        }
    }

    /**
     * 返回list大小 size()
     *
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 判断list是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    public void remove(int index){
        rangeCheck(index);
        int numMove = size - index - 1;
        if(numMove > 0){
            System.arraycopy(elementData,index+1,elementData,index,numMove);
        }
        elementData[--size] = null;
    }

    public void remove(Object object){
        for (int i = 0; i < size; i++) {
            if(getIndex(i).equals(object)){
                remove(i);
            }
        }
    }

    private void add(Object object){
        //扩容
        if(size ==  elementData.length){
            Object[] newArray = new Object[elementData.length+(elementData.length>>1)];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData = newArray;
        }
        elementData[size++] = object;
    }

    //根据索引取值
    public Object getIndex(int index){
        rangeCheck(index);
        return elementData[index];
    }

    //根据索引修改值
    public void setIndex(int index,Object object){
        //检查索引
        rangeCheck(index);
        elementData[index] = object;
    }


    public void rangeCheck(int index){
        if(index < 0 || index >= size){
            try{
                throw new Exception("下标越界");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i] + ",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }


    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("abc");
        System.out.println(myArrayList);
        for (int i = 0; i < 40; i++) {
            myArrayList.add("gao" + i);
        }
        System.out.println(myArrayList);
        final Object index = myArrayList.getIndex(10);
        System.out.println(index);
        System.out.println(myArrayList.size);
        myArrayList.setIndex(1,"你好");
        System.out.println(myArrayList);
        myArrayList.remove(2);
        System.out.println(myArrayList);
        myArrayList.remove("gao4");
        System.out.println(myArrayList);
    }
}
