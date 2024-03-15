#include <stdlib.h>
#include <stdio.h>

float sum(float a, float b){
  return a+b;
}

float multiply(float a, float b){
  return a*b;
}

float minuses(float a, float b){
  return a-b;
}

float division(float a, float b){
  return a/b;
}

int main(){
  float a , b;
  printf("\nEnter your number\n");
  scanf("%f %f", &a , &b);
  float(*funcs[])(float,float)={sum , multiply , minuses , division};
  printf("\n1.sum\n2.multiply\n3.minuses\n4.division\n");
  int choice;
  scanf("%d", &choice);
  choice--;
  printf("\nResult:%f\n", (*funcs[choice])(a,b));
  return 0;
}