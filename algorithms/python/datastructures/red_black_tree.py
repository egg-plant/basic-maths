from __future__ import annotations

from dataclasses import dataclass


# Redblack Tree is a binary tree that satisfies given critieria
# 1) Every node is either red or black
# 2) Root node is always black
# 3) Every leaf (NIL) is black
# 4) If node is red then both its children are black
# 5) For each node all the simple paths to its descendant leaves contain the same number of black nodes.

@dataclass
class RedBlackTreeNode:
    colour: str
    key: int
    left: RedBlackTreeNode
    right: RedBlackTreeNode
    parent: RedBlackTreeNode
