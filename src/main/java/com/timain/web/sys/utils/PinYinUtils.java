package com.timain.web.sys.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import org.apache.commons.lang3.StringUtils;

/**
 * 获取汉字的首字母
 * @author yyf
 * @version 1.0
 * @date 2020/4/29 13:28
 */
public class PinYinUtils {
    
    public static String getPinYin(String source) {
        if (StringUtils.isBlank(source)) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            char word = source.charAt(i);
            if (Character.toString(word).matches("[\\u4E00-\\u9FA5]")) {
                String[] pinYinArr = PinyinHelper.toHanyuPinyinStringArray(word);
                result.append(pinYinArr[0].charAt(0));
            } else {
                // 非汉字不进行转换，直接添加
                result.append(word);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = getPinYin("张三");
        System.out.println(s);
    }
}
