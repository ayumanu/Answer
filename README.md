Approach to Solving the Problem
The task involves processing a list of words to identify "compound words." A compound word is defined as a word that can be formed by concatenating other smaller words from the same list. The problem also asks to identify the longest and second-longest compound words and to track the time taken to process the file. Below is the step-by-step approach:

Step 1: Read the Input Files
We start by reading the file Input_01.txt (or Input_02.txt). The input files contain a list of words, one per line, in alphabetical order. We need to read these words into a list and also store them in a Set (for fast lookups) because checking whether a substring exists in a list is key to solving the problem.
Step 2: Define Compound Words
A compound word is a word that can be formed by concatenating two or more smaller words from the same list. For instance:
"catsdogcats" is a compound word because it can be split into "cats", "dog", and "cats".
A non-compound word like "hippopotamuses" cannot be split into smaller valid words from the list.
To check if a word is a compound word, we need to:

Split the word into two parts at various positions (i.e., from the start to some index i, and from i to the end).
Check if both parts exist in the word list.
Step 3: Iterate Through the Words
For each word in the list:
Try splitting the word into two parts at all possible positions (from 1 to length of the word - 1).
For each split, check if both parts are valid words (i.e., exist in the Set).
If the word can be split into smaller words, it is considered a compound word.
Step 4: Track Longest Compound Words
As we identify compound words, we keep track of the longest and second-longest compound words encountered.
We store these words in variables longest and secondLongest. If a new word is longer than the current longest word, we update both longest and secondLongest accordingly.
Step 5: Measure Time
To measure the time taken to process the file:
Capture the current time before starting the word checks using System.currentTimeMillis().
After processing all words, capture the time again and calculate the difference. This gives the time taken in milliseconds to process the file.
Step 6: Output the Results
After processing the entire word list, output the longest compound word, the second-longest compound word, and the time taken to process the file.