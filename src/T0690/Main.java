package T0690;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        Deque<Employee> queue = new ArrayDeque<>();
        queue.addFirst(map.get(id));
        int sum = 0;
        while (queue.size() > 0) {
            Employee tmp = queue.removeLast();
            sum += tmp.importance;
            for (Integer subordinate : tmp.subordinates) {
                queue.addFirst(map.get(subordinate));
            }
        }

        return sum;
    }
}
