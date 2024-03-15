#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void stringnavigation(int n)
{
  char* ptr = NULL;
  ptr = (char*)calloc(n,sizeof(char));
  printf("Enter your text\n");
  gets(ptr);
  for(int i=0 ; i<n; ++i){
    printf("\n%d: %d", i, *(ptr+i));
  }
  free(ptr);
}

int main()
{
  return 0;
}