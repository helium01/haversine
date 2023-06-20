package com.opencv.bank_sampah.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.opencv.bank_sampah.R
import com.opencv.bank_sampah.activity.admin.RequestOutliteActivity
import com.opencv.bank_sampah.app.ApiConfig
import com.opencv.bank_sampah.app.ApiService
import com.opencv.bank_sampah.model.data.BankSampah
import com.opencv.bank_sampah.model.data.outlite
import com.opencv.bank_sampah.model.response.carioutlites
import com.opencv.bank_sampah.model.response.outliteResponseGet
import com.opencv.bank_sampah.model.response.outlites
import com.opencv.bank_sampah.model.response.users
import retrofit2.Call
import retrofit2.Response

class BankSampahAdapter(private val context: Context, private val userList: List<carioutlites>) : BaseAdapter() {

    override fun getCount(): Int {
        return userList.size
    }

    override fun getItem(position: Int): Any {
        return userList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.listviewbanksampah, parent, false)
            holder = ViewHolder()
            holder.textViewName = view.findViewById(R.id.textViewNama)
            holder.textViewNamaOutlite = view.findViewById(R.id.textViewNamaOutlite)
            holder.textViewNoHp = view.findViewById(R.id.textViewNamaNohp)
            holder.textViewAlamat = view.findViewById(R.id.textViewNamaAlamat)
            holder.textViewStatus = view.findViewById(R.id.textViewNamaStatus)
            holder.buttonlihat=view.findViewById(R.id.buttonLokasi)
            view.tag = holder
        } else {
            view = convertView
            holder = convertView.tag as ViewHolder
        }
        val user = userList[position]
        holder.textViewNoHp?.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW)
            val url = "https://api.whatsapp.com/send?phone=${user.no_hp}"
            i.data = Uri.parse(url)
            context.startActivity(i)
        }
        holder.buttonlihat?.setOnClickListener{
            val gmmIntentUri =
                Uri.parse("geo:${user.lat},${user.lng}?z=15&q=${user.lat},${user.lng}")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            context.startActivity(mapIntent)
        }
        holder.textViewName?.text = user.id_user
        holder.textViewNamaOutlite?.text = user.nama_outlite
        holder.textViewNoHp?.text = user.no_hp
        holder.textViewAlamat?.text = user.alamat
        holder.textViewStatus?.text = user.distance


        return view
    }

    private class ViewHolder {
        var textViewName: TextView? = null
        var textViewNamaOutlite: TextView? = null
        var textViewNoHp: TextView? = null
        var textViewAlamat: TextView? = null
        var textViewStatus: TextView? = null
        var buttonlihat: Button? = null
    }
}