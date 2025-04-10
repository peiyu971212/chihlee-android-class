package com.example.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    //伴生物件，靜態區塊，類似 java class 對應的 static 區塊，const 關鍵字代表著常數，基本上取代了 public static final 的 java 寫法
    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        使用兩個不同關鍵字來宣告變數，val和var
        val number: Int = 100
//        number = 1 //無法改變
//        整數
        var count: Int = 10
        count = 15
        Log.d(TAG, "print int: $count")

//        浮點數
        var floatNumber: Float = 10f
        floatNumber = 20f
        Log.d(TAG, "print Float: $floatNumber")

//        字串
        var languageName: String = "Java"
        languageName = "Kotlin"
        Log.d(TAG, "print String: $languageName")

//        =====================================================
//        類型推論
//        val languageName = "Kotlin"
        val upperCaseName = languageName.uppercase()
        Log.d(TAG, "print String: $upperCaseName")

//        無法使用inc()函式
//        Fails to compile
//        languageName.inc()

//        =====================================================
//        空值安全
//        沒有使用？，無法用null
        val stringNull1: String? = null
//
        val stringNull2: String? = null
        Log.d(TAG, "print null: $stringNull2")

//        =====================================================
//        條件式 if-else
        if (count == 42) {
            Log.d(TAG, "I have the answer.")
        } else {
            Log.d(TAG, "The answer eludes me.")
        }

//        多個條件式
        if (count == 42) {
            Log.d(TAG, "I have the answer.")
        } else if (count > 35) {
            Log.d(TAG, "The answer is close.")
        } else {
            Log.d(TAG, "The answer eludes me.")
        }

        val answerStringIf: String = if (count == 42) {
            "I have the answer."
        } else if (count > 35) {
            "The answer is close."
        } else {
            "The answer eludes me."
        }
        Log.d(TAG, answerStringIf)

//        =====================================================
//        條件式 when
        val answerStringWhen = when {
            count == 42 -> "I have the answer."
            count > 35 -> "The answer is close."
            else -> "The answer eludes me."
        }
        Log.d(TAG, answerStringWhen)

        //        =====================================================
//        函式
        fun generateAnswerString(): String {
            val answerString = if (count == 42) {
                "I have the answer."
            } else {
                "The answer eludes me"
            }

            return answerString
        }

        val answerString = generateAnswerString()
        Log.d(TAG, "function output: $answerString")

        fun generateAnswerString(countThreshold: Int): String {
            val answerString = if (count > countThreshold) {
                "I have the answer."
            } else {
                "The answer eludes me."
            }

            return answerString
        }

        val answerStringInput = generateAnswerString(42)
        Log.d(TAG, "function input and output: $answerStringInput")

        fun generateAnswer(countThreshold: Int): String {
            return if (count > countThreshold) {
                "I have the answer."
            } else {
                "The answer eludes me."
            }
        }
        Log.d(TAG, "===function input and output===: ${generateAnswer(9)}")

//        =====================================================
        val account = "1234567  "
        val accountName = account!!.trim()
        Log.d(TAG, "print accountName: $accountName")
    }
}