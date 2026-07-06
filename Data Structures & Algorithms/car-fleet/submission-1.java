class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(a[0], b[0]));

        int last = position.length - 1;

        for (int i = position.length - 2; i > -1; i--) {
            double lastTimeToReach = (target - cars[last][0]) * 1.0 / cars[last][1];
            double beforeToReach = (target - cars[i][0]) * 1.0 / cars[i][1];

            if (beforeToReach <= lastTimeToReach) {
                cars[i][0] = -1;
            } else {
                last = i;
            }
        }

        int result = 0;
        for (int[] car: cars) {
            if (car[0] != -1) result++;
        }

        return result;
    }
}
