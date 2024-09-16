package Arrays;

public class DoubleDimensionTest {
    public static void main(String[] args) {
        DoubleDimension doubleDimension = new DoubleDimension(3, 3);

        doubleDimension.insert(0,0,3);
        doubleDimension.insert(0,1,10);
        doubleDimension.insert(0,2,7);
        doubleDimension.insert(1,0,13);
        doubleDimension.insert(1,2,9);
        doubleDimension.insert(2,1,4);

        doubleDimension.traverse();

        doubleDimension.searchArray(7);

        doubleDimension.deleteValueAtIndex(2, 1);

        doubleDimension.traverse();
    }
}
