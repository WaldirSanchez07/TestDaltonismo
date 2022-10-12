package com.example.testdaltonismo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class test : AppCompatActivity() {

    private var numeros: IntArray = intArrayOf(12, 8, 6, 29, 57, 5, 3, 15, 74, 2)
    private var respuestas = IntArray(10)
    private var idx = IntArray(10)
    private var posCurrent: Int = 0

    //
    private lateinit var imgView: ImageView
    private lateinit var grupo: RadioGroup
    private lateinit var btnPrev: Button
    private lateinit var btnNext: Button
    private lateinit var btnRes: Button
    private lateinit var rgCurrent: RadioGroup
    private lateinit var rb1: RadioButton
    private lateinit var rb2: RadioButton
    private lateinit var rb3: RadioButton
    private lateinit var builder: AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        castView()

        grupo.setOnCheckedChangeListener { radioGroup, i ->
            if (radioGroup.getCheckedRadioButtonId() !== -1) {
                val rb: RadioButton = findViewById(i)
                idx[posCurrent] = i
                respuestas[posCurrent] = Integer.parseInt(rb.getText().toString())
            }
        }

        btnNext.setOnClickListener {
            if (grupo.getCheckedRadioButtonId() !== -1) {
                grupo.clearCheck()
                nextSlide()
            } else {
                Toast.makeText(baseContext, "Por favor, responde para avanzar!", Toast.LENGTH_LONG)
                    .show()
            }
        }

        btnPrev.setOnClickListener {
            grupo.clearCheck()
            prevSlide()
        }

        btnRes.setOnClickListener {
            val n: Int = totalRespuestas()
            builder.setTitle("Resultado del Test Ishihara")
                .setMessage("Conseguiste adivinar ${n.toString()}/10 imágenes.")
                .setNeutralButton("Volver intentar") { dialog, it ->
                    tryAgain()
                }.setPositiveButton("Aceptar") { dialog, it ->
                    dialog.cancel()
                }.show()
        }
    }

    fun totalRespuestas(): Int {
        var n: Int = 0
        for (i in 0..9) {
            if (numeros[i] == respuestas[i]) {
                n += 1
            }
        }
        return n
    }

    private fun castView() {
        imgView = findViewById(R.id.imageView2)
        rgCurrent = findViewById(R.id.gb00)
        btnPrev = findViewById(R.id.btnPrev)
        btnNext = findViewById(R.id.btnNext)
        btnRes = findViewById(R.id.btnRes)
        //
        grupo = findViewById(R.id.gb00)
        rb1 = findViewById(R.id.rb01)
        rb2 = findViewById(R.id.rb02)
        rb3 = findViewById(R.id.rb03)
        //
        builder = AlertDialog.Builder(this)
    }

    fun nextSlide() {
        posCurrent += 1
        if (posCurrent === 1) {
            btnPrev.isEnabled = true
            imgView.setImageResource(R.drawable.foto_02)
            rb1.setText("8")
            rb2.setText("6")
            rb3.setText("9")
        } else if (posCurrent === 2) {
            imgView.setImageResource(R.drawable.foto_03)
            rb1.setText("5")
            rb2.setText("6")
            rb3.setText("9")
        } else if (posCurrent === 3) {
            imgView.setImageResource(R.drawable.foto_04)
            rb1.setText("29")
            rb2.setText("26")
            rb3.setText("28")
        } else if (posCurrent === 4) {
            imgView.setImageResource(R.drawable.foto_05)
            rb1.setText("51")
            rb2.setText("57")
            rb3.setText("52")
        } else if (posCurrent === 5) {
            imgView.setImageResource(R.drawable.foto_06)
            rb1.setText("6")
            rb2.setText("2")
            rb3.setText("5")
        } else if (posCurrent === 6) {
            imgView.setImageResource(R.drawable.foto_07)
            rb1.setText("8")
            rb2.setText("6")
            rb3.setText("3")
        } else if (posCurrent === 7) {
            imgView.setImageResource(R.drawable.foto_08)
            rb1.setText("19")
            rb2.setText("12")
            rb3.setText("15")
        } else if (posCurrent === 8) {
            imgView.setImageResource(R.drawable.foto_09)
            rb1.setText("71")
            rb2.setText("76")
            rb3.setText("74")
        } else {
            btnNext.isEnabled = false
            btnRes.setVisibility(View.VISIBLE)
            imgView.setImageResource(R.drawable.foto_10)
            rb1.setText("2")
            rb2.setText("4")
            rb3.setText("8")
        }

        if (idx[posCurrent] !== 0) grupo.check(idx[posCurrent])
    }

    fun prevSlide() {
        posCurrent -= 1
        if (posCurrent === 1) {
            imgView.setImageResource(R.drawable.foto_02)
            rb1.setText("8")
            rb2.setText("6")
            rb3.setText("9")
        } else if (posCurrent === 2) {
            imgView.setImageResource(R.drawable.foto_03)
            rb1.setText("5")
            rb2.setText("6")
            rb3.setText("9")
        } else if (posCurrent === 3) {
            imgView.setImageResource(R.drawable.foto_04)
            rb1.setText("29")
            rb2.setText("26")
            rb3.setText("28")
        } else if (posCurrent === 4) {
            imgView.setImageResource(R.drawable.foto_05)
            rb1.setText("51")
            rb2.setText("57")
            rb3.setText("52")
        } else if (posCurrent === 5) {
            imgView.setImageResource(R.drawable.foto_06)
            rb1.setText("6")
            rb2.setText("2")
            rb3.setText("5")
        } else if (posCurrent === 6) {
            imgView.setImageResource(R.drawable.foto_07)
            rb1.setText("8")
            rb2.setText("6")
            rb3.setText("3")
        } else if (posCurrent === 7) {
            imgView.setImageResource(R.drawable.foto_08)
            rb1.setText("19")
            rb2.setText("12")
            rb3.setText("15")
        } else if (posCurrent === 8) {
            btnNext.isEnabled = true
            btnRes.setVisibility(View.INVISIBLE)
            imgView.setImageResource(R.drawable.foto_09)
            rb1.setText("71")
            rb2.setText("76")
            rb3.setText("74")
        } else {
            btnPrev.isEnabled = false
            imgView.setImageResource(R.drawable.foto_01)
            rb1.setText("12")
            rb2.setText("15")
            rb3.setText("16")
        }

        if (idx[posCurrent] !== 0) grupo.check(idx[posCurrent])
    }

    fun tryAgain() {
        grupo.clearCheck()
        respuestas = IntArray(10)
        idx = IntArray(10)
        posCurrent = 0
        btnPrev.isEnabled = false
        btnNext.isEnabled = true
        btnRes.setVisibility(View.INVISIBLE)
        imgView.setImageResource(R.drawable.foto_01)
        rb1.setText("12")
        rb2.setText("15")
        rb3.setText("16")
    }

}