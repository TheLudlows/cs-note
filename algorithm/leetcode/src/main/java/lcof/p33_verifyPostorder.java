package lcof;

public class p33_verifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }

    private boolean verify(int[] postorder, int l, int r) {
        if (l >= r) {
            return true;
        }

        int mid = l;
        int root = postorder[r];
        while (postorder[mid] < root) {
            mid++;
        }

        for (int i = mid; i < r; i++) {
            if (postorder[i] < root) {
                return false;
            }
        }
        return verify(postorder, l, mid - 1) && verify(postorder, mid, r - 1);
    }

}
