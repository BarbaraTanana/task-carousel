package com.epam.rd.autotasks;
import java.util.ArrayList;
import java.util.List;

public class TaskCarousel {
    private final int capacity;
    private final List <Task>  tasks;
    private int counter=-1;
    public TaskCarousel( int capacity) {
        this.capacity=capacity;
        tasks = new ArrayList<>(capacity);
    }

    public boolean addTask(Task task) {
      if (task==null || task.isFinished() || tasks.size()>=capacity) {
          return false;
      }  tasks.add(task);
         return  true;
    }

    public boolean execute() {

        if (!isEmpty()) {
                counter++;
                if(counter == tasks.size()) counter = 0;
            Task task = tasks.get(counter);

            // вызывается метод CountDownLatch
            task.execute();

            if(task.isFinished()) {
                tasks.remove(task);
                counter--;
            }
            return true;
        }
        return false;
    }


    public boolean isFull() {
      return tasks.size()>=capacity ;

    }

    public boolean isEmpty() {
       return tasks.isEmpty();
    }

}
