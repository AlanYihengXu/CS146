class TreeNode(object):

    def __init__(self, val=0, left=None, right=None):

        self.val = val

        self.left = left

        self.right = right

def isValidBSTRecursive(self, current, min=None, max=None):
    if (current == None):
        return True
    if (min != None and current.val < min):
        return False
    if (max != None and current.val > max):
        return False
    return isValidBSTRecursive(None, current.left, min=min, max=current.val) and isValidBSTRecursive(None, current.right, min=current.val, max=max)

def isValidBST(self, root):
    return isValidBSTRecursive(None, root)

left = TreeNode(3, TreeNode(1), None)
right = TreeNode(8, TreeNode(5), TreeNode(9))
root = TreeNode(4, left, right)
print(isValidBST(None, root))
left = TreeNode(2, TreeNode(3), TreeNode(4))
right = TreeNode(8, TreeNode(5), TreeNode(6))
root = TreeNode(1, left, right)
print(isValidBST(None, root))