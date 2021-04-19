package com.zougang.io;

import java.io.*;
import java.util.ArrayList;

/**
 * @Author: 疾风
 * @Date： 2021-04-19
 * @Description: 通过InputStreamReader逐行读取数据
 * @version: 1.0
 */
public class TestInputStreamReader {

    public static int[] toArrayByInputStreamReader(String name) {
        // 使用ArrayList来存储每行读取到的字符串
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            File file = new File(name);
            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bf = new BufferedReader(inputReader);
            // 按行读取字符串
            String str;
            while ((str = bf.readLine()) != null) {
                arrayList.add(str);
            }
            bf.close();
            inputReader.close();
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
        int[] array = TestInputStreamReader.toArrayByInputStreamReader("src/main/resources/number.txt");
        for(int i : array){
            System.out.println(i);
        }

    }
}
