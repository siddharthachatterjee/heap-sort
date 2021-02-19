function leftChild(i) {
  return 2 * i + 1;
}

function rightChild(i) {
  return 2 * i + 2;
}

function parent(i) {
  return Math.floor((i - 1) / 2);
}

function siftDown(arr, i, boundary) {
  let l = leftChild(i);
  let r = rightChild(i);
  let maxI = i;
  if (l <= boundary && arr[l] > arr[maxI])
    maxI = l;
  if (r <= boundary && arr[r] > arr[maxI])
    maxI = r;
  if (maxI !== i) {
    [arr[maxI], arr[i]] = [arr[i], arr[maxI]];
    siftDown(arr, maxI, boundary);
  }
} 

let n = 8;
let arr = [1, 7, 2, 9, 3, 10, 8, 6];

for (let i = Math.floor((n - 1) / 2); i >= 0; --i) {
  siftDown(arr, i, n - 1);
}  
let boundary = n - 1;
while (boundary > 0) {
  [arr[0], arr[boundary]] = [arr[boundary], arr[0]];
  boundary--;
  siftDown(arr, 0, boundary);
} 

console.log(arr);
