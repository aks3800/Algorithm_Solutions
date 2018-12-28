# Tail Recursive Quick Sort

We can avoid a second recursive call in Quick Sort. This Technique is called Tail Recursive.

```
quickSort(int[] arr, int p, int r) {
    if(p < r) {
        int q = partition(arr, p, r);
        quickSort(arr, p, q - 1);
        p = q + 1;
    }
}
```
