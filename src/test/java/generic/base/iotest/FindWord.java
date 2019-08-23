package generic.base.iotest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 从文件中找出出现次数最多的单词
 */
public class FindWord {

    public static String loadFile(String path){
        try {
            Reader in = new FileReader(path);
            BufferedReader br = new BufferedReader(in);

            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }

            br.close();
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 分割文件中的英文单词
     * @param str
     * @return
     */
    public static String[] parseWords(String str) {
        String[] words = str.split("[^a-zA-Z]+");
        return words;
    }

    /**
     * 用map实现单词数量的计数，key为单词，value为数量
     * @param words
     * @return
     */
    public static Map<String, Integer> countWords(String[] words) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if(map.containsKey(word)) {
                //map中有单词，则数量加1
                int n = map.get(word);
                n++;
                map.put(word, n);

            } else {
                //第一次放入map单词数量为1
                map.put(word, 1);
            }
        }
        return map;
    }

    /**
     * 查找map中最大的value的值
     * @param map
     * @return
     */
    public static Integer getMaxValue(Map<String, Integer> map) {
        Collection<Integer> values = map.values();
        return Collections.max(values);
    }

    public static void main(String[] args) {
        String str = loadFile("/Users/zouyongqi/IdeaProjects/mytestweb/src/test/java/generic/test/Rain.java");
//        System.out.println(str);
        String[] words = parseWords(str);
        /*for (String word : words) {
            System.out.println(word);
        }*/
        Map<String, Integer> map = countWords(words);
        int maxValue = getMaxValue(map);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
            if(maxValue == entry.getValue()){
                System.out.println("word is: " + entry.getKey() + " : " + entry.getValue());
            }
        }
    }
}
