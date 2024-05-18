package HW.HW2;

public class HW2 {
    int firstBadVersion;
    boolean isBadVersion(int version) {
        return version < firstBadVersion;
    }

    public int findFirstBadVersion(int[] versions) {
        int start = 0, end = versions.length - 1;
        int first = versions[versions.length - 1];
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isBadVersion(versions[mid])) {
                first = versions[mid];
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return first;
    }
}
