package lcof;

public class p58_reverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        n = n % s.length();
        return s.substring(n) + s.substring(0, n);
    }
}
