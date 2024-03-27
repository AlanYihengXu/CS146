from typing import List, Optional


class TreeNode(object):

    def __init__(self, val=0, left=None, right=None):

        self.val = val

        self.left = left

        self.right = right

def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
    if root is None:
        return None
    output = []
    queue = []
    queue.append(root)
    while len(queue) > 0:
        level_size = len(queue)
        level = []
        for i in range(level_size):
            current = queue.pop(0)
            level.append(current.val)
            if current.left is not None:
                queue.append(current.left)
            if current.right is not None:
                queue.append(current.right)
        output.append(level)
    return output

root = TreeNode(4, TreeNode(3, TreeNode(1), None), TreeNode(8, TreeNode(5), TreeNode(9)))
result = levelOrder(None, root)
print(result)

root = None
result = levelOrder(None, root)
print(result)