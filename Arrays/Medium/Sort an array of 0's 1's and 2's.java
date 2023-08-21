class Solution {
    public void sortColors(int[] arr) {
    //      int zeros = 0;
    //    int ones = 0;
    //    int twos = 0;
    // int n = arr.length;
    //    for(int i = 0; i<n; i++)
    //    {
    //        if(arr[i] == 0)
    //        zeros++;

    //        if(arr[i] == 1)
    //        ones++;

    //        if(arr[i] == 2)
    //        twos++;
    //    }

    //    for(int i = 0; i<zeros; i++)
    //    {
    //        arr[i] =  0;
    //    }
    //    for(int i = zeros; i< zeros + ones; i++)
    //     {
    //         arr[i] = 1;
    //     }

    //     for(int i = ones +  zeros; i<n; i++)
    //     {
    //         arr[i] = 2;
    //     }

    //Dutch flag algo
    //0 to low - 1 portion contains all 0
    //low to mid - 1 portion contains all 1
    //high + 1 to n-1 portion contains all 2
    //mid to high  portion contains all unsorted random numbers
    int low = 0;
    int mid = 0;
    int high = arr.length -1;

    while(mid <= high)
    {
        if(arr[mid] == 0)
        {
            swap(arr, mid, low);
            mid++;
            low++;
        }

       else if(arr[mid] == 1)
        {
            mid++;
        }

        else
        {
            swap(arr, mid, high);
            high--;
        }
    }

    }

    private static void swap(int arr[], int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

  }
