import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Meeting01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer>males = new ArrayDeque<>();
        ArrayDeque<Integer>females = new ArrayDeque<>();

        Integer[]maleFromScanner = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[]femaleFromScanner = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);

        Arrays.stream(maleFromScanner).forEach(males::push);
        Collections.addAll(females, femaleFromScanner);
        int matches = 0;

        while (!(males.isEmpty() || females.isEmpty())) {

            if(males.peek()<=0){
                males.pop();
                continue;
            }
            if(females.peek()<=0){
                females.poll();
                continue;
            }
            if(males.peek()%25==0){
                males.pop();
                males.pop();
                continue;
            }
            if(females.peek()%25==0){
                females.poll();
                females.poll();
                continue;
            }
            int singleMale = males.pop();
            int singleWoman = females.poll();
            if(singleMale==singleWoman) {
                matches++;
            } else {
                males.push(singleMale-2);
            }
        }

        String result;

        System.out.println("Matches: " + matches);

        if(males.isEmpty()) {
            result = "Males left: none";
        } else {
            result = String.format("Males left: %s", males.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        System.out.println(result);

        if(females.isEmpty()) {
            result = "Females left: none";
        } else {
            result = String.format("Females left: %s", females.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        System.out.println(result);
    }
}
