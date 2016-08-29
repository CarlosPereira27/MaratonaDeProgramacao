#include <stdio.h>

int t, n;
int readdata() {
  if (scanf("%d%d",&t,&n)==2)
    return t;
  else
    return 0;
}

void process() {
	char temp[10000];
	int points, soma, draws;
	soma = 0;
	for(int i=0; i < t; i++) {
		scanf("%s%d",temp, &points);
		soma += points;
	}
	draws = 3*n - soma;
	printf("%d\n",draws);
}

int main(){
  //freopen("copa.in", "r", stdin);
  //freopen("copa.out", "w", stdout);
	while(readdata()){
		process();
	}
	return 0;
}
