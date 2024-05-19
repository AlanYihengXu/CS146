def longestPalindrome(self, s):
    letters = [0 for i in range(52)]
    length = 0
    for c in s:
        index = ord(c) - ord('A')
        if index > 26:
            index -= 6
        letters[index] = letters[index] + 1
    foundOdd = False
    for i in letters:
        if i % 2 == 1:
            if not foundOdd:
                length += i
                foundOdd = True
            else:
                length += i-1
        else:
            length += i
    return length

print(longestPalindrome(None, "abccccdd"))
print(longestPalindrome(None, "speediskey"))