import java.awt.*;

public class ArrayList{

    int size;

    Node node;

    private class Node{

        Point value;

        Node next ;

        public Node(){

        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public ArrayList(){
        size=0;
    }

    public void add(Point x){

        Node node =new Node();

        node.value = x;

        if(size == 0){
            this.node = node;
        }else{
            node.next=this.node;
            this.node=node;
        }

        size++;

        System.out.println(size);

    }

    public Point get(int x) {

        Node node = this.node;

        for(int i=0;i<x;i++){
            node = node.next;
        }

        return node.value;
    }


}
