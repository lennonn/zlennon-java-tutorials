package com.zlennon.concurrency.forkjoin;


// Java program to demonstrate the
// Implementation of getActiveThreadCount()

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class NewTask extends RecursiveAction
{
     private long Load = 0;

    public NewTask(long Load) { this.Load = Load; }

    protected void compute()
    {
        // fork tasks into smaller subtasks
        List<NewTask> subtasks = new ArrayList<NewTask>();
        subtasks.addAll(createSubtasks());

        for (RecursiveAction subtask : subtasks) {
            subtask.fork();
        }
    }

    // function to create and add subtasks
    private List<NewTask> createSubtasks()
    {
        // create subtasks
        List<NewTask> subtasks = new ArrayList<NewTask>();
        while (Load>0){
            NewTask subtask1 = new NewTask(this.Load=this.Load / 2);
            subtasks.add(subtask1);
        }


        return subtasks;
    }
}
