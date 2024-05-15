def nthFibonacci(n):
    if n == 0:
        return 0
    a, b = 0, 1
    for i in range(2, n+1):
        c = a + b
        a = b
        b = c
    return b
print(nthFibonacci(8))