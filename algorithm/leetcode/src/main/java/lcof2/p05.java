package lcof2;

public class p05 {
    public int maxProduct(String[] words) {

        int[] bin = new int[words.length];
        for (int i = 0; i < bin.length; i++) {
            for (int j = 0; i < words[i].length(); j++) {
                bin[i] = 1 << (words[i].charAt(j) - 'a');
            }
        }
        int max = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if((bin[i] & bin[j]) == 0) {
                    max = Math.max(max,words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
