#include <stdio.h>
#include <stdlib.h>

typedef struct __NODE__ {
  int value ;
  struct __NODE__* next ;
}node ;

node* newNode(int value){
  node* output = (node*)malloc(sizeof(node));
  output->value = value ; 
  output->next = NULL ;
  return output ;
}

void addEnd(node* head , node* newNode){
  node* curr ;
  for(curr=head ; curr->next!=NULL ; curr=curr->next);
  curr->next = newNode;
}

void print(node* head){
  int index=0 ;
  node* curr = head ;
  while(curr!=NULL){
    printf("%d:%d\n" , index , curr->value);
    index++;
    curr = curr->next ; 
  }
}

void addHead(node** head , node* newNode){
  newNode->next = *head ;
  *head = newNode ;
}

int listlen(node* head){
  int len=0;
  node* curr = head ;
  while(curr != NULL){
    len++;
    curr = curr->next ;
  }
  return len ;
}

void insert(node** head , int index , node* newNode){
  node* curr;
  if(index==0){
    newNode->next = *head ; 
    *head = newNode ;
    return ;
  }
  if(index==listlen(*head)){
    for(curr=*head ; curr->next!=NULL ; curr=curr->next );
      curr->next=newNode;
      return ; 
    }
  int i ;
  for(i=1 , curr=*head ; i<index ; ++i , curr=curr->next);
  newNode->next = curr->next;
  curr->next=newNode ;
  return;
}

void write(node* head , int index , int newValue){
  int i=0 ; 
  node* curr;
  for(curr=head ; i<index ; i++ , curr=curr->next);
  curr->value=newValue ;
  return;
}

int read(node* head  , int index ){
  int i ;
  node* curr ;
  for(i=0,curr=head ; i<index ; i++,curr=curr->next);
  return curr->value ;
}

int removeindex(node** head , int index ){
  if(index>=listlen(*head)){
    return 1 ; 
  }
  node* hold ;
  if(index==0){
    hold = (*head)->next;
    (*head) = (*head)->next;
    free(hold);
    return 0 ;
  }
  int i ;
  node* curr ;
  for(i=0,curr=*head ; i<index-1 ; i++,curr=curr->next);
  hold = curr->next;
  curr->next = curr->next->next ;
  free(hold);
  return 0 ;
}

int removevalue(node** head , int value){
  if((*head)->value == value){
    removeindex(head , 0);
    return 0 ;
  }
  node* curr = *head ;
  for(int i=0 ; i<listlen(*head) ; curr=curr->next , i++){
    if(curr->value == value){
      removeindex(head , i );
      return 0 ;
    }
  }
  return 1 ;
}

void deletelink(node** head){
  int len= listlen(*head)-1 ;
  while(len>=0){
    removeindex(head , len);
    len--;
  }
}

void replace(node* head , int target , int replacevalue){
  node* curr = head ;
  while(curr!=NULL){
    if(curr->value == target){
      curr->value = replacevalue;
      return ;
    }
    curr=curr->next;
  }
}

void replaceall(node* head , int target , int replacevalue){
  node* curr = head ;
  while(curr!=NULL){
    if(curr->value == target){
      curr->value = replacevalue;
    }
    curr=curr->next;
    }
}

int find(node* head , int target){
  int index = 0;
  node* curr = head ;
  while(curr!=NULL){
    if(curr->value == target){
      return index ;
    }
    curr=curr->next;
    index++;
  }
  return -1 ;
}

void sortlist(node* head){
  int i , j , hold ;
  node *curr_i , *curr_j;
  for(i=0,curr_i=head ; i<listlen(head) ; i++,curr_i=curr_i->next){
    for(j=i+1,curr_j=curr_i->next ; j<listlen(head) ; j++,curr_j=curr_j->next){
      if(curr_i->value > curr_j->value){
        hold = curr_i->value ;
        curr_i->value=curr_j->value;
        curr_j->value = hold ;
      }
    }
  }
}

int main(){
  node* head = newNode(23);
  addEnd(head , newNode(53));
  addEnd(head , newNode(13));
  addHead(&head , newNode(5));
  insert(&head , 1 , newNode(65));
  write(head , 4 , 24);
  printf("Your Value: %d\n", read(head , 3));
  removevalue(&head , 3);
  //deletelink(&head);
  replace(head , 5 , 39);
  sortlist(head);
  print(head);
  return 0;
}