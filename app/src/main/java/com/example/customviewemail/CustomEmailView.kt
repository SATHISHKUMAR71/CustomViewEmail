package com.example.customviewemail


import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.provider.ContactsContract.CommonDataKinds.Im
import android.text.TextUtils
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class CustomEmail @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    private lateinit var imageView: ImageView
    private lateinit var star:ImageView
    private lateinit var title: TextView
    private lateinit var subTitle: TextView
    private val desiredTextSize = resources.displayMetrics.widthPixels
    private var dateLeftPos = 0
    private var dateRightPos = 0
    private lateinit var content:TextView
    private lateinit var date:TextView

    init {
        println(desiredTextSize)

        // Initialize views
        imageView = ImageView(context)
        star = ImageView(context)

//        imageView.setColorFilter(androidx.appcompat.R.attr.colorAccent)
        imageView.setColorFilter(com.google.android.material.R.attr.colorControlHighlight)
        title = TextView(context)
        title.setTypeface(null,Typeface.BOLD)
        date = TextView(context)
        date.setTypeface(null,Typeface.BOLD)
        subTitle = TextView(context)
        subTitle.setTypeface(null,Typeface.BOLD)
        content = TextView(context)
        star.setImageResource(R.drawable.baseline_star_outline_24)
        title.textSize = desiredTextSize * 0.015f
        subTitle.textSize = desiredTextSize*0.013f
        content.textSize = desiredTextSize*0.01f
        date.textSize = desiredTextSize*0.01f
        val typedArray = context.obtainStyledAttributes(attrs,R.styleable.CustomEmail)
        val titleAttr= typedArray.getString(R.styleable.CustomEmail_emailTitle)
        val subtitleAttr= typedArray.getString(R.styleable.CustomEmail_emailSubtitle)
        val imgAttr = typedArray.getDrawable(R.styleable.CustomEmail_emailImage)
        val contentAttr = typedArray.getString(R.styleable.CustomEmail_emailContents)
        val dateAttr = typedArray.getString(R.styleable.CustomEmail_emailDate)
        imageView.setImageDrawable(imgAttr)
        title.text = titleAttr
        subTitle.text = subtitleAttr
        content.text = contentAttr
        date.text = dateAttr
        title.ellipsize = TextUtils.TruncateAt.END
        subTitle.ellipsize = TextUtils.TruncateAt.END
        content.ellipsize = TextUtils.TruncateAt.END
        title.maxLines = 1
        subTitle.maxLines =1
        content.maxLines = 1
        typedArray.recycle()
        addView(imageView)
        addView(title)
        addView(subTitle)
        addView(content)
        addView(date)
        addView(star)
    }



    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // Measure dimensions for all child views
        measureChildWithMargins(imageView, widthMeasureSpec, 0, heightMeasureSpec, 0)
        measureChildWithMargins(title, widthMeasureSpec, 0, heightMeasureSpec, 0)
        measureChildWithMargins(subTitle, widthMeasureSpec, 0, heightMeasureSpec, 0)
        measureChildWithMargins(content, widthMeasureSpec, 0, heightMeasureSpec, 0)
        measureChildWithMargins(date, widthMeasureSpec, 0, heightMeasureSpec, 0)
        dateLeftPos = desiredTextSize - (desiredTextSize*0.1).toInt() - paddingRight
        dateRightPos = desiredTextSize - paddingRight


        // Calculate total width required (considering padding)

        val screenWidth = resources.displayMetrics.widthPixels
        val imageViewWidth = (screenWidth * 0.2).toInt()
        val imageViewHeight = (imageViewWidth )

        val lp = imageView.layoutParams as MarginLayoutParams
        lp.width = imageViewWidth
        lp.height = imageViewHeight
        imageView.layoutParams = lp

        val titleLp = title.layoutParams as MarginLayoutParams
        titleLp.width = dateLeftPos - imageViewWidth - 130
        title.layoutParams = titleLp

        subTitle.layoutParams = subTitle.layoutParams.apply {
            width = dateLeftPos - imageViewWidth - 130
        }
        content.layoutParams = content.layoutParams.apply {
            width = dateLeftPos - imageViewWidth - 130
        }

        val desiredWidth = resources.displayMetrics.widthPixels
//        val desiredWidth = imageViewWidth+ title.measuredWidth+ date.measuredWidth+ paddingLeft + paddingRight + resources.getDimensionPixelSize(R.dimen.horizontalPadding)

        // Calculate total height required (considering padding)
        val desiredHeight = maxOf((title.measuredHeight +
                subTitle.measuredHeight +
                content.measuredHeight +
                paddingTop + paddingBottom + resources.getDimensionPixelSize(R.dimen.vertical_padding)*2),imageViewHeight)


        // Resolve the measured dimensions against the measure specifications
        val measuredWidth = resolveSize(desiredWidth, widthMeasureSpec)
        val measuredHeight = resolveSize(desiredHeight, heightMeasureSpec)
        // Set the measured dimensions for this custom view
        setMeasuredDimension(measuredWidth, measuredHeight)
    }



    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        // Variables to keep track of the current position
        var currentTop = paddingTop
        var currentWidth = paddingLeft


        date.layout(
            dateLeftPos,
            currentTop,
            dateRightPos,
            currentTop + date.measuredHeight
        )


//        i

        // Layout imageView
        imageView.layout(
            paddingLeft,
            currentTop,
            paddingLeft + imageView.measuredWidth,
            currentTop + imageView.measuredHeight
        )

        currentWidth +=imageView.measuredWidth + resources.getDimensionPixelSize(R.dimen.horizontalPadding)
        // Update current top position


        // Layout title
        title.layout(
            currentWidth,
            currentTop,
            dateLeftPos - 15,
            currentTop + title.measuredHeight
        )

        title.width = dateLeftPos-15 - currentWidth
        // Update current top position
        currentTop += title.measuredHeight + resources.getDimensionPixelSize(R.dimen.vertical_padding)
//        currentTop += title.measuredHeight
        // Layout subTitle
        subTitle.layout(
            currentWidth,
            currentTop,
            dateLeftPos - 15,
            currentTop + subTitle.measuredHeight
        )

        // Update current top position
        currentTop += subTitle.measuredHeight + resources.getDimensionPixelSize(R.dimen.vertical_padding)

//        currentTop += subTitle.measuredHeight
        // Layout content
        content.layout(
            currentWidth,
            currentTop,
            dateLeftPos - 15,
            currentTop + content.measuredHeight
        )

        star.layout(
            dateLeftPos,
            currentTop-subTitle.measuredHeight+resources.getDimensionPixelSize(R.dimen.vertical_padding),
            dateRightPos,
            currentTop+content.measuredHeight
        )
        // Update current top position
    }



    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }

    override fun generateDefaultLayoutParams(): LayoutParams {
        return MarginLayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
    }

    override fun generateLayoutParams(lp: LayoutParams?): LayoutParams {
        return MarginLayoutParams(lp)
    }

    override fun checkLayoutParams(p: LayoutParams?): Boolean {
        return p is MarginLayoutParams
    }

    fun setTitle(text: Text){
        title.text = text.toString()
    }
    fun setSubtitle(text:Text){
        subTitle.text = text.toString()
    }
    fun setContent(text:Text){
        content.text = text.toString()
    }
    fun setDate(text:Text){
        date.text = text.toString()
    }
    fun setImage(resourceID:Int){
        imageView.setImageResource(resourceID)
    }

    fun setTitle(text: String){
        title.text = text
    }
    fun setSubtitle(text:String){
        subTitle.text = text
    }
    fun setContent(text:String){
        content.text = text
    }
    fun setDate(text:String){
        date.text = text
    }

    fun getImage():ImageView{
        return imageView
    }

    fun getTitle():TextView{
        return title
    }
    fun getSubtitle():TextView{
        return subTitle
    }
    fun getContent():TextView{
        return content
    }
    fun getDate():TextView{
        return date
    }

    fun getStar():ImageView{
        return star
    }


}