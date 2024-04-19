def isPalindrome(s):
    alphanumeric = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"
    for c in s:
        if c not in alphanumeric:
            s = s.replace(c, '')
    for i, j in zip(s, reversed(s)):
        if (not i.lower() == j.lower()):
            return False
    return True

t = "Never odd or even"
f = "Not a clue"
print(isPalindrome(t))
print(isPalindrome(f))