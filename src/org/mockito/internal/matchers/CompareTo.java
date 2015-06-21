/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */

package org.mockito.internal.matchers;

import org.mockito.MockitoMatcher;

import java.io.Serializable;


public abstract class CompareTo<T extends Comparable<T>> implements MockitoMatcher<T>, Serializable {
    private final Comparable<T> wanted;

    public CompareTo(Comparable<T> value) {
        this.wanted = value;
    }

    @SuppressWarnings("unchecked")
    public boolean matches(Object actual) {
        if(!(actual instanceof Comparable)) {
            return false;
        }
        
        return matchResult(((Comparable) actual).compareTo(wanted));
    }

    public String toString() {
        return getName() + "(" + wanted + ")";
    }
    
    protected abstract String getName();
    
    protected abstract boolean matchResult(int result);
}
