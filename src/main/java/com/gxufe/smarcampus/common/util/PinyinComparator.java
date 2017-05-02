package com.gxufe.smarcampus.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;  
import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;

import com.gxufe.smarcampus.models.SysPart;

import net.sourceforge.pinyin4j.PinyinHelper;  
/** 
 * 汉字按照拼音排序的比较器 
 * @author KennyLee 2009-2-23 10:08:59 
 *  
 */  
public class PinyinComparator implements Comparator<Object> {  
    public int compare(Object o1, Object o2) {  
        char c1 = ((String) o1).charAt(0);  
        char c2 = ((String) o2).charAt(0);  
        return concatPinyinStringArray(  
                PinyinHelper.toHanyuPinyinStringArray(c1)).compareTo(  
                concatPinyinStringArray(PinyinHelper  
                        .toHanyuPinyinStringArray(c2)));  
    } 
    
    public static List<Object> sortList(List<Object> objList,String property,Class c){
    	List<Object> list=new ArrayList<>();
    	//String[] arr=getStringArr(objList,property);
    	List<String> strList=getStringArr(objList,property,c);
    	for (int i = 0; i < strList.size(); i++) {
			for (int j = 0; j < objList.size(); j++) {
				String value=getValue(objList.get(j),property,c);
				if (strList.get(i).equals(value)) {
					list.add(objList.get(j));
				}
			}
		}
    	return list;
    }
    
    public static List<String> getStringArr(List objList,String property,Class c){
    	String[] arr=new String[objList.size()];
    	for (int i = 0; i < objList.size(); i++) {
    		Object object=objList.get(i);
    		//System.out.println(((SysPart)(Object)clzz).getPartName());
    		arr[i]=getValue(object,property,c);
    	}
    	List<String> list= Arrays.asList(arr);  
        Arrays.sort(arr, new PinyinComparator());
        return list;
    }
    
   
    private static String getValue(Object object, String property,Class clzz) {
		try {
			Method[] methods=clzz.getMethods();
			for (Method m:methods) {
				String name=m.getName();
				if (name.equalsIgnoreCase("get"+property)) {
					//System.out.println(((SysPart)object).getPartName());
					//System.out.println((String) m.invoke(object));
					return (String) m.invoke(object);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private String concatPinyinStringArray(String[] pinyinArray) {  
        StringBuffer pinyinSbf = new StringBuffer();  
        if ((pinyinArray != null) && (pinyinArray.length > 0)) {  
            for (int i = 0; i < pinyinArray.length; i++) {  
                pinyinSbf.append(pinyinArray[i]);  
            }  
        }  
        return pinyinSbf.toString();  
    }  
    
  /*  @Test
    public void main() {  
        String[] arr = { "张三", "李四", "王五", "赵六", "JAVA", "123", "$%$#", "哈哈A",  
                "1哈哈A", "1哈哈b", "1哈哈a", "哈哈", "哈", "怡情" };  
        List<String> list = Arrays.asList(arr);  
        Arrays.sort(arr, new PinyinComparator());  
        System.out.println(list);  
    }  */
    @Test
    public void main2() {  
    	SysPart[] sysParts=new SysPart[14];
    	String[] arr = { "张三", "李四", "王五", "赵六", "JAVA", "123", "$%$#", "哈哈A",  
                "1哈哈A", "1哈哈b", "1哈哈a", "哈哈", "哈", "怡情" };
    	for (int i = 0; i < sysParts.length; i++) {
    		sysParts[i].setId(i+1);
    		sysParts[i].setPartName(arr[i]);
		}
    	List<SysPart> list = Arrays.asList(sysParts);  
    	Collections.sort(list,new PinyinComparator());
    	System.out.println(list);  
    	for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getPartName());
		}
    }
    
    public static void main(String[] args) {
    	List sysParts=new ArrayList();
    	String[] arr = { "张三", "李四", "王五", "赵六", "JAVA", "123", "$%$#", "哈哈A",  
                "1哈哈A", "1哈哈b", "1哈哈a", "哈哈", "哈", "怡情" };
    	for (int i = 0; i < arr.length; i++) {
    		SysPart sysPart=new SysPart();
    		sysPart.setId(i+1);
    		sysPart.setPartName(arr[i]);
    		sysParts.add(sysPart);
		}
    	//List<SysPart> list = Arrays.asList(sysParts);  
    	//Collections.sort(list,new PinyinComparator());
    	List list=sortList(sysParts,"partName",SysPart.class);
    	System.out.println(list);  
    	for (int i = 0; i < list.size(); i++) {
			System.out.println(((SysPart)list.get(i)).getPartName());
		}
	}
    
} 