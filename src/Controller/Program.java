package Controller;
import Common.Validation;
import Model.Element;
import Common.Algorithm;
import View.Menu;

public class Program extends Menu<String> {
  static String[] mainChoice = {"Sorting","Searching","Exit"};
    protected Validation V;
    protected Algorithm a;
    protected int [] array;
    protected int size;

    public Program(Element e) {
        super("Sorting and Searching Program",mainChoice);
        v = new Validation();
        a = new Algorithm();
        size = e.getSize();
        array = e.getArray();
    }
    
    //---------------------------------------
    public void execute(int n){
        switch(n){
            case 1:{
                sort();
                break;
            }
            case 2:{
                search();
                break;
            }
            case 3:
                System.exit(0);
        }
    }
    
    //----------------------------------------
    public void sort(){
        final String[] sortChoice = {"Bubble sort","Quick sort","Exit"};
        class sortMenu extends Menu<String>{
            public sortMenu(){
                super("Sort option",sortChoice);
            }
            
            @Override
            public void execute(int n){
                v.display("Unsorted array: ", array);
                switch(n){
                    case 1:{
                        a.bubbleSort(array);
                        v.display("Sortted array: ", array);
                        System.out.println("");
                        break;
                    }
                    case 2:{
                        a.quickSort(array, 0, size-1);
                        v.display("Sortted array: ", array);
                        System.out.println("");
                        break;
                    }
                    case 3:{
                        System.exit(0);
                        break;
                    }
                }
            }
        }
        sortMenu sm = new sortMenu();
        sm.run();
    }
    //----------------------------------------
    public void search(){
        final String [] searchChoice = {"Linear search","Binary search","Exit"};
        class searchMenu extends Menu<String>{
            public searchMenu(){
                super("Search option",searchChoice);
            }

            @Override 
            public void execute (int n){
                v.display("Array: ", array);
                int search = v.getInt("Enter value want to search: ");

                switch(n){
                    case 1:{
                        int p = a.linearSearch(array, search);
                        System.out.println("Find " + search + " at index: " + p);
                        break;
                    }
                    case 2:{
                        a.bubbleSort(array);
                        v.display("Sortted array: ", array);
                        int p = a.binarySearch(array, search, 0, size -1);
                        System.out.println("Find " + search + " at index: " + p);
                        break;
                    }
                    case 3:{
                        
                    }
                }
            }
        }
        searchMenu sm = new searchMenu();
        sm.run();
    }
  
}
