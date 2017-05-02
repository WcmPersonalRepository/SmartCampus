package com.gxufe.smarcampus.common.util;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.List;
import java.util.Locale;


/**
 * 对字典数据的名字首字母进行排序
 * @author JohnnyJiang
 *
 */
public class ChineseSort implements Comparator<Dictionary>{
 /**
  * 根据字典名字的首字母进行排序
  * @param 要排序的list
  * @return 排序后的list
  */
 public static List<Dictionary> sort(List<Dictionary> list){
  ChineseSort comp = new ChineseSort();
  Collections.sort(list,comp);
  return list; //返回排序后的列表
 }
 

 public int compare(Dictionary dic1, Dictionary dic2) {
     /*String dicName1 = dic1.getDictionaryName().toString();
     String dicName2 = dic2.getDictionaryName().toString();*/
     
     return 1;
     //return Collator.getInstance(Locale.CHINESE).compare(dicName1, dicName2);
 }

}