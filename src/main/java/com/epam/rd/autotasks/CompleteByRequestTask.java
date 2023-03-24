package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {
 public boolean k=false;
 public boolean p = false;

    @Override
    public void execute() {
        if (k) {
            p=true;
        }

    }

    @Override
    public boolean isFinished() {
      return p;
    }

    public void complete() {
        k=true;
    }
}
