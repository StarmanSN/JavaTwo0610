package Lesson9;

public class Stats<T extends Number> {
    private T[] nums;

    public Stats(T... nums) { //varargs
        this.nums = nums;
    }

    public double avg() {
        double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    public boolean isSameAvg(Stats<?> stats) { // ? - означает, что возможен любой тип, который наследуется от Number
        return Math.abs(this.avg() - stats.avg()) < 0.0001; //0.9999999999
    }
}
