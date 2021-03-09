# FracCalc
FracCalc Project v1.2.0

## Introduction
The objective of this assignment is to create a calculator to compute arithmetic
operations between integers and/or fractions and output the result as a reduced mixed
fraction.

## Specifications
### Input
* Input will be in the form of a value, followed by an arithmetic operator, and then
another value. Values and operators will be separated by a single space. Values will
contain no spaces.

* Input values may be in the form of mixed fractions, proper fractions, improper
fractions or integers. The integer and fraction parts of a mixed fraction will be
separated by an underscore (_) (e.g., `"1_3/4"` is one and three fourths to
distinguish it from `"13/4"` which is thirteen fourths).

* The calculator will support the 4 basic arithmetic operations: add (+), subtract
(-), multiply (*), and divide (/).

* The program should accept an equation, calculate the result in the proper form,
print it to screen, and then be ready to accept another equation. The user should be
able to exit the program by entering the command `"quit"` instead of an equation.

### Output
* The output value must always be reduced and never improper (it may be an integer,
fraction, or mixed fraction, as appropriate). Example: a result of `"10/4"` should be
printed to the screen as `"2_1/2"`).

### Examples
| Input             | Output    | Notes                                         |
|-------------------|-----------|-----------------------------------------------|
| `1/4 + 1_1/2`     | `1_3/4`   |                                               |
| `8/4 + 2`         | `4`       | Input may be an improper fraction.            |
| `-1 * -1/2`       | `1/2`     |                                               |
| `-11/17 + -1/17`  | `-12/17`  |                                               |
| `0 * 25_462/543`  | `0`       | Remember to check for border/special cases.   |

### Code Organization
You must organize your code in the following way to receive credit for your project.
**If you deviate from this, your unit tests will fail, and significant points will be
deducted from your grade.**

1. You must complete the implementation for the following method, inside your
`FracCalc.java` file: `public static String produceAnswer(String input)`.
This method receives a single line of user input as its parameter (for example,
`"3_1/2 + 1/4"`), and returns the answer (for example, `"3_3/4"`). **This method does
not print anything!**

2. Your `main()` method must use a `Scanner` to receive input from the user, call
`produceAnswer()` with that input, and then print the answer that was returned by
`produceAnswer()`. Your main method eventually is responsible for repeatedly reading
input from the user, calling `produceAnswer()`, printing the result, and ending once
the user types "quit", although in the first checkpoint only one line of input needs
to be read, with a single response printed to the console.

3. **Your code must pass the unit tests for the checkpoint you’re submitting.** If
all the tests fail, it may be a sign that your code is organized incorrectly.

## Importing your Assignment into Eclipse
You can refer to the [intro-to-git page](https://github.com/WilcoxAPCS/intro-to-git/blob/master/README.md#importing-your-assignment-into-eclipse)
on how to import code from GitHub. **You should only need to do this once per
computer.** **Make sure that you add your username to the end of the workspace when
starting Eclipse. If Eclipse is already running, close it and restart it first.**

## Uploading Changes to GitHub
You can refer to the
[intro-to-git page](https://github.com/WilcoxAPCS/intro-to-git/blob/master/README.md#uploading-your-changes-to-github)
on how to upload changes to GitHub.

## Testing Code
### Running FracCalc
In Eclipse, open `FracCalc.java` and click the Run button (green button with white
arrow).

### Running Unit Tests
In Eclipse, open the appropriate test file (`FracCalcTestCheckpoint1.java`
for checkpoint 1, etc.) and click the Run button (green button with white arrow).
This will run set of tests called unit tests to check that your code works. Any
errors will be printed in red in the console. **Your code must pass all unit tests
for the checkpoint in order receive full credit.** Note that these unit tests only
cover a small set of possible inputs and **you should not assume that your code works
just because they pass.** **It is your responsibility to determine if your code will
work in all cases.**

## Checkpoints
There will be 3 checkpoints in addition to the final submission to ensure that you
are on track. They are required and are worth a substantial part of your grade. **You
must submit each checkpoint on time to receive full credit.**

### Checkpoint 1: Parsing one line of input
* Your `main()` method creates a Scanner, reads one line of input, and passes that
input to `produceAnswer()`.
* `produceAnswer()` breaks up that line of input into three `Strings`:
the first operand (fraction), the operator (+ - * /), and the second operand
(fraction). Each of these `Strings` should be stored in variables inside
`produceAnswer()`.
* `produceAnswer()` returns the second operand. For example,
`produceAnswer("1_2/3 + 4_5/6")` returns `"4_5/6"`.
* `main()` prints the result returned by produceAnswer().
* Your code passes all tests in `FracCalcTestCheckpoint1.java`.

### Checkpoint 2: Multiple lines of input, parsing fractions
* Your `main()` method now accepts input from the user multiple times (until the user
types `"quit"`).

* For each line of input, `main()` calls `produceAnswer()` and prints the returned
result.

* This time, `produceAnswer()` must further parse each operand into 3 `int`
variables, one each for the numerator, denominator, and whole portion (for mixed
fractions or integers). Note that there are cases where not all 3 of these components
are present (see below).

* `produceAnswer()` now must demonstrate you have parsed fractions properly by
returning a string that describes each component of the second operand: the whole
number portion (or 0 if not specified), the numerator (or 0 if not specified), and
the denominator (or 1 if not specified). Examples:
    * `produceAnswer("5_3/4 - 6_5/8")` returns `"whole:6 numerator:5 denominator:8"`
    * `produceAnswer("-3/7 - 20")` returns `"whole:20 numerator:0 denominator:1"`
    * `produceAnswer("-32 - 27/21")` returns `"whole:0 numerator:27 denominator:21"`
    
* Your spelling, casing, and spacing must match these examples exactly, or the tests
will fail and you will not receive full credit.

* `produceAnswer()` must parse both operands even though the returned `String`
describes only the second one.

* Your code passes all tests in `FracCalcTestCheckpoint2.java`.

### Checkpoint 3: Evaluation
* `produceAnswer()` must now evaluate the formula it is given (performing addition,
subtraction, multiplication, and division, based on the operator specified), and
return the actual answer of that calculation (instead of just returning the second
operand).

* The answer need not be reduced, and need not be a mixed fraction. But it must be
correct.

* All kinds of input values the user might enter must be accepted, including simple
fractions, improper fractions, mixed fractions, and integers.

* Your code passes all tests in `FracCalcTestCheckpoint3.java`.

### Final Submission: All requirements complete
* All answers must be reduced.

* Your code passes all tests in `FracCalcTestFinal.java`.

### Extra Credit
**Do not spend time on extra credit until you have everything else working
properly.**

#### Multiple Operations
This extra credit will be awarded for calculators that can take in arbitrarily many
values and operators. This will only be tested with compatible operations such that
all equations are evaluated from left to right, in the order they appear (i.e. you
will not need to worry about order of operations).

| Input                     | Output    |
|---------------------------|-----------|
| `1 + 3 + 3`               | `6`       |
| `3/4 * 4`                 | `3`       |
| `-1/2 * 4 + 3/4`          | `-1_1/4`  |
| `5_3/4 - -6_8/8 - 5_3/4`  | `7`       |

#### Error Handling
This extra credit will be awarded for calculators that do not crash when erroneous
input is provided, but instead print useful error messages. Any error encountered
based on user input should print "ERROR: " to the screen followed by an informative
error message.

| Input     | Output                                    |
|-----------|-------------------------------------------|
| `1/0 + 1` | `ERROR: Cannot divide by zero.`           |
| `1 ++ 2`  | `ERROR: Input is in an invalid format.`   |


