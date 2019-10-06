package T1146;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        SnapshotArray snapshotArray = new SnapshotArray(3);
//        snapshotArray.set(0, 5);
//        snapshotArray.snap();
//        snapshotArray.set(0, 6);
//        snapshotArray.snap();
//        System.out.println(snapshotArray.get(0, 1));
//        SnapshotArray snapshotArray = new SnapshotArray(2);
//        snapshotArray.snap();
//        snapshotArray.set(1, 17);
//        snapshotArray.set(0, 20);
//        snapshotArray.snap();
//        snapshotArray.snap();
//        snapshotArray.snap();
//        System.out.println(snapshotArray.get(0, 1));
//        SnapshotArray snapshotArray = new SnapshotArray(2);
//        snapshotArray.snap();
//        snapshotArray.get(1, 0);
//        snapshotArray.get(0, 0);
//        snapshotArray.set(1, 8);
//        snapshotArray.get(1, 0);
//        snapshotArray.set(0, 20);
//        snapshotArray.get(0, 0);
//        snapshotArray.get(0, 7);
//        System.out.println(snapshotArray.get(0, 1));
        SnapshotArray snapshotArray = new SnapshotArray(1);
        snapshotArray.snap();
        snapshotArray.get(0, 0);
        snapshotArray.get(0, 0);
        snapshotArray.set(0, 2);
        snapshotArray.snap();
        snapshotArray.set(0, 14);
        snapshotArray.get(0, 1);
        snapshotArray.set(0, 12);
        snapshotArray.snap();
        System.out.println(snapshotArray.get(0, 0));
        snapshotArray.set(0, 7);
        snapshotArray.set(0, 7);
    }
}

class SnapshotArray {

    private int curSnapId = 0;
    private Map<Integer, Map<Integer, Integer>> snaps;
    private Map<Integer, Integer> arr;
    private Map<Integer, Integer> idx2SnapId;

    public SnapshotArray(int length) {
        this.snaps = new HashMap<>();
        this.arr = new HashMap<>();
        this.idx2SnapId = new HashMap<>();
    }

    public void set(int index, int val) {
        arr.put(index, val);
    }

    public int snap() {
        if (curSnapId == 0) {
            HashMap<Integer, Integer> snap = new HashMap<>();
            arr.forEach((idx, value) -> {
                idx2SnapId.put(idx, curSnapId);
                snap.put(idx, value);
            });
            snaps.put(curSnapId, snap);
            return curSnapId++;
        }

        HashMap<Integer, Integer> snap = new HashMap<>();
        arr.forEach((idx, value) -> {
            if (idx2SnapId.containsKey(idx)) {
                int snapId = idx2SnapId.get(idx);

                int valueInSnap = snaps.get(snapId).get(idx);
                if (valueInSnap != value) {
                    idx2SnapId.put(idx, curSnapId);
                    snap.put(idx, value);
                }
            } else {
                idx2SnapId.put(idx, curSnapId);
                snap.put(idx, value);
            }
        });

        snaps.put(curSnapId, snap);
        return curSnapId++;
    }

    public int get(int index, int snap_id) {
        if (!arr.containsKey(index)) return 0;
        if (idx2SnapId.containsKey(index)) {
            if (idx2SnapId.get(index) <= snap_id) return snaps.get(idx2SnapId.get(index)).get(index);
        } else return 0;

        for (int i = snap_id; i >= 0; i--) {
            if (snaps.get(i).containsKey(index)) {
                return snaps.get(i).get(index);
            }
        }
        return 0;
    }
}