package main;

public class BomberRandInt {
    /**
     * lowest integer in the range
     */
    private int low = 0;
    /**
     * highest integer in the range
     */
    private int high = 0;

    /**
     * stack size
     */
    private static final int BUFFER_SIZE = 101;
    /**
     * stack to hold random doubles
     */
    private static double[] buffer = new double[BUFFER_SIZE];

    /**
     * Fill the stack with 101 random doubles using the built-in random double
     * generator.
     */
    static {
        for (int i = 0; i < BUFFER_SIZE; i++)
            buffer[i] = Math.random();
    }

    /**
     * Constructs an object that generates random integers in a given range.
     *
     * @param low  the lowest integer in the range
     * @param high the highest integer in the range
     */
    public BomberRandInt(int low, int high) {
        this.low = low;
        this.high = high;
    }

    /**
     * Get the next random double from the stack then generate an integer from
     * it.
     *
     * @return a random integer
     */
    public int draw() {
        int result = low + (int) ((high - low + 1) * nextRandom());
        return result;
    }

    /**
     * Pick a random element in the stack and store the value of it into a
     * variable to be returned then fill that element with a new random double.
     *
     * @return a random double
     */
    private static double nextRandom() {
        /** pick a random element in the stack */
        int position = (int) (Math.random() * BUFFER_SIZE);
        if (position == BUFFER_SIZE) position = BUFFER_SIZE - 1;
        /** store the value of that element */
        double result = buffer[position];
        /** fill that element with a new random double */
        buffer[position] = Math.random();
        /** return the value */
        return result;
    }
}
