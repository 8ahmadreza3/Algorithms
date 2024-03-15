#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct Data {
  int value;
} Data ;

Data create(int value)
{
  Data *first = malloc(sizeof(Data));
  first->value = value;
  return *first;
}

int main()
{
  return 0;
}