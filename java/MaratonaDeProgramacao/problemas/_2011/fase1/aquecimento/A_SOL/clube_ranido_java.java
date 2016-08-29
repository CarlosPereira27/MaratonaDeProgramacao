import java.util.Scanner;
import java.io.*;

/*
 * Clube
 * r. anido
 */

class clube_ranido_java {

    static final int MAXLENGTH = 10001;
    static int m,n,x,y;
    static int[] planks = new int[MAXLENGTH];
    static int nplanks,width;

    static int check(int x, int y) {
	int x_needed,x_formed;
	int p,i,k,tmp;

	x_needed=x*100/width;
	x_formed=0;
	if (x_needed*width/100==x) {
	    // check if we have enough planks
	    tmp=Math.min(x_needed-x_formed,planks[y]);
	    x_formed=p=tmp;
	    i=1;
	    k=y-1;
	    while (x_formed<x_needed && k>i) {
		tmp=Math.min(x_needed-x_formed,Math.min(planks[k],planks[i]));
		p+=2*tmp;
		x_formed+=tmp;
		i++;
		k--;
	    }
	    if (x_formed<x_needed && k==i && 2*k==y) {
		tmp=Math.min(x_needed-x_formed,planks[k]/2);
		p+=2*tmp;
		x_formed+=tmp;
	    }
	    if (x_formed>=x_needed)
		return p;
	}
	return 0;
    }

    public static void main(String[] arg) {
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	Scanner s = new Scanner(bufferedReader);
	
	while(s.hasNext()) {
	    n = s.nextInt();
	    m = s.nextInt();
	    if(n==0 && m==0)
		break;
	    width = s.nextInt();
	    nplanks = s.nextInt();
	    for (int i=0;i<MAXLENGTH;i++) planks[i]=0;
	    for(int i=0; i<nplanks; i++) {
		x = s.nextInt();
		planks[x]++;
	    }
	    x=check(n,m);
	    y=check(m,n);
	    if (x+y>0) {
		if (x==0) System.out.println(y);
		else if (y==0) System.out.println(x);
		else System.out.println(Math.min(x,y));
	    }
	    else System.out.println("impossivel");
	}

    }
}
