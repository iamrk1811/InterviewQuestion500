import questions.LinkedList.*;
import questions.Math.EuclideanAlgorithms;
import questions.Math.FermatsLastTheorem;
import questions.Math.LeastPrimeFactor;
import questions.Math.PrimeFactorizationUsingSieve;
import questions.StackAndQueue.*;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
//        ArrayList<EdgeUndirectedGraphWithWeight>[] graph = new CreateUndirectedGraphWithWeight().create();

        int[] res = new LeastPrimeFactor().solve(6);
        System.out.println(new FermatsLastTheorem().solve(12, 2));
        Test.giveMeString("Evaluation of Postfix Expression");
    }
}