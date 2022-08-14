import java.util.*;
import java.util.stream.Collectors;

public class FoodFinder01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> vowels = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<String> consonants = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(consonants ::push);

        Map<String, Set<String>> word = new LinkedHashMap<>();
        word.put("pear", new HashSet<>());
        word.put("flour", new HashSet<>());
        word.put("pork", new HashSet<>());
        word.put("olive", new HashSet<>());

        List<String> foundWords = new ArrayList<>();
        while (!consonants.isEmpty()){
            String singleVowel = vowels.poll();
            String singleConsonant = consonants.pop();
             for (var entry : word.entrySet()){
                 if (entry.getKey().contains(singleVowel)){
                     entry.getValue().add(singleVowel);
                 }
                 if (entry.getKey().contains(singleConsonant)){
                     entry.getValue().add(singleConsonant);
                 }
             }
             vowels.offer(singleVowel);
        }
        for (var entry : word.entrySet()){
            if (entry.getKey().length() == entry.getValue().size()){
                foundWords.add(entry.getKey());
            }
        }
        System.out.println("Words found: " + foundWords.size());
        System.out.println(String.join(System.lineSeparator(), foundWords));

    }
}
