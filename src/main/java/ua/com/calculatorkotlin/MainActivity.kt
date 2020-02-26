package ua.com.calculatorkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_0.setOnClickListener { setTextFields("0") }
        btn_1.setOnClickListener { setTextFields("1") }
        btn_2.setOnClickListener { setTextFields("2") }
        btn_3.setOnClickListener { setTextFields("3") }
        btn_4.setOnClickListener { setTextFields("4") }
        btn_5.setOnClickListener { setTextFields("5") }
        btn_6.setOnClickListener { setTextFields("6") }
        btn_7.setOnClickListener { setTextFields("7") }
        btn_8.setOnClickListener { setTextFields("8") }
        btn_9.setOnClickListener { setTextFields("9") }
        minus_btn.setOnClickListener { setTextFields("-") }
        plus_btn.setOnClickListener { setTextFields("+") }
        div_btn.setOnClickListener { setTextFields("/") }
        mult_btn.setOnClickListener { setTextFields("*") }
        scobka_otkr_btn.setOnClickListener { setTextFields("(") }
        scobka_zakr_btn.setOnClickListener { setTextFields(")") }

        AC_btn.setOnClickListener {
            mathOperation.text = ""
            resultText.text = ""
        }

        btn_back.setOnClickListener {
            val str = mathOperation.text.toString()
            if (str.isNotEmpty()) {
                mathOperation.text = str.substring(0, str.length - 1)
            }
            resultText.text = ""
        }

        ravno_btn.setOnClickListener {
            try {

                val ex = ExpressionBuilder(mathOperation.text.toString()).build()
                val rezult = ex.evaluate()

                val longRes = rezult.toLong()
                if (rezult == longRes.toDouble()) {
                    resultText.text = longRes.toString()
                } else {
                    resultText.text = rezult.toString()
                }


            } catch (e: Exception) {
                Log.d("Ошибка", "сообщение ${e.message}")
            }
        }
    }

    fun setTextFields(str: String) {
        if (resultText.text != "") {
            mathOperation.text = resultText.text
            resultText.text = ""
        }
        mathOperation.append(str)
    }
}
