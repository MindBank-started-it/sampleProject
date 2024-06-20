flowchart TD
    A[Input DAG \n & starting vertex] -->B{Verify DAG}
    B -->|fail| D[Log error message]
    B --> |success|C[Check & provide \n DAG length]
  