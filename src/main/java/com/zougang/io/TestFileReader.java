package com.zougang.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Author: 疾风
 * @Date： 2021-04-19
 * @Description: 通过FileReader逐行读取数据
 * @version: 1.0
 */
public class TestFileReader {

    public static int[] toArrayByFileReader(String name) {
        // 使用ArrayList来存储每行读取到的字符串
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            FileReader fr = new FileReader(name);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                arrayList.add(str);
            }
            bf.close();
            fr.close();
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
        TestFileReader tfr = new TestFileReader();
        int[] array = tfr.toArrayByFileReader("src/main/resources/number.txt");
        for(int i : array){
            System.out.println(i);
        }
    }
}
