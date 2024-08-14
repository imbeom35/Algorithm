from sys import setrecursionlimit
from collections import namedtuple
setrecursionlimit(10 ** 6)

Node = namedtuple('Node', ['x', 'y', 'id'])

def solution(nodeinfo):
    nodeinfo = [Node(x, y, id) for id, (x, y) in enumerate(nodeinfo, 1)]
    
    def preorder(arr):
        if len(arr) < 1:
            return [node.id for node in arr]
        
        pivot = max(arr, key=lambda node: node.y)
        
        res = [pivot.id]
        res += preorder([node for node in arr if node.x < pivot.x])
        res += preorder([node for node in arr if node.x > pivot.x])
        
        return res
    
    def postorder(arr):
        if len(arr) < 1:
            return [node.id for node in arr]
        
        pivot = max(arr, key=lambda node: node.y)
        
        res = []
        res += postorder([node for node in arr if node.x < pivot.x])
        res += postorder([node for node in arr if node.x > pivot.x])
        res += [pivot.id]
        
        return res
        
    return preorder(nodeinfo), postorder(nodeinfo)