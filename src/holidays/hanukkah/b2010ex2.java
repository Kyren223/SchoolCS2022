package holidays.hanukkah;

import hw05.Node;

public class b2010ex2 {

    public static void main(String[] args) {
        Node<Integer> head = new Node<Integer>(3,
                new Node<Integer>(4,
                new Node<Integer>(5,
                new Node<Integer>(12,
                new Node<Integer>(19,
                new Node<Integer>(20,
                new Node<Integer>(100,
                new Node<Integer>(101,
                new Node<Integer>(102,
                new Node<Integer>(103,
                new Node<Integer>(104)))))))))));

        System.out.println("Head: \n" + head);
        System.out.println("RangedHead: \n" + createRangeList(head));
    }

    public static Node<RangeNode> createRangeList(Node<Integer> head) {
        Node<Integer> curr = head;
        Node<RangeNode> rangedHead = null;
        Node<RangeNode> rangedCurr = null;
        RangeNode rangeNode = null;

        int lastNumber = curr.getValue();
        while (curr != null) {
            if (lastNumber + 1 == curr.getValue()) {
                if (rangeNode == null) {
                    rangeNode = new RangeNode(lastNumber, curr.getValue());
                } else {
                    rangeNode.setTo(curr.getValue());
                }
            } else {
                if (rangeNode != null) {
                    // List has ended
                    rangeNode = new RangeNode(curr.getValue(), curr.getValue());
                }
            }

            if (rangeNode != null) {
                if (curr.getNext() == null || curr.getValue() + 1 != curr.getNext().getValue()) {
                    // We want to add the list only if:
                    // A. The next element is null, end of list
                    // B. The next value is not a continuation of the current range
                    if (rangedHead == null) {
                        rangedHead = new Node<RangeNode>(rangeNode);
                        rangedCurr = rangedHead;
                    } else {
                        rangedCurr.setNext(new Node<RangeNode>(rangeNode));
                        rangedCurr = rangedHead.getNext();
                    }
                }
            }

            lastNumber = curr.getValue();
            curr = curr.getNext();
        }

        return rangedHead;
    }

}
