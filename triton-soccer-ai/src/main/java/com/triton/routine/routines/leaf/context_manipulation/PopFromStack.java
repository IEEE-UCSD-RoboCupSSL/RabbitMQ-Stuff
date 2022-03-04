package com.triton.routine.routines.leaf.context_manipulation;

import com.triton.routine.base.Context;
import com.triton.routine.base.Routine;
import com.triton.routine.base.Runner;
import com.triton.routine.base.StackId;

public class PopFromStack extends Routine {
    private final StackId fromStack;
    private final StackId toVariable;

    public PopFromStack(StackId fromStack, StackId toVariable) {
        super();
        this.fromStack = fromStack;
        this.toVariable = toVariable;
    }

    @Override
    public void reset() {
    }

    @Override
    public void act(Runner runner, Context context) {
        Object object = context.popFromStack(runner.getAllyId(), fromStack);
        context.setVariable(runner.getAllyId(), toVariable, object);
        succeed();
    }
}
