import java.util.*;
import java.io.*;
class plagiarism {
public HashMap frequency(String f) {
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    try{
        BufferedReader reader = new BufferedReader(new FileReader(f));
        String line = reader.readLine();
        while(line!=null) {
            String[] word = line.split(" ");
            for(int i=0;i<word.length;i++) {
                word[i] = word[i].replaceAll("[!@#$?%^&*()-.]", "").trim().toLowerCase();
                if(word[i].length()>0) {
                    if(map.containsKey(word[i])) {
                        map.put(word[i], map.get(word[i])+1);
                    } else {
                        map.put(word[i], 1);
                }
            }

            }
            line = reader.readLine();
        }
    } catch (Exception e) {
        System.out.println(e);
    }
    return map;
    }

}
class dotp {
    public int dotproduct(HashMap<String, Integer> h1, HashMap<String, Integer> h2) {
        HashMap<String, Integer> hashmap1, hashmap2;
        hashmap1 = h1;
        hashmap2 = h2;
        int product = 0;
        for(String words : hashmap1.keySet()) {
            if(hashmap2.containsKey(words)) {
                product = product + hashmap1.get(words) * hashmap2.get(words);
            }
        }
        return product;
    }
}
class solution {
    public static void main(String[] args) {
        plagiarism p = new plagiarism();
        HashMap<String, Integer> first = p.frequency("Test2/File3.txt");
        double squares = 0;
        int distance;
        double similarity;
        System.out.println(first);
        for(int i : first.values()) {
            squares = squares + Math.pow(i, 2);
        }
        squares = Math.sqrt(squares);
        HashMap<String, Integer> second = p.frequency("Test2/File4.txt");
        double squares1 = 0;
        System.out.println(second);
        for(int i : second.values()) {
            squares1 = squares1 + Math.pow(i, 2);
        }
        squares1 = Math.sqrt(squares1);
        dotp d = new dotp();
        distance = d.dotproduct(first, second);
        similarity = distance / (squares * squares1);
        System.out.println(similarity*100);


    }
}

