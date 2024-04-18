def findIndices(nums, target):
    for i in range(len(nums)):
        for j in range(i+1, len(nums)):
            if nums[i] + nums[j] == target:
                return [i, j]
            
nums = [1, 2, 3, 5, 8, 13]
target = 11
print(findIndices(nums, target))