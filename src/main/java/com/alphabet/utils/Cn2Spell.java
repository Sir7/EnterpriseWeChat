package com.alphabet.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class Cn2Spell {  
	   
    /** 
    * 汉字转换为汉语拼音首字母，英文字符不变 
    * @param chines 汉字 
    * @return 拼音 
    */  
    public static String converterToFirstSpell(String chines){         
        String pinyinName = "";  
        char[] nameChar = chines.toCharArray();  
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();  
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);  
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);  
        for (int i = 0; i < nameChar.length; i++) {  
            if (nameChar[i] > 128) {  
                try {  
                    pinyinName += PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0].charAt(0);  
                } catch (BadHanyuPinyinOutputFormatCombination e) {  
                    e.printStackTrace();  
                }  
            }else{  
                pinyinName += nameChar[i];  
            }  
        }  
        return pinyinName;  
    }  
   
    /** 
    * 汉字转换为汉语拼音，英文字符不变 
    * @param chines 汉字 
    * @return 拼音 
    */  
    public static String converterToSpell(String chines){          
        String pinyinName = "";  
        char[] nameChar = chines.toCharArray();  
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();  
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);  
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);  
        for (int i = 0; i < nameChar.length; i++) {  
            if (nameChar[i] > 128) {  
                try {  
                    pinyinName += PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0];  
                } catch (BadHanyuPinyinOutputFormatCombination e) {  
                    e.printStackTrace();  
                }  
            }else{  
                pinyinName += nameChar[i];  
            }  
        }  
        return pinyinName;  
    }  
    
    /**
     * 取得姓和名数组
     * @param fullName
     * @return
     */
    public static String[] familyNameIndex(String fullName){
    	String[] RepeatedFamilyName = new String[]{"欧阳","太史",
    	        "端木","上官","司马","东方","独孤","南宫","万俟","闻人","夏侯",
    	        "诸葛","尉迟","公羊","赫连","澹台","皇甫","宗政","濮阳","公冶",
    	        "太叔","申屠","公孙","慕容","仲孙","钟离","长孙","宇文","司徒",
    	        "鲜于","司空","闾丘","子车","亓官","司寇","巫马","公西","颛孙",
    	        "壤驷","公良","漆雕","乐正","宰父","谷梁","拓跋","夹谷","轩辕",
    	        "令狐","段干","百里","呼延","东郭","南门","羊舌","微生","公户",
    	        "公玉","公仪","梁丘","公仲","公上","公门","公山","公坚","左丘",
    	        "公伯","西门","公祖","第五","公乘","贯丘","公皙","南荣","东里",
    	        "东宫","仲长","子书","子桑","即墨","达奚","褚师"};
    	String[] name = new String[2];
        if(fullName.length()>2){ //存在复姓
        	// 名字的前两个字符
            String frontTwoChar = fullName.substring(0, 2);
            //处理复姓
            for (int i = 0; i < RepeatedFamilyName.length; i++) {
            	if (RepeatedFamilyName[i].equals(frontTwoChar)) {
            		name[0] = fullName.substring(0, 2);
                    name[1] = fullName.substring(2);
                    break;//找到相匹配的复姓就跳出循环，停止判断
                }
            }
        }
        if(name[0]==null || "".equals(name[0])) {
        	name[0] = fullName.substring(0, 1);
            name[1] = fullName.substring(1);
        }
        return name;
    }

    public static String xingDming(String name){
    	StringBuffer str = new StringBuffer();
    	String[] temp = familyNameIndex(name);
    	for(int i=0;i<temp.length;i++){
    		str.append(converterToSpell(temp[i]));
    		if(i==0){
    			str.append(".");
    		}
    	}
    	return str.toString();
    }

    public static void main(String[] args) {  
    	System.out.println(xingDming("公孙策"));
    }  
}  