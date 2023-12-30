public class main {

    public static void main(String[] args) {
        CustomArrayList customArrayList = new CustomArrayList(4);
        System.out.println("Array is empty: " + customArrayList.isEmpty());
        customArrayList.add(4);
        customArrayList.add(9);
        customArrayList.add(22);
        customArrayList.add(10);
        customArrayList.show();
        System.out.println("Array is empty: " + customArrayList.isEmpty());
        customArrayList.add(2, 2);
        customArrayList.show();
        customArrayList.remove(2);
        customArrayList.show();
        System.out.println(22 + " exists in the Array: " + customArrayList.isIn(22));
        System.out.println("Index of " + 22 + ": " + customArrayList.find(22));
        System.out.println(73 + " exists in the Array: " + customArrayList.isIn(73));
        System.out.println("Index of " + 73 + ": " + customArrayList.find(73));
    }
}