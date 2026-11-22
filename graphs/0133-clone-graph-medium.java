class Solution {
    private Map<Node, Node> clones = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        return clone(node);
    }

    private Node clone(Node node) {
        if (clones.containsKey(node)) {
            return clones.get(node);
        }
        Node copy = new Node(node.val);
        clones.put(node, copy);
        for (Node neighbour : node.neighbors) {
            copy.neighbors.add(clone(neighbour));
        }
        return copy;
    }
}
