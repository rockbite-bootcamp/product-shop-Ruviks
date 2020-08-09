package com.company.Pool;

import java.util.ArrayList;

public abstract class Pool<T extends Poolable> {

    ArrayList<T> freeObjects = new ArrayList<>();

    ArrayList<T> usedObjects = new ArrayList<>();

    public Pool() {

    }

    protected abstract T newObject();

    public T obtain () {
        if (freeObjects.isEmpty()) {
            T object = newObject();
            freeObjects.add(object);
        }

        T object = freeObjects.remove(0);
        usedObjects.add(object);

        return object;
    }

    public void free (T object) {
        usedObjects.remove(object);
        freeObjects.add(object);

        object.reset();
    }

}