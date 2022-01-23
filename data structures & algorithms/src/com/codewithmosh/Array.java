package com.codewithmosh;

public class Array {
	private int[] items;
	private int count;
	
	public Array(int length) {
		items = new int[length];
	}
	
	public void print() {
		for (int i = 0; i < count; i++)
			System.out.println("[" + i + "]: " + items[i]);
	}
	
	public void insert(int value) {
		if (count == items.length) {
			int[] newItems = new int[count * 2];
			for (int i = 0; i < count; i++)
				newItems[i] =  items[i];
			items = newItems;
		}
		items[count] = value;
		count++;
	}
	
	public void insertAt(int item, int index) {
		if (index < 0)
			throw new IllegalArgumentException();
		if (index > count) { // if index greater than size, fill with 0s.
			int[] newItems = new int[index + 1];
			for (int i = 0; i < count; i++)
				newItems[i] = items[i];
			for (int j = count; j < index; j++)
				newItems[j] = 0;
			newItems[index] = item;
			count = index + 1;
			items = newItems;
		} else {
			int[] newItems = new int[count + 1];
			for (int i = 0; i < index; i++)
				newItems[i] = items[i];
			newItems[index] = item;
			for (int j = index + 1; j < count + 1; j++)
				newItems[j] = items[j - 1];
			count = count + 1;
			items = newItems;
		}
	}
	
	public void removeAt(int index) {
		if (index < 0 || index >= count)
			throw new IllegalArgumentException();
		for (int i = index; i < count; i++)
			items[i] = items[i + 1];
		count--;
	}

	public int indexOf(int value) {
		for (int i = 0; i < count; i++)
			if (items[i] == value) 
				return i;
		return -1;
	}

	public int max() { //O(n)
		int max = items[0];
		for (int i = 1; i < count; i++)
			if (items[count] < max)
				max = items[i];
		return max;
	}
	
	public void reverse() { //O(n)
		int[] newItems = new int[count];
		for (int i = 0; i < count; i++)
			newItems[i] = items[count - i -1];
	    items = newItems;
	}
}
