import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Node cur = new Node(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            String value;
            Node newNode;
            switch (command) {
                case 1:
                    value = st.nextToken();

                    newNode = new Node(value);

                    if (cur.hasPrevious()) {
                        cur.previous.setNext(newNode);
                    }
                    cur.setPrevious(newNode);

                    break;
                case 2:
                    value = st.nextToken();

                    newNode = new Node(value);

                    if (cur.hasNext()) {
                        cur.next.setPrevious(newNode);
                    }
                    cur.setNext(newNode);

                    break;
                case 3:
                    if (cur.previous != null) {
                        cur = cur.previous;
                    }
                    break;
                case 4:
                    if (cur.next != null) {
                        cur = cur.next;
                    }
                    break;
            }

            cur.print();

        }

    }

    public static class Node {
        public Node previous;
        public String value;
        public Node next;

        public Node(String value) {
            this.previous = null;
            this.value = value;
            this.next = null;
        }

        public void setNext(Node next) {
            this.next = next;
            next.previous = this;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
            previous.next = this;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public boolean hasPrevious() {
            return this.previous != null;
        }

        public void print() {
            if (this.hasPrevious()) {
                System.out.print(this.previous.value);
            } else {
                System.out.print("(Null)");
            }
            System.out.print(" " + this.value + " ");
            if (this.hasNext()) {
                System.out.print(this.next.value);
            } else {
                System.out.print("(Null)");
            }
            System.out.println();
        }
    }
}
