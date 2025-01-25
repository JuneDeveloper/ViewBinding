package com.example.viewbinding.utils

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.viewbinding.model.Person
import com.example.viewbinding.R

class MyAdapter(private val listPerson:MutableList<Person>):RecyclerView.Adapter<MyAdapter.PersonViewHolder>() {

    class PersonViewHolder(view: View):ViewHolder(view){
        val image:ImageView = view.findViewById(R.id.imageRecycleViewIV)
        val name:TextView = view.findViewById(R.id.nameRecycleViewTV)
        val surname:TextView = view.findViewById(R.id.surnameRecycleViewTV)
        val age:TextView = view.findViewById(R.id.ageRecycleViewTV)
        val phone:TextView = view.findViewById(R.id.phoneRecycleViewTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val item = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item,parent,false)
        return PersonViewHolder(item)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = listPerson[position]
//        holder.image.setImageURI(person.image)
        holder.name.text = person.name
        holder.surname.text = person.surname
        holder.age.text = person.age
        holder.phone.text = person.phone
    }

    override fun getItemCount(): Int {
        return listPerson.size
    }
}