package Workshop.SmartArray;

import Workshop.SmartArray.SmartArray;

public class Test {
    public static void main(String[] args) {

        SmartArray smartArray = new SmartArray();

        smartArray.add(9);
        smartArray.add(8);
        smartArray.add(7);
        smartArray.add(6);
        smartArray.add(5);

        System.out.println(smartArray.get(3));
        System.out.println(smartArray.get(1));

        System.out.println(smartArray.remove(0));
        System.out.println(smartArray.remove(0));

        smartArray.add(1);
        smartArray.add(2);
        smartArray.add(3);
        smartArray.add(4);
        smartArray.add(5);

        smartArray.add(0, 8);
        smartArray.add(0, 9);

        System.out.println(smartArray.contains(17));
        System.out.println(smartArray.contains(5));

        smartArray.forEach(System.out::println);

        }
}
