package others.chapter4;

import java.util.*;

/**
 * @version 1.0
 * @author:bresai
 * @date:2020/5/20
 * @content:
 */
public class BuildOrder {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f");
        HashMap<String, List<String>> map = new HashMap<>();
        map.put("a", Arrays.asList("d"));
        map.put("b", Arrays.asList("d"));
        map.put("d", Arrays.asList("c"));
        map.put("f", Arrays.asList("b", "a"));

        List<String> order = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        HashSet<String> projects = new HashSet<>(list);

        HashSet<String> inOrder = new HashSet<>();
        System.out.println(findOrder(order, projects, map, visited, inOrder));
        System.out.println(order);
    }


    public static boolean findOrder(List<String> order, HashSet<String> projects,
                             Map<String, List<String>> dependencies, HashSet<String> visited, HashSet<String> inOrder){

        for(String project : projects){
            if (!visit(order, project, dependencies, visited, inOrder)){
                return false;
            }
        }

        return true;
    }

    public static boolean visit(List<String> order, String project,
                      Map<String, List<String>> dependencies, HashSet<String> visited, HashSet<String> inOrder) {
        if (!dependencies.containsKey(project)){
            visited.add(project);
            if (! order.contains(project)){
                order.add(project);
            }
            return true;
        }

        if (inOrder.contains(project)){
            return false;
        }

        List<String> related = dependencies.get(project);

        for(String relate : related){
            if (!visited.contains(relate)){
                inOrder.add(project);
                if (!visit(order, relate, dependencies, visited, inOrder)){
                    return false;
                }
                inOrder.remove(project);

                if (! order.contains(project)){
                    order.add(project);
                }
            }
        }

        return true;
    }

}
