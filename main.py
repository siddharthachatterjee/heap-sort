from math import floor

def left_child(i):
  return 2 * i + 1

def right_child(i):
  return 2 * i + 2
  
def parent(i):
  return floor((i - 1) / 2)
  
def sift_down(arr, i, boundary):
  l = left_child(i)
  r = right_child(i)
  max_i = i
  if l <= boundary and arr[l] > arr[max_i]:
    max_i = l
  if r <= boundary and arr[r] > arr[max_i]:
    max_i = r
  if max_i != i:
    temp = arr[max_i]
    arr[max_i] = arr[i]
    arr[i] = temp
    sift_down(arr, max_i, boundary)

n = int(input())
arr = list(map(int, input().split()))

for i in range(floor((n - 1) / 2), -1, -1):
  sift_down(arr, i, n - 1)

boundary = n - 1
while boundary > 0:
  temp = arr[boundary]
  arr[boundary] = arr[0]
  arr[0] = temp
  boundary -= 1
  sift_down(arr, 0, boundary)
  
print(arr)
