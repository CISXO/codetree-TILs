import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

        System.out.println(impossibleSet);
        System.out.println(sortedFeatures);

        List<Integer> covDataList = new ArrayList<>(); // cov_data를 저장할 리스트

        for (String rm_data : impossibleSet) {
            StringTokenizer strong = new StringTokenizer(rm_data);
            List<Integer> indices = new ArrayList<>();

            // 인덱스를 -1로 초기화
            for (int i = 0; i < sortedFeatures.size(); i++) {
                indices.add(-1);
            }

            while (strong.hasMoreTokens()) {
                String token = strong.nextToken();
                // 각 token의 위치 찾기
                for (int i = 0; i < sortedFeatures.size(); i++) {
                    List<String> featureList = sortedFeatures.get(i);
                    int index = featureList.indexOf(token);
                    if (index != -1) {
                        System.out.println("Token: " + token + " | Feature index: " + i + " | Position: " + index);
                        indices.set(i, index); // 각 feature의 인덱스를 List에 저장
                    }
                }
            }

            // 각 feature의 개수를 동적으로 계산
            List<Integer> featureCounts = new ArrayList<>();
            for (HashSet<String> feature : featureSet) {
                featureCounts.add(feature.size()); // 각 HashSet의 크기를 추가
            }

            // cov_data 계산
            int cov_data = calculatePosition(indices, featureCounts);
            covDataList.add(cov_data); // cov_data를 리스트에 추가
        }

        // cov_data 리스트 정렬
        Collections.sort(covDataList);
        for (int cov_data : covDataList) {
            if (cov_data <= T) {
                T++;
            }
        }

        String result = calculateTthCombination(sortedFeatures, impossibleSet, T - 1, totalCombinations);
        System.out.println(result);
    }

    public static int calculatePosition(List<Integer> indices, List<Integer> featureCounts) {
    int totalCombinations = 1; 
    int position = 0; 

    for (int i = indices.size() - 1; i >= 0; i--) { 
        if (indices.get(i) == -1) {
            throw new IllegalArgumentException("Invalid index found: " + indices.get(i));
        }
        position += indices.get(i) * totalCombinations; 
        totalCombinations *= featureCounts.get(i);
    }

    return position + 1; 
}

    private static String calculateTthCombination(ArrayList<ArrayList<String>> sortedFeatures, HashSet<String> impossibleSet, long T, long totalCombinations) {
        ArrayList<String> currentCombination = new ArrayList<>();
        long remainingT = T;

        for (ArrayList<String> featureList : sortedFeatures) {
            totalCombinations /= featureList.size();
            int index = (int) (remainingT / totalCombinations); 
            currentCombination.add(featureList.get(index)); 
            remainingT %= totalCombinations; 
        }

        String combination = String.join(" ", currentCombination);

        return combination;
    }
}