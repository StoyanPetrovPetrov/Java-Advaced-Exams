import java.util.*;

public class AutumnCocktails01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        ArrayDeque<Integer> freshness = new ArrayDeque<>();

        Integer[] ingredientsFromScanner = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer ::parseInt).toArray(Integer[]::new);
        Integer[]freshnessFromScanner = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer ::parseInt).toArray(Integer[]::new);
        Collections.addAll(ingredients,ingredientsFromScanner);
        Arrays.stream(freshnessFromScanner).forEach(freshness ::push);
        Map<Integer,String>needResourcesForCocktail = new HashMap<>();
        needResourcesForCocktail.put(150,"Pear Sour");
        needResourcesForCocktail.put(250,"The Harvest");
        needResourcesForCocktail.put(300,"Apple Hinny");
        needResourcesForCocktail.put(400,"High Fashion");
        Map<String,Integer> makeCocktails = new TreeMap<>();
        while (!(ingredients.isEmpty() || freshness.isEmpty())){
            int singleIngrid = ingredients.poll();
            if (singleIngrid == 0){
                continue;
            }
            int singleFresh = freshness.pop();
            int totalFreshnessLevel = singleIngrid * singleFresh;
            if (needResourcesForCocktail.containsKey(totalFreshnessLevel)){
                String makeCocktail = needResourcesForCocktail.get(totalFreshnessLevel);
                makeCocktails.putIfAbsent(makeCocktail,0);
                makeCocktails.put(makeCocktail,makeCocktails.get(makeCocktail) +1);
            }else {
                ingredients.offer(singleIngrid + 5);
            }
        }
        if (makeCocktails.size() == 4){
            System.out.println("It's party time! The cocktails are ready!");
        }else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!ingredients.isEmpty()){
            int sum = 0;
            while (!ingredients.isEmpty()){
                sum += ingredients.poll();
            }
            System.out.println("Ingredients left: " + sum);
        }
        makeCocktails.forEach((key, value) -> System.out.printf(" # %s --> %d%n", key, value));
    }
}
