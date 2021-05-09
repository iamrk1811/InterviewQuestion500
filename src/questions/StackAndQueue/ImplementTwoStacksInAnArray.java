package questions.StackAndQueue;

public class ImplementTwoStacksInAnArray {
//    Q - https://www.geeksforgeeks.org/implement-two-stacks-in-an-array/
    int[] arr;
    int first = -1;
    int second = 0;
    int size = 0;

    public ImplementTwoStacksInAnArray(int size) {
        this.arr = new int[size];
        this.second = size;
    }

    //    push first
    public boolean pushFirst(int data) {
        if (this.size == this.arr.length) return false;
        this.first++;
        this.arr[this.first] = data;
        this.size++;
        return true;
    }

    //    push second
    public boolean pushSecond(int data) {
        if (this.size == this.arr.length) return false;
        this.second--;
        this.arr[this.second] = data;
        this.size++;
        return true;
    }

    //    pop first
    public int popFirst() {
        if (this.first == -1) return -1;
        int deletedData = this.arr[this.first];
        this.first--;
        this.size--;
        return deletedData;
    }
    //    pop first
    public int popSecond() {
        if (this.second == this.arr.length) return -1;
        int deletedData = this.arr[this.second];
        this.second++;
        this.size--;
        return deletedData;
    }

    //    peek first
    public int peekFirst() {
        if (this.first == -1) return -1;
        return this.arr[this.first];
    }

    //    peek first
    public int peekSecond() {
        if (this.second == this.arr.length) return -1;
        return this.arr[this.second];
    }

    //    size
    public int size() {
        return this.size;
    }

    //    isEmpty
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i <= this.first; i++) {
            str.append(this.arr[i]).append(" ");
        }
        str.append("->");
        for (int i = this.arr.length - 1; i >= this.second; i--) {
            str.append(this.arr[i]).append(" ");
        }
        return str.toString();
    }

}
