package com.isa.section2.chapter4;

import com.sedgewick.stdlib.In;
import com.sedgewick.stdlib.StdOut;

public class Multiway {
	public static void merge(In[] streams) {
		int N = streams.length;
		IndexMinPQ<String> pq = new IndexMinPQ<String>(N);
		for (int i = 0; i < N; i++)
			if (!streams[i].isEmpty())
				pq.insert(i, streams[i].readString());
		while (!pq.isEmpty()) {
			StdOut.println(pq.minKey());
			int i = pq.delMin();
			if (!streams[i].isEmpty())
				pq.insert(i, streams[i].readString());
		}
	}

	public static void main(String[] args) {
		int N = args.length;
		In[] streams = new In[N];
		for (int i = 0; i < N; i++)
			streams[i] = new In(Thread.currentThread().getContextClassLoader().getResource(args[i]).toString());
		merge(streams);
	}
}