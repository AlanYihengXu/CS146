def canFinish(numCourses, prerequisites):
    canTake = [False for i in range(numCourses)]
    stack = []
    for i in range(numCourses):
        visited = [False for i in range(numCourses)]
        stack.append(i)
        while len(stack) is not 0:
            current = stack.pop()
            if canTake[current]:
                visited[current] = True
                continue       
            if (visited[current]):
                return False
            canTakePrereq = True
            for prereq in prerequisites:
                if prereq[0] is current:
                    canTakePrereq = canTakePrereq and canTake[prereq[1]]
                    stack.append(prereq[1])
            canTake[current] = canTakePrereq
            visited[current] = True
        canTake[i] = True
    return True

test1 = [[1, 0]]
print(canFinish(2, test1))
test2 = [[1, 0], [0, 1]]
print(canFinish(2, test2))
test3 = [[0, 1], [0, 2], [1, 3], [2, 3]]
print(canFinish(4, test3))
test4 = []
print(canFinish(1, test4))