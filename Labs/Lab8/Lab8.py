from typing import List

def coinChangeRecurse(coins: List[int], amount: int):
    if amount == 0:
        return 0
    min = float('inf')
    for i in coins:
        if i <= amount:
            temp = coinChangeRecurse(coins, amount-i) + 1
            if temp < min: 
                min = temp
    return min

def coinChange(self, coins: List[int], amount: int) -> int:
    min = coinChangeRecurse(coins, amount)
    if min == float('inf'):
        min = -1
    return min

coins1 = [1, 2, 5]
print(coinChange(None, coins1, 11)) #3
coins2 = [2]
print(coinChange(None, coins2, 3)) #-1
coins3 = [1]
print(coinChange(None, coins3, 0)) #0
coins4 = [1, 10, 25, 50, 100]
print(coinChange(None, coins4, 40)) #4
coins5 = [2, 3]
print(coinChange(None, coins5, 11)) #4