package inaction.chapter4

import javax.naming.Context
import javax.swing.text.AttributeSet

open class View2 {
    constructor(ctx: Context) {

    }

    constructor(ctx: Context, attr: AttributeSet) {

    }
}


class MyButton : View2 {

   constructor(ctx: Context) : super(ctx) {

   }


    constructor(ctx: Context, attr: AttributeSet) :super(ctx, attr) {

    }
}
