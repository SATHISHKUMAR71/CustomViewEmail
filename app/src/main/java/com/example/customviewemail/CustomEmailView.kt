package com.example.customviewemail


import android.content.Context
import android.graphics.Color
import android.text.TextUtils
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class CustomEmail @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {

    private lateinit var imageView: ImageView
    private lateinit var title: TextView
    private lateinit var subTitle: TextView
    private val desiredTextSize = resources.displayMetrics.widthPixels

    private lateinit var content:TextView
    private lateinit var date:TextView

    init {
        println(desiredTextSize)
        // Initialize views
        imageView = ImageView(context)
        title = TextView(context)
        title.ellipsize = TextUtils.TruncateAt.END
        title.maxLines = 1
        subTitle = TextView(context)
        subTitle.ellipsize = TextUtils.TruncateAt.END
        subTitle.maxLines = 1
        content = TextView(context)
        content.ellipsize = TextUtils.TruncateAt.END
        content.maxLines = 1
        date = TextView(context)

        title.textSize = desiredTextSize * 0.02f
        subTitle.textSize = desiredTextSize*0.015f
        content.textSize = desiredTextSize*0.01f
        date.textSize = desiredTextSize*0.01f

        //        title.text = "Title"
//        subTitle.text = "Subtitle"
//        content.text = "This is the simple Content"
//        date.text = "7 July"
        // Example styling for the text views (you can customize further)
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
        typedArray.recycle()
        addView(imageView)
        addView(title)
        addView(subTitle)
        addView(content)
        addView(date)
    }



    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // Measure dimensions for all child views
        measureChildWithMargins(imageView, widthMeasureSpec, 0, heightMeasureSpec, 0)
        measureChildWithMargins(title, widthMeasureSpec, 0, heightMeasureSpec, 0)
        measureChildWithMargins(subTitle, widthMeasureSpec, 0, heightMeasureSpec, 0)
        measureChildWithMargins(content, widthMeasureSpec, 0, heightMeasureSpec, 0)
        measureChildWithMargins(date, widthMeasureSpec, 0, heightMeasureSpec, 0)



        // Calculate total width required (considering padding)

        val screenWidth = resources.displayMetrics.widthPixels
        val imageViewWidth = (screenWidth * 0.3).toInt()
        val imageViewHeight = (imageViewWidth / 2)

        val lp = imageView.layoutParams as MarginLayoutParams
        lp.width = imageViewWidth
        lp.height = imageViewHeight
        imageView.layoutParams = lp
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
            currentWidth + title.measuredWidth,
            currentTop + title.measuredHeight
        )

        // Update current top position
        currentTop += title.measuredHeight + resources.getDimensionPixelSize(R.dimen.vertical_padding)

        // Layout subTitle
        subTitle.layout(
            currentWidth,
            currentTop,
            currentWidth+subTitle.measuredWidth,
            currentTop + subTitle.measuredHeight
        )

        // Update current top position
        currentTop += subTitle.measuredHeight + resources.getDimensionPixelSize(R.dimen.vertical_padding)


        // Layout content
        content.layout(
            currentWidth,
            currentTop,
            currentWidth + content.measuredWidth,
            currentTop + content.measuredHeight
        )

        // Update current top position


        currentTop = paddingTop + (title.measuredHeight/2)
        val currentLeft = paddingLeft + imageView.measuredWidth+resources.getDimensionPixelSize(R.dimen.margin_left)
        // Layout date


        val dateLeftPos = desiredTextSize - (desiredTextSize*0.1).toInt()
        val dateRightPos = desiredTextSize
//        val availableWidth = MeasureSpec.getSize(measuredWidth)
//        val dateLeftPos = availableWidth - paddingRight - date.measuredWidth - resources.getDimensionPixelSize(R.dimen.date_end_margin_right)
//        val dateRightPos = availableWidth - paddingRight
        date.layout(
            dateLeftPos,
            currentTop,
            dateRightPos,
            currentTop + date.measuredHeight
        )
        println("Date Left position: $dateLeftPos")
        println(dateRightPos)
        println("Date width: ${dateRightPos-dateLeftPos}")

        println("Title Measured Width: ${title.measuredWidth}")
        println("image and title width: ${title.measuredWidth+imageView.measuredWidth}")
        if((title.measuredWidth+imageView.measuredWidth) > dateLeftPos){
            println("Assigned Title Width: IF ${desiredTextSize-imageView.measuredWidth-(dateRightPos-dateLeftPos)}")
            title.width = desiredTextSize-imageView.measuredWidth-(dateRightPos-dateLeftPos) - resources.getDimensionPixelSize(R.dimen.dateMargin)
        }
        if((subTitle.measuredWidth+imageView.measuredWidth) > dateLeftPos){
            println("Assigned Title Width: IF ${desiredTextSize-imageView.measuredWidth-(dateRightPos-dateLeftPos)}")
            subTitle.width = desiredTextSize-imageView.measuredWidth-(dateRightPos-dateLeftPos) - resources.getDimensionPixelSize(R.dimen.dateMargin)
        }
        if((content.measuredWidth+imageView.measuredWidth) > dateLeftPos){
            println("Assigned Title Width: IF ${desiredTextSize-imageView.measuredWidth-(dateRightPos-dateLeftPos)}")
            content.width = desiredTextSize-imageView.measuredWidth-(dateRightPos-dateLeftPos) - resources.getDimensionPixelSize(R.dimen.dateMargin)
        }
        println("Title Text: ${title.text}")
        println("Title measured Width: ${title.measuredWidth}")
        println("DesiredTextSize: $desiredTextSize")
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

}