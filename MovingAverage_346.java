public class MovingAverage_346 {
    int [] num;
    int pos;
    int sum;
    int count;

    /** Initialize your data structure here. */
    public MovingAverage_346(int size) {
        num = new int[size];
        pos = 0;
        sum = 0;
        count = 0;
    }

    public double next(int val) {
        sum -= num[pos];
        num[pos++] = val;
        if(pos == num.length) {
            pos = 0;
        }
        sum += val;
        count = count == num.length ? count : count + 1;
        return ((double) sum) / count;
    }
}
