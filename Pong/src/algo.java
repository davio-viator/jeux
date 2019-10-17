public class algo {
    public static void main(String []args){
        int[] t = {1,2,3,4,6,7,8,9};
        System.out.println(croissant(t,0));
        System.out.println(PGCDAux(52,8,1));
    }


    static boolean croissant(int []t,int i){
        //resultat retourner si oui ou non t est croissant
       if(i == t.length-1 ) return true;
       if(t[i] <= t[i+1])return croissant(t,i+1);
       return false;
    }

    static int PGCDAux(int a,int b,int s){
        if(a/b==1) return a;
        if(a%s==0 && b%s==0 && b<a) s = PGCDAux(a,b,s++);
        return s;
    }
}
