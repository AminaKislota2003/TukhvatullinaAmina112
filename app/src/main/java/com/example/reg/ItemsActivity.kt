package com.example.reg

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>(
            Item(1, "one", "Знакомство со школой танцев", "Действует на любой 1 урок к любому преподавателю", "a", 0),
            Item(2, "two", "Если пока не получилось определиться с направлением", "Действует на любой урок длительностью в 1 час", "1", 600),
            Item(3, "three", "Для удлиненных уроков", "Действует на любой урок длительностью в 1,5 часа", "1", 800),
            Item(4, "four", "Действие абонемента 30 дней", "Действует на на 1 стиль на уроки по 1 часу", "1", 2000),
            Item(5, "five", "Действие абонемента 30 дней", "Действует на 4 разных занятия по 1 часу", "1", 2200),
            Item(6, "six", "Действие абонемента 30 дней", "Действует на 8 занятий для начинающей детской группы", "1", 3000),
            Item(7, "seven", "Действие абонемента 30 дней", "Действует на 8 занятий в одной выбранной группе", "1", 3000),
            Item(8, "eight", "Действие абонемента 30 дней", "Действует на 8 различных занятий", "1", 3500),
            Item(9, "nine", "Действие абонемента 30 дней", "Действует на 12 занятий для профессиональной детской группы", "1", 4000),
            Item(10, "ten", "Действует на 12 занятий", "1", "1", 4000),
            Item(11, "eleven", "Действует на 16 занятий", "1", "1", 4500),
            Item(12, "twelve", "Действует на неограниченное количество занятий в течение 30 дней", "1", "6500",6500)
        )

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)
    }
}
