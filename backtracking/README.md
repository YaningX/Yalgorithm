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
- [Dice Roll Game](https://github.com/YaningX/Yalgorithm/blob/master/backtracking/src/main/java/DiceRollGame.java)<br>
&ensp; &ensp; Input an integer parameter representing a number of 6-sided dice to roll, and then output all possible combinations of values that could appear on the dice.<br>
<img src="https://github.com/YaningX/Yalgorithm/blob/master/docs/picture/backtracking/decisionTree.png" width="400"/>
- [Key Array to String Array](https://github.com/YaningX/Yalgorithm/blob/master/backtracking/src/main/java/Key2String.java)<br>
&ensp; &ensp; In our cell phone, the keyboard has ten number keys, i.e 0 ~ 9, and each number key is related to some chars. The goal is to turn an input set of number, and then output all possible string set.
- [Permutation](https://github.com/YaningX/Yalgorithm/blob/master/backtracking/src/main/java/Permutation.java)
- [SubSetSum](https://github.com/YaningX/Yalgorithm/blob/master/backtracking/src/main/java/SubSetSum.java)
