public class Main {
    public static void main(String[] args){
        MyArrayList list = new MyArrayList();
        list.add(new Integer(3));
        list.add(new Integer(5));
        list.add(new Integer(7));
        list.add(new Integer(23));
        list.add(new Integer(1));

        for(int i = 0; i < list.getSize(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        list.add(new Integer(100));
        for(int i = 0; i < list.getSize(); i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        System.out.println("element[5]: " + list.get(5));
        System.out.println("list size: "+ list.getSize());
        System.out.println("remove element with index 2: " + list.remove(2));
        for(int i = 0; i < list.getSize(); i++){
            System.out.print(list.get(i) + " ");
        }
    }
}
