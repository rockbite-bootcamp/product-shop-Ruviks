package com.company.Commands;

import com.company.Pool.Poolable;

public interface Command extends Poolable {
    void execute() throws Exception;

    void undo() throws Exception;
}
