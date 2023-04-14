package modules.hw;

import modules.data.Tape;
import modules.data.TuringRunnable;
import modules.data.automatas.Automata;
import modules.data.automatas.TuringAutomata;
import modules.data.exceptions.AutomataException;
import modules.data.exceptions.TapeException;

import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        //finalDeterministicAutomataExample();
        turingAutomataExample();
    }
    
    public static void finalDeterministicAutomataExample() {
        try {
            Automata automata = new Automata(false);
            automata.addLine("s->Q1/a");
            automata.addLine("Q1->Q1/a,b");
            // L = {aw^n | n >= 0 | w = a or b}
            // Sigma of {a,b} and starts with a
            List<String> inputs = new ArrayList<>();
            inputs.add("aabaa");
            inputs.add("bababbaaab");
            inputs.add(""); // Epsilon
            inputs.add("ababba");
            for (String input : inputs) {
                System.out.println("Input: " + input + " Output: " + automata.run(input));
            }
        } catch (AutomataException | TapeException e) {
            e.printStackTrace();
        }
    }

    public static void turingAutomataExample() {
        try {
            TuringAutomata automata = new TuringAutomata();
            // L = {a^n b^n | n >= 0}
            // Sigma of {a,b}
            automata.addLine("s->q5/B/B/R");
            automata.addLine("s->Q4/<>/<>/R"); // Acceptance state
            automata.addLine("s->q1/a/A/R");

            //automata.addLine("q1->q1/a/a/R");
            //automata.addLine("q1->q1/B/B/R");
            automata.addLine("q1->q1/a,B/a,B/R");
            automata.addLine("q1->q2/b/B/L");

            //automata.addLine("q2->q2/B/B/L");
            //automata.addLine("q2->q2/a/a/L");
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
}
