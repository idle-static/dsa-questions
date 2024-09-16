package Arrays;

/**
 * Implement a Double Dimension Array Class with
 * the following methods
 * ------------
 * 1. Insert
 * 2. Traverse
 * 3. Search for an element based on index
 * 4. Delete and element from a specific index
 * ------------
 * Write a driver program to test each method
 */

public class DoubleDimension {
   private final int[][] arr;
   private final int rows;
   private final int columns;

   public DoubleDimension(int rows, int columns){
      this.rows = rows;
      this.columns = columns;
      arr = new int[rows][columns];
   }

   public void insert(int row, int column, int value){
      try {
         if (row >= 0 && row < rows && column >= 0 && column < columns){
            arr[row][column] = value;
            System.out.println("Successfully Inserted");
         } else {
            System.out.println("This cell is already occupied");
         }

      } catch (ArrayIndexOutOfBoundsException e){
         System.out.println("Invalid index to access array");
      }
   }

   public void traverse(){
      try {
         for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
               System.out.println(arr[i][j] + " ");
            }
         }
      } catch (Exception e) {
         System.out.println("Array no longer exists.");
      }
   }

   public void searchArray (int valueToSearch){
      for (int i = 0; i < rows; i++){
         for (int j = 0; j < columns; j++){
            if (arr[i][j] == valueToSearch){
               System.out.println("Value is found at the index of " + i + ", " + j);
               return;
            }
         }
         System.out.println(valueToSearch + " is not found.");
      }
   }

   public void deleteValueAtIndex (int row, int column){
      try {
         if (row >= 0 && row < rows && column >= 0 && column < columns) {
            arr[row][column] = 0;
            System.out.println("Successfully Deleted");
         }
      } catch (ArrayIndexOutOfBoundsException e) {
         System.out.println("Invalid index to delete");
      }
   }
}
