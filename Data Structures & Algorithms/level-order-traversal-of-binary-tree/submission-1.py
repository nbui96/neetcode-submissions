# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if not root: return []

        q = deque([root])
        result = []

        while q:
            level = len(q)
            level_order = []
            for i in range(level):
                node = q.popleft()
                level_order.append(node.val)
                if node.left: q.append(node.left)
                if node.right: q.append(node.right)
            if level_order:
                result.append(level_order)
        
        return result