
package algorithms.fringe;

import algorithms.Node;
import java.util.Iterator;

public class BinHeap implements Iterable<Node>  {
    private Node heap[];
    private int n;
    private final CompareF comp;
    
    public BinHeap(int capecity){
        heap= new Node[capecity+1];
        n=0;
        comp = new CompareF();
    }
    
    void resize(int capecity){
        Node[] tmp = new Node[capecity];
        for(int i=0; i<n ; i++){
            tmp[i] = heap[i];
        }
        heap = tmp;         
    }
    
    public void add(Node node){
        if(heap.length - 1 == n)
            resize(heap.length * 2);
        heap[++n] = node;
        heapifyUp(n);
    }
    
    public Node pop(){
        swap(1,n);
        Node ans = heap[n];
        n--;
        heapifyDown(1);
        heap[n+1] = null;
        return ans;
    }
    
//    public void remove(Node node){
//        if(!contains(node)) return;
//        for (int i=1; i<n ; i++) {
//            if(heap[i].x==node.x && heap[i].y==node.y){
//                swap(i,n);
//                n--;
//                heapifyDown(i);
//                heap[n+1] = null;
//            }
//        }
//    } 
    
//    public boolean contains(Node node){
//        if (isEmpty()) return false;
//        for (int i=1; i<n-1 ; i++) {
//            System.out.println(i+" "+size());
//            if(heap[i].x==node.x && heap[i].y==node.y) return true;
//        }
//        return false;
//    } 
    
    public void remove(){
        swap(1,n);
        //Node ans = heap[n];
        n--;
        heapifyDown(1);
        heap[n+1] = null;
        //return ans;
    }
    
    void heapifyUp(int x){
        while(x > 1 && priority(x/2, x)){
            swap(x, x/2);
            x = x/2;
        }
    }
    
    void heapifyDown(int x){
        while (2*x < n){
            int y = 2*x;
            if(y < n && priority(y, y+1)) 
                y++;
            if(!priority(x, y)) return;
            swap(x, y);
            x = y;
        }
    }
    
    void swap(int i, int j){
        Node tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
    
    boolean priority(int i, int j){
        return comp.compare(heap[i], heap[j])==1;
    }
    
    boolean isEmpty(){
        return n==0;
    }
    
    public int size() {
        return n;
    }
    
    public Node getNode(int i){
        return heap[i];
    }

    @Override
    public Iterator<Node> iterator() {
        return new Iterator<Node> () {
            private int pos=0;

            @Override
            public boolean hasNext() {
               return heap.length>pos;
            }

            @Override
            public Node next() {
               return heap[pos++];
            }
            
            @Override
            public void remove() {
                throw new UnsupportedOperationException("Cannot remove an element of an array.");
            }
            
        };  
    }
}


