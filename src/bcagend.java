import sun.tools.jconsole.JConsole;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class bcagend {
    //attributes
    Set<String> possible = new HashSet<String>();
    String state = "";
    String actualnum = "";
    public bcagend(){
        int max = 9999;
        boolean unique;
        String nums;
        for(int i =1000;i<=max;i++){
            unique = true;
            nums = Integer.toString(i);
            for(int j=0;j< nums.length()-1;j++){
                for(int k =j+1;k<nums.length();k++){
                    if(nums.charAt(k) == nums.charAt(j)){
                        unique= false;
                    }
                }
            }
            if(unique){
                this.possible.add(nums);
            }
        }
        Iterator<String> val = this.possible.iterator();
        this.actualnum = val.next();
    }
    public String calculate(String guess,int b,int c){

        if(guess.equals("start")){
            this.state = "start";
        }
        if(guess.equals("=")){
            this.state="done";
        }
        if(this.state.equals("start")){
            int[] actualbc = {b,c};
            int[] tembc;
            for (Iterator<String> iterator = this.possible.iterator(); iterator.hasNext();) {
                String temelement = iterator.next();
                tembc = this.getBullsAndCows(temelement,this.actualnum);
                if (tembc[0] != actualbc[0] || tembc[1] != actualbc[1]) {
                    iterator.remove();
                }
                if(this.possible.size() == 1){
                    this.state = "done";
                    this.actualnum=temelement;
                }
                this.actualnum=temelement;
            }
        }else if(this.state.equals("done")){
            return actualnum;
        }else{
            return "no operation";
        }
        System.out.println(this.possible.size());
        return actualnum;
    }
    public int[] getBullsAndCows(String num, String guess){
        //[bulls, cows]
        int[] bc = {0,0};
        for(int i=0;i<num.length();i++){
            int numtocompare = Character.getNumericValue(num.charAt(i));
            for(int j=0;j<num.length();j++){
                int guesstocompare = Character.getNumericValue(guess.charAt(j));
                if(numtocompare == guesstocompare){
                    if(i == j){
                        bc[0]++;
                    }else{
                        bc[1]++;
                    }
                }
            }
        }
        return bc;
    }
}
