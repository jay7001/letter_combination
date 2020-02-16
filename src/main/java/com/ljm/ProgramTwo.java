package com.ljm;

import java.util.*;

public class ProgramTwo {

    private static Map<Integer, String[]> btnMappings;

    static {
        btnMappings = new HashMap<>();
        btnMappings.put(0, new String[] {"0"});
        btnMappings.put(1, new String[] {"1"});
        btnMappings.put(2, new String[] {"a","b","c"});
        btnMappings.put(3, new String[] {"d","e","f"});
        btnMappings.put(4, new String[] {"g","h","i"});
        btnMappings.put(5, new String[] {"j","k","l"});
        btnMappings.put(6, new String[] {"m","n,","o"});
        btnMappings.put(7, new String[] {"p","q","r","s"});
        btnMappings.put(8, new String[] {"t","u","v"});
        btnMappings.put(9, new String[] {"w","x","y","z"});
    }

    public static void main(String[] args) throws Exception {
        output(new Integer[] {2,3,4,879});
    }

    public static void output(Integer[] inArr) {
        if (inArr == null || inArr.length <= 0) {
            return;
        }
        //convert arr
        List<Integer> ints = new ArrayList<>(inArr.length);
        Collections.addAll(ints, inArr);
        for (int i=0;i<ints.size();i++) {
            int val = ints.get(i);
            if (val > 9) {
                char[] chars = String.valueOf(val).toCharArray();
                List<Integer> sub = new ArrayList<>();
                for (int j=0;j<chars.length;j++) {
                    sub.add(Integer.parseInt(String.valueOf(chars[j])));
                }
                ints.remove(i);
                ints.addAll(i, sub);
                i = i + sub.size() - 1;
            }
        }
        Integer[] arr = ints.toArray(new Integer[0]);
        //save
        LetterTree root = new LetterTree();
        for (int i=0;i<arr.length;i++) {
            String[] letters = btnMappings.get(arr[i]);
            LetterTree letterTree;
            List<LetterTree> children = new ArrayList<>();
            for (String letter : letters) {
                letterTree = new LetterTree(letter, new ArrayList<>());
                children.add(letterTree);
            }

            appendChild(root, children);
        }
        //print
        print(root, new StringBuilder());
    }
    private static void print(LetterTree letterTree, StringBuilder sb) {
        if (letterTree.getData() != null) {
            sb.append(letterTree.getData());
        }
        if (letterTree.getChildren() == null || letterTree.getChildren().size() == 0) {
            System.out.print(sb.toString() + " ");
        }
        for (LetterTree child : letterTree.getChildren()) {
            print(child, new StringBuilder(sb));
        }
    }

    private static void appendChild(LetterTree letterTree, List<LetterTree> children) {
        if (letterTree.getChildren() == null || letterTree.getChildren().size() == 0) {
            letterTree.setChildren(children);
        } else {
            if (letterTree.getChildren() != children) {
                int size = letterTree.getChildren().size();
                for (int i = 0; i < size; i++) {
                    LetterTree child = letterTree.getChildren().get(i);
                    appendChild(child, children);
                }
            }
        }
    }

}