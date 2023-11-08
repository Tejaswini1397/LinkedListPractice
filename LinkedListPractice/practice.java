package LinkedListPractice;

import java.util.*;
public class practice {
  public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         int n=sc.nextInt();
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=n-i;j++){
        //         System.out.print(" ");
        //     }
        //     for(int j=1;j<=i;j++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }
    
    // Node node1=new Node(50);
    // Node node2=new Node(100);
    // Node node3=new Node(20);
    
    // Node head=node1;
    
    // node1.next = node2;
    // node2.next=node3;
    // Node temp=head;
    // while(temp!=null){
       
    //     System.out.println(temp.data);
    //      temp=temp.next;
    // }
    // System.out.println(node1.data);
    // System.out.println(node2.data);
    // System.out.println(node2);
    LinkedList ll=new LinkedList();
    // ll.addNode(60);
    // ll.addNode(90);
    // ll.addNode(85);
    // ll.addNode(87);
    // ll.addNode(55);
    // ll.printLinkedList();
    for(int i=0;i<n;i++){
        ll.addNode(sc.nextInt());
    }
  //  ll.printLinkedList();
    //  int m=sc.nextInt();
    // deleteNode(ll, m);
    // System.out.println();
    // LinkedList ll1=new LinkedList();
    // for(int i=0;i<m;i++){
    //     ll1.addNode(sc.nextInt());
    // }
//    Node temp=intersectionP(ll.head,ll1.head);
//Node temp=middleofLinkedList(ll.head);
// Node temp=reverse(ll.head);
//    while(temp!=null){
//     System.out.print(temp.data+ " ");
//     temp=temp.next;
//    }
// int k=sc.nextInt();
// int m=sc.nextInt();

// makeLoop(ll.head, m);
// Node cycle=IsCyclePresent(ll.head);
// System.out.println(cycle.data);
// Node temp=insertAtNode(ll.head, k,m);
// removeNthFromEnd(ll.head, m);
// while(temp!=null){
//     System.out.print(temp.data+" ");
//     temp=temp.next;
// }
// LinkedList ll1=new LinkedList();
// for(int i=0;i<n;i++){
//     ll1.addNode(sc.nextInt());
// }
// Node curr=multiplyLL(ll.head,ll1.head );
// System.out.println(temp.data);
// System.out.println(curr.data);
//palindromicLinkedList(ll.head); 
//  Node temp=addLinkedList(ll.head, ll1.head);
Node temp=unfoldList(ll.head);
//rearrangeList(ll.head);
//segaregate012(ll.head);
// RemoveDuplicate(ll.head);
// subtractLinkedList(ll.head, ll1.head); 
while(temp!=null){
    System.out.print(temp.data+" ");
    temp=temp.next;
 }

}
public static Node unfoldList(Node head){
   Node dummyEven=new Node(-1);
   Node dummyOdd=new Node(-1);
   Node temp=head;
   Node tempEven=dummyEven, tempOdd=dummyOdd;
   int idx=0;
   while(temp!=null){
    if(idx%2==0){
        tempEven.next=temp;
        tempEven=tempEven.next;
    }else{
        tempOdd.next=temp;
        tempOdd=tempOdd.next;
    }
    idx++;
    temp=temp.next;
   }
   tempOdd.next=null;
   Node rev=reverse(dummyOdd.next);
   tempEven.next=rev;
//    Node tmp=dummyEven.next;
   return dummyEven.next;
}
public static Node rearrangeList(Node head){
   Node mid=middleofLinkedList(head);
   Node midNext=mid.next;
   mid.next=null;
   Node rev=reverse(midNext);
   Node left=head;
   Node right=rev;
   Node temp=null;
   while(left!=null && right!=null){
    temp=left.next;
    left=right;
    right=temp;
   }
   return head;
}
public static Node segaregate012(Node head){
    Node dummy0=new Node(-1);
    Node temp0=dummy0;
    Node dummy1=new Node(-1);
    Node temp1=dummy1;
    Node dummy2=new Node(-1);
    Node temp2=dummy2;
    Node temp=head;
    while(temp!=null){
        if(temp.data==0){
            temp0.next=temp;
            temp0=temp0.next;
        }else if(temp.data==1){
            temp1.next=temp;
            temp1=temp1.next;
        }else{
            temp2.next=temp;
            temp2=temp2.next;
        }
        temp=temp.next;
    }
    temp2.next=null;
    temp1.next=dummy2.next;
    temp0.next=dummy1.next;
    return dummy0.next;
}
public static int length(Node head){
    int len=0;
    Node curr=head;
    while(curr!=null){
        len++;
        curr=curr.next;
    }
    return len;
}
public static Node subtractLinkedList(Node head1,Node head2){
   while(head1!=null && head1.data==0){
    head1=head1.next;
   }
   while(head2!=null && head2.data==0) head2=head2.next;
   int n1=length(head1);
   int n2=length(head2);
   if(n1<n2){
    Node temp=head1;
    head1=head2;
    head2=temp;
   }
   if(n1==n2){
    Node l1=head1;
    Node l2=head2;
    while(l1.data==l2.data){
        l1=l1.next;
        l2=l2.next;
        if(l1==null) return new Node(0);
    }
    if(l1.data<l2.data){
        Node temp=l1;
        l1=l2;
        l2=temp;
    }
   }
   Node l1=reverse(head1);
   Node l2=reverse(head2);
   Node res=null;
   while(l1!=null){
    int small=0;
    if(l2!=null){
        small=l2.data;
    }
    if(l1.data<small){
        l1.next.data=l1.next.data-1;
        l1.data=l1.data+10;
    }
    Node n=new Node(l1.data-small);
    n.next=res;
    res=n;
    l1=l1.next;
    if(l2!=null) l2=l2.next;
   }
   while(res!=null && res.data==0) res=res.next;
   return res;


}
public static Node RemoveDuplicate(Node head){
    if(head==null ||  head.next==null) return head;
    Node temp=head;
    while(temp!=null){
        while(temp.next!=null && temp.data==temp.next.data){
            temp.next=temp.next.next;
        }
        temp=temp.next;
    }
    return head;

}
public static Node addLinkedList(Node head1,Node head2){
   Node l1=reverse(head1);
   Node l2=reverse(head2);
   Node dummy=new Node(-1);
   Node temp=dummy;
   int sum=0;
   int carry=0;
   while(l1!=null || l2!=null){
    sum=0;
    if(l1!=null){
        sum+=l1.data;
        l1=l1.next;
    } 
    if(l2!=null){
        sum+=l2.data;
        l2=l2.next;
    }
    sum+=carry;
    carry=sum/10;
    Node n=new Node(sum%10);
    temp.next=n;
    temp=temp.next;
   }
   if(carry>0){
    Node n=new Node(carry);
    temp.next=n;
   }
   return reverse(dummy.next);
}
   public static void palindromicLinkedList(Node head){
    if(head==null) return;
    Node mid=middleofLinkedList(head);
    Node rev=reverse(mid);
    Node left=head;
    Node right=rev;
    boolean flag=true;
    while(right!=null && right.next!=null){
        if(right.data!=left.data){
            flag=false;
        }
        left=left.next;
        right=right.next;
    }
    if(flag) System.out.println("LinkedList is Palindromic");
    else System.out.println("Given LinkedList Not Palindromic");
   }
   public static Node insertAtNode(Node head,int k, int pos){
    Node node=new Node(k);
    if(head==null){
        return head=node;
    }
    else if(pos==0){
        node.next=head;
         head=node;
         return head;
    }else{
        Node temp =head;
        for(int i=0;i<pos-1;i++){
            temp=temp.next;
        }
        node.next=temp.next;
        temp.next=node;
        return head;
        

    }
    
   }
  
    public static Node multiplyLL(Node head1, Node head2) {
        // Write your code here
        int num1=0,num2=0;
        
        while(head1!=null || head2!=null){
            if(head1!=null){
                if(head1.data<0){
                    head1=head1.next;
                }else{
                num1=num1*10+head1.data;
                head1=head1.next;
                }
            }
            if(head2!=null){
                if(head2.data<0){
                    head2=head2.next;
                }
                else{
                num2=num2*10+head2.data;
                head2=head2.next;
                }
            }
        }
        int num=num1*num2;
        Node temp=new Node(num);
        
        return temp;

    }
   public static Node  removeNthFromEnd(Node head,int k){
    // Node slow=head;
    // Node fast=head;
    // for(int i=0;i<k;i++){
    //     fast=fast.next;
    // }
    // if(fast==null) return head.next;
    // while(fast!=null && fast.next!=null){
    //     slow=slow.next;
    //     fast=fast.next;
    // }
    // slow.next=slow.next.next;
    Node temp=head;
    int idx=0;
    while(temp!=null){
        idx++;
        temp=temp.next;
    }
    if(k==idx){
        head=head.next;
        return head;
    }
    temp=head;
    for(int i=1;i<idx-k;i++){
        temp=temp.next;
    }
    temp.next=temp.next.next;
   
    return head;
   }
   public static void makeLoop(Node head, int x){
    if (x == 0)
        return;
    Node curr = head;
    Node last = head;

    int currentPosition = 1;
    while (currentPosition < x)
    {
        curr = curr.next;
        currentPosition++;
    }
    
    while (last.next != null)
        last = last.next;
    last.next = curr;
}
public static Boolean IsCyclePresent1(Node head){
    Node fast=head;
    Node slow=head;
    while(fast!=null && fast.next!=null){
        fast=fast.next.next;
        slow=slow.next;
        if(fast==slow) return true;
    }
    return false;
}
   public static Node IsCyclePresent(Node head){
    Node slow=head;
    Node fast=head;
    while(fast!=null && fast.next!=null){
        fast=fast.next.next;
        slow=slow.next;
        if(fast==slow){
            fast=head;
            while(fast!=slow){
                fast=fast.next;
                slow=slow.next;
            }
        
        }
        return fast;

    }
    return null;
   } 
   public static Node reverse(Node head){
    if(head==null || head.next==null) return head;
    Node prev=null;
    Node curr=head;
    while(curr!=null){
        Node next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
    }
    return prev;
   }
   public static Node middleofLinkedList(Node head){
    Node slow=head;
    Node fast=head;
    while(fast!=null && fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
    }
    return slow;
   }
    public static Node intersectionP(Node l1, Node l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        Node dummy =new Node(-1);
        Node temp=dummy;
       while(l1!=null && l2!=null){
        if(l1.data<=l2.data){
            temp.next=l1;
            l1=l1.next;
        }else{
            temp.next=l2;
            l2=l2.next;
        }
        temp=temp.next;
       }
      if(l1!=null) temp.next=l1;
      else temp.next=l2;

        return dummy.next;
    }
    public static void deleteNode(LinkedList ll,int remove){
       
       if(ll.head==null) return;
       if(remove==0){
        ll.head=ll.head.next;
        return;
       }
       int idx=0;
       Node temp=ll.head;
       while(idx+1!=remove){
        idx++;
        temp=temp.next;
       }
       temp.next=temp.next.next;
    }
    
}
 class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
class LinkedList{
    Node head;
    void addNode(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }else{
           Node temp=head;
           while(temp.next!=null){
            temp=temp.next;
           }
           temp.next=newNode;
        }

    }
    void printLinkedList(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

}