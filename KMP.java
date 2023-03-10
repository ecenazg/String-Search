public class KMP {
    
    public static void search(String pattern, String text) {
        int M= pattern.length();
        int N=text.length();

        int i=0; //txt
        int j=0; //pattern
        int[] lps= new int[M]; //patternla aynı lengthde olması lazım

        calculateLPS(pattern, M, lps);

        while((N-i)>=(M-j)){
            if(pattern.charAt(j)==text.charAt(i)){
                i++;
                j++;
                
                if(j==M){
                    System.out.println("pattern found at index" + (i-j));
                    j=lps[j-1];
                }

                //mismatch after first iteration j is matched

                else if( i<N && pattern.charAt(j)!=text.charAt(i)){
                    //not matched if j is not at 0, j goes back i moves forward
                    //because they will match anyway
                    if(j!=0){
                        j=lps[j-1];
                        
                    }
                    else 
                    i++;


                }
            }
        }

    }
    public static void calculateLPS(String pat, int M, int[] lps){
        //create lps[] that will hold the longest
        // prefix suffix values for pattern

        int len=0;
        int i=1;
        lps[0]=0;

        while(i<M){
            if(pat.charAt(i)==pat.charAt(len)){
                len++;
                lps[i]=len;
                i++;

            }
            else{
                if(len!=0){
                    len=lps[len-1];

                }
                else{
                    lps[i]=len;
                    i++;
                }
            }
        }
    }
    public static void main(String[] args) {
        String text ="ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        search(pattern, text);
    }
}