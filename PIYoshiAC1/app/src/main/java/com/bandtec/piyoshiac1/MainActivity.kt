package com.bandtec.piyoshiac1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcularNota (componente:View) {
        val nome = et_nome.text.toString()
        val n1 = et_n1.text.toString().toInt()
        val n2 = et_n2.text.toString().toInt()
        val n3 = et_n3.text.toString().toInt()
        var validacoes = true

        if (n1 < 5 || n1 > 10 || n2 < 5 || n2 > 10 || n3 < 5 || n3 > 10) {
            Toast.makeText(this, "Digite as notas conforme especificado!", Toast.LENGTH_SHORT).show()
            validacoes = false
        }
        if (nome.length < 2) {
            Toast.makeText(this, "Digite pelo menos duas letras como seu nome!", Toast.LENGTH_SHORT).show()
            validacoes = false
        }

        if (validacoes == true) {
            val n4Necessaria = 28 - (n1 + n2 + n3)
            if (n4Necessaria > 10) {
                tv_resultado.text = "${nome}, seu desempenho neste curso foi péssimo, independente do desempenho no semestre final."
                tv_resultado.setTextColor(Color.RED)
            } else if (n4Necessaria >= 8 && n4Necessaria <= 10) {
                tv_resultado.text = "${nome}, você precisa de nota geral ${n4Necessaria} para ter desempenho médio aceitável neste curso."
                tv_resultado.setTextColor(Color.YELLOW)
            } else if (n4Necessaria >= 5 && n4Necessaria <= 7) {
                tv_resultado.text = "${nome}, você precisa de nota geral ${n4Necessaria} para ter desempenho médio aceitável neste curso."
                tv_resultado.setTextColor(Color.GREEN)
            } else {
                tv_resultado.text = "${nome}, você pode até reprovar neste semestre que seu desempenho médio será bom. Mas é melhor ir alguns dias pra aula pra garantir o mínimo 5 e se formar."
                tv_resultado.setTextColor(Color.GREEN)
            }
        } else {
            tv_resultado.text = "Tem coisa errada nestes dados preenchidos aí!"
        }

    }
}