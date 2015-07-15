## Backtracking
============
### Basic Idea
Finding solution(s) by trying partial solutions and then abandoning them if they are not suitable.
- a "brute force" algorithmic technique (tries all paths)
- often implemented recursively

#### A general pseudo-code algorithm for backtracking problems:
```
Explore(choices):
– if there are no more choices to make: stop.
– else:
    - Make a single choice C.
    - Explore the remaining choices.
    - Un-make choice C, if necessary. (backtrack!)
```
#### Application:
- [DiceRollGame](./src/main/java/DiceRollGame.java)