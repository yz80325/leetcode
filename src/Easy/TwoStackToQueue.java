package Easy;

import java.util.Stack;

public class TwoStackToQueue {

    class StackQueue{
        Stack<Integer>stack1=new Stack<>();
        Stack<Integer>stack2=new Stack<>();
        public void Insert(Integer data){
            stack1.push(data);
        }
        public Integer Queuepush() throws Exception {
            if (stack1.size()==0){
                throw new Exception("queue is empty");
            }
            if (stack2.size()==0){
                while (stack1.size()>0){
                    Integer pop = stack1.pop();
                    stack2.push(pop);
                }
            }
            return stack2.pop();
        }
    }
}
