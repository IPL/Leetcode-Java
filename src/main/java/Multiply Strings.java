public class Solution {
    public String multiply(String num1, String num2) {
        String result ="";
        int[] res = new int[num1.length()+num2.length()];
        for(int i=0;i<res.length;i++)
            res[i]=0;
        for(int i=num2.length()-1;i>=0;i--){
            int k=num1.length()+i;
            int pre = 0;
            for(int j=num1.length()-1;j>=0;j--){
                res[k]=pre+(num1.charAt(j)-'0')
                            *(num2.charAt(i)-'0')
                       +res[k];
                pre=res[k]/10;
                res[k]=res[k]%10;
                k--;
            }
            while(pre!=0){
                res[k]=pre+res[k];
                pre=res[k]/10;
                res[k]=res[k]%10;
                k--;
            }
        }
        int start=0;
        while(start<res.length && res[start]==0){
            start++;
        }
        for(int i=start;i<res.length;i++){
            result=result+res[i];
        }
        if(result=="")
            return "0";
        return result;
    }
}