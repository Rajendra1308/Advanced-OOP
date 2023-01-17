package StackAndQueue;

import java.util.*;
import java.io.*;
/**
 * This class is a container that holds an unlimited number of
 * String objects. It is able to remove objects and add objects.
 */

public class Container {


    /**
     * Reads the given file and add it into a list.
     * Each element of the list contains one line of the file.
     * @param fileName is the name of the file that is read in this method.
     */

    public static final List<String> readFile(String fileName) {
        // add your code here. You may change the return value.
        ArrayList list=new ArrayList<String>(10);
        File myFile= new File(fileName);
        try {
            Scanner scanner= new Scanner(myFile);
            while (scanner.hasNextLine()){
                list.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;

    }

    /**
     * This method adds the <code> obj </code> to the container.
     * @param obj is the object that is added to the container.
     */

    void add(Object obj) {
    }

    /**
     * This method removes the object from the container
     * @return returns the removed object.
     */
    Object remove() {
        return null;
    }

    /**
     * @return It returns the number of elements in the container.
     */
    int getSize() {
        return 0;
    }

}

/**
 *
 * This class simulates a Queue, which is a data structure that insert and remove data
 * by FIFO (first-in, first-out) rule
 *
 */
class Queue extends Container{
    ArrayList<String> queue;
    /**
     * This is the constructor that initializes the <code> queue </code>
     * with all the strings in the <code> fileName </code> that is labeled
     * by "Queue"
     * @param fileName is the name of the file that is read.
     */
    public Queue(String fileName) {
        queue= new ArrayList<>(Container.readFile(fileName));
        ArrayList<String> queue1= new ArrayList<>(10);
        for (int i = 0; i <queue.size() ; i++) {
            if(queue.get(i).startsWith("Queue")){
                queue1.add(queue.get(i).substring(5).trim());
            }
        }
        queue=queue1;


    }

    /**
     * This method adds the object into the Queue.
     * Please note that the rule of the queue insertion/removal is
     * First in, First out.
     * @param obj is the object that is added to the queue.
     */
    @Override
    public void add(Object obj) {
        queue.add((String) obj);
    }
    /**
     * This method removes an object from the Queue.
     * Please note that the rule of the queue insertion/removal is
     * First in, First out.
     */
    @Override
    public Object remove() {
        return this.queue.remove(0);
    }
    /**
     * @return returns the object which is in front of the queue.
     */
    public Object top() {
        return this.queue.get(0);
    }

    /**
     * Returns the number of items in the queue.
     */
    @Override
    public int getSize(){
        return this.queue.size();
    }
}

/**
 *
 * This class simulates a Stack, which is a data structure that insert and remove data
 * by FILO (first-in, last-out) rule
 *
 */
class Stack extends Container{
    ArrayList<String> stack;

    /**
     * This is the constructor that initializes the <code> stack </code>
     * with all the strings in the <code> fileName </code> that is labeled
     * by "Stack"
     * @param fileName is the name of the file that is read.
     */
    public Stack(String fileName) {
        // insert your code here.
        stack= new ArrayList<>(Container.readFile(fileName));
        ArrayList<String> stack1= new ArrayList<>(10);
        for (int i = 0; i <stack.size() ; i++) {
            if(stack.get(i).startsWith("Stack")){
                stack1.add(stack.get(i).substring(5).trim());
            }
        }
        stack=stack1;
    }
    /**
     * This method removes an object from the stack.
     * Please note that the rule of the stack insertion/removal is
     * First in, Last out.
     */

    @Override
    public void add(Object obj) {
        this.stack.add((String) obj);
    }

    /**
     * This method removes an object from the stack.
     * Please note that the rule of the stack insertion/removal is
     * First in, Last out.
     */

    @Override
    public Object remove() {
        return this.stack.remove(stack.size()-1);
    }
    /**
     * @return returns the object which is on top of the stack.
     */

    public Object top() {
        return this.stack.remove(this.stack.size()-1);
    }
    /**
     * Returns the number of items in the stack.
     */
    @Override
    public int getSize() {
        return this.stack.size();
    }
}
