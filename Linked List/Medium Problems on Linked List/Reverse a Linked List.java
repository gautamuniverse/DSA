//recusrion solution

        //Base case
        // if(head.next == null)
        // return head;

        // Node smallHead = reverseLinkedList(head.next);

        // Node temp = head.next;

        // head.next = null;
        // temp.next = head;

        // return smallHead;

        //Iterative solution
        
        //prev node
        Node prev= null;
        //Next node to current
        Node next = null;
        //Current node
        Node curr = head;

        while(curr != null)
        {

            //Move next to the next of the current node
            next = curr.next;

            //Change the next of the curr node link
            curr.next = prev;

            //Move prev = to the curr node
            prev= curr;

            //move curr to the next node
            curr = next;
        }


        return prev;