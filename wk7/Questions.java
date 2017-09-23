import java.util.*;

public class Questions {
  public static void main(String[] args) {
    int[] nums ={1,2,3,4,5,6};
    int[] nums2 ={1,2,3,4,5,6,7};
    int [] nums3= {};
    printEveryOther(nums);
    printEveryOther(nums2);
    printEveryOther(nums3);

    int[] nums4 ={5,7,1, 3,4};
    System.out.println(findMin(nums4));
  }

  public static void printEveryOther(int[] nums){
    recursePrintEveryOther(nums, 0);
    System.out.println();
  }


  private static void recursePrintEveryOther(int[] nums, int position){
    if (position > nums.length-1) {
      return;
    }
    System.out.print(nums[position]+ " ");
    recursePrintEveryOther(nums, position+2);
  }

  public static int findMin(int[] nums){
    int min = recurseFindMin(nums, 0, nums[0]);
    return min;
  }

  private static int recurseFindMin(int[] nums, int position, int currentMin){
    if (position ==nums.length-1){
      return currentMin <= nums[position] ? currentMin :nums[position];
    } else {
      return currentMin <= recurseFindMin(nums, position+1, nums[position+1]) ? 
      currentMin : recurseFindMin(nums, position+1, nums[position+1]);
    }
  }
}

