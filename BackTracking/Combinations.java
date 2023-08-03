public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    void solve1(int num, int tot, int k, List<Integer> ans) {
        if (num == tot + 1) {
            if (ans.size() == k) {
                res.add(new ArrayList<>(ans));
            }
            return;
        }

        ans.add(num);
        solve1(num + 1, tot, k, ans);
        ans.remove(ans.size() - 1);
        solve1(num + 1, tot, k, ans);
    }

    void solve2(int num, int tot, int k, List<Integer> ans) {
        if (ans.size() == k) {
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = num; i <= tot; i++) {
            ans.add(i);
            solve2(i + 1, tot, k, ans);
            ans.remove(ans.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> ans = new ArrayList<>();
        solve2(1, n, k, ans);
        return res;
    }
}