/*
Maratona SBC2006
Copa do Mundo
r. anido
*/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define CHECKINPUT
#define MAX_NAME 11
#define MAX_TEAMS 200
#define MAX_MATCHES 10000

int points, matches, teams;

void error(char *msg)
{
  fprintf(stderr, "\nERROR: %s\n", msg);
  exit(1);
}

int main(void)
{
  int i, p;
  char name[MAX_NAME];

  while (scanf("%d%d", &teams, &matches)==2) {
#if CHECK_INPUT
    printf("%d %d\n", team, matches);
    if (teams<2 || teams>MAX_TEAMS || matches<1 || matches > MAX_MATCHES)
		error("error in teams");
#endif
    points = 0;
    for (i=0; i<teams; i++) {
      scanf("%s %d", (char*) &name, &p);
      points += p;
    }
    printf("%d\n", matches*3 - points);
  }
  return(0);
}
