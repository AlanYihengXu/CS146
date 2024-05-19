from typing import List


def minMeetingRooms(self, intervals: List[List[int]]) -> int:
    endTimes = []
    for interval in intervals:
        for i in range(len(endTimes)):
            if endTimes[i] <= interval[0]:
                endTimes[i] = interval[1]
                break
        else:
            endTimes.append(interval[1])
    return len(endTimes)

print(minMeetingRooms(None, [[0,30],[5,10],[15,20]]))
print(minMeetingRooms(None, [[0,1],[1,2],[2,3]]))