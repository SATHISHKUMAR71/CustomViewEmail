package com.example.customviewemail

import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private var emails:List<Email>):RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {


    inner class EmailViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.email_view,parent,false)
        return EmailViewHolder(view)
    }

    override fun getItemCount(): Int {
        return emails.size
    }

    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        holder.itemView.apply {
            var i =0
            val email = this.findViewById<CustomEmail>(R.id.emailView)
            val image = email.setImage(emails[position].imageId)
            val title = email.setTitle(emails[position].title)
            val subtitle = email.setSubtitle(emails[position].subTitle)
            val content = email.setContent(emails[position].content)
            val date = email.setDate(emails[position].date)

            this.setOnClickListener{
                Toast.makeText(context,"Mail os Clicked",Toast.LENGTH_SHORT).show()
                email.getTitle().typeface = Typeface.DEFAULT
                email.getSubtitle().typeface = Typeface.DEFAULT
                email.getDate().typeface = Typeface.DEFAULT
            }
            val star = email.getStar()
            star.setOnClickListener {
                i+=1
                if(i%2 == 0){
                    star.setImageResource(R.drawable.baseline_star_outline_24)
                    Toast.makeText(context,"Message UnStared",Toast.LENGTH_SHORT).show()
                }
                else{
                    star.setImageResource(R.drawable.baseline_star_24)
                    Toast.makeText(context,"Message Stared",Toast.LENGTH_SHORT).show()
                }

            }
        }

    }
}


