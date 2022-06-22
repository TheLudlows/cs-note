package lcof;

public class p33_verifyPostorder {
    public static boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }

    // y验证左右子树 需要去掉根结点
    private static boolean verify(int[] postorder, int l, int r) {
        if(l >= r) {
            return true;
        }

        int root = postorder[r];


        int mid = l;
        // 左子树
        while(postorder[mid] < root) {
            mid++;
        }

        // l ~ mid -l 都大雨root 右子树

        // 验证左子树
        for(int i=mid;i<=r-1;i++) {
            if(root > postorder[i]) {
                return false;
            }
        }

        // 分别验证左右子树
        return verify(postorder, l, mid-1) && verify(postorder, mid , r-1);

    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 8, 6, 12, 16, 14, 10};

        verifyPostorder(arr);
    }


}
