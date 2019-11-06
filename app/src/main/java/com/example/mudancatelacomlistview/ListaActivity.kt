package com.example.mudancatelacomlistview

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.lista.*
import java.util.ArrayList

class ListaActivity : AppCompatActivity() {
    private lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista)

        initVars()
        initActions()
    }

    private fun initVars() {
        context = this
        var data = intent.getIntExtra(ConstantesExtra.NUMERO_LISTA, -1)
        var dados = gerarDados(data.toInt())

        tv_elements.text = "Foi Gerada uma lista com ${dados.size} elementos"

        lv_elementos.adapter = Adapter(context, R.layout.celula,dados)
    }

    private fun gerarDados(quantidade: Int): ArrayList<HMAux> {
        var lista = ArrayList<HMAux>()
        var aux: HMAux
        for (i in 1..quantidade) {
            aux = HMAux()
            aux[ConstantesHMAux.NOME] = "Nome - $i"
            aux[ConstantesHMAux.ID] = "$i"
            lista.add(aux)
        }
        return lista
    }

    override fun onBackPressed() {
        var _intent = Intent(context, MainActivity::class.java)
        startActivity(_intent)
        finish()
    }

    private fun initActions() {
        lv_elementos.setOnItemClickListener { parent, view, position, id ->
            var _intent = Intent(context, DetalheActivity::class.java)
            _intent.putExtra(ConstantesExtra.NUMERO_DETALHES, id)
            startActivity(_intent)
        }
    }
}