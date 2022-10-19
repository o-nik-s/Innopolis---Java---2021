package adapter;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 27.09.2021
 * 21. Structural Patterns
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        FileToWordsAdapter adapter = new FileToWordsAdapter(reader);
        StatisticUtil statisticUtil = new StatisticUtil(adapter);
        System.out.println(statisticUtil.dictionary());
    }
}
