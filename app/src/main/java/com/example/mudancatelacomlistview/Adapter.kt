package com.example.mudancatelacomlistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class Adapter(
    var context: Context,
    var celula: Int,
    var dados: ArrayList<HMAux>
) : BaseAdapter() {
    var inflater = LayoutInflater.from(context)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var mView = convertView
        if(mView == null){
            mView = inflater.inflate(celula, parent, false)
        }
        var tv_nome = mView?.findViewById<TextView>(R.id.tv_nome)
        var elemNome = getItem(position) as HMAux
        tv_nome?.text = elemNome[ConstantesHMAux.NOME]

        return mView!!
    }

    override fun getItem(position: Int): Any {
        return dados[position]
    }

    override fun getItemId(position: Int): Long {
       var id = dados[position][ConstantesHMAux.ID]?.let {
            return it.toLong()
        }
        return id ?: -1L
    }

    override fun getCount(): Int {
        return dados.size
    }
}