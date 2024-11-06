package leetcode.slidingwindow

import kotlin.math.max

fun maxProfit(prices: IntArray): Int {
    var toBuy = 0
    var toSell = 1
    var maxProfit = 0

    while (toSell < prices.size) {
        if (prices[toBuy] < prices[toSell]) {
            val profit = prices[toSell] - prices[toBuy]
            maxProfit = max(maxProfit, profit)
        } else {
            toBuy = toSell
        }
        toSell ++
    }

    return maxProfit
}

fun main() {
    println(maxProfit(intArrayOf(7,1,5,3,6,4,0,1,1)))
}