/*******************************************************************************
 *  Copyright (c) 2012 Google, Inc.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Google, Inc. - initial API and implementation
 *******************************************************************************/
package com.windowtester.internal.runtime.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A basic implementation of a filtering iterator.
 * 
 * Adapted from: http://www.erik-rasmussen.com/blog/2008/01/18/the-filter-pattern-java-conditional-abstraction-with-iterables/
 */
public abstract class Filter<T> {
	
	public abstract boolean passes(T object);

	public Iterator<T> filter(Iterator<T> iterator) {
		return new FilterIterator(iterator);
	}

	public Iterable<T> filter(T[] iterable) {
		return filter(Arrays.asList(iterable));
	}
	
	public Iterable<T> filter(final Iterable<T> iterable) {
		return new Iterable<T>() {
			public Iterator<T> iterator() {
				return filter(iterable.iterator());
			}
		};
	}

	private class FilterIterator implements Iterator<T> {
		private Iterator<T> iterator;
		private T next;

		private FilterIterator(Iterator<T> iterator) {
			this.iterator = iterator;
			toNext();
		}

		public boolean hasNext() {
			return next != null;
		}

		public T next() {
			if (next == null)
				throw new NoSuchElementException();
			T returnValue = next;
			toNext();
			return returnValue;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		private void toNext() {
			next = null;
			while (iterator.hasNext()) {
				T item = iterator.next();
				if (item != null && passes(item)) {
					next = item;
					break;
				}
			}
		}
	}
}
