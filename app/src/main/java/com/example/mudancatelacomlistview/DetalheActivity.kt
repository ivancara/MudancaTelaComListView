package com.example.mudancatelacomlistview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.detalhe.*

class DetalheActivity:AppCompatActivity() {
    private lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalhe)

        initVars()
        initActions()
    }


    private fun initVars() {
        context = this

        var retorno = intent.getLongExtra(ConstantesExtra.NUMERO_DETALHES, -1)

        tv_detalhe.text = "Foi selecionado o elemento $retorno"

    }

    private fun initActions() {

    }
}