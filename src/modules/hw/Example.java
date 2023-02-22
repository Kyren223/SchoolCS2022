package modules.hw;

import modules.data.automatas.Automata;
import modules.data.exceptions.AutomataException;

import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        finalDeterministicAutomataExample();
    }
    
    public static void finalDeterministicAutomataExample() {
        try {
            Automata automata = new Automata(false);
            automata.addLine("s-> Q1/a");
            automata.addLine("Q1->Q1/a,b");
            // L = {ax^n | n >= 0 | x = a or b}
            // Sigma of {a,b} and starts with a
            List<String> inputs = new ArrayList<>();
            inputs.add("aabaa");
            inputs.add("bababbaaab");
            inputs.add(""); // Epsilon
            inputs.add("ababba");
            for (String input : inputs) {
                System.out.println("Input: " + input + " Output: " + automata.run(input));
            }
        } catch (AutomataException e) {
            e.printStackTrace();
        }
    }
}
