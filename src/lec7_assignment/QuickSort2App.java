package lec7_assignment;

// quickSort2.java
// demonstrates quick sort with median-of-three partitioning
// to run this program: C>java QuickSort2App
////////////////////////////////////////////////////////////////
class ArrayIns
{
private long[] theArray; // ref to array theArray
private int nElems; // number of data items
int numComp=0,numCopies=0;
//--------------------------------------------------------------
public ArrayIns(int max) // constructor
{
theArray = new long[max]; // create the array
nElems = 0; // no items yet
}
//--------------------------------------------------------------
public void insert(long value) // put element into array
{
theArray[nElems] = value; // insert it
nElems++; // increment size
}
//--------------------------------------------------------------
public void display() // displays array contents
{
System.out.print("A=");
for(int j=0; j<nElems; j++) // for each element,
System.out.print(theArray[j] + " "); // display it
System.out.println(" ");
}
//--------------------------------------------------------------
public void quickSort()
{
recQuickSort(0, nElems-1);
}
//--------------------------------------------------------------
public void recQuickSort(int left, int right)
{
int size = right-left+1;
if(size <= 3) {
	numComp++; // manual sort if small
	manualSort(left, right);
}
else // quicksort if large
{
long median = medianOf3(left, right);
int partition = partitionIt(left, right, median);
recQuickSort(left, partition-1);
recQuickSort(partition+1, right);
}
} // end recQuickSort()
//--------------------------------------------------------------
public long medianOf3(int left, int right)
{
int center = (left+right)/2;
// order left & center
if( theArray[left] > theArray[center] ) {
	swap(left, center);
	numComp++;
}
// order left & right
if( theArray[left] > theArray[right] ) {
	swap(left, right);
	numComp++;
}
// order center & right
if( theArray[center] > theArray[right] ) {
	swap(center, right);
	numComp++;
}
swap(center, right-1); // put pivot on right
numComp=numComp+3;
return theArray[right-1]; // return median value
} // end medianOf3()
//--------------------------------------------------------------
public void swap(int dex1, int dex2) // swap two elements
{
long temp = theArray[dex1]; // A into temp
theArray[dex1] = theArray[dex2]; // B into A
theArray[dex2] = temp; // temp into B
numCopies=numCopies+3;
} // end swap(
//--------------------------------------------------------------
public int partitionIt(int left, int right, long pivot)
{
int leftPtr = left; // right of first elem
int rightPtr = right - 1; // left of pivot
while(true)
{
while( theArray[++leftPtr] < pivot ) // find bigger
	numComp++; // (nop)
while( theArray[--rightPtr] > pivot ) // find smaller
	numComp++; // (nop)
if(leftPtr >= rightPtr) { // if pointers cross,
	numComp++;
	break;
}
 // partition done
else { // not crossed, so
	swap(leftPtr, rightPtr); // swap elements
	numComp++;
}
} // end while(true)
swap(leftPtr, right-1); // restore pivot
return leftPtr; // return pivot location
} // end partitionIt()
//--------------------------------------------------------------
public void manualSort(int left, int right)
{
int size = right-left+1;
if(size <= 1) {
	numComp++;
	return; // no sort necessary
}
if(size == 2)
{ // 2-sort left and right
	numComp++;
if( theArray[left] > theArray[right] ) {
	swap(left, right);
	numComp++;
}
return;
}
else // size is 3
{ // 3-sort left, center, & right
	numComp++;
if( theArray[left] > theArray[right-1] ) 
	swap(left, right-1); // left, center
if( theArray[left] > theArray[right] )
	swap(left, right); // left, right
if( theArray[right-1] > theArray[right] ) 
	swap(right-1, right); // center, right
	numComp=numComp+3;
}
} // end manualSort()
//--------------------------------------------------------------
} // end class ArrayIns
////////////////////////////////////////////////////////////////
class QuickSort2App
{
public static void main(String[] args)
{
int maxSize = 16; // array size
ArrayIns arr; // reference to array
arr = new ArrayIns(maxSize); // create the array
/*for(int j=0; j<maxSize; j++) // fill array with
{ // random numbers
long n = (int)(java.lang.Math.random()*99);
arr.insert(n);
}*/
arr.insert(7);
arr.insert(6);
arr.insert(5);
arr.insert(4);
arr.insert(3);
arr.insert(2);
arr.insert(1);
arr.display(); // display items
arr.quickSort(); // quicksort them
arr.display(); // display them again
System.out.println("Number of Copies: "+arr.numCopies);
System.out.println("Number of Comparions: "+arr.numComp);
} // end main()
} // end class QuickSort2App