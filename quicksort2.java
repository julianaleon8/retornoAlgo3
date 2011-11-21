/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author susana
 */
class quicksort2 {

 //@ requires a.length>=0;
 //@ ensures (\forall int i; 0<=i && i<a.length-1; a[i]<=a[i+1]);

 public static String[] quicksortt2 (String[] a,int p, int r) {
//@ decreases p;
	if (p<r-1)
	{
		int q=partition(a,p,r);
		quicksortt2(a,p,q);
		quicksortt2(a,q+1,r);
	}

return a;
}

public static int partition(String [] a,int p, int r) {

//@ loop_invariant izq-1<=i && i<=j && 0<=j && j<=izq+der && (\forall int h; pivote<=h && h<i;(\forall int f; pivote<=f && f<j;A[j]>pivote && A[i]<=pivote));
	//@ decreases r-1-j;

String x=a[r-1];
int i=p-1;
	for (int j = p;j<r-1;j++) {
		if (a[j].compareTo(x)<=0) {
			i=i+1;
			String temp=a[i];
			a[i]=a[j];
			a[j]=temp;
		}
	}
	String temp=a[i+1];
	a[i+1]=a[r-1];
	a[r-1]=temp;
return i+1;
}




}

