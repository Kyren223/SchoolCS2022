package modules.hw;

import modules.data.automatas.TuringAutomata;

import java.util.ArrayList;
import java.util.List;

public class Ex1 {

    public static void main(String[] args) throws InterruptedException {
    }

    public static void ex1() {
        // Work in Progress - making an automata system
        // L = {a^n,b^n | n >= 0}
        try {
            TuringAutomata automata = new TuringAutomata();
            // L = {a^n b^n | n >= 0}
            // Sigma of {a,b}
            automata.addLine("s->q5/B/B/R");
            automata.addLine("s->Q4/<>/<>/R"); // Acceptance state
            automata.addLine("s->q1/a/A/R");
            automata.addLine("q1->q1/a,B/a,B/R");
            automata.addLine("q1->q2/b/B/L");
            automata.addLine("q2->q2/a,B/a,B/L");
            automata.addLine("q2->s/A/A/R");
            automata.addLine("q5->q5/B/B/R");
            automata.addLine("q5->Q4/<>/<>/R");

            List<String> inputs = new ArrayList<>();
            inputs.add("aabb"); // true
            inputs.add("aaaabb"); // false
            inputs.add(""); // Epsilon - true
            inputs.add("aabbb"); // false
            inputs.add("abab"); // false

            for (String input : inputs) {
                System.out.println("Input: " + input + " Output: " + automata.run(input));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ex2() {
        try {
            TuringAutomata automata = new TuringAutomata();
            automata.addLine("s->Q1");

            List<String> inputs = new ArrayList<>();
            inputs.add("aabaa"); // true
            inputs.add("bababbaaab"); // false
            inputs.add(""); // Epsilon - false
            inputs.add("abbbba"); // true

            for (String input : inputs) {
                System.out.println("Input: " + input + " Output: " + automata.run(input));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
