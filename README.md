# SortCards

Assignment 1 for Algorithms class

Specifications:
Input:

Read cards from the console, in the form of #S (# = face value, S = suit)

Example: AS 2H 3C 4D TS

A = Ace, T = Ten, J = Jack, Q = Queen, K = King

S = Spades, H = Hearts, C = Clubs, D = Diamonds

Five cards are dealt at a time.

A line beginning with 00 means stop processing input.

2C KC 3S TD 6H 
7S 3C 3S QC 2S 
4H AH JH 7C 3C 
5D QH TS 4H JD 
KH QS 9S 2C QC 
JH 3H QC 2H 3H 
2H AD KS TC AC 
AS 9D 9C AS 7S 
7C 9D 9H AC 8C 
4D 2H 8C QD 7S 
00

Output:

Sort suits first (like in a new pack of cards)

Spades --> Hearts --> Clubs --> Diamonds

Then values, Ace-low, King-high

Example output for the above input:

3S 6H 2C KC TD
2S 3S 7S 3C QC
AH 4H JH 3C 7C
TS 4H QH 5D JD
9S QS KH 2C QC
2H 3H 3H JH QC
KS 2H AC TC AD
AS AS 7S 9C 9D
9H AC 7C 8C 9D
7S 2H 8C 4D QD

YOU MUST IMPLEMENT INSERTION SORT FOR THIS EXERCISE
