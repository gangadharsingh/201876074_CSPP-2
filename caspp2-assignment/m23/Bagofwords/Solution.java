import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Collection;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
/**
* @author : gangadharsingh.
 */
/**
 * Class for frequencydict..
 */
class Frequencydict {
    private  HashMap<String, Integer> hm;
    Frequencydict() {
        hm = new HashMap<String, Integer>();
    }
    /**
     * { function_description }.
     *
     * @param      d     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    HashMap<String, Integer> makedict(final String[] d) {
        HashSet<String> set = new HashSet<>(Arrays.asList(d));
        int cnt = 0;
        for (final String l : set) {
            cnt = 0;
            for (final String k : d) {
                if (l.equals(k)) {
                    cnt++;
                }
            }
            hm.put(l, cnt);
        }
        return hm;
    }
}
/**
 * Class for plagarise.
 */
class Plagarise {
    /**
     * { function_description }.
     *
     * @param      freqdata1  The freqdata 1
     * @param      freqd2     The freqd 2
     *
     * @return     { description_of_the_return_value }
     */
    int dotproduct(HashMap<String, Integer> freqdata1,
        HashMap<String, Integer> freqd2) {
        int dp = 0;
        HashSet<String> newSet = new HashSet<String>(freqdata1.keySet());

        newSet.addAll(freqd2.keySet());

        for (final String k : newSet) {
            if (freqdata1.get(k) == null) {
                freqdata1.put(k, 0);
            }
            if (freqd2.get(k) == null) {
                freqd2.put(k, 0);
            }
            dp += freqdata1.get(k) * freqd2.get(k);
        }
        return dp;
    }
    /**
     * { function_description }.
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    double euclideanNorm(Collection<Integer> a, Collection<Integer> b) {
        int s1 = 0;
        int s2 = 0;
        for (int c : a) {
            s1 += Math.pow(c, 2);
        }
        for (int d : b) {
            s2 += Math.pow(d, 2);
        }
        return Math.sqrt(s1) * Math.sqrt(s2);
    }
}
/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * { function_description }.
     *
     * @param      args       The arguments
     *
     * @throws     Exception  { exception_description }
     */
    public static void main(final String[] args) throws Exception {
        try {

            Frequencydict k1;
            Plagarise pl;
            Scanner sc = new Scanner(System.in);
            File folder = new File(sc.next());
            File[] filesArray = folder.listFiles();
            Arrays.sort(filesArray);
            String[] filenames = folder.list();
            Arrays.sort(filenames);
            ArrayList<String> filestringslist = new ArrayList<String>();
            for (File a : filesArray) {
                // System.out.println(a);
                FileReader f = new FileReader(a);
                BufferedReader b = new BufferedReader(f);
                String filestring = "";
                while (true) {
                    String tmp = b.readLine();
                    if (tmp != null) {
                        filestring += tmp;
                    } else {
                        break;
                    }
                }
                // System.out.println(filestring);
                filestringslist.add(filestring);
                f.close();
                b.close();
            }

            HashMap<String, Integer> freqdata1;
            double percentage = 0;
            ArrayList<Long> resultlist = new ArrayList<Long>();
            ArrayList<HashMap<String, Integer>> dictlist =
                new ArrayList<HashMap<String, Integer>>();
            for (final String b : filestringslist) {
                // System.out.println(b);
                k1 = new Frequencydict();
                freqdata1 = new HashMap<String, Integer>();
                freqdata1 = k1.makedict(cleanstring(b).split(" "));
                // freqdata1 = k1.makedict(b. toLowerCase().split(" "));
                dictlist.add(freqdata1);
                // System.out.println(freqdata1);
            }

            String[] mp = new String[2];
            float max = 0;
            int x = -1;
            int y = -1;
            for (HashMap<String, Integer> k : dictlist) {
                x++;
                for (HashMap<String, Integer> l : dictlist) {
                    y++;
                    pl = new Plagarise();
                    int dp = pl.dotproduct(k, l);
                    double en = pl.euclideanNorm(k.values(), l.values());
                    percentage = dp / en * 100;
                    if (max < Math.round(percentage) && Math.round(percentage) != 100) {
                        max = Math.round(percentage);
                        mp[0] = filenames[x];
                        mp[1] = filenames[y];
                    }
                    resultlist.add(Math.round(percentage));
                }
                y = -1;
            }
            x = -1;
            String s = "      " + "\t\t";
            for (final String k : filenames) {
                s += k + "\t";
            }
            int k = 0;
            s += "\n";
            for (int i = 0; i < filenames.length; i++) {
                s += filenames[i] + "\t";
                for (int j = 0; j < filenames.length; j++) {
                    s += resultlist.get(k++) + "\t" + "\t";
                }
                s += "\n";
            }
            System.out.print(s);
            System.out.println("Maximum similarity is between " + mp[0]
                + " and " + mp[1]);
        }

        catch (Exception e) {
            System.out.println("empty directory");
        }
    }
    /**
     * { function_description }.
     *
     * @param      data1  The data 1
     *
     * @return     { description_of_the_return_value }
     */
    public static String cleanstring(final String data1) {
        //
        // System.out.println(data1);
        //
        Pattern p = Pattern.compile("[^a-z A-Z 0-9]");
        Matcher m = p.matcher(data1);
        String newstring = m.replaceAll("").toLowerCase().replace(".", " ");
        // System.out.println(newstring);
        return newstring;
    }

}