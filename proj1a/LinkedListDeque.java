// package whatever; // don't place package name!


public class LinkedListDeque<Item> {

    private class StuffNode {
        public Item item;
        public StuffNode next;
        public StuffNode prev;

        public StuffNode (Item i,StuffNode p, StuffNode n) {
            item = i;
            next = n;
            prev = p;
        }
        public StuffNode(){}
    }


    private int size;
    private StuffNode head;
    private StuffNode tail;
    
    public LinkedListDeque() {
        head = new StuffNode();
        tail = new StuffNode();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addFirst(Item value) {
        StuffNode temp = new StuffNode(value, head, head.next);
        head.next.prev = temp;
        head.next = temp;
        size ++;
    }

    public void addLast(Item value) {
        StuffNode temp = new StuffNode(value, tail.prev, tail);
        tail.prev.next = temp;
        tail.prev = temp;
        size ++;
    }


    public Item getFirst() {
        return head.next.item;
    }
    public Item getLast() {
        return tail.prev.item;
    }

    public Item get(int index) {
        int pos = 0;
        StuffNode ptr = head;
        if (index >= size) return null;
        while(pos <= index) {
            ptr = ptr.next;
            pos++;
        }
        return ptr.item;

    }

    public Item getRecursive(int index) {
        if (index >= size) return null;
        return getRecursive(head, index);
    }
    private Item getRecursive(StuffNode starter, int index) {
        if (index == 0) {
            return starter.next.item;
        }
        return getRecursive(starter.next, index-1);
    }

    public Item removeFirst() {
        if (size == 0) return null;
        StuffNode toRemove = head.next;
        toRemove.next.prev = head;
        toRemove.prev.next = toRemove.next;
        size --;
        return toRemove.item;
    }
    public Item removeLast() {
        if (size == 0) return null;
        StuffNode toRemove = tail.prev;
        toRemove.next.prev = toRemove.prev;
        toRemove.prev.next = tail;
        size --;
        return toRemove.item;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        StuffNode ptr = head.next;
        while (ptr != tail) {
            System.out.print(ptr.item + " ");
            ptr = ptr.next;
        }
    }
}    