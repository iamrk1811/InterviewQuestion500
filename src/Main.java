import questions.array.KConcatenation;

public class Main {
    public static void main(String[] args) throws Exception {
        int max = new KConcatenation().solve(new int[]{
                10000,10000,10000,10000,10000,10000,10000,10000,10000,10000
        }, 100000);
        System.out.println(max);
    }
}
