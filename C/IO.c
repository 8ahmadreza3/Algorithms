#include <stdio.h>
#include <stdlib.h>

void file() {
  FILE* fptr;
  fptr = fopen("Text.txt","r"); // modes: r w rb wb a
  if(fptr==NULL){
    printf("Error");
    exit(1);
  }
  /*scanf("%d" , &num);
    fprintf(fptr , "%d" , num );*/
    
    /*fscanf(fptr , "%d" , &num);
    printf("%d" , num);*/
  int myscan ;
  while (myscan!= EOF){
    if(feof(fptr)){
      break;
    }
    int num ;
    myscan=fscanf(fptr , "%d\n" , &num);
    printf("%d " , num);
  }
  fclose(fptr);
}

int main() {
  return 0;
}