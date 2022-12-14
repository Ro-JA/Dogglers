/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.data.DataSource
import com.example.dogglers.data.DataSource.dogs
import com.example.dogglers.model.Dog

/**
 * Адаптер для расширения соответствующего макета элемента списка и заполнения представления информацией
 * из соответствующего источника данных
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
) : RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    // ЗАДАЧА: Инициализируйте данные, используя список, найденный в data/Источнике данных
    private val listDogs = DataSource.dogs


    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        // ЧТО НУЖНО СДЕЛАТЬ: объявить и инициализировать все компоненты пользовательского интерфейса элемента списка
        val imageDog: ImageView = view!!.findViewById(R.id.image_view_dog)
        val nameDog: TextView = view!!.findViewById(R.id.text_view_dog_name)
        val ageDog: TextView = view!!.findViewById(R.id.text_view_dog_age)
        val hobbiesDog: TextView = view!!.findViewById(R.id.text_view_dog_hobbies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        // TODO: Используйте условие для определения типа макета и установите его соответствующим образом.
        // если переменной layout является Layout.СЕТКА следует использовать элемент списка сетки. В противном
        // случае следует использовать элемент вертикального/горизонтального списка.

        // // ЧТОБЫ СДЕЛАТЬ раздувание макета

        // TODO: Значение Null не должно передаваться владельцу представления. Это должно быть обновлено, чтобы отразить
        // раздутый макет.
        val adapterLayout = if (layout == 3) {
            LayoutInflater.from(parent.context)
                .inflate(R.layout.grid_list_item, parent, false)
        } else {
            LayoutInflater.from(parent.context)
                .inflate(R.layout.vertical_horizontal_list_item, parent, false)
        }
        return DogCardViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int = listDogs.size // ЗАДАЧА: вернуть размер набора данных вместо 0

    override fun onBindViewHolder(holder: DogCardAdapter.DogCardViewHolder, position: Int) {
        // ЧТО НУЖНО СДЕЛАТЬ: Получить данные в текущей позиции
// TODO: Установите ресурс изображения для текущей собаки
// ЗАДАЧА: Задайте текст для имени текущей собаки.
// ЗАДАЧА: Установите текст для текущего возраста собаки
        val resources = context?.resources
        val item = listDogs[position]
        holder.imageDog.setImageResource(item.imageResourceId)
        holder.ageDog.text = resources!!.getString(R.string.dog_age, item.age)
        holder.hobbiesDog.text = resources!!.getString(R.string.dog_hobbies, item.hobbies)
        holder.nameDog.text = item.name


        // TODO: Задайте текст для хобби текущей собаки, передав хобби в
        // строковую константу R.string.dog_hobbies.
        // Передача аргумента строковому ресурсу выглядит следующим образом:
        // ресурсы?.getString(R.string.dog_hobbies, dog.hobbies)
    }
}
