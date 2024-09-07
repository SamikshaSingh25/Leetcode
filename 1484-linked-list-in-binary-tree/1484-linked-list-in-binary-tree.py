class Solution:
    def isSubPath(
        self, head: Optional[ListNode], root: Optional[TreeNode]
    ) -> bool:
        if not root:
            return False
        # Check the current node and all its descendants
        result = self.dfs(root, head)
        # Check all paths from the left and right children of the root
        result = result or self.isSubPath(head, root.left)
        result = result or self.isSubPath(head, root.right)
        return result

    def dfs(self, node: Optional[TreeNode], head: Optional[ListNode]) -> bool:
        if not head:
            return True
        if not node:
            return False
        result = False
        if node.val == head.val:
            # Continue searching in both left and right subtrees
            result = self.dfs(node.left, head.next)
            result = result or self.dfs(node.right, head.next)
        return result