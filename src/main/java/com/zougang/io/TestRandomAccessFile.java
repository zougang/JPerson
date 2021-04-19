package com.zougang.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * @Author: 疾风
 * @Date： 2021-04-19
 * @Description: 通过RandomAccessFile方式逐行读取文件
 * @version: 1.0
 */
public class TestRandomAccessFile {

    public static int[] toArrayByRandomAccessFile(String name) {
        // 使用ArrayList来存储每行读取到的字符串
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            File file = new File(name);
            RandomAccessFile fileR = new RandomAccessFile(file,"r");
            // 按行读取字符串
            String str = null;
            while ((str = fileR.readLine())!= null) {
                arrayList.add(str);
            }
            fileR.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对ArrayList中存储的字符串进行处理
        int length = arrayList.size();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            String s = arrayList.get(i);
            array[i] = Integer.parseInt(s.trim());
        }
        // 返回数组
        return array;
    }

    public static void main(String[] args){
        int[] array = TestRandomAccessFile.toArrayByRandomAccessFile("src/main/resources/number.txt");
        for(int i : array){
            System.out.println(i);
        }

    }
}
