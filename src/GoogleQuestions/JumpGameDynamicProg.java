package GoogleQuestions;

public class JumpGameDynamicProg {
    /*
The basic idea is this: at each step, we keep track of the furthest reachable index.
The nature of the problem (eg. maximal jumps where you can hit a range of targets instead
of singular jumps where you can only hit one target) is that for an index to be reachable,
each of the previous indices have to be reachable.
Hence, it suffices that we iterate over each index, and If we ever encounter an index that is not reachable,
we abort and return false. By the end, we will have iterated to the last index. If the loop finishes, t
hen the last index is reachable.
     */
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        //keep track of reachable index
        int reachable = 0;
        for(int i = 0; i < nums.length; i++) {
            if( i > reachable) {
                return false;
            }
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
    public static void main(String[] args) {
        JumpGameDynamicProg j = new JumpGameDynamicProg();
        int[] nums = {2,3,1,1,4}; //3,2,1,0,4
        System.out.println(j.canJump(nums));
    }
}
