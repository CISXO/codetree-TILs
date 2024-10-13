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

        HashSet<String> impossibleSet = new HashSet<>();

        int N = Integer.parseInt(st.nextToken());
        long T = Long.parseLong(st.nextToken());

        // 불가능한 조합을 HashSet에 저장
        for (int i = 0; i < N; i++) {
            String data = bf.readLine();
            data = data.replace("Farmer John has no", "").replace("cow.", "").trim();
            impossibleSet.add(data);
        }

        // 각 특징별로 가능한 특징들을 HashSet에 저장
        ArrayList<HashSet<String>> featureSet = new ArrayList<>();
        StringTokenizer firstLineTokens = new StringTokenizer(impossibleSet.iterator().next());
        int tokenCount = firstLineTokens.countTokens();

        // 특징별로 가능한 조합을 추가
        for (int i = 0; i < tokenCount; i++) {
            featureSet.add(new HashSet<>());
        }

        // 불가능한 조합을 이용해 가능한 특징을 채움
        for (String impossible : impossibleSet) {
            String[] parts = impossible.split(" ");
            for (int i = 0; i < tokenCount; i++) {
                featureSet.get(i).add(parts[i]);
            }
        }

        // 각 특징 그룹을 사전순으로 정렬
        ArrayList<ArrayList<String>> sortedFeatures = new ArrayList<>();
        for (int i = 0; i < tokenCount; i++) {
            ArrayList<String> sortedList = new ArrayList<>(featureSet.get(i));
            Collections.sort(sortedList);
            sortedFeatures.add(sortedList);
        }

        // 전체 가능한 조합의 수 계산
        long totalCombinations = 1;
        for (ArrayList<String> featureList : sortedFeatures) {
            totalCombinations *= featureList.size();
        }

        // T번째 조합을 몫과 나머지 방식으로 계산
        String result = calculateTthCombination(sortedFeatures, impossibleSet, T - 1, totalCombinations);
        System.out.println(result);
    }

    private static String calculateTthCombination(ArrayList<ArrayList<String>> sortedFeatures, HashSet<String> impossibleSet, long T, long totalCombinations) {
        ArrayList<String> currentCombination = new ArrayList<>();
        long remainingT = T;

        for (ArrayList<String> featureList : sortedFeatures) {
            totalCombinations /= featureList.size(); // 현재 특징의 크기를 나눠줌
            int index = (int) (remainingT / totalCombinations); // 몫을 통해 선택할 인덱스 결정
            currentCombination.add(featureList.get(index)); // 해당 특징 선택
            remainingT %= totalCombinations; // 나머지를 계산하여 다음 특징으로 넘어감
        }

        // 최종적으로 생성된 조합을 검증 (불가능한 조합이면 건너뜀)
        String combination = String.join(" ", currentCombination);
        if (impossibleSet.contains(combination)) {
            // 불가능한 조합일 경우에는 스킵하고 다음 조합을 처리할 필요가 있음
            return calculateTthCombination(sortedFeatures, impossibleSet, T + 1, totalCombinations);
        }

        return combination;
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
        그거 조합한게 답

 */
//