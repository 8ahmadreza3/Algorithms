#include <stdio.h>
#include <stdlib.h>

void bubble_sort(int array[], int array_size , int (*compare)(int , int )){
  for(int i=0 ; i<array_size ; ++i){
    for(int j=i+1 ; j<array_size ; ++j ){
      if((*compare)(array[i],array[j])){
        int hold=array[i];
        array[i]=array[j];
        array[j]=hold ;
      }
    }
  }
}

int compare_up(int a , int b){
    return a>b ;
}

int compare_down(int a , int b){
    return a<b ;
}

void printarray(int array[], int size){
  printf("\n[%d", array[0]);
  for(int i=1 ; i<size ; ++i){
    printf(",%d", array[i]);
  }
  printf("]\n");
}

int main(){
  int array[]={2,6,8,0,9,5,3,1};
  bubble_sort(array , 8 , compare_down);
  printarray(array , 8);
  bubble_sort(array , 8 , compare_up);
  printarray(array , 8);
  return 0 ;
}