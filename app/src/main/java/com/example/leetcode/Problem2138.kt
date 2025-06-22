package com.example.leetcode

//2138. Divide a String Into Groups of Size k
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//A string s can be partitioned into groups of size k using the following procedure:
//
//The first group consists of the first k characters of the string, the second group consists of the next k characters of the string, and so on. Each element can be a part of exactly one group.
//For the last group, if the string does not have k characters remaining, a character fill is used to complete the group.
//Note that the partition is done so that after removing the fill character from the last group (if it exists) and concatenating all the groups in order, the resultant string should be s.
//
//Given the string s, the size of each group k and the character fill, return a string array denoting the composition of every group s has been divided into, using the above procedure.

fun main() {
    val s = "abcdefghij"
    val k = 3
    val fill = 'x'
    val result = Solution2138().divideString3(s, k, fill)
    println(
        "input" +
                " s $s k $k fill $fill" +
                "\noutput ${result.map { it }}"
    )
}

class Solution2138 {

    fun divideString1(s: String, k: Int, fill: Char): Array<String?> {
        val ans = arrayOfNulls<String>((s.length + k - 1) / k)

        var i = 0
        var j = 0
        while (i < s.length) {
            ans[j++] = if (i + k > s.length)
                s.substring(i) + fill.toString().repeat(i + k - s.length)
            else
                s.substring(i, i + k)
            i += k
        }

        return ans
    }

    fun divideString2(s: String, k: Int, fill: Char): Array<String> {
        require(k > 0) { "Group size must be positive" }

        return s.chunked(k) { chunk ->
            chunk.padEnd(k, fill)
        }
            .map { it.toString() }
            .toTypedArray()
    }

    fun divideString3(s: String, k: Int, fill: Char): Array<String> =
        (s.indices step k)
            .map { start ->
                s.substring(start, minOf(start + k, s.length)).padEnd(k, fill)
            }
            .toTypedArray()
}