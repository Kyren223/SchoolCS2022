package modules.data;

@FunctionalInterface
public interface TuringRunnable {
    public abstract boolean run(Tape tape);
}
