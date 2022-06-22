package lcof2;

import java.util.Stack;

public class p37 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < asteroids.length; ) {
            if (stack.isEmpty() || stack.peek() < 0 || asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else if (Math.abs(asteroids[i]) >= stack.peek()) {
                if (stack.pop() < Math.abs(asteroids[i])) {
                    continue;
                }
            }
            i++;
        }
        int[] result = new int[stack.size()];

        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
