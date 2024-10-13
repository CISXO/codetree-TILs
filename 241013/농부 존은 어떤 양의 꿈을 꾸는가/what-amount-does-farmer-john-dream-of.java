import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        HashSet<String> hashlist = new HashSet<>();
        ArrayList<String> resultList = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());


        String input = bf.readLine();
        input = input.replace("Farmer John has no", "").replace("cow.", "").trim();
        hashlist.add(input);
        StringTokenizer dataset = new StringTokenizer(input);
        int token_count = dataset.countTokens();

        HashSet<String>[] feature_set = new HashSet[token_count];
        for (int i = 0; i < token_count; i++) {
            feature_set[i] = new HashSet<>();
            feature_set[i].add(dataset.nextToken());
        }

        for (int i = 1; i < N; i++) {
            String data = bf.readLine();
            data = data.replace("Farmer John has no", "").replace("cow.", "").trim();
            hashlist.add(data);
            StringTokenizer dtset = new StringTokenizer(data);

            for (int j = 0; j < token_count; j++) {
                feature_set[j].add(dtset.nextToken());
            }
        }


        for (int s = 0; s < token_count; s++) {
            for (int i = 0; i < feature_set[s].size(); i++) {
            }
        }

        ArrayList<String> currentCombination = new ArrayList<>();
        generateCombinations(feature_set, 0, currentCombination, resultList);

        for (String value : hashlist) {
            resultList.remove(value);
        }
        Collections.sort(resultList);
//        for (String combination : resultList) {
//            System.out.println(combination);
//        }
        System.out.println(resultList.get(T-1));
    }

    private static void generateCombinations(HashSet<String>[] feature_set, int index, ArrayList<String> currentCombination, ArrayList<String> resultList) {
        if (index == feature_set.length) {
            resultList.add(String.join(" ", currentCombination));
            return;
        }

        for (String value : feature_set[index]) {
            currentCombination.add(value);
            generateCombinations(feature_set, index + 1, currentCombination, resultList);
            currentCombination.remove(currentCombination.size() - 1);  // 마지막 요소를 제거
        }
    }
}