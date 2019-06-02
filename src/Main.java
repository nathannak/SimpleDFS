
import java.util.*;
import java.lang.*;

class Main {

    public static void main(String[] args) {

        Main.Node root = new Main.Node("A");
        root.addChild("B").addChild("C");
        root.children.get(0).addChild("D");
        System.out.println( root.depthFirstSearch(new ArrayList<>()) );
    }

    static class Node{

        public String name;

        ArrayList<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public ArrayList<String> depthFirstSearch(ArrayList<String> array) {

            Deque<Node> dq = new ArrayDeque<>();
            dq.push(this);

            while(!dq.isEmpty()){

                Node node = dq.pop();
                array.add(node.name);

                ArrayList<Node> _children = node.children;
                Collections.sort(_children, new Comparator<Node>(){
                    public int compare(Node a , Node b){

                        return b.name.compareTo(a.name);

                    }
                });

                for(int i = 0 ; i < _children.size(); i++){
                    dq.push(_children.get(i));
                }

            }

            return array;

        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }

    }
}
