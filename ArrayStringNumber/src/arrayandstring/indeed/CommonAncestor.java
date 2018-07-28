package arrayandstring.indeed;

import java.util.*;

/**
 *         6         8
 *        / \      /  \
 *       7   5   4     9
 *      / \  \ / \    / \
 *     3  11  1   2  10 15
 */
public class CommonAncestor {

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {6, 7}, {6, 5},
                {7, 3}, {7, 11},
                {5, 1},
                {8, 4}, {8, 9},
                {4, 1}, {4, 2},
                {9, 10}, {9, 15}
        };

        CommonAncestor commonAncestor = new CommonAncestor();

        System.out.println(commonAncestor.findLeaf(graph));
        System.out.println(commonAncestor.commonAncestors(graph, 1, 15));
        System.out.println(commonAncestor.commonSuccessors(graph, 6, 8));
    }

    public List<Integer> findLeaf(int[][] graph) {
        List<Integer> output = new ArrayList<>();
        Map<Integer, List<Integer>> parentChildMap = createParentChildMap(graph);
        System.out.println(parentChildMap);

        for (Integer parent : parentChildMap.keySet()) {
            if (parentChildMap.get(parent).isEmpty()) {
                output.add(parent);
            }
        }
        return output;
    }

    public List<Integer> commonAncestors(int[][] graph, int child1, int child2) {
        List<Integer> output = new ArrayList<>();

        Map<Integer, List<Integer>> childParentMap = createChildParentMap(graph);

        System.out.println(childParentMap);


        Set<Integer> child1Parent = findAllAncestor(childParentMap, child1);

        Set<Integer> child2Parent = findAllAncestor(childParentMap, child2);

        for (Integer ancestor : child1Parent) {
            if (child2Parent.contains(ancestor)) {
                output.add(ancestor);
            }
        }
        return output;
    }

    private Set<Integer> findAllAncestor(Map<Integer, List<Integer>> childParentMap, int child) {
        System.out.println(child);
        Set<Integer> allParents = new LinkedHashSet<>();

        List<Integer> parents = childParentMap.get(child);


        Stack<Integer> parentStack = new Stack<>();
        parentStack.addAll(parents);

        createGenerationSet(childParentMap, allParents, parentStack);

        System.out.println(allParents);

        return allParents;
    }

    public List<Integer> commonSuccessors(int[][] graph, int parent1, int parent2) {
        List<Integer> output = new ArrayList<>();

        Map<Integer, List<Integer>> parentChildMap = createParentChildMap(graph);

        Set<Integer> parent1Successors = findAllSuccessors(parentChildMap, parent1);
        Set<Integer> parent2Successors = findAllSuccessors(parentChildMap, parent2);

        for (Integer ancestor : parent1Successors) {
            if (parent2Successors.contains(ancestor)) {
                output.add(ancestor);
            }
        }

        return output;
    }

    private Set<Integer> findAllSuccessors(Map<Integer, List<Integer>> parentChildMap, int parent) {
        System.out.println(parent);

        List<Integer> children = parentChildMap.get(parent);
        Set<Integer> allSuccessors = new LinkedHashSet<>();
        Stack<Integer> childStack = new Stack<>();

        childStack.addAll(children);

        createGenerationSet(parentChildMap, allSuccessors, childStack);

        return allSuccessors;
    }

    private void createGenerationSet(Map<Integer, List<Integer>> generationMap, Set<Integer> allGen, Stack<Integer> genStack) {
        while (!genStack.isEmpty()) {
            Integer chd = genStack.pop();
            allGen.add(chd);

            List<Integer> successors = generationMap.get(chd);
            if (!successors.isEmpty()) {
                genStack.addAll(successors);
            }
        }
    }

    private Map<Integer, List<Integer>> createParentChildMap(int[][] graph) {
        Map<Integer, List<Integer>> parentChildMap = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            int parent = graph[i][0];
            int child = graph[i][1];

            createRelationMap(parentChildMap, child, parent);
        }


        return parentChildMap;
    }

    private Map<Integer, List<Integer>> createChildParentMap(int[][] graph) {
        Map<Integer, List<Integer>> parentChildMap = new HashMap<>();

        for (int i = 0; i < graph.length; i++) {
            int parent = graph[i][0];
            int child = graph[i][1];

            createRelationMap(parentChildMap, parent, child);
        }

        return parentChildMap;
    }

    private void createRelationMap(Map<Integer, List<Integer>> parentChildMap, int node1, int node2) {
        if (!parentChildMap.containsKey(node2)) {
            parentChildMap.put(node2, new ArrayList<>());
        }
        parentChildMap.get(node2).add(node1);

        if (!parentChildMap.containsKey(node1)) {
            parentChildMap.put(node1, new ArrayList<>());
        }
    }
}
