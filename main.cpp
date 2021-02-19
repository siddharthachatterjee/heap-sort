#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int leftChild(int i) {
  return 2 * i + 1;
}

int rightChild(int i) {
  return 2 * i + 2;
}

int parent(int i) {
  return (int)(i - 1) / 2;
}

void siftDown(vector<int>& arr, int i, int boundary) {
  int l = leftChild(i), r = rightChild(i), max_i = i;
  if (l <= boundary && arr[l] > arr[max_i])
    max_i = l;
  if (r <= boundary && arr[r] > arr[max_i]) 
    max_i = r;
   if (max_i != i) {
    swap(arr[i], arr[max_i]);
    siftDown(arr, max_i, boundary);
   }
}

int main() {
  int n; cin >> n;
  vector<int> arr(n);
  for (int i = 0; i < n; ++i) 
    cin >> arr[i];
  for (int i = (n - 1) / 2; i >= 0; --i) {
    siftDown(arr, i, n - 1);
  }
  int boundary = n - 1;
  while (boundary > 0) {
    swap(arr[0], arr[boundary]);
    boundary--;
    siftDown(arr, 0, boundary);
  }
  for (int val : arr) {
    cout << val << " ";
  }
}
