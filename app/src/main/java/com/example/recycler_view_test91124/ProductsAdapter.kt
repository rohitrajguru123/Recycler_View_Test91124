package com.example.recycler_view_test91124

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductsAdapter(
    private val laptops: List<Laptop>,
    private val books: List<Book>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_LAPTOP = 1
    private val VIEW_BOOK = 2

    class LaptopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgLaptop: ImageView = itemView.findViewById(R.id.imgLaptop)
        private val tvLaptop: TextView = itemView.findViewById(R.id.tvLaptop)

        fun bind(laptop: Laptop) {
            imgLaptop.setImageResource(laptop.imags)
            tvLaptop.text = laptop.laptopname
        }
    }

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgBook: ImageView = itemView.findViewById(R.id.imgBook)
        private val tvBook: TextView = itemView.findViewById(R.id.tvBook)

        fun bind(book: Book) {
            imgBook.setImageResource(book.imags)
            tvBook.text = book.bookname
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return if (viewType == VIEW_LAPTOP) {
            val view = layoutInflater.inflate(R.layout.laptop_viewholder, parent, false)
            LaptopViewHolder(view)
        } else {
            val view = layoutInflater.inflate(R.layout.books_viewholder, parent, false)
            BookViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val laptopIndex = position / 2
        val bookIndex = (position - 1) / 2

        if (getItemViewType(position) == VIEW_LAPTOP && laptopIndex < laptops.size) {
            (holder as LaptopViewHolder).bind(laptops[laptopIndex])
        } else if (bookIndex < books.size) {
            (holder as BookViewHolder).bind(books[bookIndex])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0 && position / 2 < laptops.size) {
            VIEW_LAPTOP
        } else {
            VIEW_BOOK
        }
    }

    override fun getItemCount(): Int {
        return laptops.size + books.size
    }
}
