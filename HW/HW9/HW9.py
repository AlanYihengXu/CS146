class TreeNode(object):

    def __init__(self, val=0, left=None, right=None):

        self.val = val

        self.left = left

        self.right = right

def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
    current_node = root
    while current_node != None:
        if p.val < current_node.val and q.val < current_node.val:
            current_node = current_node.left
        elif p.val > current_node.val and q.val > current_node.val:
            current_node = current_node.right
        else:
            return current_node
    return None

five = TreeNode(5)
nine = TreeNode(9)
eight = TreeNode(8, five, nine)
one = TreeNode(1)
three = TreeNode(3, one, None)
four = TreeNode(4, three, eight)
print(lowestCommonAncestor(None, four, one, five).val)