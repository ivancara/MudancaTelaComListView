package com.example.mudancatelacomlistview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.inicio.*

class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inicio)

        initVars()
        initActions()
    }

    private fun initVars() {
        context = this
    }

    private fun initActions() {
        bt_gerar.setOnClickListener {
            var _intent = Intent(context, ListaActivity::class.java)
            var numero = et_numeroRegistros.text.toString().toInt()

            _intent.putExtra(ConstantesExtra.NUMERO_LISTA, numero)

            startActivity(_intent)
            finish()
        }
    }
}
