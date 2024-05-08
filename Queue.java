import java.util.*;

public class Queue {
    static Scanner readElement = new Scanner(System.in);
    
    static int data;
    static int counter;
    static int size;
    static String answer;
    static Queue queueThird;

    private int front;
    private int rear;
    private int arr[];
    private int maxSizeQueue;

    public Queue(int sizeTOArray){
        this.front = 0;
        this.rear = -1;
        arr = new int[sizeTOArray];
        maxSizeQueue = sizeTOArray;
    }

    public boolean isEmpty(){
        return rear == -1; 
    }

    public boolean isFull(){
        return rear == arr.length-1;
    }
    
    public void insertElement(int dataElement){
        if(isFull()){
            System.out.println("Sorry you can't add element when array be as full!");
            return;
        }else{
            arr[++rear] = dataElement;
        }
    }

    public void removeElement(){
        if(isEmpty()){
            System.out.println("Sorry you can't remove element when array be as empty!");
            return;
        }else{
            System.out.println(arr[front--]);
        }
    }

    public int getFront(){
        return arr[front];
    }

    public int getRear(){
        return arr[rear];
    }

    public int getSize(){
        return maxSizeQueue;
    }

    public void QueuePrint(){
        System.out.print("Element be as: [ ");        
        for(int i = front ; i <= rear ; i++){
            System.out.print( " | " + arr[i] + " ");
        }System.out.print(" ] \n");
    }

    public void QueueMin(){
        int min = QueueSum();
        for(int i = front ; i <= rear ; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        System.out.println("The minimum number: " + (min));
    }

    public void QueueMax(){
        int max = 0;
        for(int i = front ; i <= rear ; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("The maximum number: " + (max));
    }
    
    public int QueueSum(){
        int sum = 0;
        for(int i = front ; i <= rear ; i++){
            sum +=arr[i];
        }
        return sum;
    }

    public void removeElement(int neededElement) {        
        for(int i = front;  i <= rear ; i++ ){
            if(arr[i] == neededElement){
                arr[i] = arr[i+1];
                rear--;
            }
        }        
    }

    // Selection sort
    public void sortingElement(){
        int outerLoop , innerLoop , minimumElement;
        for(outerLoop = 0 ; outerLoop < arr.length ; outerLoop++){
            minimumElement = outerLoop;

            for(innerLoop = outerLoop + 1 ; innerLoop < arr.length ; innerLoop++){
                if(arr[innerLoop] < arr[minimumElement]){
                    minimumElement = innerLoop;
                }
            }swapping(outerLoop , minimumElement);
        }
    }
    
    private void swapping(int firstElement , int lastElement){
        int temporary = arr[firstElement];
        arr[firstElement] = arr[lastElement];
        arr[lastElement] = temporary;
    }
    
    public void Merge(Queue queueOne , Queue queueTwo){        
        for(int i = queueOne.front ; i <= queueOne.rear ; i++){
            insertElement(queueOne.arr[i]);
        }
        for(int j = queueTwo.front ; j <= queueTwo.rear ; j++){
            insertElement(queueTwo.arr[j]);
        }
    }

    
    public static void main(String[] args) {
        System.out.println("\nHello , Welcome in my java application! \n");
        
        showTaskInfo();
        System.out.print("\nNow based on these info do you want to test ability of these task (Yes/No) ? ");
        String result = readElement.next();

        if(result.equalsIgnoreCase("Yes")){
            System.out.print("\nOkay , enter number of task here: ");
            int taskNumber = readElement.nextInt();
                switch(taskNumber){
                    case 1:
                        firstTaskQueue();
                    break;
                    case 2:
                        secondTaskQueue();
                    break;
                    case 3:
                        thirdTaskQueue();
                    break;
                    default:
                    System.out.println("\nSorry , you enter wrong number of task !");
                }
        }else{
            return;
        }
        
        System.out.println("\nAs you want and thank you for visit us!");
    }



    private static void showTaskInfo() {

        System.out.println("I'm have Three type of tasks to be as:");
        
        System.out.println("\nTask #1: related to find minimum and maximum numbers then show the summation of these numbers ");
        System.out.println("Task #2: related to deleted specific number after added list of numbers ");
        System.out.println("Task #3: related to provide sorting to element then do merging to two queue in one sorted queue elements ");
    
    }

    private static void thirdTaskQueue(){
        System.out.print("\nPlease Enter The Size Of First Queue: ");
        int sizeFirstQueue = readElement.nextInt();

        Queue queueFirst = new Queue(sizeFirstQueue);
        
        for(int k = 0 ; k < queueFirst.getSize() ; k++){
            System.out.print("\nEnter data #" + (k+1) + " : ");
            int value = readElement.nextInt(); 
            queueFirst.insertElement(value); 
        }

        queueFirst.sortingElement();
        queueFirst.QueuePrint();

        System.out.print("\nNow Enter The Size Of Second Queue: ");
        int sizeSecondQueue = readElement.nextInt();
        
        Queue queueSecond = new Queue(sizeSecondQueue);
        
        for(int Q = 0 ; Q < queueSecond.getSize() ; Q++){
            System.out.print("\nEnter data #" + (Q+1) + " : ");
            int newValue = readElement.nextInt(); 
            queueSecond.insertElement(newValue); 
        }
        
        queueSecond.sortingElement();
        queueSecond.QueuePrint();

        int thirdQueueSize = queueFirst.getSize() + queueSecond.getSize();
        queueThird = new Queue(thirdQueueSize);
        
        queueThird.Merge(queueFirst,queueSecond);
        queueThird.sortingElement();

        System.out.println("\nThe elements after do merging: ");
        queueThird.QueuePrint();
    }

    private static void secondTaskQueue() {

        System.out.print("\nPlease Enter The Size Of Queue: ");
        int sizeQueue = readElement.nextInt();
        Queue objQueue = new Queue(sizeQueue);
        

        for(int k = 0 ; k < objQueue.getSize() ; k++){
            System.out.print("\nEnter data #" + (k+1) + " : ");
            int value = readElement.nextInt(); 
            objQueue.insertElement(value); 
        }

        objQueue.QueuePrint();

        System.out.print("\nBased on this list of elements , enter needed number to removed: ");
        int neededElement = readElement.nextInt();
        objQueue.removeElement(neededElement);
        
        System.out.print("\nElement after do changes: ");
        objQueue.QueuePrint();
    }

    private static void firstTaskQueue() {
        System.out.print("\nEnter number of data items as you want: ");
        size = readElement.nextInt();
        Queue queueObj = new Queue(size);

        System.out.println("Hint: if you want to added all items write Yes otherwise write No!");
        System.out.print("\nDo you want to add all " + (size) + " (Yes/No)? ");
        answer = readElement.next();

        enterData(queueObj);
        optionShow();
        
        System.out.print("\nAre you want to know your data based on exist options (Yes/No)? ");
        answer = readElement.next();
        optionCase(answer,queueObj);   
    }

    private static void enterData(Queue queueObj) {
        data = ' ';
        counter = 0;

        if(answer.equalsIgnoreCase("No")){
            System.out.println("\nEnter needed item and write -1 if you want to exit!");

            while(data != -1 && counter < size){
                System.out.print("\nEnter data #" + (counter+1) + " : ");
                data = readElement.nextInt();
                
                if(data != -1){
                    queueObj.insertElement(data);
                }
                counter+=1;
            }  
        
        }else{

            System.out.println("\nEnter needed item here");
            
            for(int i = 0 ; i < size ; i++){
                System.out.print("\nEnter data #" + (i+1) + " : ");
                data = readElement.nextInt();
                queueObj.insertElement(data);
            }
        }
    }

    private static void optionCase(String answer , Queue queueObj) {
        
        if(answer.equalsIgnoreCase("Yes")){
            
            System.out.print("\nEnter needed option here: ");
            int option = readElement.nextInt();
            
            switch(option){
                case 1:
                    queueObj.QueueMax();
                break;
                
                case 2:
                    queueObj.QueueMin();
                break;
                
                case 3:
                    System.out.print("\nThe summation of your numbers: " + queueObj.QueueSum());
                break;
                
                case 4:
                    queueObj.QueuePrint();
                break;
                
                default:
                    System.out.println("\nPlease enter a valid option!");
            }
        }else{
            System.out.println("Thank you for visit us , have a nice day!");
        }
    
    }

    private static void optionShow() {
        
        System.out.println("\nFinally , do you want to know the: ");
        System.out.println("1.Maximum number");
        System.out.println("2.Minimum number");
        
        System.out.println("3.Summation to all numbers");
        System.out.println("4.display to all numbers");
        
    }
}
