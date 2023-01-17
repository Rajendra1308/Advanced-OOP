package ListAndSet;

public class Container {
    protected final int ORIGINAL_SIZE = 10;
    protected Object[] list; // is a container that stores the element of MyList
    protected Object[] set; // is a container that stores the element of MySet
    protected int size; // this variable holds the actual number of elements that are stored in either of the containers (i.e. MyList or MySet).
    /**
     * This method adds the <code> obj </code> to the end of the container.
     * @param obj is the object that is added to the container.
     */
    void add(Object obj) {
        this.add(obj);
    }

    /**
     * This method removes the <code> obj </code> from the container.
     * It shifts all the elements to make sure that removal of the element
     * does not create a whole in the container.
     * @param obj is the object that is removed from the container.
     * @return It returns the object that was removed.
     */
    Object remove(Object obj) {

        return obj;
    }


    /**
     * This method returns true if the container is empty.
     * @return It returns true if the container is empty, otherwise false.
     */
    boolean isEmpty() {
        // you may want to change the return value
        return this.getSize() == 0;
    }


    /**
     * This method returns the number of elements stored in the container.
     * @return It returns the number of elements in the container.
     */
    int getSize() {
        // you may want to change the return value
        return this.size;
    }


}

/**
 *
 * This class simulates an ArrayList, where you can add unlimited number of
 * elements to the list.
 *
 */
class MyList extends Container {
    /**
     * This is the default constructor that sets all the instance variables to their defualt value.
     */
    public MyList() {

        list = new Object[ORIGINAL_SIZE];
        size = 0;
    }

    /**
     * This method returns the element that is stored at index <code> index </code>.
     *
     * @param index is the<code> index </code> at which the element is accessed and returned.
     * @return it returns the element stored at the given <code> index </code>.
     */
    public Object get(int index) {
        return this.list[index];
    }

    /**
     * This method overrides the <code> add </code> method defined in class <code> container</code>, by
     * adding the <code> obj </code> to the back of <code> list </code> array.
     * The original size of the <code> array </code>, is defined by <code> ORIGINAL_SIZE </code>, however, it is possible that
     * more elements is added to this array. In case the array does not have enough capacity to add one more element, it grows itself
     * by doubling the size of <code> list </code> array.
     */
    @Override
    void add(Object obj) {


        if (this.size >= ORIGINAL_SIZE) {
            int size1 = size * 2;
            list = new Object[size1];
            for (int i = 0; i < this.size; i++) {
                list[i] = this.list[i];

            }
            list[this.size] = obj;
            size++;
        } else {
            list[size] = obj;
            size++;
        }


    }

    /**
     * This method removes the first occurrence of <code> obj </code>
     * from <code> list </code>
     *
     * @pre <code> obj </code> exists in the <code>list</code> array.
     */
    @Override
    Object remove(Object obj) {
        int index = -1;

//        if(list[list.length-1].equals(obj)){
//            list[list.length-1]=null;
//        }


        //if(count!=0) {
//        if (list[list.length - 1] == obj) {
//            list[list.length - 1] = null;
//
//        } else {
//            for (int i = 0; i < list.length; i++) {
//                if (list[i].equals(obj)) {
//                    list[i] = "";
//                    count = i;
//                    break;
//
//                }
//
//            }
//
//            for (int i = count; i < this.size; i++) {
//                list[i] = list[i + 1];
//            }
//            //}
//
//            return obj;
//        }
        for (int i = 0; i <size ; i++) {
            if(this.list[i].equals(obj)){
                index=i;

            }
        }
        if(index==size){
            obj=null;
            size--;
        }
        else{
            for (int i = index; i <size ; i++) {
                list[i]=list[i+1];

            }
            size--;
        }



        /**
         * This method returns the elements of the MyList in a form of
         * [obj1 obj2 obj3 ...]
         */

        return list;
    }

    @Override
    public String toString() {
        String c = "[";
        for (int i = 0; i < size; i++) {

            if (i == size - 1) {
                c = c + list[i];
            } else {
                c = c + list[i] + " ";
            }
        }


        return c + "]";
    }
}// end of MyList


class MySet extends Container {
    public MySet() {
        set = new Object[ORIGINAL_SIZE];
        size = 0;

    }

    /**
     * This method overrrides the <code> add </code> method defined in class <code> container</code>, by
     * adding the <code> obj </code> to the back of <code> set </code> array.
     * The original size of the <code> set </code>, is defined by <code> ORIGINAL_SIZE </code>, however, it is possible that
     * more elements is added to this set. In case the set does not have enough capacity to add one more element, it grows itself
     * by doubling the size of <code> set </code> array.
     */

    @Override
    void add(Object obj) {
        boolean On = true;
        for (int i = 0; i < size; i++) {
            if (set[i] == obj) {
                On = false;
            }
        }
        if (On) {
            if (this.size >= ORIGINAL_SIZE) {
                int size1 = size * 2;
                set = new Object[size1];
                for (int i = 0; i < this.size; i++) {
                    set[i] = this.set[i];

                }
                set[this.size] = obj;
                size++;
            } else {
                set[size] = obj;
                size++;
            }
        }
    }

    /**
     * This method removes the first occurrence of <code> obj </code>
     * from <code> set </code>
     *
     * @pre <code> obj </code> exists in the <code>set</code> array.
     */
    @Override
    Object remove(Object obj) {
        int index = -1;

//        if(list[list.length-1].equals(obj)){
//            list[list.length-1]=null;
//        }


        //if(count!=0) {
//        if (list[list.length - 1] == obj) {
//            list[list.length - 1] = null;
//
//        } else {
//            for (int i = 0; i < list.length; i++) {
//                if (list[i].equals(obj)) {
//                    list[i] = "";
//                    count = i;
//                    break;
//
//                }
//
//            }
//
//            for (int i = count; i < this.size; i++) {
//                list[i] = list[i + 1];
//            }
//            //}
//
//            return obj;
//        }
        for (int i = 0; i < size; i++) {
            if (this.set[i].equals(obj)) {
                index = i;

            }
        }
        if (index == size) {
            obj = null;
            size--;
        } else {
            for (int i = index; i < size; i++) {
                set[i] = set[i + 1];

            }
            size--;
        }
        return obj;
    }


    /**
     * This method returns the elements of the MySet in a form of
     * [obj1 obj2 obj3 ...]
     */

    @Override
    public String toString() {
        String c = "[";
        for (int i = 0; i < size; i++) {

            if (i == size - 1) {
                c = c + set[i];
            } else {
                c = c + set[i] + " ";
            }
        }


        return c + "]";
    }

}

