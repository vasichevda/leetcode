package com.example.leetcode

//2311. Longest Binary Subsequence Less Than or Equal to K
//You are given a binary string s and a positive integer k.
//
//Return the length of the longest subsequence of s that makes up a binary number less than or equal to k.
//
//Note:
//
//The subsequence can contain leading zeroes.
//The empty string is considered to be equal to 0.
//A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.

fun main() {
    val s = "1001010"
    val k = 5
    val result = Problem2311().longestSubsequence(s, k)
    println(
        "input " +
                "s $s k $k" +
                "\noutput $result"
    )
}

class Problem2311 {
    fun longestSubsequence(s: String, k: Int): Int {
        var oneCount = 0
        var num = 0
        var pow = 1
        var i = s.length - 1
        while (i >= 0 && num + pow <= k) {
            if (s[i] == '1') {
                ++oneCount
                num += pow
            }
            pow *= 2
            --i
        }
        return s.chars().filter { c: Int -> c == '0'.code }.count().toInt() + oneCount
    }
}
