firstBadVersion = None
def isBadVersion(version):
    return version < firstBadVersion

def findFirstBadVersion(versions):
    start, end = 0, len(versions)-1
    first = versions[-1]
    while start < end:
        mid = (start + end) / 2
        if isBadVersion(versions[mid]):
            first = versions[mid]
            end = mid
        else:
            start = mid + 1
    return first
