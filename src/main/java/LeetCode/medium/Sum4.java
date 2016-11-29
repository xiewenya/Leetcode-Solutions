package LeetCode.medium;

import java.util.*;

/**
 * Created by bresai on 2016/11/28.
 */
// TODO: 2016/11/29 not passed yet
public class Sum4 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        if (nums.length == 0) return result;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (!map.containsKey(target - nums[i] - nums[j] - nums[k])) continue;

                    int last = map.get(target - nums[i] - nums[j] - nums[k]);
                    if (last <= k) continue;

                    List<Integer> singleResult = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k],
                            target - nums[i] - nums[j] - nums[k]));
                    Collections.sort(singleResult);
                    if (result.contains(singleResult)) continue;
                    result.add(singleResult);
                }
            }
        }
        return result;
    }


    public List<List<Integer>> fourSum1(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> nodes = new ArrayList<>();
        List<List<Integer>> values = new ArrayList<>();
        List<List<Integer>> indexes = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                nodes.add(nums[i] + nums[j]);
                values.add(new ArrayList<>(Arrays.asList(nums[i], nums[j])));
                indexes.add(new ArrayList<>(Arrays.asList(i, j)));
            }
        }

        for (int i = 0; i < nodes.size() - 1; i++) {
            for (int j = i + 1; j < nodes.size(); j++) {
                if (nodes.get(i) + nodes.get(j) == target) {
                    if ( indexes.get(j).contains(indexes.get(i).get(0))) continue;
                    if ( indexes.get(j).contains(indexes.get(i).get(1))) continue;
                    List<Integer> singleResult = new ArrayList<>(values.get(i));
                    singleResult.addAll(values.get(j));
                    Collections.sort(singleResult);

                    result.add(singleResult);
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] array = {-497,-494,-484,-477,-453,-453,-444,-442,-428,-420,-401,-393,-392,-381,-357,-357,-327,-323,-306,-285,-284,-263,-262,-254,-243,-234,-208,-170,-166,-162,-158,-136,-133,-130,-119,-114,-101,-100,-86,-66,-65,-6,1,3,4,11,69,77,78,107,108,108,121,123,136,137,151,153,155,166,170,175,179,211,230,251,255,266,288,306,308,310,314,321,322,331,333,334,347,349,356,357,360,361,361,367,375,378,387,387,408,414,421,435,439,440,441,470,492};
        int target = 1682;
        Sum4 object = new Sum4();
        System.out.println(object.fourSum1(array, target));
    }
}
