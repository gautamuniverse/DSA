//Explanation
//Compare all neignbour elements (a,b) in A,
//the case of a > b can happen at most once.
//
//Note that the first element and the last element are also connected.
//
//If all a <= b, A is already sorted.
//If all a <= b but only one a > b,
//we can rotate and make b the first element.
//Other case, return false.
//
//
//Complexity
//Time O(n)
//Space O(1)


    public boolean check(int[] A) {
        int k = 0, n = A.length;
        for (int i = 0; i < n; ++i) {
            if (A[i] > A[(i + 1) % n]) {
                k++;
            }
            if (k > 1) {
                return false;
            }
        }
        return true;
    }