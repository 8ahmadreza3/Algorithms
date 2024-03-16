#include <stdio.h>
#include <stdlib.h>

typedef struct __Node__{
  int value ;
  struct __Node__* next_x;
  struct __Node__* next_y;
} node;

node *newnode(int value){
  node *output=(node*)malloc(sizeof(node));
  output->value = value ;
  output->next_x = output->next_y = NULL ;
  return output ;
}

node *makeMxN(int n , int m , int defaultvalue ){
  node *headoutput = newnode(defaultvalue);
  node *curri = headoutput , *currj ;
  for(int i=0 ; i<n-1 ; i++ , curri=curri->next_x){
    curri->next_x=newnode(defaultvalue);
    currj=curri;
    for(int j=0 ; j<m-1 ; j++ , currj=currj->next_y){
      currj->next_y=newnode(defaultvalue);
    }
  }
  currj=curri;
  for(int j=0 ; j<m-1 ; j++ , currj=currj->next_y){
    currj->next_y=newnode(defaultvalue);
  }
  return headoutput ;
}

void print(node *head){
  node *currx=head , *curry= head ;
  int i=0 , j ;
  while(currx!=NULL){
    j=0;
    while(curry!=NULL){
      printf("(%d,%d):%d\n" , i , j ,curry->value);
      j++;
      curry=curry->next_y ;
    }
    currx=currx->next_x;
    curry=currx ;
    i++;
    printf("\n");
  }
}

void addxy(node* head , int x , int y , node* newnode){
  node* currx = head ;
  for(int i=0 ; i<x ; i++,currx=currx->next_x);
  if(y==0){
    currx->next_x = newnode ;
    return ;
  }
  node*curry = head ;
  for(int i=0 ; i<x ; i++,curry=currx->next_y);
  curry->next_y = newnode ;
}

int main(){
  node *head = makeMxN(2 , 2 , 0);
  addxy(head , 1 , 1 , newnode(6));
  print(head);
  return 0 ;
}