package com.kevin.kotlin3

/**
 * other：Kevin
 * create time：2021/6/27
 * describe：枚举
 */
enum class Season {
    SPRING, SUMMER, AUTUMN, WINTER
}

enum class Season2(var temperature: Int) {
    SPRING(10), SUMMER(30), AUTUMN(20), WINTER(-10)
}

// 枚举申明方法
enum class Season3 {
    SPRING {
        override fun getSeason(): Season3 =
            SPRING
    },
    SUMMER {
        override fun getSeason(): Season3 =
            SUMMER
    },
    AUTUMN {
        override fun getSeason(): Season3 =
            AUTUMN
    },
    WINTER {
        override fun getSeason(): Season3 =
            WINTER
    };

    abstract fun getSeason(): Season3
}

fun main() {
    val season = Season.values()
    season.forEach { println(it) }

    println("------------")

    val season1 = Season.valueOf("SPRING")
    println(season1.name)
}