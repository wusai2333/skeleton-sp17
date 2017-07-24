
class ArrayDeque<Item>
{
    private Item[] items;
    private int size;
    private int first;
    private int last;
    private int capacity;
    public ArrayDeque() {
        capacity = 8;
        items = (Item[])new Object[capacity];
        size = 0;
        first = 0;
        last = 0;
    }

    public void addFirst(Item x) {
        if (size != 0) {
            first--;
            if (first < 0) {
                first = capacity - 1;
            }
            if (first == last) {
                resize();
                first--;
            }
            items[first] = x;
            size = size + 1;
        } else {
            items[first] = x;
            size ++;
        }
    }

    public void addLast(Item x) {
        if (size != 0) {
            last++;
            if (last > capacity -1) {
                last = 0;
            }
            if (last == first) {
                resize();
                last++;
            }
            items[last] = x;
            size++;
        } else {
            items[last] = x;
            size ++;
        }
    }

    public Item removeFirst() {
        if (size == 0) {
            return null;
        }
        Item toRemoved = items[first];
        first++;
        size--;
        if (first > capacity - 1) {
            first = 0;
        }
        if (size < capacity / 2 && capacity > 8) {
            resize();
        }
        return toRemoved;
    }

    public Item removeLast() {
        if (size == 0) {
            return null;
        }
        Item toRemoved = items[last];
        last--;
        size--;
        if (last < 0) {
            last = capacity - 1;
        }
        if (size < capacity/2 && capacity > 8) {
            resize();
        }
        return toRemoved;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }

    public Item get(int idx) {
        if (idx >= size) return null;
        if (idx >= capacity) {
            idx = (first + idx) % capacity;
            return items[idx];
        }
        return items[first + idx];
    }

    public void printDeque() {
        int start = first;
        while (start != last) {
            System.out.print(items[start] + " ");
            start ++;
            if (start >= capacity) {
                start = 0;
            }
        }
        System.out.print(items[last]);
    }

    private void resize() {
        if (size < capacity/2) {
            int newCapacity = capacity / 2;
            Item[] newArray = (Item[]) new Object[newCapacity];
            int pos = 0;
            while (first != last) {
                newArray[pos++] = items[first++];
                if(first > capacity -1) {
                    first = 0;
                }
            }
            newArray[pos] = items[last];
            items = newArray;
            first = 0;
            last = pos;
            capacity = newCapacity;
        } else {
            int newCapacity = 2 * capacity;
            Item[] newArray = (Item[]) new Object[newCapacity];
            int pos = newCapacity / 4;
            while (first != last) {
                newArray[pos++] = items[first++];
                if (first > capacity - 1) {
                    first = 0;
                }
            }
            newArray[pos] = items[last];
            items = newArray;
            first = newCapacity/4;
            last = pos;
            capacity = newCapacity;
        }
    }
}

