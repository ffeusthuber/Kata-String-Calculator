# String Calculator Kata

## Incremental Kata (Coding-Exercise) to practice Test-Driven Development (TDD)

### Step 1

Create a simple String calculator with a method signature:

	int Add(string numbers)
The method can take up to two numbers, separated by commas, and will return their sum.
For example `“”` or `“1”` or `“1,2”` as inputs.
For an empty string it will return 0.
<br />
<br />

### Step 2
Allow the Add method to handle an unknown amount of numbers.
<br />
<br />

### Step 3
Allow the Add method to handle new lines between numbers (instead of commas):
- The following input is ok: `“1\n2,3”` (will equal 6)
- The following input is NOT ok: `“1,\n”` (not need to prove it - just clarifying)
<br />

### Step 4
Support different delimiters:
To change a delimiter, the beginning of the string will contain a separate line that looks like this:<br />
`“//[delimiter]\n[numbers…]”` 
for example `“//;\n1;2”` <br />
should return three where the default delimiter is `‘;’`. <br />
The first line is optional. All existing scenarios should still be supported.
<br />
<br />

### Step 5
Calling Add with a negative number will throw an exception `“negatives not allowed”` - and the negative that was passed.
If there are multiple negatives, show all of them in the exception message.
<br />
<br />

### Step 6
Numbers bigger than 1000 should be ignored, so adding 2 + 1001 = 2
<br />
<br />

### Step 7
Delimiters can be of any length with the following format: `“//[delimiter]\n”` for example: `“//[***]\n1***2***3”` should return 6.
<br />
<br />

### Step 8
Allow multiple delimiters like this: `“//[delim1][delim2]\n”` for example `“//[*][%]\n1*2%3”` should return 6.
<br />
<br />

### Step 9
Make sure you can also handle multiple delimiters with length longer than one char.
<br />
<br />



Link: `https://kata-log.rocks/string-calculator-kata`
