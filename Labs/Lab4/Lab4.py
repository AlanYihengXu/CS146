class TreeNode(object):

    def __init__(self, val=0, left=None, right=None):

        self.val = val

        self.left = left

        self.right = right

def invertTreeRecurse(self, current):
    if current == None:
        return
    temp = current.left
    current.left = current.right
    current.right = temp
    invertTreeRecurse(None, current.left)
    invertTreeRecurse(None, current.right)

def invertTree(self, root):
    invertTreeRecurse(None, root)
    return root

left = TreeNode(2, TreeNode(3), TreeNode(4))
right = TreeNode(8, TreeNode(5), TreeNode(6))
root = TreeNode(1, left, right)
print(root.val, root.left.val, root.right.val, root.left.left.val, root.left.right.val, root.right.left.val, root.right.right.val)
invertTree(None, root)
print(root.val, root.left.val, root.right.val, root.left.left.val, root.left.right.val, root.right.left.val, root.right.right.val)