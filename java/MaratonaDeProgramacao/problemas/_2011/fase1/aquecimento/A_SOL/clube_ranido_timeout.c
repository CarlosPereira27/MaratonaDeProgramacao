// clube.c
// r. anido

#include <stdio.h>
#include <strings.h>

#define MAX_PLANKS 100000
#define min(x,y) (x<y?x:y)
#define max(x,y) (x>y?x:y)
 
int n,m;
int planks[MAX_PLANKS];
int used[MAX_PLANKS];
int nplanks,width;

int check(int x, int y)
{
  int x_needed,x_formed;

  x_needed=x*100/width;
  x_formed=0;
  bzero(used,n*sizeof(int));
  while (1)
    ; // waste time
  if (x_formed==x_needed) return 1;
  return 0;
}

int main (void)
{
  int i,x,y;
  
  while (scanf("%d%d",&n,&m)==2) {
    scanf("%d",&width);
    scanf("%d",&nplanks);
    for (i=0;i<nplanks;i++) {
      scanf("%d",&x);
      planks[i]=x;
    }
    x=check(n,m);
    y=check(m,n);
    if (x+y>0) {
      if (x==0) printf("%d\n",y);
      else if (y==0) printf("%d\n",x);
      else printf("%d\n",min(x,y));
    }
    else printf("impossivel\n");
  }
  return(0);
}
