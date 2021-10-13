package com.zz.ppjoke.model

import com.zz.ppjoke.annotation.AllOpenNoarg

data class Destination(
    val isFragment: Boolean,
    val asStarter: Boolean,
    val needLogin: Boolean,
    val pageUrl: String,
    val clazName: String,
    val id: Int
)