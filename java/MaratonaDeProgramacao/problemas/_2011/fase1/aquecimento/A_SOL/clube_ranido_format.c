// clube.c
// r. anido

#include <stdio.h>
#include <strings.h>

#define MAX_LENGTH 10001
#define min(x,y) (x<y?x:y)
#define max(x,y) (x>y?x:y)
 
int n,m;
int planks[MAX_LENGTH];
int nplanks,width;

int check(int x, int y)
{
  int x_needed,x_formed;
  int p,i,k,tmp;

  x_needed=x*100/width;
  x_formed=0;
  if (x_needed*width/100==x) {
    // check if we have enough planks
    tmp=min(x_needed-x_formed,planks[y]);
    x_formed=p=tmp;
    i=1;
    k=y-1;
    while (x_formed<x_needed && k>i) {
      tmp=min(x_needed-x_formed,min(planks[k],planks[i]));
      p+=2*tmp;
      x_formed+=tmp;
      i++;
      k--;
    }
    if (x_formed<x_needed && k==i && 2*k==y) {
      tmp=min(x_needed-x_formed,planks[k]/2);
      p+=2*tmp;
      x_formed+=tmp;
    }
    if (x_formed>=x_needed)
      return p;
  }
  return 0;
}

int main (void)
{
  int i,x,y;
  
  while (scanf("%d%d",&n,&m)==2) {
    scanf("%d",&width);
    scanf("%d",&nplanks);
    bzero(planks,MAX_LENGTH*sizeof(int));
    for (i=0;i<nplanks;i++) {
      scanf("%d",&x);
      planks[x]++;
    }
    x=check(n,m);
    y=check(m,n);
    if (x+y>0) {
      if (x==0) printf("%d\n",y);
      else if (y==0) printf("%d\n",x);
      else printf("%d\n",min(x,y));
    }
    else printf("impossível\n");
  }
  return(0);
}
