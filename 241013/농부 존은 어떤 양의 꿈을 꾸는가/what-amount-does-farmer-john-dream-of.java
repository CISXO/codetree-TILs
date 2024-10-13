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

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        // 불가능한 조합을 hashlist에 저장
        for (int i = 0; i < N; i++) {
            String data = bf.readLine();
            data = data.replace("Farmer John has no", "").replace("cow.", "").trim();
            hashlist.add(data);
        }

        // 각 특징별로 가능한 특징들을 HashSet에 저장
        ArrayList<HashSet<String>> feature_set = new ArrayList<>();
        String example = hashlist.iterator().next();
        StringTokenizer dataset = new StringTokenizer(example);
        int token_count = dataset.countTokens();

        // 빈 HashSet을 추가하여 각 특징 그룹별로 저장소 마련
        for (int i = 0; i < token_count; i++) {
            feature_set.add(new HashSet<>());
        }

        // 불가능한 조합을 이용해 feature_set에 가능한 특징들을 채움
        for (String impossible : hashlist) {
            String[] parts = impossible.split(" ");
            for (int i = 0; i < token_count; i++) {
                feature_set.get(i).add(parts[i]);
            }
        }

        // 각 특징 그룹을 사전순으로 정렬하여 조합 생성에 사용
        ArrayList<ArrayList<String>> sortedFeatures = new ArrayList<>();
        for (int i = 0; i < token_count; i++) {
            ArrayList<String> sortedList = new ArrayList<>(feature_set.get(i));
            Collections.sort(sortedList);
            sortedFeatures.add(sortedList);
        }

        // T번째 조합 찾기
        String result = findTthCombination(sortedFeatures, hashlist, T);
        System.out.println(result);
    }

    // 가능한 조합 중 T번째 조합을 찾는 메서드
    private static String findTthCombination(ArrayList<ArrayList<String>> features, HashSet<String> impossibleSet, int T) {
        ArrayList<String> currentCombination = new ArrayList<>();
        int[] indices = new int[features.size()];
        int totalCombinations = 0;

        while (true) {
            // 조합 생성
            currentCombination.clear();
            for (int i = 0; i < features.size(); i++) {
                currentCombination.add(features.get(i).get(indices[i]));
            }

            String combination = String.join(" ", currentCombination);

            // 불가능한 조합이 아니면 카운트 증가
            if (!impossibleSet.contains(combination)) {
                totalCombinations++;
                if (totalCombinations == T) {
                    return combination;
                }
            }

            // 조합을 다음으로 넘김 (사전순)
            for (int i = features.size() - 1; i >= 0; i--) {
                if (indices[i] < features.get(i).size() - 1) {
                    indices[i]++;
                    break;
                } else {
                    indices[i] = 0;
                }
            }
        }
    }
}


/*
정렬된 데이타 셋 [] , [], []
r * s * t
s *
전체 개수를 구하고
hashset 개수에서  s1, s2, s3, s4 ...
        s1* s2 * s3* s4 * ...Total value
        value1 = T / ((Total value)/s1) = 몫 / 나머지1  ->
        value2 = 나머지1 / ((Total value)/(s1*s2)) = 몫 .. 나머지2
        ...
        valuen = 나머지n-1 / ((Total value)/(s1*s2* ...sn)) = 나머지
        value1 몫 set1에서 선택 , value2 .. value n ..
  -> 미리 제거해야 하지 못하기 때문에 안됨

 */
//