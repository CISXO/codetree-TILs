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

        // 각 특징 그룹을 사전순으로 정렬하여 조합 생성에 사용
        ArrayList<ArrayList<String>> sortedFeatures = new ArrayList<>();
        for (int i = 0; i < tokenCount; i++) {
            ArrayList<String> sortedList = new ArrayList<>(featureSet.get(i));
            Collections.sort(sortedList);
            sortedFeatures.add(sortedList);
        }

        // 빠른 조합 찾기
        String result = findTthCombination(sortedFeatures, impossibleSet, T);
        System.out.println(result);
    }

    // 가능한 조합 중 T번째 조합을 빠르게 찾는 메서드
    private static String findTthCombination(ArrayList<ArrayList<String>> sortedFeatures, HashSet<String> impossibleSet, long T) {
        ArrayList<String> currentCombination = new ArrayList<>();
        int[] indices = new int[sortedFeatures.size()];
        long totalCombinations = 0;

        while (true) {
            currentCombination.clear();
            for (int i = 0; i < sortedFeatures.size(); i++) {
                currentCombination.add(sortedFeatures.get(i).get(indices[i]));
            }

            String combination = String.join(" ", currentCombination);

            // 불가능한 조합이 아니면 카운트 증가
            if (!impossibleSet.contains(combination)) {
                totalCombinations++;
                if (totalCombinations == T) {
                    return combination;
                }
            }

            // 조합을 사전순으로 넘김
            for (int i = sortedFeatures.size() - 1; i >= 0; i--) {
                if (indices[i] < sortedFeatures.get(i).size() - 1) {
                    indices[i]++;
                    break;
                } else {
                    indices[i] = 0;
                }
            }
        }
    }
}