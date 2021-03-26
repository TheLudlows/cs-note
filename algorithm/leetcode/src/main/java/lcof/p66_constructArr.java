package lcof;

public class p66_constructArr {
    public int[] constructArr(int[] a) {
        int[] ret = new int[a.length];
        if (ret.length == 0) {
            return ret;
        }
        ret[0] = 1;
        for (int i = 1; i < a.length; i++) {
            ret[i] = a[i - 1] * ret[i - 1];
        }

        int suffix = 1;
        for(int i=a.length-1;i>=0;i--) {
            ret[i] = suffix * ret[i];
            suffix *= a[i];
        }
        return ret;
    }
}
