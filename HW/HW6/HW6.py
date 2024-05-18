from typing import List


def threeSum(self, nums: List[int]) -> List[List[int]]:
    nums.sort()
    output = []
    for i in range(0, len(nums)-1):
        if nums[i] > 0:
            break
        if i > 0 and nums[i] == nums[i-1]:
            continue
        for j in range(i+1, len(nums)):
            if j > i+1 and nums[j] == nums[j-1]:
                continue
            if nums[i] + nums[j] + nums[-1] < 0:
                continue
            lower = j+1
            higher = len(nums)-1
            while lower <= higher:
                middle = (lower + higher) // 2
                if nums[i] + nums[j] + nums[middle] == 0:
                    triplet = [nums[i], nums[j], nums[middle]]
                    output.append(triplet)
                    break
                if nums[i] + nums[j] + nums[middle] < 0:
                    lower = middle+1
                else:
                    higher = middle-1
    return output

print(threeSum(None, [0, 1, 1]))
print(threeSum(None, [-5, 0, 5, 10, -10, 0]))
print(threeSum(None, [5, -3, -2, 0, 3]))