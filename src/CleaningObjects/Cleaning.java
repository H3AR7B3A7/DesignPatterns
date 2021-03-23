package CleaningObjects;

import java.lang.ref.Cleaner;

public class Cleaning {
    public static void main(String[] args) {
        try (Room myRoom = new Room(5)){
            System.out.println("Goodbye!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Room implements AutoCloseable{
    private static final Cleaner cleaner = Cleaner.create();
    private final State state;
    private final Cleaner.Cleanable cleanable;

    public Room(int numberOfJunkPiles) {
        this.state = new State(numberOfJunkPiles);
        this.cleanable = cleaner.register(this, state);
    }

    private static class State implements Runnable {
        int numberOfJunkPiles;

        public State(int numberOfJunkPiles) {
            this.numberOfJunkPiles = numberOfJunkPiles;
        }

        @Override
        public void run() {
            System.out.println("Cleaning room...");
            numberOfJunkPiles = 0;
        }
    }

    @Override
    public void close() throws Exception {
        cleanable.clean();
    }
}