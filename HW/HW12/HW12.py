from typing import List


def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
    supplied =  [False for i in range(n)]
    cost = 0
    sortedPipes = []
    for i in range(n):
        for pipe in pipes:
            if (pipe[0] is i+1 or pipe[1] is i+1) and pipe[2] < wells[i]:
                break
        else:
            cost += wells[i]
            supplied[i] = True
            addConnectedPipes(i+1, pipes, supplied, sortedPipes)       
    while False in supplied:
        if not sortedPipes:
            minWell = -1
            for i in range(len(supplied)):
                if not supplied[i] and (minWell == -1 or wells[i] < wells[minWell]):
                    minWell = i
            cost += wells[minWell]
            supplied[minWell] = True
            addConnectedPipes(minWell+1, pipes, supplied, sortedPipes)
            continue
        pipe = sortedPipes.pop(0)
        if supplied[pipe[0]-1] and supplied[pipe[1]-1]:
            continue
        cost += pipe[2]
        if supplied[pipe[0]-1]:
            supplied[pipe[1]-1] = True
            addConnectedPipes(pipe[1], pipes, supplied, sortedPipes)
        else:
            supplied[pipe[0]-1] = True
            addConnectedPipes(pipe[0], pipes, supplied, sortedPipes)
    return cost
def addConnectedPipes(house, pipes, supplied, sortedPipes):
    for pipe in pipes:
        if pipe[0] == house and not supplied[pipe[1]-1] or pipe[1] == house and not supplied[pipe[0]-1]:
            if not sortedPipes or pipe[2] > sortedPipes[len(sortedPipes)-1][2]:
                sortedPipes.append(pipe)
                continue
            for j in range(len(sortedPipes)):
                if (pipe[2] < sortedPipes[j][2]):
                    sortedPipes.insert(j, pipe)
                    break

wells = [1, 2]
pipes = [[1, 2, 1], [1, 2, 2]]
print(minCostToSupplyWater(None, 2, wells, pipes))
wells2 = [5, 4, 1]
pipes2 = [[1, 2, 1], [1, 2, 2]]
print(minCostToSupplyWater(None, 3, wells2, pipes2))
wells3 = [0, 10, 10, 10, 10, 10, 10]
pipes3 = [[1, 2, 2], [1, 4, 5], [1, 5, 8], [1, 7, 9], [7, 5, 15], [6, 4, 4], [6, 3, 6], [5, 2, 2], [2, 3, 2], [3, 4, 2]]
print(minCostToSupplyWater(None, 7, wells3, pipes3))