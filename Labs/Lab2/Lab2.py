import re

def isAnagram(s, t):
    if (not s or not t):
        print("Input is null")
        return False
    s = re.sub("[^a-z]", "", s.lower())
    t = re.sub("[^a-z]", "", t.lower())
    letters = {}
    for c in s:
        if not letters.get(c):
            letters.update({c : 0})
        letters.update({c : letters.get(c)+1})
    for c in t:
        if not letters.get(c):
            return False
        letters.update({c : letters.get(c)-1})
        if letters.get(c) < 0:
            return False
    for i in letters.values():
        if i != 0:
            return False
    return True

print(isAnagram("Anagram", "Nag a ram"))
print(isAnagram("ABCDE", "DADBC"))
print(isAnagram(None, "null"))